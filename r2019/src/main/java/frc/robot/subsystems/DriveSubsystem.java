/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

/**
 * Subsystem for interacting with the 4 drive motors
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private DifferentialDrive m_drive;

  public DriveSubsystem() {
    // This constructor is called on robotInit

    // 4 Talon SRs are used to control our drive motors
    SpeedControllerGroup leftTalons = new SpeedControllerGroup(
      new Talon(RobotMap.TALON_FRONT_LEFT),
      new Talon(RobotMap.TALON_BACK_LEFT)
    );
    SpeedControllerGroup rightTalons = new SpeedControllerGroup(
      new Talon(RobotMap.TALON_FRONT_RIGHT),
      new Talon(RobotMap.TALON_BACK_RIGHT)
    );

    // Differential drive
    m_drive = new DifferentialDrive(leftTalons, rightTalons);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
  }

  /**
   * Drive by controlling the left and right wheels
   * Note: This function must be called constantly in order to ensure
   * motor safety
   * @param left Speed of the left motors
   * @param right Speed of the right motors
   */
  public void driveTank(double left, double right) {
    m_drive.tankDrive(left, right, false);
  }
}
