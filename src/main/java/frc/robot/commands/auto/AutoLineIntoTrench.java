/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auto;

import java.util.List;

import com.nerdherd.lib.drivetrain.auto.DriveStraightContinuous;
import com.nerdherd.lib.drivetrain.experimental.Drivetrain;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj.trajectory.constraint.CentripetalAccelerationConstraint;
import edu.wpi.first.wpilibj.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.intake.IntakeBalls;
import frc.robot.constants.DriveConstants;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoLineIntoTrench extends SequentialCommandGroup {
  private Drivetrain m_drive;
  public AutoLineIntoTrench(Drivetrain drive) {
    m_drive = drive;
  
    var autoVoltageConstraint = new DifferentialDriveVoltageConstraint(
      new SimpleMotorFeedforward(DriveConstants.kramseteS, DriveConstants.kramseteV, DriveConstants.kramseteA),
      m_drive.m_kinematics, 
      DriveConstants.kRamseteMaxVolts);

      var autoCentripetalAccelerationConstraint = new CentripetalAccelerationConstraint(DriveConstants.kMaxCentripetalAcceleration);
  
    TrajectoryConfig config = new TrajectoryConfig(DriveConstants.kDriveMaxVel, DriveConstants.kDriveMaxAccel);
    // config.addConstraints(autoVoltageConstraint);
    config.addConstraints(List.of(autoVoltageConstraint, autoCentripetalAccelerationConstraint));

    // Trajectory shootIntoTrench = TrajectoryGenerator.generateTrajectory(
    //   new Pose2d(DriveConstants.kAutoLineMeters, DriveConstants.kGoalMetersY, new Rotation2d(Math.PI)),
    //   List.of(new Translation2d(2, -0.85), new Translation2d(DriveConstants.kTrenchMetersX, DriveConstants.kTrenchMetersY)), 
    //   new Pose2d(DriveConstants.kEndTrenchMetersX, DriveConstants.kEndTrenchMetersY, new Rotation2d(0)),
    //   config);
    
      Trajectory shootIntoTrench = TrajectoryGenerator.generateTrajectory(
      new Pose2d(DriveConstants.kAutoLineMeters, DriveConstants.kGoalMetersY, new Rotation2d(Math.PI)),
      List.of(new Translation2d(2, -0.85), new Translation2d(DriveConstants.kTrenchMetersX, DriveConstants.kTrenchMetersY)), 
      new Pose2d(DriveConstants.kTrenchThirdBallX, DriveConstants.kEndTrenchMetersY, new Rotation2d(0)),
      config);

//generateTrajectory( startPos(x,y,theta),  )
    RamseteCommand stealTrench = new RamseteCommand(
      shootIntoTrench, 
      m_drive::getPose2d, new RamseteController(1.0, 0.7), 
      new SimpleMotorFeedforward(DriveConstants.kramseteS, DriveConstants.kramseteV, DriveConstants.kramseteA), 
      m_drive.m_kinematics, m_drive::getCurrentSpeeds, 
      new PIDController(DriveConstants.kLeftP, DriveConstants.kLeftI, DriveConstants.kLeftD), 
      new PIDController(DriveConstants.kRightP, DriveConstants.kRightI, DriveConstants.kRightD),
      m_drive::setVoltage, m_drive);
    
    
    addCommands(
      // new BasicAutoNoMove(),
      // new InstantCommand( () -> m_drive.setPose(new Pose2d(DriveConstants.kAutoLineMeters, DriveConstants.kGoalMetersY, new Rotation2d(Math.PI)))),
      // new ParallelRaceGroup(new IntakeBalls(), stealTrench),
      // new DriveStraightContinuous(m_drive, 0, 0)
      stealTrench

    );
  }
}
