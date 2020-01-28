/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

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
        SmartDashboard.putData("Run motor 1V", new SetMotorPower(Robot.hood, 0.1));
        SmartDashboard.putData("Reset Hood", new ResetSingleMotorEncoder(Robot.hood));
        SmartDashboard.putData("Run motor -1V", new SetMotorPower(Robot.hood, -0.1));
        SmartDashboard.putData("Ramp Hood", new MotorVoltageRamping(Robot.hood, 0.025));
        SmartDashboard.putData("Ramp Hood Down", new MotorVoltageRamping(Robot.hood, -0.025));
        SmartDashboard.putData("pos 4000", new SetMotorMotionMagic(Robot.hood, 4000));

    }
}