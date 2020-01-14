/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.nerdherd.lib.motor.motorcontrollers.NerdyTalon;
import com.nerdherd.lib.motor.single.SingleMotorTalonSRX;

import frc.robot.constants.ShooterConstants;

/**
 * Add your docs here.
 */
public class Shooter extends SingleMotorTalonSRX {
  public Shooter(){
    super(5, "Shooter", true, true);

    super.configPIDF(ShooterConstants.kP, ShooterConstants.kI, ShooterConstants.kD, ShooterConstants.kF);
    super.configTalonDeadband(ShooterConstants.kDeadband);
    super.configFollowersTalons(new NerdyTalon[] { new NerdyTalon(4)});
    
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
