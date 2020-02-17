/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.nerdherd.lib.drivetrain.experimental.Drivetrain;
import com.nerdherd.lib.drivetrain.teleop.ArcadeDrive;
import com.nerdherd.lib.motor.motorcontrollers.CANMotorController;
import com.nerdherd.lib.motor.motorcontrollers.NerdySparkMax;
import com.nerdherd.lib.motor.motorcontrollers.NerdyTalon;
import com.nerdherd.lib.motor.motorcontrollers.NerdyVictorSPX;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.constants.DriveConstants;

// import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends Drivetrain {
  /**
   * Creates a new Drive.
   */
  public Drive() {
    super(new NerdySparkMax(RobotMap.kLeftMasterNeo, MotorType.kBrushless), new NerdySparkMax(RobotMap.kRightMasterNeo, MotorType.kBrushless),
    new CANMotorController[] {
      new NerdySparkMax(RobotMap.kLeftSlaveNeo, MotorType.kBrushless),
    },
    new CANMotorController[] {
      new NerdySparkMax(RobotMap.kRightSlaveNeo, MotorType.kBrushless),
    },
     true, false, 0.637);
    
     super.configAutoChooser(Robot.chooser);
     super.configMaxVelocity(DriveConstants.kMaxVelocity);
     super.configSensorPhase(false, false);
    
     super.configTicksPerFoot(DriveConstants.kLeftTicksPerFoot, DriveConstants.kRightTicksPerFoot);
     super.configLeftPIDF(4.07, 0, 0, DriveConstants.kLeftF);
     super.configRightPIDF(4.07, 0, 0, DriveConstants.kRightF);
     super.configStaticFeedforward(DriveConstants.kLeftStatic, DriveConstants.kRightStatic);
     super.configKinematics(0.63742712872013762571, new Rotation2d(0), new Pose2d(0,0, new Rotation2d(0)));
     
    }

  @Override
  public void periodic() {
    super.updateOdometry();
    super.reportToSmartDashboard();
  }
}
