/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

// import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem for the Power Distribution Panel and diagnostics
 */
public class ElectricalSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // private PowerDistributionPanel m_powerDistributionPanel;

  public ElectricalSubsystem() {
    // Disabled as temporary fix for issue #8
    // m_powerDistributionPanel = new PowerDistributionPanel();
    System.out.println("Warning: Electircal system is temporarily disabled");
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
  }

  /**
   * Clear Power Distribution Board sticky faults
   */
  public void clearStickyFaults() {
    // m_powerDistributionPanel.clearStickyFaults();
    System.out.println("Warning: Electircal system is temporarily disabled");
  }
}
