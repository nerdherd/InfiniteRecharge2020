/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

// import edu.wpi.first.wpilibj.command.Subsystem;
import com.nerdherd.lib.drivetrain.experimental.Drivetrain;
import com.nerdherd.lib.drivetrain.teleop.ArcadeDrive;
import com.nerdherd.lib.logging.NerdyBadlog;
import com.nerdherd.lib.motor.motorcontrollers.CANMotorController;
import com.nerdherd.lib.motor.motorcontrollers.NerdyTalon;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.Constants.DriveConstants;
/**
 * Add your docs here.
 */
public class Drive extends Drivetrain {
  
  public Drive() {
    super(new NerdyTalon(2), new NerdyTalon(3), new CANMotorController[] {new NerdyTalon(2), new NerdyTalon(2)} , new CANMotorController[] {new NerdyTalon(2), new NerdyTalon(2)}, true, false);
    super.configLeftPIDF(0.0, 0, 0, DriveConstants.kLeftF);
    super.configRightPIDF(0.0, 0, 0, DriveConstants.kRightF);
    super.configStaticFeedforward(DriveConstants.kLeftStatic, DriveConstants.kRightStatic);
    super.configAutoChooser(Robot.chooser);
    super.configMaxVelocity(DriveConstants.kMaxVelocity);
    super.configSensorPhase(false, false);
    super.configTicksPerFoot(DriveConstants.kLeftTicksPerFoot, DriveConstants.kRightTicksPerFoot);

    setDefaultCommand(new ArcadeDrive(Robot.drive, Robot.oi));
  }
  

  // Put methods for controlling this subsystem
  // here. Call these from Commands.


  @Override
  public void periodic() {
    reportToSmartDashboard();
    super.calcXY();
  }

  @Override
  public void startLog() {
    super.startLog();
  }

  @Override
  public void stopLog() {
    super.stopLog();
  }

  @Override
  public void logToCSV() {
    super.logToCSV();
  }
  

  @Override
  public void reportToSmartDashboard() {
    // SmartDashboard.putNumber("Left Master Voltage", getLeftOutputVoltage());
		// SmartDashboard.putNumber("Right Master Voltage", getRightOutputVoltage());
		// SmartDashboard.putNumber("Left Master Position", getLeftMasterPosition());
		// SmartDashboard.putNumber("Right Master Position", getRightMasterPosition());
    // SmartDashboard.putNumber("Yaw", getRawYaw());
    // SmartDashboard.putNumber("Pitch", getPitch());
    // SmartDashboard.putNumber("Roll", getRoll());
    super.reportToSmartDashboard();
    // SmartDashboard.putNumber("Left Vel FPS", super.getLeftVelocityFeet());
    // SmartDashboard.putNumber("Right Vel FPS", super.getRightVelocityFeet());
  }
  @Override
  public void initLoggingData() {
    NerdyBadlog.createTopic("Pitch", () -> getPitch());
  }
  
}

