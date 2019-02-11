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

public class SetLights extends Command {

  public static enum LightState {
    kOff,
    kOn,
    kBlinkSlow,
    kBlinkMedium,
    kBlinkFast
  }

  private Timer m_timer;
  private LightState m_state;

  public SetLights(LightState state) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_lightSystem);
    m_timer = new Timer();
    m_state = state;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    m_timer.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    switch(m_state) {
      case kOff:
        Robot.m_lightSystem.setLights(false);
        break;
      case kOn:
        Robot.m_lightSystem.setLights(true);
        break;
      case kBlinkSlow:
        if (m_timer.get() > 1.0) {
          Robot.m_lightSystem.toggleLights();
          m_timer.reset();
        }
        break;
      case kBlinkMedium:
        if (m_timer.get() > 0.5) {
          Robot.m_lightSystem.toggleLights();
          m_timer.reset();
        }
        break;
      case kBlinkFast:
        if (m_timer.get() > 0.25) {
          Robot.m_lightSystem.toggleLights();
          m_timer.reset();
        }
        break;
      default:
        Robot.m_lightSystem.setLights(false);
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
    Robot.m_lightSystem.setLights(false);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
