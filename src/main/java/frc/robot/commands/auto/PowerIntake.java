/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.Robot;
import frc.robot.commands.intake.IntakeBalls;

public class PowerIntake extends ParallelCommandGroup {
  public PowerIntake() {
    addCommands(
      new InstantCommand(() -> Robot.intakeRoll.setPower(0.75)),
      new InstantCommand(() -> Robot.hopper.setPower(0.4, 0.4)),
      new InstantCommand(() -> Robot.index.setPower(0.4, 0.4))
    );

   
  }
}
