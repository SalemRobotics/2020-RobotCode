package frc.robot.xbox;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Button;

/**
 * Taken from https://github.com/Team319/frc319-2018/blob/master/src/org/usfirst/frc/team319/models/XboxRightTrigger.java
 * @author mwtidd
 */
public class XboxRightTrigger extends Button {
	private final Joystick joystick;

	public XboxRightTrigger(Joystick joystick) {
		this.joystick = joystick;

	}

	public boolean get() {
		return joystick.getRawAxis(3) > .25;
	}
}