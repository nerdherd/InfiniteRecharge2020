/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.nerdherd.lib.motor.commands.SetDualMotorPower;
import com.nerdherd.lib.motor.commands.SetMotorPower;
import com.nerdherd.lib.motor.commands.SetMotorVelocity;
import com.nerdherd.lib.oi.DefaultOI;

// import org.graalvm.compiler.lir.aarch64.AArch64Move.StoreConstantOp;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ClimberExtend;
import frc.robot.commands.ClimberRetract;
import frc.robot.commands.InfiniteRecharge;
import frc.robot.commands.Intake;
import frc.robot.commands.PanelExtend;
import frc.robot.commands.PanelRetract;
import frc.robot.commands.PanelRotate;
import frc.robot.commands.ShootBall;
import frc.robot.commands.StopIntake;

/**
 * Add your docs here.
 */
public class OI extends DefaultOI {

    public JoystickButton intake_1, shoot_2, infiniteRecharge_3, stow_4, climberExtend_5, climberRetract_6,
    panelRetract_7, panelExtend_8, panelRotation_9, stopIntake_10, wallShot_11;
    
   
    public OI(){
        super();
        intake_1 = new JoystickButton(super.operatorJoy, 1);
        shoot_2 =  new JoystickButton(super.operatorJoy, 2);
        infiniteRecharge_3 =  new JoystickButton(super.operatorJoy, 3);
        // infinteRecharge = Start flywheel
        // stow_4 =  new JoystickButton(super.operatorJoy, 4);
        climberExtend_5 =  new JoystickButton(super.operatorJoy, 5);
        climberRetract_6 =  new JoystickButton(super.operatorJoy, 6);
        panelRetract_7 =  new JoystickButton(super.operatorJoy, 7);
        panelExtend_8 =  new JoystickButton(super.operatorJoy, 8);
        panelRotation_9 = new JoystickButton(super.operatorJoy, 9);
        stopIntake_10 =  new JoystickButton(super.operatorJoy, 10);
        wallShot_11 =  new JoystickButton(super.operatorJoy, 11);

        intake_1.whenPressed(new Intake());
        shoot_2.whenPressed(new ShootBall());
        infiniteRecharge_3.whenPressed(new InfiniteRecharge());
        // stow_4.whenPressed(new Stow());
        climberExtend_5.whenPressed(new ClimberExtend());
        climberRetract_6.whenPressed(new ClimberRetract());
        panelRetract_7.whenPressed(new PanelRetract());
        panelExtend_8.whenPressed(new PanelExtend());
        panelRotation_9.whenPressed(new PanelRotate());
        stopIntake_10.whenPressed(new StopIntake());



        // SmartDashboard.putData("Feeder45", new SetDualMotorPower(Robot.feeder, 0.45, 0.45));
        // SmartDashboard.putData("Feeder25", new SetDualMotorPower(Robot.feeder, 0.25, 0.25));
        SmartDashboard.putData("Feeder35", new SetDualMotorPower(Robot.feeder, 0.35, 0.35));


        SmartDashboard.putData("backFeeder", new SetDualMotorPower(Robot.feeder, -0.25, -0.25));

        // SmartDashboard.putData("Feeder50", new SetDualMotorPower(Robot.feeder, 0.5, 0.5));
        // SmartDashboard.putData("Feeder55", new SetDualMotorPower(Robot.feeder, 0.55, 0.55));
        // SmartDashboard.putData("Feeder60", new SetDualMotorPower(Robot.feeder, 0.60, 0.60));
        // SmartDashboard.putData("Feeder65", new SetDualMotorPower(Robot.feeder, 0.65, 0.65));
        // SmartDashboard.putData("Feeder70", new SetDualMotorPower(Robot.feeder, 0.70, 0.70));
        // SmartDashboard.putData("Feeder100", new SetDualMotorPower(Robot.feeder, 1.0, 0.0));
        SmartDashboard.putData("FeederOff", new SetDualMotorPower(Robot.feeder, 0.0, 0.0));



        SmartDashboard.putData("12V ", new SetMotorPower(Robot.shooter, 1));
        SmartDashboard.putData("75%Volts", new SetMotorPower(Robot.shooter, 0.75));        
        // SmartDashboard.putData("70%Volts", new SetMotorPower(Robot.shooter, 0.7));        
        // SmartDashboard.putData("65%Volts", new SetMotorPower(Robot.shooter, 0.65));
        // SmartDashboard.putData("65%Volts", new SetMotorPower(Robot.shooter, 0.65));        
        // SmartDashboard.putData("50%Volts", new SetMotorPower(Robot.shooter, 0.5));
        // SmartDashboard.putData("30%Volts", new SetMotorPower(Robot.shooter, 0.3));  
        SmartDashboard.putData("ShooterOff", new SetMotorPower(Robot.shooter, 0.0));   
 
        
        SmartDashboard.putData("set hood pos 1000 or 26 degrees", new DumbSetPosition(Robot.hood, 1000, 0.215, 100));
        SmartDashboard.putData("set hood pos 2000 or 32 degrees", new DumbSetPosition(Robot.hood, 2000, 0.215, 100));
        SmartDashboard.putData("set hood pos 3000 or 38 degrees", new DumbSetPosition(Robot.hood, 3000, 0.215, 100));
        SmartDashboard.putData("set hood pos 4000 or 44 degrees", new DumbSetPosition(Robot.hood, 4000, 0.215, 100));
        SmartDashboard.putData("set hood pos 5000 or 50 degrees", new DumbSetPosition(Robot.hood, 5000, 0.215, 100));
        SmartDashboard.putData("set hood pos 6000 or 56 degrees", new DumbSetPosition(Robot.hood, 6000, 0.215, 100));
        SmartDashboard.putData("set hood pos 7000 or 62 degrees", new DumbSetPosition(Robot.hood, 7000, 0.25, 100));
        SmartDashboard.putData("set hood pos 7700 or 65 degrees", new DumbSetPosition(Robot.hood, 7700, 0.25, 100));
        SmartDashboard.putData("set hood position", new SetArmAnglePID(Robot.hood, 45));
        SmartDashboard.putData("set hood position 4000", new SetMotorPositionPID(Robot.hood, 4000));
        SmartDashboard.putData("set voltaij 2", new SetMotorPower(Robot.hood, 2./12.));
        SmartDashboard.putData("set voltaij -2", new SetMotorPower(Robot.hood, -2./12.));
        SmartDashboard.putData("set voltaij 0", new SetMotorPower(Robot.hood, 0./12.));
        SmartDashboard.putData("Ramp upwards without ff", new MotorVoltageRamping(Robot.hood, 0.25));
        SmartDashboard.putData("Ramp up with ff", new MechanismVoltageRampingWithFF(Robot.hood, 0.25));
        SmartDashboard.putData("Ramp down with ff", new MechanismVoltageRampingWithFF(Robot.hood, -0.25));


    }
}