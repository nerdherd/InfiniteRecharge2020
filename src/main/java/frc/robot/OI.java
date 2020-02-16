/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.nerdherd.lib.drivetrain.shifting.ShiftHigh;
import com.nerdherd.lib.drivetrain.shifting.ShiftLow;
import com.nerdherd.lib.motor.commands.MotorVoltageRamping;
import com.nerdherd.lib.motor.commands.ResetSingleMotorEncoder;
import com.nerdherd.lib.motor.commands.SetDualMotorPower;
import com.nerdherd.lib.motor.commands.SetMotorPower;
import com.nerdherd.lib.motor.commands.SetMotorVelocity;
import com.nerdherd.lib.motor.commands.mechanisms.SetArmAngleMotionMagic;
import com.nerdherd.lib.motor.single.SingleMotorMechanism;
import com.nerdherd.lib.oi.DefaultOI;
import com.nerdherd.lib.pneumatics.commands.ExtendPiston;
import com.nerdherd.lib.pneumatics.commands.RetractPiston;

import edu.wpi.first.wpilibj.Sendable;

// import org.graalvm.compiler.lir.aarch64.AArch64Move.StoreConstantOp;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutolineShot;
import frc.robot.commands.ShootBall;
import frc.robot.commands.TrenchShot;
import frc.robot.commands.WallShot;
import frc.robot.commands.flywheel.InfiniteRecharge;
import frc.robot.commands.intake.Intake;
import frc.robot.commands.intake.Stow;
import frc.robot.constants.ShooterConstants;

/**
 * Add your docs here.
 */
public class OI extends DefaultOI {

    public JoystickButton intake_1, startShooting_2, trenchShot_7, autolineShot_9, stow_10, wallShot_11,
            autoDistance_12, hoodAngle_5;
    // trench and auto manual shooting position for shooter
    // climberExtend_5, climberRetract_6

