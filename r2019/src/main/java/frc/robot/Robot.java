/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  // Operator input
  public static OI m_oi;

  // Subsystems
  public static DriveSubsystem m_driveSystem;
  public static ElectricalSubsystem m_electicalSystem;
  public static BackLiftSubsystem m_backLiftSystem;
  public static FrontLiftSubsystem m_frontLiftSystem;
  public static PneumaticsSubsystem m_pneumaticSystem;
  public static ElevatorSubsystem m_elevatorSystem;
  public static FootSubsystem m_footSystem;

  private Command m_autoCommand;

  private SendableChooser<Command> m_autoChooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    // Subsystems
    m_driveSystem = new DriveSubsystem();
    m_backLiftSystem = new BackLiftSubsystem();
    m_frontLiftSystem = new FrontLiftSubsystem();
    m_elevatorSystem = new ElevatorSubsystem();
    m_footSystem = new FootSubsystem();
    m_pneumaticSystem = new PneumaticsSubsystem();
    m_electicalSystem = new ElectricalSubsystem();
    System.out.println("Subsystems Ready");

    // m_autoChooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Autonomous Routine", m_autoChooser);

    // Clear sticky faults
    m_pneumaticSystem.clearStickyFaults();
    
    System.out.println("Sticky faults cleared");

    // Operator Input
    m_oi = new OI();
    System.out.println("Operator Input Ready");

    System.out.println("READY TO LAUNCH");
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    // Cancel the auto command
    if (m_autoCommand != null) {
      m_autoCommand.cancel();
    }

    m_autoCommand = m_autoChooser.getSelected();
    if (m_autoCommand != null) {
      m_autoCommand.start();
    }

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // Cancel the auto command
    if (m_autoCommand != null) {
      m_autoCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }
}
