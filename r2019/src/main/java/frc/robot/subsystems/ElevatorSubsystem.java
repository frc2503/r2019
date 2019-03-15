/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.SetElevator;

/**
 * Add your docs here.
 */
public class ElevatorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static enum ElevatorState {
    kUp,
    kDown,
    kOff
  }

  private Talon m_elevatorTalon;
  private DigitalInput m_bottomSwitch;
  private DigitalInput m_topSwitch;

  public ElevatorSubsystem() {
    m_elevatorTalon = new Talon(RobotMap.talonElevator);
    m_bottomSwitch = new DigitalInput(RobotMap.switchBottom);
    m_topSwitch = new DigitalInput(RobotMap.switchTop);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new SetElevator());
  }

  public void setElevator(double value) {
    // System.out.println("top: " + (!m_topSwitch.get() ? "TRUE" : "FALSE"));
    // System.out.println("bottom: " + (!m_bottomSwitch.get() ? "TRUE" : "FALSE"));
    if (value < 0.0 && m_topSwitch.get()) {
      m_elevatorTalon.set(value);
      // System.out.println("talon set " + value);
    } else if (value > 0.0 && m_bottomSwitch.get()) {
      m_elevatorTalon.set(value);
      // System.out.println("talon set " + value);
    } else {
      m_elevatorTalon.set(0.0);
      // System.out.println("talon set " + 0);
    }
    
  }
}
