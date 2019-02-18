/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.RaiseSolenoids;
import frc.robot.commands.SetBackCylinder;
import frc.robot.commands.SetFrontCylinder;
import frc.robot.subsystems.CylinderState;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public Joystick m_leftStick;
  public Joystick m_rightStick;
  public Joystick m_gamepad;

  // private JoystickButton m_left4;
  // private JoystickButton m_right4;

  private JoystickButton m_left3;
  private JoystickButton m_right3;

  private JoystickButton m_right5;

  public OI() {
    m_leftStick = new Joystick(RobotMap.joystickLeft);
    m_rightStick = new Joystick(RobotMap.joystickRight);
    m_gamepad = new Joystick(RobotMap.gamepad);

    // m_left4 = new JoystickButton(m_leftStick, 4);
    // m_right4 = new JoystickButton(m_rightStick, 4);
    m_left3 = new JoystickButton(m_leftStick, 3);
    m_right3 = new JoystickButton(m_rightStick, 3);
    m_right5 = new JoystickButton(m_rightStick, 5);
    
    m_left3.whenPressed(new SetBackCylinder(CylinderState.kRetracted));
    // m_left4.whenPressed(new SetBackCylinder(CylinderState.kExtended));

    m_right3.whenPressed(new SetFrontCylinder(CylinderState.kRetracted));
    // m_right4.whenActive(new SetFrontCylinder(CylinderState.kExtended));

    m_right5.whenPressed(new RaiseSolenoids());
  }
}
