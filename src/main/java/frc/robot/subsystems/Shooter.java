/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.nerdherd.lib.motor.motorcontrollers.CANMotorController;
import com.nerdherd.lib.motor.motorcontrollers.NerdyFalcon;
import com.nerdherd.lib.motor.motorcontrollers.NerdyTalon;
import com.nerdherd.lib.motor.single.SingleMotorMechanism;

import frc.robot.constants.ShooterConstants;

/**
 * Add your docs here.
 */
public class Shooter extends SingleMotorMechanism {

  private NerdyFalcon follower;
  public Shooter(){
    super(new NerdyFalcon(1), "Shooter", true, false);
    super.motor.setCoastMode();
    follower = new NerdyFalcon(2);
    follower.setCoastMode();
    super.configPIDF(ShooterConstants.kP, ShooterConstants.kI, ShooterConstants.kD, ShooterConstants.kF);
    super.configDeadband(ShooterConstants.kDeadband);
    // super.motor.configFollowers(new CANMotorController[] {follower});
    // follower.setInverted(TalonFXInvertType.OpposeMaster);
    follower.follow((TalonFX) super.motor);
    super.configCurrentLimit(80, 60);

    
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.


}
