/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
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

  public DriveSubsystem() {
    // This constructor is called on robotInit
    m_talonFrontLeft = new Talon(RobotMap.TALON_FRONT_LEFT);
    m_talonFrontRight = new Talon(RobotMap.TALON_FRONT_RIGHT);
    m_talonBackLeft = new Talon(RobotMap.TALON_BACK_LEFT);
    m_talonBackRight = new Talon(RobotMap.TALON_BACK_RIGHT);

    // Invert the Talons which are mounted backwards
    m_talonFrontLeft.setInverted(true);
    m_talonBackLeft.setInverted(true);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
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
    m_talonFrontLeft.set(left);
    m_talonFrontRight.set(right);
    m_talonBackLeft.set(left);
    m_talonBackRight.set(right);
  }
}
