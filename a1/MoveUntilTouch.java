package a1;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;

/**
 * Craig Brennan C12434322
 * Brandon Murnane C13377256
 *
 *
 * Waits for clap sound, then prints "Claps" on the screen.
 */
public class MoveUntilTouch implements Behavior {
	
	DifferentialPilot pilot;
	private TouchSensor touch;
	private boolean touchDetected;
	private boolean suppressed = false;
	
	public MoveUntilTouch(SensorPort port){
		pilot = new DifferentialPilot();//TODO: set to correct motors
		//DifferentialPilot(float wheelDiameter, float trackWidth, Motor leftMotor, Motor rightMotor)
		//ie: = new DifferentialPilot(2.25f, 5.5f, Motor.A, Motor.C);
		touch = new TouchSensor(port);
		touchDetected = false;
	}
	
	public boolean takeControl() {
		return !touchDetected;
	}
	
	public void suppress() {
		suppressed = true;
	}
	
	public void action() {
		detectTouch();
	}
	
	public void detectTouch() {
		//TODO: move loop until bump into object
		pilot.forward();
		while(!touch.isPressed()) {
			//Move until bump into object
			if(suppressed)
				return;
		}
		pilot.stop();
		LCD.drawString("Stop",0,0);
		Button.waitForAnyPress();
		return;
	}
}