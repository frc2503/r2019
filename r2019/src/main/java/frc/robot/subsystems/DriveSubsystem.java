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
import frc.robot.commands.DriveHuman;

/**
 * Subsystem for interacting with the 4 drive motors
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // Talon SRs are used to control our 4 drive motors
  private Talon m_talonFrontLeft;
  private Talon m_talonFrontRight;
  private Talon m_talonBackLeft;
  private Talon m_talonBackRight;

  private SpeedControllerGroup m_leftTalons;
  private SpeedControllerGroup m_rightTalons;

  private DifferentialDrive m_drive;

  public DriveSubsystem() {
    // This constructor is called on robotInit
    m_talonFrontLeft = new Talon(RobotMap.TALON_FRONT_LEFT);
    m_talonFrontRight = new Talon(RobotMap.TALON_FRONT_RIGHT);
    m_talonBackLeft = new Talon(RobotMap.TALON_BACK_LEFT);
    m_talonBackRight = new Talon(RobotMap.TALON_BACK_RIGHT);

    // Group Talons
    m_leftTalons = new SpeedControllerGroup(m_talonFrontLeft, m_talonBackLeft);
    m_rightTalons = new SpeedControllerGroup(m_talonFrontRight, m_talonBackRight);

    // Invert left side
    m_leftTalons.setInverted(true);

    // Differential drive
    m_drive = new DifferentialDrive(m_leftTalons, m_rightTalons);
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
    m_drive.tankDrive(left, right, false);
  }
}
