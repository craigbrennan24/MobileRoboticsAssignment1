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
  
  public void setup() {
	  //Setup behaviors into behavior array
	  //*****************************************************************************************************
	  //*     NOTE                                                                                          *
	  //* I could not make it into the lab on 15/3/2016 so I do not know the correct ports for the hardware,*
	  //* but the code should be correct. simply a matter of entering the correct ports here before running *
	  //*****************************************************************************************************
	  Behavior b1 = new Start();
	  Behavior b2 = new ListenForClap(/*Add Sensorport*/);
	  Behavior b3 = new MoveUntilLight(/*Add Sensorport*/);
	  Behavior b4 = new MoveUntilSonarDetect(/*Add Sensorport*/);
	  Behavior b5 = new MoveUntilTouch(/*Add Sensorport*/);
	  behaviors = new Behavior[]{ b5, b4, b3, b2, b1 };//Entered into array in reverse because Arbitrator
														   //assigns priority as the size of the element's array index
														   //ie, higher index = higher priority
	  arby = new Arbitrator(behaviors);
  }

  public static void main(String[] args) throws Exception {
	  Assignment1 robot = new Assignment1();
	  robot.setup(); //Set up behaviours
	  robot.arby.start(); //Start the arbitrator
  }
}