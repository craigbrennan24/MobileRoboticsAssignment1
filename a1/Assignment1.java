package a1;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;

/**
 * Mobile Robotics Assignment 1
 * Craig Brennan C12434322
 * Brandon Murnane C13377256
 */
public class Assignment1 {
  Behavior [] behaviors;
  Arbitrator arby;
  
  public void start(){
	  //Prints "Assignment 1" and waits for button to be pressed to begin
	  LCD.clear();
	  LCD.drawString("Assignment 1",0,0);
	  Button.waitForAnyPress();
	  LCD.clear();
  }
  
  public void setup() {
	  //Setup behaviors into behavior array
	  //Behavior b1 = new ListenForClap(SensorPort.S1);
	  Behavior b1 = new TestBehavior();
	  Behavior b2 = new ListenForClap(SensorPort.S1);
	  behaviors = new Behavior[]{ b2 };
	  arby = new Arbitrator(behaviors);
  }

  public static void main(String[] args) throws Exception {
	  Assignment1 robot = new Assignment1();
	  robot.setup();
	  robot.start();
	  robot.arby.start();
  }
}