/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveTrapezoid extends Command {

  private double m_time;
  private double m_targetSpeed;
  private double m_leftFactor;
  private double m_rightFactor;

  private double m_accelTime;
  private double m_decelTime;
  private double m_cruiseTime;

  private Timer m_timer;

  // Magic numbers
  private final double m_kDefaultAccelTime = 0.5;
  private final double m_kDefaultDecelTime = 0.5;

  /**
   * Drive autonomously with a trapezoidal motion profile
   * @param time Time to drive
   * @param targetSpeed Velocity to travel at
   * @param leftFactor Left track speed multiplier. -1.0 for backwards, etc
   * @param rightFactor Right track speed multiplier. -1.0 for backwards, etc
   */
  public DriveTrapezoid(double time, double targetSpeed, double leftFactor, double rightFactor) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_driveSystem);

    m_time = time;
    m_targetSpeed = targetSpeed;
    m_leftFactor = leftFactor;
    m_rightFactor = rightFactor;

    m_timer = new Timer();
  }

  /**
   * Drive autonomously with a trapezoidal motion profile
   * @param time Time to drive
   * @param targetSpeed Velocity to travel at
   */
  public DriveTrapezoid(double time, double targetSpeed) {
    this(time, targetSpeed, 1.0, 1.0);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // Calculate acceleration and deceleration times
    // This is an approximation and needs to be adjusted
    // For accel, do either 1.0 seconds or half of the path time.
    // Worse case scenario, our motion profile will be a triangle
    m_accelTime = Math.min(m_kDefaultAccelTime, m_time / 2.0);
    m_decelTime = Math.min(m_kDefaultDecelTime, m_time / 2.0);

    // Cruise time is when we are neither accelerating or decelerating
    m_cruiseTime = m_time - m_accelTime - m_decelTime;
    m_timer.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // Accelerate, cruise, then decelerate
    if (m_timer.get() < m_accelTime) {
      // Accelerate
      double accelFactor = Math.min(m_timer.get() / m_accelTime, 1.0);
      double leftSpeed = m_targetSpeed * accelFactor * m_leftFactor;
      double rightSpeed = m_targetSpeed * accelFactor * m_rightFactor;
      Robot.m_driveSystem.driveTank(leftSpeed, rightSpeed);
    } else if (m_timer.get() < m_accelTime + m_cruiseTime) {
      // Cruise
      double leftSpeed = m_targetSpeed * m_leftFactor;
      double rightSpeed = m_targetSpeed * m_rightFactor;
      Robot.m_driveSystem.driveTank(leftSpeed, rightSpeed);
    } else if (m_timer.get() < m_accelTime + m_cruiseTime + m_decelTime) {
      // Decelerate
      double decelFactor = Math.max(m_time - m_timer.get() / m_decelTime, 0.0);
      double leftSpeed = m_targetSpeed * decelFactor * m_leftFactor;
      double rightSpeed = m_targetSpeed * decelFactor * m_rightFactor;
      Robot.m_driveSystem.driveTank(leftSpeed, rightSpeed);
    } else {
      // Stop
      Robot.m_driveSystem.driveTank(0.0, 0.0);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return m_timer.get() > m_time;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    // Stop the robot
    Robot.m_driveSystem.driveTank(0.0, 0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
