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
		suppressed = false;
		listen();
	}
	
	public void listen() {
		try {
			//TEST: listen for 2 seconds and display sound readings
			LCD.clear();
			for(int i = 0;i < 100; i++) {
				LCD.setPixel(1,i,60-(sound.readValue()/2));
				Thread.sleep(20);
				if(suppressed)
					return; //exit is method is suppressed
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}