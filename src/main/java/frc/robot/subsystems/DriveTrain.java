/*----------------------------------------------------------------------------*/
/* Copyright (c) 2020 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.Constants.DriveConstants;
import frc.robot.Games;
import frc.robot.commands.DriveCMD;
import frc.robot.utils.UnitConversions;

//Trajectory Imports
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Pose2d;




/**
 * Add your docs here.
 */
public class DriveTrain extends SubsystemBase {
  // Put methods for controlling this subsystem here. Call these from Commands.

  //Trajectory
  private final DifferentialDriveOdometry m_odometry;

  public DriveTrain(){
    //initialize motor ports
    RobotMap.dt_leftfront = new TalonFX(RobotMap.dt_leftfront_port);
    RobotMap.dt_leftrear = new TalonFX(RobotMap.dt_leftrear_port);
    RobotMap.dt_rightrear = new TalonFX(RobotMap.dt_rightrear_port);
    RobotMap.dt_rightfront = new TalonFX(RobotMap.dt_rightfront_port);

    //initialize gyro
    RobotMap.gyro = new PigeonIMU(RobotMap.GYRO_PORT);

    //reset to factory defaults
    RobotMap.dt_leftfront.configFactoryDefault();
    RobotMap.dt_leftrear.configFactoryDefault();
    RobotMap.dt_rightfront.configFactoryDefault();
    RobotMap.dt_rightrear.configFactoryDefault();

    //set PID F value
    RobotMap.dt_leftfront.config_kF(0, Games.DrivePID_F);
    RobotMap.dt_rightfront.config_kF(0, Games.DrivePID_F);
    RobotMap.dt_leftfront.config_kP(0, Games.DrivePID_P);
    RobotMap.dt_rightfront.config_kP(0, Games.DrivePID_P);
    RobotMap.dt_leftfront.config_kI(0, Games.DrivePID_I);
    RobotMap.dt_rightfront.config_kI(0, Games.DrivePID_I);
    RobotMap.dt_leftfront.config_kD(0, Games.DrivePID_D);
    RobotMap.dt_rightfront.config_kD(0, Games.DrivePID_D);


    RobotMap.dt_leftfront.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    RobotMap.dt_rightfront.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    //set followers
    RobotMap.dt_leftrear.follow(RobotMap.dt_leftfront);
    RobotMap.dt_rightrear.follow(RobotMap.dt_rightfront);

    m_odometry = new DifferentialDriveOdometry(Rotation2d.fromDegrees(getGyroAngle()));


  }
  
  @Override
  public void periodic() {
    setDefaultCommand(new DriveCMD());
    // Update the odometry in the periodic block
    m_odometry.update(Rotation2d.fromDegrees(getGyroAngle()), getLeftEncoderValue(),
                      getRightEncoderValue());
  }

  protected double limit(double value) {
    if (value > 1.0) {
      return 1.0;
    }
    if (value < -1.0) {
      return -1.0;
    }
    return value;
  }

  protected double deadBand(double input, double db){
    if (Math.abs(input) < db){
      return 0; 
    }
    else {
      return input; 
    }
  }


  public void driveWithJoysticks(double xSpeed, double zRotation) {
    xSpeed = limit(xSpeed);
    xSpeed = deadBand(xSpeed, RobotMap.dt_deadBand);

    zRotation = limit(zRotation);
    zRotation = deadBand(zRotation, RobotMap.dt_deadBand);

    // Square the inputs (while preserving the sign) to increase fine control
    // while permitting full power.
    xSpeed = Math.copySign(xSpeed * xSpeed, xSpeed);
    zRotation = Math.copySign(zRotation * zRotation, zRotation);

    double leftMotorOutput;
    double rightMotorOutput;

    double maxInput = Math.copySign(Math.max(Math.abs(xSpeed), Math.abs(zRotation)), xSpeed);

    if (xSpeed >= 0.0) {
      // First quadrant, else second quadrant
      if (zRotation >= 0.0) {
        leftMotorOutput = maxInput;
        rightMotorOutput = xSpeed - zRotation;
      } else {
        leftMotorOutput = xSpeed + zRotation;
        rightMotorOutput = maxInput;
      }
    } else {
      // Third quadrant, else fourth quadrant
      if (zRotation >= 0.0) {
        leftMotorOutput = xSpeed + zRotation;
        rightMotorOutput = maxInput;
      } else {
        leftMotorOutput = maxInput;
        rightMotorOutput = xSpeed - zRotation;
      }
    }

    RobotMap.dt_leftfront.set(ControlMode.PercentOutput, (leftMotorOutput) * 1.0);
    RobotMap.dt_rightfront.set(ControlMode.PercentOutput, (rightMotorOutput) * -1.0);
  }

  public void haltDriveTrain() {
    driveWithJoysticks(0, 0);
  }

  public static double getMeanEncoderValue(){
    double total = RobotMap.dt_leftfront.getSelectedSensorPosition() +  RobotMap.dt_rightfront.getSelectedSensorPosition();
    double mean = total/2;
    return mean;
  }

  public static double getRightEncoderValue(){
    double right = RobotMap.dt_rightfront.getSelectedSensorPosition();
    return right;
  }

  public static double getLeftEncoderValue(){
    double left = RobotMap.dt_leftfront.getSelectedSensorPosition();
    return left; 
  }

  public static double getGyroAngle(){
    double angle = RobotMap.gyro.getCompassHeading();
    return angle;
  }

  public static void driveToInch(double inches){
    RobotMap.dt_leftfront.setSelectedSensorPosition(0);
    RobotMap.dt_rightfront.setSelectedSensorPosition(0);
    RobotMap.dt_leftfront.set(ControlMode.Position, (UnitConversions.inchesToPulses(inches * 12)) * -1);
    RobotMap.dt_rightfront.set(ControlMode.Position, (UnitConversions.inchesToPulses(inches * 12)) * 1);

  }

  public DifferentialDriveWheelSpeeds getWheelSpeeds() {
    return new DifferentialDriveWheelSpeeds(getLeftEncoderValue(), getRightEncoderValue());
  }

  public Pose2d getPose() {
    return m_odometry.getPoseMeters();
  }







}
