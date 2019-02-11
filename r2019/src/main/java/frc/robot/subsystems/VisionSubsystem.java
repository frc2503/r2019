/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem for our USB webcam
 */
public class VisionSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public VisionSubsystem() {
    // Just use the only camera plugged in.
    // If we need more cameras, they will need to be indexed
    UsbCamera mainCamera = CameraServer.getInstance().startAutomaticCapture();
    // FIXME: Lower to meet bandwidth requirements
    mainCamera.setResolution(640, 480);
    mainCamera.setFPS(24);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
  }
}
