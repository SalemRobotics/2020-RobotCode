package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class IntakeRoller extends SubsystemBase {
    
    //Motor stuff
    public static CANSparkMax rollerMotorA;
    public static CANSparkMax rollerMotorB;

    public IntakeRoller() {
        rollerMotorA = new CANSparkMax(RobotMap.rollerMotorA, CANSparkMaxLowLevel.MotorType.kBrushless);
        rollerMotorB = new CANSparkMax(RobotMap.rollerMotorB, CANSparkMaxLowLevel.MotorType.kBrushless);

        //rollerMotorB.follow(rollerMotorA, true);

    } 

    // Methods
    public void Intake(double power) {
        //rollerMotorA.set(power);
        rollerMotorB.set(power);
    }

    public static void Stop() {
        rollerMotorA.set(0);
        rollerMotorB.set(0);

    }

    public void Repel() {
        rollerMotorA.set(-0.2);
        rollerMotorB.set(-0.2);
    }

    


    @Override
    public void periodic() {

    }


    
}