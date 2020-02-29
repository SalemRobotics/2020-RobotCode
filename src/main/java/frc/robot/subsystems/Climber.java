package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Climber extends SubsystemBase {

    public TalonSRX climberTalon;

    public Climber(){
        climberTalon = new TalonSRX(RobotMap.CLIMBER_MOTOR);
    }

    //methods
    public void climberUp(double power){
        climberTalon.set(ControlMode.PercentOutput, 1*power);
    }

    public void climberDown(double power){
        climberTalon.set(ControlMode.PercentOutput, -1*power); 
    }

    public void Stop(){
        climberTalon.set(ControlMode.PercentOutput, 0); 
    }



    @Override
    public void periodic(){

    }
}