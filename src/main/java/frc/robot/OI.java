package frc.robot;

//Imports
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import frc.robot.xbox.*;

// Commands
import frc.robot.commands.Intake.Intake;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot. 
 */
public class OI {

	// Driver Controller (init)
	public XboxJoystickController driverController = new XboxJoystickController(0);
	public XboxJoystickController operatorController = new XboxJoystickController(1);
	

	public OI() {

		initializeDefaultButtons();		



	private void initializeDefaultButtons(){
	
		aButton2.whileHeld(new Intake());
		
		

	}

	private void initializeDefaultButtons() {
/*
		// Pneumatics
		driverController.startButton.whenPressed(new HatchPistonIn());
		driverController.selectButton.whenPressed(new HatchPistonOut());
		driverController.bButton.whenPressed(new MechIn());
		driverController.xButton.whenPressed(new MechOut());

		// Wrist
		// currently you can control the wrist by both the left joystick and these buttons
		operatorController.aButton.whileHeld(new WristUp());
		operatorController.yButton.whileHeld(new WristDown());

		
		//Intake
		operatorController.leftBumper.whileHeld(new TakeIn());
		operatorController.rightBumper.whileHeld(new TakeOut());
		operatorController.xButton.whileHeld(new IntakeHold());

		// Elevator
		driverController.leftBumper.whenPressed(new LiftUpWhileHeld());
		driverController.leftBumper.whenReleased(new StopElevator());
		driverController.rightBumper.whenPressed(new LiftDownWhileHeld());
		driverController.rightBumper.whenReleased(new StopElevator());

		//driverController.yButton.whenPressed(new ManualPositionalElevator);
		//driverController.selectButton.whenPressed(new ResetElevator);

		// Drive Train
		driverController.aButton.whenPressed(new ToggleDriveMode());
*/
	}

	// Analog Stick Values
	public double getDriveX() {
		return driverController.getRightStickX()*Math.abs(driverController.getRightStickX()*.5);
	}

	public double getDriveY() {
		return driverController.getRawAxis(1)*Math.abs(driverController.getRawAxis(1));
	}

	public double elevatorTriggers(){
		double value = driverController.getRawAxis(3);
		return driverController.getRawAxis(2)*.4 - value;
	}

	public double getElevatorPower() {
		double stick = -operatorController.getLeftStickY();
		stick *= Math.abs(stick);
		if (Math.abs(stick) < 0.05) {
			stick = 0;
		}
		return stick;
	}
}