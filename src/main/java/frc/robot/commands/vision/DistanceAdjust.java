/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.vision;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DistanceAdjust extends CommandBase {
  /**
   * Creates a new DistanceAdjust.
   */

  private double m_StraightP;

  public DistanceAdjust(double kStraightP) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.drive);
    addRequirements(Robot.jevois);
    m_StraightP = kStraightP;

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.jevois.enableStream();
    SmartDashboard.putString("Current Command", "DistanceAdjust");
    }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double error;
    double power;
    double distance = Robot.jevois.getOldDistance();
    if (distance < 15.5){
      error = distance - 10;
      power = m_StraightP * error;
      Robot.drive.setPowerFeedforward(power, power);
    }
    else {
      error = distance - 21;
      power = m_StraightP * error;
      Robot.drive.setPowerFeedforward(power, power);
    }
    SmartDashboard.putNumber("Left Power", power);
    SmartDashboard.putNumber("Right Power", power);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
