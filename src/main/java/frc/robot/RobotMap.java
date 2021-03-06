package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class RobotMap {

    //drive train stuffs
        public final int driveleft_port = 1;

        public static TalonFX dt_leftrear, dt_leftfront, dt_rightrear, dt_rightfront;
        public static PigeonIMU gyro;

        public static final int dt_leftrear_port = 0;
        public static final int dt_leftfront_port = 1;
        public static final int dt_rightrear_port = 2;
        public static final int dt_rightfront_port = 3;

        public static final double dt_deadBand = 0.02; 
        public static final double dt_maxInput = 1.0; 

        public static DifferentialDrive drivetrain;

        public static final int GYRO_PORT = 13;



    //intake stuffs
        public static final int rollerMotorA = 4;
        public static final int rollerMotorB = 5;
        public static final int armTalon = 6; 

    //launcher stuffs
        public static final int LAUNCHER_MOTOR_A = 7;
        public static final int LAUNCHER_MOTOR_B = 8;
        public static final int LAUNCHER_MOTOR_C = 9;

    //hopper stuffs
        public static final int AGITATOR_MOTOR = 10;
        public static final int FUNNEL_MOTOR = 11;

    //climber stuffs
        public static final int CLIMBER_MOTOR = 12; 


}
