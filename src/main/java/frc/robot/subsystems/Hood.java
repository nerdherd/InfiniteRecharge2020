/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.nerdherd.lib.motor.single.mechanisms.SingleMotorArm;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.constants.HoodConstants;

public class Hood extends SingleMotorArm {
  /**
   * Creates a new Hood.
   */
  public Hood() {
    super(RobotMap.kHoodID, "Hood", true, false);
    super.configTalonDeadband(0.004);
    super.configFFs(HoodConstants.kHoodGravityFF, HoodConstants.kHoodStaticFriction);
    super.configMotionMagic(HoodConstants.kMotionMagicAcceleration, HoodConstants.kMotionMagicVelocity);
    super.configPIDF(HoodConstants.kHoodP, 0, 0, HoodConstants.kHoodF);
    super.configAngleConversion(HoodConstants.kHoodAngleRatio, HoodConstants.kHoodAngleOffset);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    super.reportToSmartDashboard();
  }
}
