/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.climber;

import com.nerdherd.lib.motor.commands.SetMotorPower;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.constants.ClimberConstants;
import frc.robot.subsystems.Climber;

public class ClimberReady extends SetMotorPower {
  /**
   * Creates a new ClimberReady.
   */
  public ClimberReady() {
    super(Climber.getInstance(), ClimberConstants.kClimberDesiredUpPow);
    addRequirements(Robot.climberRatchet);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    super.initialize();
    Robot.climberRatchet.setReverse();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Climber.getInstance().setPower(0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Climber.getInstance().getHeight() > ClimberConstants.kHardStopPos;     
  }
}
