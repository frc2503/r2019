/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.ProcessPneumatics;

/**
 * Add your docs here.
 */
public class PneumaticsSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private Compressor m_compressor;

  public PneumaticsSubsystem() {
    m_compressor = new Compressor();

    m_compressor.setClosedLoopControl(true);
    m_compressor.start();
    System.out.println("Set closed loop control for compressor");
  }

  public void clearStickyFaults() {
    m_compressor.clearAllPCMStickyFaults();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ProcessPneumatics());
  }

  public boolean getPressureSwitch() {
    return m_compressor.getPressureSwitchValue();
  }

  public double getCompressorCurrent() {
    return m_compressor.getCompressorCurrent();
  }
}
