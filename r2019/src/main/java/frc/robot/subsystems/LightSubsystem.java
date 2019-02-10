/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.SetLights;
import frc.robot.commands.SetLights.LightState;

/**
 * The light subsystem is used for diagnostics
 */
public class LightSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private Relay m_lightRelay;

  public LightSubsystem() {
    m_lightRelay = new Relay(RobotMap.RELAY_LIGHTS);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new SetLights(LightState.kOff));
  }

  /**
   * Turn the lights on or off
   * @param on If the lights should be on
   */
  public void setLights(boolean on) {
    // Relay acts as an electronic switch
    m_lightRelay.set(on ? Value.kOn : Value.kOff);
  }

  /**
   * Toggle lights
   */
  public void toggleLights() {
    // If not off, then it's on
    if (m_lightRelay.get() == Value.kOff) {
      setLights(true);
    } else {
      setLights(false);
    }
  }
}
