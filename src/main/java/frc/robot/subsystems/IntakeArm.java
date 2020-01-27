package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class IntakeArm extends Subsystem {

    //Motor Stuff
    public TalonSRX armTalon;

    public IntakeArm() {
        armTalon = new TalonSRX(RobotMap.armTalon);
    }


    //Methods
    public void armIntakeUp() {
        armTalon.set(ControlMode.PercentOutput, 1);
    }

    public void armIntakeDown(){
        armTalon.set(ControlMode.PercentOutput, 1);
    }

    public void Stop() {
        armTalon.set(ControlMode.PercentOutput, 0);
    }


    @Override
    protected void initDefaultCommand() {
       Stop();
    }




}