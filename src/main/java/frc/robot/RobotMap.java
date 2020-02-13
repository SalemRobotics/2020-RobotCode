package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class RobotMap {

    //drive train stuffs
        public final int driveleft_port = 1;

        public static TalonFX dt_leftrear, dt_leftfront, dt_rightrear, dt_rightfront;

        public static final int dt_leftrear_port = 0;
        public static final int dt_leftfront_port = 1;
        public static final int dt_rightrear_port = 2;
        public static final int dt_rightfront_port = 3;

        public static final double dt_deadBand = 0.02; 
        public static final double dt_maxInput = 1.0; 

        public static DifferentialDrive drivetrain;

        public static final int GYRO_PORT = 8;


    //intake stuffs
        public static final int rollerMotor = 4;
        public static final int armTalon = 5; 

    //launcher stuffs
        public static final int LAUNCHER_MOTOR_A = 6;
        public static final int LAUNCHER_MOTOR_B = 7;

    //hopper stuffs
        public static final int AGITATOR_MOTOR = 9;
        public static final int FUNNEL_MOTOR = 10;


}
