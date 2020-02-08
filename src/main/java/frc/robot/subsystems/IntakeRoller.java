package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class IntakeRoller extends Subsystem {
    
    //Motor stuff
    public static VictorSPX rollerMotor;

    public IntakeRoller() {
        rollerMotor = new VictorSPX(RobotMap.rollerMotor);
    }

    // Methods
    public static void Intake() {
        rollerMotor.set(ControlMode.PercentOutput, .80);
    }

    public static void Stop() {
        rollerMotor.set(ControlMode.PercentOutput, 0);

    }

    public void Repel() {
        rollerMotor.set(ControlMode.PercentOutput, -.2);
    }

    


    @Override
    protected void initDefaultCommand() {

        Repel();
    }


    
}