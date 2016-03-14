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
	
	private TouchSensor touch;
	private boolean touchDetected;
	private boolean suppressed = false;
	
	public MoveUntilTouch(SensorPort port){
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
		return;
	}
}