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
public class ListenForClap implements Behavior {
	
	private SoundSensor sound;
	private boolean suppressed = false;
	
	public ListenForClap(SensorPort port){
		sound = new SoundSensor(port);
	}
	
	public boolean takeControl() {
		return Button.RIGHT.isPressed();
	}
	
	public void suppress() {
		LCD.clear();
		suppressed = true;
	}
	
	public void action() {
		suppressed = false;
		listen();
	}
	
	public void listen() {
		try {
			//Sound test, displays sound reading whenever Right key is pressed
			LCD.clear();
			LCD.drawString(String.valueOf(sound.readValue()),0,0);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}