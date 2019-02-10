/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.SetClamp.ClampState;
import frc.robot.subsystems.LiftSubsystem.CylinderState;

public class ResetIntake extends CommandGroup {
  /**
   * Set the intake to the default position
   */
  public ResetIntake() {
    addParallel(new SetIntakeCylinder(CylinderState.kRetracted));
    addSequential(new SetClamp(ClampState.kClosed));
  }
}
