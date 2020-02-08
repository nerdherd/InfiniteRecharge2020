/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.nerdherd.lib.motor.motorcontrollers.NerdyFalcon;
import com.nerdherd.lib.motor.motorcontrollers.NerdyTalon;
import com.nerdherd.lib.motor.single.SingleMotorMechanism;

import frc.robot.constants.ShooterConstants;

/**
 * Add your docs here.
 */
public class Shooter extends SingleMotorMechanism {
  public Shooter(){
    super(new NerdyFalcon(0), "Shooter", false, false);

    super.configPIDF(ShooterConstants.kP, ShooterConstants.kI, ShooterConstants.kD, ShooterConstants.kF);
    super.configDeadband(ShooterConstants.kDeadband);
    super.configFollowerTalons(new NerdyTalon[] { new NerdyTalon(7)});
    super.configCurrentLimit(80, 60);

    
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.


}
