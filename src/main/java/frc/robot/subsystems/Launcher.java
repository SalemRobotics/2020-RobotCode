package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Launcher extends Subsystem {
    
    //Motor Stuff
    public CANSparkMax launcherMotorA;
    public CANSparkMax launcherMotorB;
    public CANSparkMax launcherMotorC;

    public Launcher(){
        
        launcherMotorA = new CANSparkMax(RobotMap.LAUNCHER_MOTOR_A, CANSparkMaxLowLevel.MotorType.kBrushless);
        launcherMotorB = new CANSparkMax(RobotMap.LAUNCHER_MOTOR_B, CANSparkMaxLowLevel.MotorType.kBrushless);
        launcherMotorC = new CANSparkMax(RobotMap.LAUNCHER_MOTOR_C, CANSparkMaxLowLevel.MotorType.kBrushed);
        launcherMotorB.follow(launcherMotorA);
    }

    //Methods
    public void launch(){
        launcherMotorA.set(.8);
    }

    
    public void stop(){
        launcherMotorA.set(0);
    }

    
    @Override
    protected void initDefaultCommand() {
        stop();

    }






}

 