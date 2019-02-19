/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SetElevator extends Command {

  private static final double kElevatorSpeed = 0.25;

  public SetElevator() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_elevatorSystem);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    switch (Robot.m_oi.m_gamepad.getPOV()) {
      case 0:
        Robot.m_elevatorSystem.setElevator(kElevatorSpeed * -1);
        break;
      case 180:
        Robot.m_elevatorSystem.setElevator(kElevatorSpeed);
        break;
      default:
        Robot.m_elevatorSystem.setElevator(0.0);
        break;
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
    Robot.m_elevatorSystem.setElevator(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
