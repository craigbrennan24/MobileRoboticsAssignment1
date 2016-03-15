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
	private boolean suppressed;
	private boolean heardClap;
	
	public ListenForClap(SensorPort port){
		sound = new SoundSensor(port);
		heardClap = false;
		suppressed = false;
	}
	
	public boolean takeControl() {
		return !heardClap;
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
		while(!heardClap) {
		//Loop until clap sound is heard, or break if behavior is suppressed.
			try{
				if(sound.readValue() >= 90){
					heardClap = true;
					LCD.clear();
					LCD.drawString("Claps",0,0);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(suppressed)
				return; //exit if suppressed
		}
	}
}