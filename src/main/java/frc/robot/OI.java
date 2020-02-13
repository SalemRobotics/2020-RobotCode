package frc.robot;

//Imports
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import frc.robot.commands.Intake.Intake;
import frc.robot.commands.IntakeArm.IntakeArmDownCMD;
import frc.robot.commands.IntakeArm.IntakeArmUpCMD;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot. 
 */
public class OI {
	//Controller Inits
		Joystick driverController = new Joystick(0);
		Joystick operatorController = new Joystick(1);

		//Driver Controller

		//Operator Controller
			JoystickButton aButton2 = new JoystickButton(operatorController, 0);
			JoystickButton xButton2 = new JoystickButton(operatorController, 2); 
			JoystickButton leftBumper2 = new JoystickButton(operatorController, 5);
			JoystickButton rightBumper2 = new JoystickButton(operatorController, 5);

			
		

	public OI(){
		initializeDefaultButtons();
	}

	private void initializeDefaultButtons(){
	
		aButton2.whileHeld(new Intake());
		
		/*
		leftBumper2.whileHeld(new IntakeArmUpCMD());
		rightBumper2.whileHeld(new IntakeArmDownCMD());
		*/
		
	}
	
	//Analog Driver Controller Stick Values
		public double getLeftStickX() {
			return driverController.getRawAxis(0);
		}

		public double getLeftStickY() {
			return -driverController.getRawAxis(1);
		}

		public double getRightStickX() {
			return driverController.getRawAxis(4);
		}

		public double getRightStickY() {
			return -driverController.getRawAxis(5);
		}

		public double getRightTrigger() {
			return driverController.getRawAxis(3);
		}

		public double getLeftTrigger() {
			return -driverController.getRawAxis(2);
		}

		

}

