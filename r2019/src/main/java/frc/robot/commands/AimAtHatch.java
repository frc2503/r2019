/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AimAtHatch extends Command {
  private NetworkTableEntry m_tapeTurn;
  public AimAtHatch() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_driveSystem);
    System.out.println("HATCH");
    m_tapeTurn = NetworkTableInstance.getDefault().getTable("TapeFinder").getEntry("tapeTurn");
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double turnAmount = m_tapeTurn.getNumber(0.0).doubleValue();
    // double turnSpeed = turnAmount / -160.0;
    // if (Math.abs(turnSpeed) < 0.25) {
    //   turnSpeed *= 1 / (30 - Math.abs(turnAmount));
    // }
    double turnSpeed = 0.4;
    if (turnAmount > 0) {
      turnSpeed *= -1.0;
    } 
    if (Math.abs(turnAmount) < 30) {
      turnSpeed *= 0;
    }
    System.out.println(turnAmount + ", " + turnSpeed);
    Robot.m_driveSystem.driveTank(turnSpeed, -turnSpeed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_driveSystem.driveTank(0.0, 0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
