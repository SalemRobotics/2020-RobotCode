package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class IntakeArm extends SubsystemBase {

    //Motor Stuff
    public TalonSRX armTalon;

    public IntakeArm() {
        armTalon = new TalonSRX(RobotMap.armTalon);
        System.out.println("Intake Arm, On Line");
    }


    //Methods
    public void armIntakeUp(final double power) {
        armTalon.set(ControlMode.PercentOutput, 0.25 * power);
    }

    public void armIntakeDown(final double power) {
        armTalon.set(ControlMode.PercentOutput, -0.25*power);
    }

    public void Stop() {
        armTalon.set(ControlMode.PercentOutput, 0);
    }


    @Override
    public void periodic() {
        
    }




}