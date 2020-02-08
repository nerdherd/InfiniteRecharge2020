/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.nerdherd.lib.motor.motorcontrollers.NerdyTalon;
import com.nerdherd.lib.motor.single.mechanisms.SingleMotorElevator;

import frc.robot.RobotMap;
import frc.robot.constants.ClimberConstants;

/**
 * Add your docs here.
 */
public class Climber extends SingleMotorElevator {
  private static Climber m_climberInstance = new Climber();

public Climber(){
  super(RobotMap.kClimberID1, "Climber ", false, false);
  super.configFollowerTalons(new NerdyTalon[]{new NerdyTalon(RobotMap.kClimberID2)});
  super.configDeadband(ClimberConstants.kClimberTalonDeadband);
  super.configHeightConversion(ClimberConstants.kClimberDistanceRatio,
    ClimberConstants.kClimberHeightOffset);
  super.configCurrentLimit(60, 60);
}
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  @Override
  public void reportToSmartDashboard(){
    super.reportToSmartDashboard();
  }

  public static synchronized Climber getInstance(){
    return m_climberInstance;
  }
}

