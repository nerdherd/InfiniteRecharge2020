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
        SmartDashboard.putData("Feeder45", new SetDualMotorPower(Robot.feeder, 0.45, 0.45));
        SmartDashboard.putData("Feeder25", new SetDualMotorPower(Robot.feeder, 0.25, 0.25));
        SmartDashboard.putData("Feeder35", new SetDualMotorPower(Robot.feeder, 0.35, 0.35));


        SmartDashboard.putData("backFeeder45", new SetDualMotorPower(Robot.feeder, -0.45, -0.45));

        SmartDashboard.putData("Feeder50", new SetDualMotorPower(Robot.feeder, 0.5, 0.5));
        SmartDashboard.putData("Feeder55", new SetDualMotorPower(Robot.feeder, 0.55, 0.55));
        SmartDashboard.putData("Feeder60", new SetDualMotorPower(Robot.feeder, 0.60, 0.60));
        SmartDashboard.putData("Feeder65", new SetDualMotorPower(Robot.feeder, 0.65, 0.65));
        SmartDashboard.putData("Feeder70", new SetDualMotorPower(Robot.feeder, 0.70, 0.70));
        SmartDashboard.putData("Feeder100", new SetDualMotorPower(Robot.feeder, 1.0, 0.0));


        // SmartDashboard.putData("12V single", new SetMotorPower(Robot.motor, 1));
        SmartDashboard.putData("75%Volts", new SetMotorPower(Robot.shooter, 0.75));        
        SmartDashboard.putData("70%Volts", new SetMotorPower(Robot.shooter, 0.7));        
        SmartDashboard.putData("65%Volts", new SetMotorPower(Robot.shooter, 0.65));
        SmartDashboard.putData("65%Volts", new SetMotorPower(Robot.shooter, 0.65));        
        SmartDashboard.putData("50%Volts", new SetMotorPower(Robot.shooter, 0.5));
        SmartDashboard.putData("30%Volts", new SetMotorPower(Robot.shooter, 0.3));        
        
        


    }
}
