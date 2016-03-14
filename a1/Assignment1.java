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
	  Behavior b1 = new StartBehavior();
	  Behavior b2 = new ListenForClap(SensorPort.S1);
	  Behavior b3 = new MoveUntilLight(/*Add Sensorport*/);
	  Behavior b4 = new MoveUntilSonarDetect(/*Add Sensorport*/);
	  Behavior b5 = new MoveUntilTouch(/*Add Sensorport*/);
	  behaviors = new Behavior[]{ b6, b5, b4, b3, b2, b1 };//Entered into array in reverse because Arbitrator
														   //assigns priority as the size of the array index
														   //ie, higher index = higher priority
	  arby = new Arbitrator(behaviors);
  }

  public static void main(String[] args) throws Exception {
	  Assignment1 robot = new Assignment1();
	  robot.setup();
	  robot.start();
	  robot.arby.start();
  }
}