    public OI() {
        super();
        intake_1 = new JoystickButton(super.operatorJoy, 1);
        startShooting_2 = new JoystickButton(super.operatorJoy, 2);
        trenchShot_7 = new JoystickButton(super.operatorJoy, 7);
        autolineShot_9 = new JoystickButton(super.operatorJoy, 9);
        stow_10 = new JoystickButton(super.operatorJoy, 10);
        wallShot_11 = new JoystickButton(super.operatorJoy, 11);
        autoDistance_12 = new JoystickButton(super.operatorJoy, 12);
        hoodAngle_5 = new JoystickButton(super.operatorJoy, 5);

        intake_1.toggleWhenPressed(new Intake());
        startShooting_2.whenPressed(new ShootBall());
        trenchShot_7.whenPressed(new TrenchShot());
        autolineShot_9.whenPressed(new AutolineShot());
        stow_10.whenPressed(new Stow());
        wallShot_11.whenPressed(new WallShot());
        hoodAngle_5.whenPressed(new SetArmAngleMotionMagic(Robot.hood, 34));
        // autoDistance_12.whenPressed(new AutoDistance());

        // shoot_2.whileHeld(new ShootBall());
        // infiniteRecharge_3.whenPressed(new InfiniteRecharge());
        // stow_4.whenPressed(new Stow());
        // // climb_5.whenPressed(new ClimberClimb());
        // panelRetract_7.whenPressed(new PanelRetract());
        // panelExtend_8.whenPressed(new PanelExtend());
        // panelRotation_9.whenPressed(new PanelRotate());
        // wallShot_11.whenPressed(new WallShot());

        SmartDashboard.putData("1VIndex", new SetMotorPower(Robot.index, 0.0833));   
        SmartDashboard.putData("2VIndex", new SetMotorPower(Robot.index, 0.166)); 
        SmartDashboard.putData("3VIndex", new SetMotorPower(Robot.index, 0.25));        
       
     
        // SmartDashboard.putData("Feeder45", new SetDualMotorPower(Robot.feeder, 0.45,
        // 0.45));
        // SmartDashboard.putData("Feeder25", new SetDualMotorPower(Robot.feeder, 0.25,
        // 0.25));
        // SmartDashboard.putData("Feeder35", new SetDualMotorPower(Robot.feeder, 0.35,
        // 0.35));

        // SmartDashboard.putData("backFeeder", new SetDualMotorPower(Robot.feeder,
        // -0.25, -0.25));
        // SmartDashboard.putData("Feeder25", new SetDualMotorPower(Robot.feeder, 0.25,
        // 0.25));

        // SmartDashboard.putData("Feeder50", new SetDualMotorPower(Robot.feeder, 0.5,
        // 0.5));
        // SmartDashboard.putData("Feeder55", new SetDualMotorPower(Robot.feeder, 0.55,
        // 0.55));
        // SmartDashboard.putData("Feeder60", new SetDualMotorPower(Robot.feeder, 0.60,
        // 0.60));
        // SmartDashboard.putData("Feeder65", new SetDualMotorPower(Robot.feeder, 0.65,
        // 0.65));
        // SmartDashboard.putData("Feeder70", new SetDualMotorPower(Robot.feeder, 0.70,
        // 0.70));
        // SmartDashboard.putData("Feeder100", new SetDualMotorPower(Robot.feeder, 1.0,
        // 0.0));
        // SmartDashboard.putData("FeederOff", new SetDualMotorPower(Robot.feeder, 0.0,
        // 0.0));

        // SmartDashboard.putData("12V ", new SetMotorPower(Robot.shooter, 1));
        // SmartDashboard.putData("75%Volts", new SetMotorPower(Robot.shooter, 0.75));
        // SmartDashboard.putData("70%Volts", new SetMotorPower(Robot.shooter, 0.7));
        // SmartDashboard.putData("65%Volts", new SetMotorPower(Robot.shooter, 0.65));
        // SmartDashboard.putData("65%Volts", new SetMotorPower(Robot.shooter, 0.65));
        // SmartDashboard.putData("45%Volts", new SetMotorPower(Robot.index, 0.45));
        // SmartDashboard.putData("30%Volts", new SetMotorPower(Robot.shooter, 0.3));
        // SmartDashboard.putData("ShooterOff", new SetMotorPower(Robot.shooter, 0.0));

        SmartDashboard.putData("4VShooter", new SetMotorPower(Robot.shooter, 0.33));
        // SmartDashboard.putData("4.5VShooter", new SetMotorPower(Robot.shooter,
        // (4.5/12.0)));
        // SmartDashboard.putData("4.7VShooter", new SetMotorPower(Robot.shooter,
        // (4.7/12.0)));
        // SmartDashboard.putData("4.6VShooter", new SetMotorPower(Robot.shooter,
        // (4.6/12.0)));
        SmartDashboard.putData("1VShooter", new SetMotorPower(Robot.shooter, 0.083333333));
        SmartDashboard.putData("3VShooter", new SetMotorPower(Robot.shooter, 0.25));
        SmartDashboard.putData("2VShooter", new SetMotorPower(Robot.shooter, 0.167));
        SmartDashboard.putData("5Vshooter", new SetMotorPower(Robot.shooter, 0.416));
        // SmartDashboard.putData("5.5VShooter", new SetMotorPower(Robot.shooter,
        // 0.45833));
        // SmartDashboard.putData("5.7VShooter", new SetMotorPower(Robot.shooter,
        // 0.475));

        SmartDashboard.putData("6VShooter", new SetMotorPower(Robot.shooter, 0.5));
        SmartDashboard.putData("7VShooter", new SetMotorPower(Robot.shooter, 0.58333333));
        SmartDashboard.putData("8VShooter", new SetMotorPower(Robot.shooter, 0.66666));
        SmartDashboard.putData("9VShooter", new SetMotorPower(Robot.shooter, 0.75));
        SmartDashboard.putData("10VShooter", new SetMotorPower(Robot.shooter, 0.83333333));
        SmartDashboard.putData("11VShooter", new SetMotorPower(Robot.shooter, 0.9166));
        SmartDashboard.putData("12VShooter", new SetMotorPower(Robot.shooter, 1.0));

        SmartDashboard.putData("15000", new SetMotorVelocity(Robot.shooter, 15000));
        SmartDashboard.putData("14000", new SetMotorVelocity(Robot.shooter, 14000));
        SmartDashboard.putData("13000", new SetMotorVelocity(Robot.shooter, 13000));




        // SmartDashboard.putData("1VSingleFalcon", new SetMotorPower(Robot.falcon,
        // 0.083333333));

        // SmartDashboard.putData("ShooterRamp", new MotorVoltageRamping(Robot.shooter,
        // 0.25));
        // SmartDashboard.putData("HoodRamp", new MotorVoltageRamping(Robot.hood,
        // 0.125));
        SmartDashboard.putData("SetHoodPower", new SetMotorPower(Robot.hood, 0.15));
        SmartDashboard.putData("-SetHoodPower", new SetMotorPower(Robot.hood, 0.15));
        SmartDashboard.putData("SetHoodFF 10 deg", new
        SetArmAngleMotionMagic(Robot.hood, 10));
        SmartDashboard.putData("SetHoodFF -10 deg", new
        SetArmAngleMotionMagic(Robot.hood, -10));
        SmartDashboard.putData("SetHoodFF 30 deg", new
        SetArmAngleMotionMagic(Robot.hood, 30));
        SmartDashboard.putData("SetHoodFF 20 deg", new SetArmAngleMotionMagic(Robot.hood, 20));
        SmartDashboard.putData("SetHoodFF 34 deg", new
        SetArmAngleMotionMagic(Robot.hood, 34));
        // SmartDashboard.putData("Set hood angle 10", new InstantCommand(() ->
        // Robot.hood.motor.setPositionPID(1000)));
        // SmartDashboard.putData("Tell me what you are", new InstantCommand(() ->
        // System.out.println(Robot.hood.motor.getClass().toString())));
        SmartDashboard.putData("ResetHoodEncoder", new ResetSingleMotorEncoder(Robot.hood));

        SmartDashboard.putData("3VHopper", new SetDualMotorPower(Robot.hopper, 0.4, 0.8));
        // SmartDashboard.putData("-3VHopper", new SetDualMotorPower(Robot.hopper, -0.45, -0.25));
        SmartDashboard.putData("StopHopper", new SetDualMotorPower(Robot.hopper, 0.0, 0.0));
        SmartDashboard.putData("StopShooter", new SetMotorPower(Robot.shooter, 0.0));
        SmartDashboard.putData("3VIntakeRollers", new SetMotorPower(Robot.intakeRoll, 0.25));
        SmartDashboard.putData("Neg3VIntakeRollers", new SetMotorPower(Robot.intakeRoll, -0.5));

        SmartDashboard.putData("StopIntakeRollers", new SetMotorPower(Robot.intakeRoll, 0.0));
        SmartDashboard.putData("6VIndex", new SetMotorPower(Robot.index, 0.5));
        SmartDashboard.putData("Neg6VIndex", new SetMotorPower(Robot.index, -0.5));
        SmartDashboard.putData("StopIndex", new SetMotorPower(Robot.index, 0.0));
        SmartDashboard.putData("ExtendIntake", new ExtendPiston(Robot.intake));
        SmartDashboard.putData("RetractIntake", new RetractPiston(Robot.intake));

        SmartDashboard.putData("ShiftUp", new ShiftHigh(Robot.drive));
        SmartDashboard.putData("ShiftDown", new ShiftLow(Robot.drive));

        SmartDashboard.putData("ShooterRamp", new MotorVoltageRamping(Robot.shooter, 0.25/12));

        SmartDashboard.putData("Shoot", new ShootBall());
        SmartDashboard.putData("InfiniteRecharge", new InfiniteRecharge());
    }

	private Sendable SetMotorPower(SingleMotorMechanism index, double d) {
		return null;
	}
}