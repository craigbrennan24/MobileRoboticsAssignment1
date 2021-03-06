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
	
	private DifferentialPilot pilot;
	private LightSensor light;
	private foundLightSurface;
	private boolean suppressed = false;
	
	public MoveUntilLight(SensorPort port){
		pilot = new DifferentialPilot(2.25f, 5.5f, Motor.B, Motor.C);
		light = new LightSensor(port);
		foundLightSurface = false;
	}
	
	public boolean takeControl() {
		return !foundLightSurface;
	}
	
	public void suppress() {
		pilot.stop();
		suppressed = true;
	}
	
	public void action() {
		detectLight();
	}
	
	public void detectLight() {
		pilot.forward();
		while(light.getLightValue() < 50 ) {
			//Loop until found light
			if(suppressed)
				return;
		}
		pilot.stop();
		foundLightSurface = true;
		moveScript();
	}
	
	public void moveScript() {
		//turn 90 degrees to the left
		pilot.rotate(90.0, false);//Do not immediately return, wait until movement is comlete
	}
}