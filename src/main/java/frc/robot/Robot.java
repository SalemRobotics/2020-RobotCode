package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//Subsystem imports hhhh
import frc.robot.subsystems.*;
import frc.robot.OI;



public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  //Subsystem Initializations
  public static DriveTrain drivetrain;
  public static IntakeRoller intakeroller;
  public static IntakeArm intakearm;
  public static Launcher launcher;
  public static OI oi;
  public static SmartDashboard sd;
      
  
  @Override
  public void robotInit() {
    /*
    *DriveTrain Initializations

    RobotMap.dt_leftfront = new TalonFX(RobotMap.dt_leftfront_port);
    RobotMap.dt_leftrear = new TalonFX(RobotMap.dt_leftrear_port);
    RobotMap.dt_rightfront = new TalonFX(RobotMap.dt_rightfront_port);
    RobotMap.dt_rightrear = new TalonFX(RobotMap.dt_rightrear_port);

    RobotMap.dt_leftfront.configFactoryDefault();
    RobotMap.dt_leftrear.configFactoryDefault();
    RobotMap.dt_rightfront.configFactoryDefault();
    RobotMap.dt_rightrear.configFactoryDefault();

  
    RobotMap.dt_leftrear.follow(RobotMap.dt_leftfront);
    RobotMap.dt_rightrear.follow(RobotMap.dt_rightfront);
    */

    drivetrain = new DriveTrain();
    intakeroller = new IntakeRoller();
    intakearm = new IntakeArm();
    launcher = new Launcher();
    oi = new OI();
  }
//hello
  
  @Override
  public void robotPeriodic() {
  }

  
  @Override
  public void autonomousInit() {
   DriveTrain.driveToInch(10);
  }

  
  @Override
  public void autonomousPeriodic() {
    SmartDashboard.putNumber("Left Motor Out", RobotMap.dt_leftfront.getSensorCollection().getIntegratedSensorPosition());
    SmartDashboard.putNumber("Right Motor Out", RobotMap.dt_rightfront.getSensorCollection().getIntegratedSensorPosition());
    
  }

  
  @Override
  public void teleopInit() {
    RobotMap.dt_leftfront.setSelectedSensorPosition(0);
    RobotMap.dt_rightfront.setSelectedSensorPosition(0);
  }
  @Override
  public void teleopPeriodic() {
    //Tele-op Drive Command
    drivetrain.driveWithJoysticks(oi.getDriveY(), oi.getDriveX());
    
    //Smartboard Drive Value Output
    SmartDashboard.putNumber("Left Motor Out", RobotMap.dt_leftfront.getSensorCollection().getIntegratedSensorPosition());
    SmartDashboard.putNumber("Right Motor Out", RobotMap.dt_rightfront.getSensorCollection().getIntegratedSensorPosition());
    
  }

 

  @Override
  public void testPeriodic() {
  }
}

