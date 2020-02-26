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
       // armTalon.set(, demand);
    }


    //Methods
    public void armIntakeUp(double power) {
        armTalon.set(ControlMode.PercentOutput, power);
    }

    public void armIntakeDown(double power){
        armTalon.set(ControlMode.PercentOutput, -power);
    }

    public void Stop() {
        armTalon.set(ControlMode.PercentOutput, 0);
    }


    @Override
    public void periodic() {
        
    }




}