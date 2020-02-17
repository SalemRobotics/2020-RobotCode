package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Hopper extends SubsystemBase {
  
  public CANSparkMax agitatorMotor;
  public CANSparkMax funnelMotor;

  public Hopper() {
    agitatorMotor = new CANSparkMax(RobotMap.AGITATOR_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless);
    funnelMotor = new CANSparkMax(RobotMap.FUNNEL_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless);
  }

  public void funnel(){
    funnelMotor.set(.5);
  }

  public void agitate(){
    agitatorMotor.set(.5);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
