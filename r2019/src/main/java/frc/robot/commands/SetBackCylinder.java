/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.CylinderState;

public class SetBackCylinder extends Command {

  private Timer m_timer;
  private CylinderState m_state;

  // Time it takes to extend or retract
  private static final double ACTUATE_TIME = 2.0;

  public SetBackCylinder(CylinderState state) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_backLift);
    m_state = state;
    m_timer = new Timer();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    m_timer.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // Set solenoid value
    switch (m_state) {
      case kExtended:
        Robot.m_backLift.setCylinder(Value.kForward);
        break;
      case kRetracted:
        Robot.m_backLift.setCylinder(Value.kReverse);
        break;
      default:
        break;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    // Wait until the command has run for ACTUATE_TIME seconds
    return m_timer.get() > ACTUATE_TIME;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_backLift.setCylinder(Value.kOff);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
