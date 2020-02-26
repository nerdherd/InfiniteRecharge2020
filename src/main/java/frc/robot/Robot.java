/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.nerdherd.lib.drivetrain.auto.DriveStraightContinuous;
import com.nerdherd.lib.drivetrain.teleop.ArcadeDrive;
import com.nerdherd.lib.logging.NerdyBadlog;
import com.nerdherd.lib.misc.AutoChooser;
import com.nerdherd.lib.motor.commands.ResetSingleMotorEncoder;
import com.nerdherd.lib.motor.single.SingleMotorMechanism;
import com.nerdherd.lib.motor.single.SingleMotorVictorSPX;
import com.nerdherd.lib.pneumatics.Piston;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.auto.BasicAuto;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Hood;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Indexer;
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
  public static Indexer indexer;
  public static DriverStation ds;
  public static Shooter shooter;
  public static Hopper hopper;
  public static SingleMotorVictorSPX intakeRoll;
  public static Indexer index;
  // public static SingleMotorMechanism motor;
  // public static PowerDistributionPanel pdp;
  public static Command m_autonomousCommand;
  public static Piston intake;
  public static Piston panelPos;
  public static SingleMotorMechanism panelRot;
  public static Climber climber;
  public static Piston climberRatchet;
  public static Limelight limelight;
  public static OI oi;
  public static ResetSingleMotorEncoder hoodReset;

  // public static SingleMotorMechanism falcon;


  
  @Override
  public void robotInit() {
    hood = new Hood();
    climber = new Climber();
    indexer = new Indexer();
    // falcon = new SingleMotorMechanism(1, "shooter", true, true);
    limelight = new Limelight();
    drive = new Drive();
    // jevois = new Jevois(115200, SerialPort.Port.kUSB);
		// jevois.startCameraStream();
    shooter = new Shooter();
    // motor = new SingleMotorMechanism(6, "Motor", true, true);
    ds = DriverStation.getInstance();
    // climberRatchet = new Piston(6, 9);
    // climberRatchet.setReverse();
    CameraServer.getInstance().startAutomaticCapture();

    hopper = new Hopper();
    // index = new SingleMotorMechanism(RobotMap.kIndex, "Index", false, false);
    index = new Indexer();
    intakeRoll = new SingleMotorVictorSPX(RobotMap.kIntakeRoll, "intake rollers", false);
    intake = new Piston(RobotMap.kIntakePort1, RobotMap.kIntakePort2);
    chooser = new AutoChooser();
    // pdp = new PowerDistributionPanel();
    // panelPos = new Piston(RobotMap.kPanelPort1ID, RobotMap.kPanelPort2ID);
    // panelRot = new SingleMotorMechanism(RobotMap.kPanelRollerID, "Control Panel", false, false);
    
    hoodReset = new ResetSingleMotorEncoder(Robot.hood);
    oi = new OI();
    drive.setDefaultCommand(new ArcadeDrive(Robot.drive, Robot.oi, 0.687));

    NerdyBadlog.initAndLog("/home/lvuser/logs/", "4201_practice", 0.02, shooter, hood, index, hopper, drive);

    m_autonomousCommand = new BasicAuto();
  }

  @Override
  public void robotPeriodic() {
    


    // CommandScheduler.getInstance().run();
    // System.out.println(shooter.kF);
    shooter.reportToSmartDashboard();
    hopper.reportToSmartDashboard();
    index.reportToSmartDashboard();
    // jevois.reportToSmartDashboard();
    limelight.reportToSmartDashboard();
    // motor.reportToSmartDashboard();
    hood.reportToSmartDashboard();
    
    // climber.reportToSmartDashboard();
  }

  @Override
  public void disabledInit() {
    // hood.resetEncoder();
    drive.setCoastMode();
  }
  @Override
  public void autonomousInit() {
    m_autonomousCommand = new DriveStraightContinuous(drive, 30000, 0.3);
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
    // drive.setBrakeMode();
    drive.setCoastMode();
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
