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
  public static final int TALON_FRONT_LEFT = 2;
  public static final int TALON_FRONT_RIGHT = 3;
  public static final int TALON_BACK_LEFT = 1;
  public static final int TALON_BACK_RIGHT = 0;

  // Foot Talon
  public static final int TALON_FOOT = 4;

  // Human input devices
  public static final int JOYSTICK_LEFT = 1;
  public static final int JOYSTICK_RIGHT = 0;

  // Solenoids
  public static final int SOLENOID_FRONT_1 = 0;
  public static final int SOLENOID_FRONT_2 = 1;
  public static final int SOLENOID_BACK_1 = 2;
  public static final int SOLENOID_BACK_2 = 3;
  public static final int SOLENOID_ARM_1 = 4;
  public static final int SOLENOID_ARM_2 = 5;

  // Hatch clamp servo
  public static final int SERVO_CLAMP = 5;

  // Light relay
  public static final int RELAY_LIGHTS = 0;
}
