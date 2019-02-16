/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SetClamp extends Command {

  public enum ClampState {
    kClosed,
    kOpen
  }

  private ClampState m_state;
  private double m_requiredValue;

  private static final double OPENED_POSITION = 0.75;
  private static final double CLOSED_POSITION = 0.1;

  public SetClamp(ClampState state) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_intakeSystem);
    m_state = state;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    switch(m_state) {
      case kOpen:
        m_requiredValue = OPENED_POSITION;
        break;
      case kClosed:
        m_requiredValue = CLOSED_POSITION;
        break;
      default:
        break;
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_intakeSystem.setClampServo(m_requiredValue);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
    // return Math.abs(m_requiredValue - Robot.m_intakeSystem.getClampServo()) < SERVO_DEADBAND;
  }
}
