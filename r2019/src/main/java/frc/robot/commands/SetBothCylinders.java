/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.subsystems.LiftSubsystem.CylinderState;

public class SetBothCylinders extends CommandGroup {
  /**
   * Set the state of both cylinders
   */
  public SetBothCylinders(CylinderState state) {
    addParallel(new SetFrontCylinder(state));
    addSequential(new SetBackCylinder(state));
  }
}
