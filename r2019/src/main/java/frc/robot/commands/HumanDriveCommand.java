/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class HumanDriveCommand extends Command {

  private Joystick m_leftStick;
  private Joystick m_rightStick;

  public HumanDriveCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_driveSystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    m_leftStick = Robot.m_oi.m_leftStick;
    m_rightStick = Robot.m_oi.m_rightStick;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // Get left and right values from joysticks
    double leftVal = m_leftStick.getY();
    double rightVal = m_rightStick.getY();

    // The values need to be inverted because we want "up" on the controller to
    // be forward, which is positive

    leftVal = leftVal * -1.0;
    rightVal = rightVal * -1.0;

    // The robot is much easier to control when the inputs from the joysticks
    // are quadratic instead of linear. This allows for finer control at lower speeds
    // while still being able to reach full speed.

    // Squaring the input here would not work here because the sign of the input needs
    // to be preserved in order to drive backwards

    leftVal = leftVal * Math.abs(leftVal);
    rightVal = rightVal * Math.abs(rightVal);

    // Drive
    Robot.m_driveSystem.driveTank(leftVal, rightVal);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
