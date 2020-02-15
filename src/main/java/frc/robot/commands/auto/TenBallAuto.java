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
import edu.wpi.first.wpilibj.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class TenBallAuto extends SequentialCommandGroup {
  /**
   * sike tis ten ball
   */
  private Drivetrain m_drive;
    public TenBallAuto(Drivetrain drive) {
    m_drive = drive;
    m_drive.setCoastMode();
    var autoVoltageConstraint =
    new DifferentialDriveVoltageConstraint(
        new SimpleMotorFeedforward(1.15,2.79,0.544),
        m_drive.m_kinematics, 
        10);

    TrajectoryConfig m_config = new TrajectoryConfig(4.5, 2.0);
    m_config.addConstraint(autoVoltageConstraint);
    
    Trajectory m_traj = TrajectoryGenerator.generateTrajectory(new Pose2d(3.048, -2.404, new Rotation2d(0)),
    List.of(), new Pose2d(6.163, -3.014, new Rotation2d(0.4548)),
        m_config);
     RamseteCommand ramsete = new RamseteCommand(m_traj, m_drive::getPose2d, new RamseteController(2.0, 0.7), 
                                    new SimpleMotorFeedforward(1.15,2.79,0.544), 
                                    m_drive.m_kinematics, m_drive::getCurrentSpeeds, 
                                    new PIDController(3.11, 0, 0), new PIDController(3.11, 0, 0),
                                     m_drive::setVoltage, m_drive); 
      


      
      Trajectory m_traj3 = TrajectoryGenerator.generateTrajectory(new Pose2d(6.163, -3.014, new Rotation2d(0.4548)),
      List.of(), new Pose2d(4.097, -2.404, new Rotation2d(Math.PI)),
      m_config);
      RamseteCommand ramsete3 = new RamseteCommand(m_traj3, m_drive::getPose2d, new RamseteController(3.0, 0.7), 
      new SimpleMotorFeedforward(1.15,2.79,0.544), 
      m_drive.m_kinematics, m_drive::getCurrentSpeeds, 
      new PIDController(3.11, 0, 0), new PIDController(3.11, 0, 0),
      m_drive::setVoltage, m_drive);   
      
      // TrajectoryConfig m_config2 = new TrajectoryConfig(4.5, 2.0);
      // m_config2.addConstraint(autoVoltageConstraint);
    
      // m_config2.setReversed(true);
      Trajectory m_traj4 = TrajectoryGenerator.generateTrajectory(new Pose2d(4.097, -2.404, new Rotation2d(Math.PI)),
      List.of(), new Pose2d(9.624, -0.705, new Rotation2d(0)),
      m_config);
      RamseteCommand ramsete4 = new RamseteCommand(m_traj4, m_drive::getPose2d, new RamseteController(2.0, 0.7), 
      new SimpleMotorFeedforward(1.15,2.79,0.544), 
      m_drive.m_kinematics, m_drive::getCurrentSpeeds, 
      new PIDController(3.11, 0, 0), new PIDController(3.11, 0, 0),
      m_drive::setVoltage, m_drive);   
      

      addCommands(ramsete, ramsete3, ramsete4, new DriveStraightContinuous(m_drive, 0, 0));
 
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    

  }
}
