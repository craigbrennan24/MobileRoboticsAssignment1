package assignment1;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;

/**
 * Mobile Robotics Assignment 1
 * Craig Brennan
 * Brandon Murnane
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
	  Behavior b1 = new ListenForClap();
	  behaviors = new Behavior[]{ b1 };
	  arby = new Arbitrator(behaviors);
  }

  public static void main(String[] args) {
	  Assignment1 robot = new Assignment1();
	  robot.setup();
	  robot.start();
	  robot.arby.start();
  }
}