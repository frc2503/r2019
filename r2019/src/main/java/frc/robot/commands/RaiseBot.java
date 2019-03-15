/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.robot.subsystems.CylinderState;

public class RaiseBot extends CommandGroup {
  
  public RaiseBot() {

    addParallel(new SetFrontCylinder(CylinderState.kExtended));
    addSequential(new WaitCommand(0.1));
    addParallel(new SetBackCylinder(CylinderState.kExtended));
  }
}
