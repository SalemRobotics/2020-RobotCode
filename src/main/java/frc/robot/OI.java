package frc.robot;

//Imports
import edu.wpi.first.wpilibj.buttons.Trigger;
import frc.robot.commands.Intake.Intake;
import frc.robot.commands.IntakeArm.IntakeArmDownCMD;
import frc.robot.commands.IntakeArm.IntakeArmUpCMD;
import frc.robot.subsystems.Hopper;
import frc.robot.xbox.XboxJoystickController;
import frc.robot.commands.Hopper.*;
import frc.robot.commands.Launcher.LaunchCMD;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot. 
 */
public class OI {

	//Controller Inits
	XboxJoystickController driverController = new XboxJoystickController(0);
	XboxJoystickController operatorController = new XboxJoystickController(1);			

	public OI(){

		initializeDefaultButtons();

	}

	private void initializeDefaultButtons(){
	
		//Operator Buttons
		operatorController.xButton.whileHeld(new Intake());
		operatorController.aButton.whileHeld(new Agitate());
		operatorController.yButton.whileHeld(new LaunchCMD());
		
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
			return driverController.getRawAxis(2);
		}

		//Analog Operator Controller Stick Values
		public double opLeftStickX() {
			return operatorController.getRawAxis(0);
		}

		public double opLeftStickY() {
			return -operatorController.getRawAxis(1);
		}

		public double opRightStickX() {
			return operatorController.getRawAxis(4);
		}

		public double opRightStickY() {
			return -operatorController.getRawAxis(5);
		}

		public double opRightTrigger() {
			return operatorController.getRawAxis(3);
		}

		public double opLeftTrigger() {
			return operatorController.getRawAxis(2);
		}

		

}

