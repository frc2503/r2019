/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.SetLiftCylinders;

/**
 * Subsystem for everything lifting
 */
public class LiftSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static enum CylinderState {
    kExtended,
    kRetracted
  }

  private Compressor m_compressor;

  private DoubleSolenoid m_solenoidFront;
  private DoubleSolenoid m_solenoidBack;

  private Talon m_talonFoot;

  public LiftSubsystem() {
    m_compressor = new Compressor();
    m_solenoidFront = new DoubleSolenoid(RobotMap.SOLENOID_FRONT_1, RobotMap.SOLENOID_FRONT_2);
    m_solenoidBack = new DoubleSolenoid(RobotMap.SOLENOID_BACK_1, RobotMap.SOLENOID_BACK_2);
    m_talonFoot = new Talon(RobotMap.TALON_FOOT);

    // Start compressor
    m_compressor.setClosedLoopControl(true);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new SetLiftCylinders(CylinderState.kRetracted));
  }

  /**
   * Clear Pneumatic Control System sticky faults
   */
  public void clearStickyFaults() {
    m_compressor.clearAllPCMStickyFaults();
  }

  /**
   * Set the state of the front cylinder
   * @param value Solenoid value
   */
  public void setFrontCylinder(Value value) {
    m_solenoidFront.set(value);
  }

  /**
   * Set the state of the back cylinder
   * @param value Solenoid value
   */
  public void setBackCylinder(Value value) {
    m_solenoidBack.set(value);
  }

  /**
   * Drive the wheel on the back cylinder
   * @param speed Motor speed
   */
  public void driveFoot(double speed) {
    m_talonFoot.set(speed);
  }
}
