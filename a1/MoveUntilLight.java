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
public class MoveUntilLight implements Behavior {
	
	private LightSensor light;
	private foundLightSurface;
	private boolean suppressed = false;
	
	public MoveUntilLight(SensorPort port){
		light = new LightSensor(port);
		foundLightSurface = false;
	}
	
	public boolean takeControl() {
		return !foundLightSurface;
	}
	
	public void suppress() {
		LCD.clear();
		suppressed = true;
	}
	
	public void action() {
	}
}