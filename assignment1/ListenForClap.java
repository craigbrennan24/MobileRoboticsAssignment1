package assignment1;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;

/**
 * Waits for clap sound, then prints "Claps" on the screen.
 */
public class ListenForClap implements Behavior {
	private SoundSensor sound = new SoundSensor(SensorPort.S2);
	private boolean suppressed = false;
	
	public boolean takeControl() {
		return true;
	}
	
	public void suppress() {
		suppressed = true;
	}
	
	public void action() {
		LCD.clear();
		LCD.drawString("Assignment 1",0,0);
		Button.waitForAnyPress();
		LCD.clear();
	}
	
	public void listen() {
		
	}
}