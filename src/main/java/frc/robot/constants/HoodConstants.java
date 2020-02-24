/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.constants;

/**
 * Add your docs here.
 */
public class HoodConstants {

    public static final double kHoodGravityFF = 0.0671;
    // difficult to get data going downward because there is no tension
    public static final double kHoodStaticFriction = 0.3;// 1.263;
    public static final int kMotionMagicAcceleration = 2500;
    public static final int kMotionMagicVelocity = 2500;
    public static final double kHoodP = 1;
    public static final double kHoodF = 0.369644;
    // 0.1092 kHoodF OG
    public static final double kHoodAngleRatio = 360./4096./15.;
    public static final double kHoodAngleOffset = -10;
    
    public static final double kHoodAccel = 116;
    public static final double kHoodVel = 168;

    public static final double kHoodV = 0.0715;
    public static final double kHoodA = 0.00103;
    public static final double kHoodS = 0.403;
    public static final double kHoodCos = 0.0671;

    public static final double kWallShotAngle = -10;
    public static final double kTrenchShotAngle = 34;
    public static final double kAutolineShotAngle = 28;
    public static final double kStowAngle = -10;
}