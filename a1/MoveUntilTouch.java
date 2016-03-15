package a1;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;

/**
 * Craig Brennan C12434322
 * Brandon Murnane C13377256
 *
 *
 * Moves forward until bump sensor detects a collision, then stops and prints "Stop"
 */
public class MoveUntilTouch implements Behavior {
	
	private DifferentialPilot pilot;
	private String text;
	private TouchSensor touch;
	private boolean touchDetected;
	private boolean suppressed = false;
	
	public MoveUntilTouch(SensorPort port){
		text = "Stop";
		pilot = new DifferentialPilot(2.25f, 5.5f, Motor.B, Motor.C);
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
		pilot.forward();
		while(!touch.isPressed()) {
			//Move until bump into object
			if(suppressed)
				return;
		}
		touchDetected = true;
		pilot.stop();
		LCD.drawString(text,0,0);
		Button.waitForAnyPress();
		return;
	}
}