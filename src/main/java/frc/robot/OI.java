package frc.robot;

//Imports
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
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

		JoystickButton xButton = new JoystickButton(this, );
		JoystickButton yButton = new JoystickButton(this, );
		JoystickButton aButton = new JoystickButton(this, );
		JoystickButton bButton = new JoystickButton(this, );



	public OI(){
		initializeDefaultButtons();
	}

	private void initializeDefaultButtons(){
		
	}
	
	//Analog Stick Values
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

