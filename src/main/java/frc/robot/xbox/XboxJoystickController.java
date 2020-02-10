package frc.robot.xbox;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * Provides a convenience wrapper to create an Xbox controller. Ensures all the
 * buttons are wired. This becomes more useful when you start having more than
 * one controller as it makes the OI a lot easier to read and understand what is
 * going on.
 * 
 * Inspired by https://github.com/Team319/frc319-2018/blob/master/src/org/usfirst/frc/team319/models/BobController.java
 */
public class XboxJoystickController extends Joystick {
	public JoystickButton xButton = new JoystickButton(this, 3);
	public JoystickButton yButton = new JoystickButton(this, 4);
	public JoystickButton aButton = new JoystickButton(this, 1);
	public JoystickButton bButton = new JoystickButton(this, 2);
	public JoystickButton rightBumper = new JoystickButton(this, 6);
	public JoystickButton leftBumper = new JoystickButton(this, 5);
	public JoystickButton startButton = new JoystickButton(this, 8);
	public JoystickButton selectButton = new JoystickButton(this, 7);
	public JoystickButton leftStickButton = new JoystickButton(this, 9);
	public JoystickButton rightStickButton = new JoystickButton(this, 10);

	public Button leftTriggerButton = new XboxLeftTrigger(this);
	public Button rightTriggerButton = new XboxRightTrigger(this);

	public XboxJoystickController(int port) {
		super(port);
	}

	public double getLeftStickX() {
		return this.getRawAxis(0);
	}

	public double getLeftStickY() {
		return -this.getRawAxis(1);
	}

	public double getRightStickX() {
		return this.getRawAxis(4);
	}

	public double getRightStickY() {
		return -this.getRawAxis(5);
	}

	public double getRightTrigger() {
		return this.getRawAxis(3);
	}

	public double getLeftTrigger() {
		return -this.getRawAxis(2);
	}

}