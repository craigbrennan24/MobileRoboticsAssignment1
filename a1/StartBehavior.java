package a1;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;

/**
 * Craig Brennan C12434322
 * Brandon Murnane C13377256
 *
 *
 * Prints "Assignment 1" on the screen and waits for button press
 */
public class Start implements Behavior {
	
	private boolean complete;
	private String text;
	private boolean suppressed = false;
	
	public Start(){
		text = "Assignment 1";
		complete = false;
	}
	
	public boolean takeControl() {
		return !complete;
	}
	
	public void suppress() {
		LCD.clear();
		suppressed = true;
	}
	
	public void action() {
		start();
	}
	
	public void start() {
		LCD.drawString(text,0,0);
		Button.waitForAnyPress();
		complete = true;
		LCD.clear();
		return;
	}
}