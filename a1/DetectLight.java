package a1;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;

/**
 * Craig Brennan C12434322
 * Brandon Murnane C13377256
 *
 *
 * Moves forward until a light surface is detected underneath.
 */
public class DetectLight implements Behavior {
	
	private LightSensor light;
	private boolean suppressed = false;
	
	public DetectLight(SensorPort port){
		light = new LightSensor(port);
	}
	
	public boolean takeControl() {
		return true;
	}
	
	public void suppress() {
		LCD.clear();
		suppressed = true;
	}
	
	public void action() {
	}
}