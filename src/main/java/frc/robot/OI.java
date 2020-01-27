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

    Joystick xboxMain = new Joystick(0);

	public double getLeftStickX() {
		return xboxMain.getRawAxis(0);
	}

	public double getLeftStickY() {
		return -xboxMain.getRawAxis(1);
	}

	public double getRightStickX() {
		return xboxMain.getRawAxis(4);
	}

	public double getRightStickY() {
		return -xboxMain.getRawAxis(5);
	}

	public double getRightTrigger() {
		return xboxMain.getRawAxis(3);
	}

	public double getLeftTrigger() {
		return -xboxMain.getRawAxis(2);
	}

	

}

