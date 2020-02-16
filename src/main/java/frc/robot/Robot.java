/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.nerdherd.lib.drivetrain.teleop.ArcadeDrive;
import com.nerdherd.lib.logging.LoggableLambda;
import com.nerdherd.lib.logging.NerdyBadlog;
import com.nerdherd.lib.misc.AutoChooser;
import com.nerdherd.lib.motor.dual.DualMotorIntake;
import com.nerdherd.lib.motor.motorcontrollers.NerdyTalon;
import com.nerdherd.lib.motor.single.SingleMotorMechanism;
import com.nerdherd.lib.motor.single.SingleMotorVictorSPX;
import com.nerdherd.lib.pneumatics.Piston;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.SerialPort;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Hood;
import frc.robot.subsystems.Jevois;
import frc.robot.subsystems.Limelight;
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
  public static Drive drive;
  public static Jevois jevois;
  public static Hood hood;
  public static DriverStation ds;
  public static Shooter shooter;
  public static DualMotorIntake hopper;
  public static SingleMotorMechanism intakeRoll;
  public static SingleMotorMechanism index;
  // public static SingleMotorMechanism motor;
  // public static PowerDistributionPanel pdp;
  public static OI oi;
  public static Command m_autonomousCommand;
  public static Piston intake;
  public static Piston panelPos;
  public static SingleMotorMechanism panelRot;
  public static Climber climber;
  public static Piston climberRatchet;
  public static Limelight limelight;
  public static SingleMotorMechanism falcon;


  
  @Override
  public void robotInit() {
    hood = new Hood();
    climber = new Climber();
    falcon = new SingleMotorMechanism(1, "shooter", true, true);
    limelight = new Limelight();
    drive = new Drive();
    // jevois = new Jevois(115200, SerialPort.Port.kUSB);
		// jevois.startCameraStream();
    shooter = new Shooter();
    // motor = new SingleMotorMechanism(6, "Motor", true, true);
    ds = DriverStation.getInstance();
    // climberRatchet = new Piston(6, 9);
    // climberRatchet.setReverse();

    hopper = new DualMotorIntake(new SingleMotorVictorSPX(RobotMap.kFeederID1, "Top Intake", false),
     new SingleMotorVictorSPX(RobotMap.kFeederID2, "Bottom Intake", true));
    index = new SingleMotorMechanism(RobotMap.kIndex, "Index", false, false);
    intakeRoll = new SingleMotorMechanism(new NerdyTalon(RobotMap.kIntakeRoll), "Intake", true, true);
    intake = new Piston(RobotMap.kIntakePort1, RobotMap.kIntakePort2);
    chooser = new AutoChooser();
    // pdp = new PowerDistributionPanel();
    panelPos = new Piston(3, 4);
    panelRot = new SingleMotorMechanism(5, "Control Panel", false, false);
    oi = new OI();
    drive.setDefaultCommand(new ArcadeDrive(Robot.drive, Robot.oi));

    NerdyBadlog.initAndLog("/home/lvuser/logs/", "ShooterCharacterization", 0.02, shooter, hood, index, hopper);


  }

  @Override
  public void robotPeriodic() {
    // CommandScheduler.getInstance().run();
    // CameraServer.getInstance().
    // System.out.println(shooter.kF);
    shooter.reportToSmartDashboard();
    hopper.reportToSmartDashboard();
    index.reportToSmartDashboard();
    jevois.reportToSmartDashboard();
    limelight.reportToSmartDashboard();
    // motor.reportToSmartDashboard();
    hood.reportToSmartDashboard();
    // climber.reportToSmartDashboard();
  }

  @Override
  public void disabledInit() {
    // hood.resetEncoder();
  }
  @Override
  public void autonomousInit() {
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
