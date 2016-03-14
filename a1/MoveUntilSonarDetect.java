package a1;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;

/**
 * Craig Brennan C12434322
 * Brandon Murnane C13377256
 *
 *
 * Moves forward until detecting a hard surface by sonar at less than 25cm distance
 */
public class MoveUntilSonarDetect implements Behavior {
	
	private UltrasonicSensor sonar;
	private surfaceDetected;
	private boolean suppressed = false;
	
	public MoveUntilSonarDetect(SensortPort port){
		sonar = new UltrasonicSensor(port);
		surfaceDetected = false;
	}
	
	public boolean takeControl() {
		return !surfaceDetected;
	}
	
	public void suppress() {
		suppressed = true;
	}
	
	public void action() {
		detectSonar();
	}
	
	public void detectSonar() {
		while(sonar.getDistance() > 25 ){
			//TODO: add move forward loop here
			if(suppressed)
				return;
		}
		surfaceDetected = true;
	}
	
	public void moveScript() {
		//TODO: add move script here
		//stop and turn 180
		//move forward 20 then stop
		//Turn 90 to the right
		if(suppressed)
			return;
	}
}