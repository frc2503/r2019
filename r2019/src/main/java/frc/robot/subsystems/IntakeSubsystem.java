/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ResetIntake;

/**
 * Subsystem used to grab hatch panels
 */
public class IntakeSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private DoubleSolenoid m_solenoidArm;
  private Servo m_servoClamp;

  public IntakeSubsystem() {
    m_solenoidArm = new DoubleSolenoid(RobotMap.solenoidArm1, RobotMap.solenoidArm2);
    m_servoClamp = new Servo(RobotMap.servoClamp);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ResetIntake());
  }

  /**
   * Set the value of the clamp servo
   * @param value The value of the servo from 0 to 1.0
   */
  public void setClampServo(double value) {
    m_servoClamp.set(value);
  }

  /**
   * Get the value of the clamp servo
   * @return The value of the clamp servo
   */
  public double getClampServo() {
    return m_servoClamp.get();
  }

  /**
   * Set the state of the cylinder
   * @param value Solenoid value
   */
  public void setCylinder(Value value) {
    m_solenoidArm.set(value);
  }

}
