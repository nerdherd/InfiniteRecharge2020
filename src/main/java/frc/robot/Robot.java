/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.nerdherd.lib.drivetrain.auto.DriveStraightContinuous;
import com.nerdherd.lib.drivetrain.teleop.ArcadeDrive;
import com.nerdherd.lib.logging.LoggableLambda;
import com.nerdherd.lib.logging.NerdyBadlog;
import com.nerdherd.lib.misc.AutoChooser;
import com.nerdherd.lib.motor.dual.DualMotorIntake;
import com.nerdherd.lib.motor.single.SingleMotorTalonSRX;

import edu.wpi.first.hal.PDPJNI;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.OI;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  public static AutoChooser chooser;
  public static Drive drive;
  public static Shooter shooter;
  public static DualMotorIntake feeder;
  public static Intake intake;
  public static SingleMotorTalonSRX intakeroll;
  public static SingleMotorTalonSRX index;
  // public static SingleMotorTalonSRX motor;
  public static PowerDistributionPanel pdp;
  public static OI oi;
  public static Command m_autonomousCommand;

  
  @Override
  public void robotInit() {
    drive = new Drive();
    shooter = new Shooter();
    // motor = new SingleMotorTalonSRX(6, "Motor", true, true);
    feeder = new DualMotorIntake(new SingleMotorTalonSRX(5, "Top Intake", true, false), new SingleMotorTalonSRX(6, "Bottom Intake", false, false));
    intake = new Intake();
    index = new SingleMotorTalonSRX(21, "Index", false, true);
    intakeroll = new SingleMotorTalonSRX(12, "Intake", true, true);
    chooser = new AutoChooser();
    pdp = new PowerDistributionPanel();
    oi = new OI();
    drive.setDefaultCommand(new ArcadeDrive(Robot.drive, Robot.oi));
    LoggableLambda busVoltage = new LoggableLambda("Bus Voltage", () -> pdp.getVoltage());

    NerdyBadlog.initAndLog("/media/sda1/logs/", "FeederToShooter", 0.02, shooter, feeder, busVoltage);


  }

  @Override
  public void robotPeriodic() {
    // CommandScheduler.getInstance().run();
    shooter.reportToSmartDashboard();
    feeder.reportToSmartDashboard();
    index.reportToSmartDashboard();
    // motor.reportToSmartDashboard();
  }

  @Override
  public void autonomousInit() {
    m_autonomousCommand =  new InstantCommand(() -> new DriveStraightContinuous(drive, 50000, 0.3));
    if (m_autonomousCommand != null) { 
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
    CommandScheduler.getInstance().run();
    
  }

  @Override
  public void teleopInit() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
  
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
