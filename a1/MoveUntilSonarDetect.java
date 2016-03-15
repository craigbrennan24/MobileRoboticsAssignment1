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
	
	private DifferentialPilot pilot;
	private UltrasonicSensor sonar;
	private surfaceDetected;
	private boolean suppressed = false;
	
	public MoveUntilSonarDetect(SensortPort port){
		pilot = new DifferentialPilot(2.25f, 5.5f, Motor.B, Motor.C);
		sonar = new UltrasonicSensor(port);
		surfaceDetected = false;
	}
	
	public boolean takeControl() {
		return !surfaceDetected;
	}
	
	public void suppress() {
		pilot.stop();
		suppressed = true;
	}
	
	public void action() {
		detectSonar();
	}
	
	public void detectSonar() {
		pilot.forward();
		while(sonar.getDistance() > 25 ) {
			//Loop until a surface less than 25cm away is detected
			if(suppressed)
				return;
		}
		pilot.stop();
		surfaceDetected = true;
	}
	
	public void moveScript() {
		//stop and turn 180 degrees
		//move forward 20 then stop
		//Turn 90 degrees to the right
		pilot.rotate(180.0, false);
		pilot.travel(20.0, false);
		pilot.rotate(-90.0, false);
	}
}