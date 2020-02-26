package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class IntakeRoller extends Subsystem {
    
    //Motor stuff
    public static CANSparkMax rollerMotorA;
    public static CANSparkMax rollerMotorB;

    public IntakeRoller() {
        rollerMotorA = new CANSparkMax(RobotMap.rollerMotorA, MotorType.kBrushless);
        rollerMotorB = new CANSparkMax(RobotMap.rollerMotorB, MotorType.kBrushless);

        rollerMotorB.follow(rollerMotorA, true);

    } 

    // Methods
    public static void Intake() {
        rollerMotorA.set(.80);
    }

    public static void Stop() {
        rollerMotorA.set(0);

    }

    public void Repel() {
        rollerMotorA.set(-.2);
    }

    


    @Override
    protected void initDefaultCommand() {

        Repel();
    }


    
}