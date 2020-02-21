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
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class StealShoot extends SequentialCommandGroup {
  /**
   * Creates a new StealShoot.
   */
  private Drivetrain m_drive;

  public StealShoot(Drivetrain drive) {
  m_drive = drive;  
  TrajectoryConfig m_config = new TrajectoryConfig(3, 2.0);
  
  Trajectory m_traj = TrajectoryGenerator.generateTrajectory(new Pose2d(3.048, -7.506, new Rotation2d(0)),
  List.of(), new Pose2d(6.359, -7.506, new Rotation2d(0)),
  m_config);
  RamseteCommand ramsete = new RamseteCommand(m_traj, m_drive::getPose2d, new RamseteController(2.0, 2.7), 
      new SimpleMotorFeedforward(1.14,2.72,0.619), 
      m_drive.m_kinematics, m_drive::getCurrentSpeeds, 
      new PIDController(3.11, 0, 0), new PIDController(3.11, 0, 0),
        m_drive::setVoltage, m_drive); 
  
  Trajectory m_traj2 = TrajectoryGenerator.generateTrajectory(new Pose2d(6.359, -7.506, new Rotation2d(0)),
  List.of(), new Pose2d(3.048, -2.404, new Rotation2d(Math.PI)),
  m_config);
  RamseteCommand ramsete2 = new RamseteCommand(m_traj2, m_drive::getPose2d, new RamseteController(2.0, 2.7), 
      new SimpleMotorFeedforward(1.14,2.72,0.619), 
      m_drive.m_kinematics, m_drive::getCurrentSpeeds, 
      new PIDController(3.11, 0, 0), new PIDController(3.11, 0, 0),
        m_drive::setVoltage, m_drive); 
              
  addCommands(ramsete, ramsete2, new DriveStraightContinuous(m_drive, 0, 0));
  }
}
