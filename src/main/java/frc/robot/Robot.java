package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

//Subsystem imports 
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
  public static Hopper hopper;
  public static OI oi;
  public static SmartDashboard sd;
  public static Climber climber; 
      
  
  @Override
  public void robotInit() {

    // Subsystem Init
    drivetrain = new DriveTrain();
    intakeroller = new IntakeRoller();
    intakearm = new IntakeArm();
    launcher = new Launcher();
    hopper = new Hopper();
    oi = new OI();
    climber = new Climber(); 

  }

  
  @Override
  public void robotPeriodic() {
  }

  
  @Override
  public void autonomousInit() {
  }

  
  @Override
  public void autonomousPeriodic() {
    //SmartDashboard.putNumber("Left Motor Out", RobotMap.dt_leftfront.getSensorCollection().getIntegratedSensorPosition());
    //SmartDashboard.putNumber("Right Motor Out", RobotMap.dt_rightfront.getSensorCollection().getIntegratedSensorPosition());
    
  }

  
  @Override
  public void teleopInit() {
    RobotMap.dt_leftfront.setSelectedSensorPosition(0);
    RobotMap.dt_rightfront.setSelectedSensorPosition(0);
    climber.climberTalon.set(ControlMode.PercentOutput, .5);
  }
  @Override
  public void teleopPeriodic() {

    //Tele-op Controls
      //Intake
      intakearm.armIntakeUp(oi.opLeftStickY());
      //intakeroller.Intake(1);

      //Hopper
      hopper.agitate(oi.opRightStickY()*-0.325);

      //Climber
      climber.climberUp(oi.opLeftTrigger()*.5);
    
      

    //Smartboard Drive Value Output
    SmartDashboard.putNumber("Left Motor Out", RobotMap.dt_leftfront.getSensorCollection().getIntegratedSensorPosition());
    SmartDashboard.putNumber("Right Motor Out", RobotMap.dt_rightfront.getSensorCollection().getIntegratedSensorPosition());


    CommandScheduler.getInstance().run();
  }

 

  @Override
  public void testPeriodic() {
  }
}

