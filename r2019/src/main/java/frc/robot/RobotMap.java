/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // Drive Talons
  public static final int talonFrontLeft = 2;
  public static final int talonFrontRight = 3;
  public static final int talonBackLeft = 1;
  public static final int talonBackRight = 0;

  // Foot Talon
  public static final int talonFoot = 4;

  // Human input devices
  public static final int joystickLeft = 1;
  public static final int joystickRight = 0;

  // Solenoids
  public static final int solenoidFront1 = 0;
  public static final int solenoidFront2 = 1;
  public static final int solenoidBack1 = 2;
  public static final int solenoidBack2 = 3;
  public static final int solenoidArm1 = 4;
  public static final int solenoidArm2 = 5;

  // Hatch clamp servo
  public static final int servoClamp = 5;

  // Light relay
  public static final int relayLight = 0;
}
