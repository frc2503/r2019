/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveFoot extends Command {
  public DriveFoot() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_footSystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double val = Robot.m_oi.m_leftStick.getY() * -0.5;
    System.out.println("Setting foot to " + val);
    if (Robot.m_oi.m_leftStick.getRawButton(2)) {
      Robot.m_footSystem.setFoot(val * -1.0);
    } else {
      Robot.m_footSystem.setFoot(0.0);;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_footSystem.setFoot(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}