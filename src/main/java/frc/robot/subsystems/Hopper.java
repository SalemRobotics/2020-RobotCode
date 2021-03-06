package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Hopper extends SubsystemBase {
  
  public static CANSparkMax agitatorMotor;
  public CANSparkMax funnelMotor;

  public Hopper() {
    funnelMotor = new CANSparkMax(RobotMap.FUNNEL_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless);
    agitatorMotor = new CANSparkMax(RobotMap.AGITATOR_MOTOR,CANSparkMaxLowLevel.MotorType.kBrushless);
    System.out.println("Hopper, On Line!");
  }

  public void agitate(double power){
    agitatorMotor.set(power);
  }

  public void funnel(double power){
    agitatorMotor.set(power);
  }
  public static void Stop(){
    agitatorMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
