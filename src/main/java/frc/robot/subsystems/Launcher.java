package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Launcher extends SubsystemBase {
    
    //Motor Stuff
    public CANSparkMax launcherMotorA;
    public CANSparkMax launcherMotorB;
    public CANSparkMax launcherKickerMotor;

    public Launcher(){
        //Kicker Motor 
        launcherKickerMotor = new CANSparkMax(RobotMap.LAUNCHER_MOTOR_C, CANSparkMaxLowLevel.MotorType.kBrushless);

        //Launcher Motors
        launcherMotorA = new CANSparkMax(RobotMap.LAUNCHER_MOTOR_A, CANSparkMaxLowLevel.MotorType.kBrushless);
        launcherMotorB = new CANSparkMax(RobotMap.LAUNCHER_MOTOR_B, CANSparkMaxLowLevel.MotorType.kBrushless);
        launcherMotorB.follow(launcherMotorA);
    }

    //Methods
    public void launch(double power){
        launcherMotorA.set(power);
        launcherKickerMotor.set(power);
    }

    
    public void stop(){
        launcherMotorA.set(0);
        launcherKickerMotor.set(0);
    }

    
    @Override
    public void periodic() {
    }






}

 