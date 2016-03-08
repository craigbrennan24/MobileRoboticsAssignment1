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
public class TestBehavior implements Behavior {
	
	private String test;
	private boolean suppressed = false;
	
	public TestBehavior(){
		test = "Test";
	}
	
	public boolean takeControl() {
		return Button.LEFT.isPressed();
	}
	
	public void suppress() {
		LCD.clear();
		suppressed = true;
	}
	
	public void action() {
		test();
	}
	
	public void test() {
		LCD.drawString(test,0,0);
		Button.waitForAnyPress();
		LCD.clear();
		return;
	}
}