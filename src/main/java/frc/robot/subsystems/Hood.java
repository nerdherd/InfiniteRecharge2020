/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import com.nerdherd.lib.motor.single.mechanisms.SingleMotorArm;

import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import frc.robot.RobotMap;
import frc.robot.constants.HoodConstants;

public class Hood extends SingleMotorArm  {

  public Hood() {
    super(RobotMap.kHoodID, "Hood", true, true );
    super.configAngleConversion(HoodConstants.kHoodAngleRatio, HoodConstants.kHoodAngleOffset);
    super.configTrapezoidalConstraints(new TrapezoidProfile.Constraints(HoodConstants.kHoodVel, HoodConstants.kHoodAccel));
    super.configPIDF(HoodConstants.kHoodP, 0, 0, 0);
    super.configFFs(HoodConstants.kHoodGravityFF, HoodConstants.kHoodStaticFriction);
    super.configOblargConstants(HoodConstants.kHoodS, HoodConstants.kHoodCos, HoodConstants.kHoodV, HoodConstants.kHoodA);
    super.configMotionMagic(HoodConstants.kMotionMagicAcceleration, HoodConstants.kMotionMagicVelocity);
  //96 for entire arm, -28 for start of middle of hood
  //
  }
}
