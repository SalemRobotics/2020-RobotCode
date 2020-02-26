package frc.robot.xbox;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Button;

/**
 * Taken from https://github.com/Team319/frc319-2018/blob/master/src/org/usfirst/frc/team319/models/XboxLeftTrigger.java
 * @author mwtidd
 */
public class XboxLeftTrigger extends Button {
	private final Joystick joystick;

	public XboxLeftTrigger(Joystick joystick) {
		this.joystick = joystick;

	}

	public boolean get() {
		return joystick.getRawAxis(2) > .25;
	}
}