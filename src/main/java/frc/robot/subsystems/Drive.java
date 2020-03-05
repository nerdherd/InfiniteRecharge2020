/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.nerdherd.lib.drivetrain.experimental.Drivetrain;
import com.nerdherd.lib.drivetrain.experimental.ShiftingDrivetrain;
import com.nerdherd.lib.drivetrain.teleop.ArcadeDrive;
import com.nerdherd.lib.motor.motorcontrollers.CANMotorController;
import com.nerdherd.lib.motor.motorcontrollers.NerdyFalcon;
import com.nerdherd.lib.motor.motorcontrollers.NerdySparkMax;
import com.nerdherd.lib.motor.motorcontrollers.NerdyTalon;
import com.nerdherd.lib.motor.motorcontrollers.NerdyVictorSPX;
import com.nerdherd.lib.pneumatics.Piston;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.constants.DriveConstants;

// import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends ShiftingDrivetrain {
  /**
   * Creates a new Drive.
   */
  public Drive() {
    super(new NerdyTalon(8),
     new NerdyTalon(1),
    new CANMotorController[] {
      new NerdyVictorSPX(5),
    },
    new CANMotorController[] {
      new NerdyVictorSPX(4),
    },
     false, false, new Piston(RobotMap.kShifterPort1ID, RobotMap.kShifterPort2ID),
      DriveConstants.kTrackWidth);
    
     super .configTicksPerFoot(DriveConstants.kLeftTicksPerFoot, DriveConstants.kRightTicksPerFoot);
     super.configAutoChooser(Robot.chooser);
     super.configMaxVelocity(DriveConstants.kMaxVelocity);
     super.configSensorPhase(true, true);
     
     super.configKinematics(DriveConstants.kTrackWidth, new Rotation2d(0), new Pose2d(0, 0, new Rotation2d(0)));
     super.configLeftPIDF(DriveConstants.kramseteP, DriveConstants.kramseteI, DriveConstants.kramseteP, DriveConstants.kLeftF);
     super.configRightPIDF(DriveConstants.kramseteP, DriveConstants.kramseteI, DriveConstants.kramseteP, DriveConstants.kRightF);
     super.configStaticFeedforward(DriveConstants.kramseteS, DriveConstants.kramseteS);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    super.updateOdometry();
    super.reportToSmartDashboard();
  }
}
