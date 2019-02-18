/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.DriveHuman;

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
    // Both Talons on either side use the same PWM signal
    Talon leftTalons = new Talon(RobotMap.talonsLeft);
    Talon rightTalons = new Talon(RobotMap.talonsRight);

    leftTalons.setInverted(true);
    rightTalons.setInverted(true);

    // Differential drive
    m_drive = new DifferentialDrive(leftTalons, rightTalons);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveHuman());
  }

  /**
   * Drive by controlling the left and right wheels
   * Note: This function must be called constantly in order to ensure
   * motor safety
   * @param left Speed of the left motors
   * @param right Speed of the right motors
   */
  public void driveTank(double left, double right) {
    // SmartDashboard
    System.out.println("Driving");
    SmartDashboard.putNumber("leftTrack", left);
    SmartDashboard.putNumber("rightTrack", right);
    
    m_drive.tankDrive(left, right, false);
  }
}
