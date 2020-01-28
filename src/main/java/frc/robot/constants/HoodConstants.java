/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.constants;

import frc.robot.subsystems.Hood;

/**
 * Add your docs here.
 */
public class HoodConstants {

    public static final double kHoodGravityFF = 1.054;
    // difficult to get data going downward because there is no tension
    public static final double kHoodStaticFriction = 1.263;
    public static final int kMotionMagicAcceleration = 125;
    public static final int kMotionMagicVelocity = 300;
    public static final double kHoodP = 1.5;
    public static final double kHoodF = 0.05448;
    // 0.1092 kHoodF OG
    public static final double kHoodAngleRatio = 0.005897;
    public static final double kHoodAngleOffset = 20;
    


}
