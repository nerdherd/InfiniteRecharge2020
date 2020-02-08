/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.nerdherd.lib.drivetrain.auto.DriveStraightContinuous;
import com.nerdherd.lib.drivetrain.experimental.Drivetrain;
import com.nerdherd.lib.drivetrain.teleop.ArcadeDrive;
import com.nerdherd.lib.logging.LoggableLambda;
import com.nerdherd.lib.logging.NerdyBadlog;
import com.nerdherd.lib.misc.AutoChooser;
import com.nerdherd.lib.motor.dual.DualMotorIntake;
import com.nerdherd.lib.motor.motorcontrollers.CANMotorController;
import com.nerdherd.lib.motor.motorcontrollers.NerdyTalon;
import com.nerdherd.lib.motor.motorcontrollers.NerdyVictorSPX;
import com.nerdherd.lib.motor.single.SingleMotorMechanism;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Jevois;
import frc.robot.subsystems.Shooter;
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
	public static final String kDate = "2020_01_25_";
  
  public static AutoChooser chooser;
  public static Drivetrain m_drive;
  public static Jevois jevois;
  
  public static DriverStation ds;
  public static Shooter shooter;
  public static DualMotorIntake feeder;
  public static Intake intake;
  public static SingleMotorMechanism intakeroll;
  public static SingleMotorMechanism index;
  // public static SingleMotorMechanism motor;
  public static PowerDistributionPanel pdp;
  public static OI oi;
  public static Command m_autonomousCommand;

  
  @Override
  public void robotInit() {
    m_drive = new Drivetrain(new NerdyTalon(1), new NerdyTalon(2),  	    
    new CANMotorController[] { new NerdyVictorSPX(19), new NerdyVictorSPX(20) },	  
    new CANMotorController[] { new NerdyVictorSPX(3), new NerdyVictorSPX(4) }, true, false, 0.63742712872013762571);	
   
    jevois = new Jevois(115200, SerialPort.Port.kUSB);
		jevois.startCameraStream();
    shooter = new Shooter();
    // motor = new SingleMotorMechanism(6, "Motor", true, true);
    ds = DriverStation.getInstance();
    feeder = new DualMotorIntake(new SingleMotorMechanism(5, "Top Intake", true, false), new SingleMotorMechanism(6, "Bottom Intake", false, false));
    intake = new Intake();
    index = new SingleMotorMechanism(21, "Index", false, true);
    intakeroll = new SingleMotorMechanism(12, "Intake", true, true);
    chooser = new AutoChooser();
    pdp = new PowerDistributionPanel();
    oi = new OI();
    // m_drive.setDefaultCommand(new ArcadeDrive(Robot.m_drive, Robot.oi));
    LoggableLambda busVoltage = new LoggableLambda("Bus Voltage", () -> pdp.getVoltage());

    NerdyBadlog.initAndLog("/media/sdbz1/logs/", "FeederToShooter", 0.02, shooter, feeder, index, busVoltage, m_drive);


  }

  @Override
  public void robotPeriodic() {
    // CommandScheduler.getInstance().run();
    // CameraServer.getInstance().
    shooter.reportToSmartDashboard();
    feeder.reportToSmartDashboard();
    index.reportToSmartDashboard();
    jevois.reportToSmartDashboard();
    // motor.reportToSmartDashboard();
  }

  @Override
  public void autonomousInit() {
    // m_autonomousCommand =  new InstantCommand(() -> new DriveStraightContinuous(drive, 50000, 0.3));
    // if (m_autonomousCommand != null) { 
    //   m_autonomousCommand.schedule();
    // }
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
