/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.vision;

import com.nerdherd.lib.motor.commands.mechanisms.SetArmAngleMotionMagic;

import frc.robot.Robot;
import frc.robot.constants.ShooterConstants;

/**
 * Add your docs here.
 */
public class DistanceToAngle extends SetArmAngleMotionMagic {
    public DistanceToAngle(){
        super(Robot.hood, Robot.hood.storedAngle);
    }
    @Override
    public void execute() {
        // TODO Auto-generated method stub
        Robot.hood.setAngleMotionMagic(Robot.hood.distToAngle(Robot.limelight.getDistanceWidth()));
        if(Robot.limelight.getDistanceWidth() <= 220){
            Robot.shooter.setVelocity(ShooterConstants.kAutoAngleCloseVelocity);
        }else{
            Robot.shooter.setVelocity(0);   
        }
        
    }
}
