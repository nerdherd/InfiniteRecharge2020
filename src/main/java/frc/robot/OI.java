/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.nerdherd.lib.motor.commands.DumbSetPosition;
import com.nerdherd.lib.motor.commands.MotorVoltageRamping;
import com.nerdherd.lib.motor.commands.ResetSingleMotorEncoder;
import com.nerdherd.lib.motor.commands.SetMotorMotionMagic;
import com.nerdherd.lib.motor.commands.SetMotorPower;
import com.nerdherd.lib.oi.DefaultOI;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * Add your docs here.
 */
public class OI extends DefaultOI {

    public JoystickButton intake_1, feeder_2, index_3, shooter_4, stopShooter_5, stopIntake_6,
                         stowIntake_7, feederOuttake_8, indexOuttake_9, turnToAngle_0;
    
    
    // intake_1, feeder_2, index_3, shooter_4, stopShooter_5, stopIntake_6,
    //                      stowIntake_7, feederOuttake_8, indexOuttake_9;
    
    public OI(){
        super();
        SmartDashboard.putData("Run shooter motor 6V", new SetMotorPower(Robot.shooter, 0.5));
        SmartDashboard.putData("Reset Hood", new ResetSingleMotorEncoder(Robot.hood));
        SmartDashboard.putData("Run shooter motor -6V", new SetMotorPower(Robot.shooter, -0.5));
        SmartDashboard.putData("Ramp Hood", new MotorVoltageRamping(Robot.hood, 0.025));
        SmartDashboard.putData("Ramp Hood Down", new MotorVoltageRamping(Robot.hood, -0.025));
        // SmartDashboard.putData("Hood Pos 4000", new SetMotorMotionMagic(Robot.hood, 4000));
        
        SmartDashboard.putData("set hood pos 1000 or 26 degrees", new DumbSetPosition(Robot.hood, 1000, 0.215, 100));
        SmartDashboard.putData("set hood pos 2000 or 32 degrees", new DumbSetPosition(Robot.hood, 2000, 0.215, 100));
        SmartDashboard.putData("set hood pos 3000 or 38 degrees", new DumbSetPosition(Robot.hood, 3000, 0.215, 100));
        SmartDashboard.putData("set hood pos 4000 or 44 degrees", new DumbSetPosition(Robot.hood, 4000, 0.215, 100));
        SmartDashboard.putData("set hood pos 5000 or 50 degrees", new DumbSetPosition(Robot.hood, 5000, 0.215, 100));
        SmartDashboard.putData("set hood pos 6000 or 56 degrees", new DumbSetPosition(Robot.hood, 6000, 0.215, 100));
        SmartDashboard.putData("set hood pos 7000 or 62 degrees", new DumbSetPosition(Robot.hood, 7000, 0.25, 100));
        SmartDashboard.putData("set hood pos 7700 or 65 degrees", new DumbSetPosition(Robot.hood, 7700, 0.25, 100));

    }
}