/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.nerdherd.lib.motor.commands.SetDualMotorPower;
import com.nerdherd.lib.motor.commands.SetMotorPower;
import com.nerdherd.lib.oi.DefaultOI;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Add your docs here.
 */
public class OI extends DefaultOI {
    
    public OI(){
        super();
        SmartDashboard.putData("Feeder", new SetDualMotorPower(Robot.feeder, 0.5, 0.5));
        SmartDashboard.putData("75%Volts", new SetMotorPower(Robot.shooter, 0.75));
    }
}
