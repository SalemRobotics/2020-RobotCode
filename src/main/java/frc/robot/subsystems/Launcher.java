package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Launcher extends Subsystem {
    
    //Motor Stuff
    public CANSparkMax launcherMotorA;
    public CANSparkMax launcherMotorB;

    public Launcher(){

        launcherMotorA = new CANSparkMAX(RobotMap.LAUNCHER_MOTOR_A, 1);
        launcherMotorB = new CANSparkMAX(RobotMap.LAUNCHER_MOTOR_B, 1);
        launcherMotorB.follow(launcherMotorA);
    }

    //Methods
    public void launch(){
        launcherMotorA.set(1);
    }

    
    public void stop(){
        launcherMotorA.set(0);
    }

    
    @Override
    protected void initDefaultCommand() {
        Stop();

    }






}

 