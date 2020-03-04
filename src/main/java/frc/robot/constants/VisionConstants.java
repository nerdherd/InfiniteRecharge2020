/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.constants;
import java.util.*;
import java.lang.*;

/**
 * Add your docs here.
 */
public class VisionConstants {

    // OLD CONSTANTS!
    public final static double kHorizontalFOV = 55;
    public final static double kVerticalFOV = 42.65386; // calculated from focalLength
    public final static double kHorizontalPixels = 320;
    public final static double kVerticalPixels = 240; 
    public final static double kXFocalLength = 341.3307738; // focalLength = px_width / (2 * tan(FOV / 2))
    public final static double kXFocalLength_lime = 249.68216560510; // 320*240, 709.170231847 960*720
    public final static double kYFocalLength = 332.3115843; //NOT ACCURATE?

    // LIMELIGHT CONSTANTS!
    public final static double kHorizontalFOV_lime = 59.79780368;
    public final static double kVerticalFOV_lime = 45.19904048;

    // Physical camera constants
    public final static double kCameraHorizontalMountAngle = 0; 
    public final static double kCameraMountHeight = 31.0; //15.25, 26.00
    public final static double kCameraHorizontalOffset = 0;
    public final static double kCameraBumperOffset = 0.0; //orig 16
    
    public final static double kTargetHeight = 36.5; // inches 74.25 for field 
    public final static double kTargetWidth = 38.5;
    
    public final static double kDriveRotationDeadband = 1.5;
    public final static double kDetectDistance = 25;

}