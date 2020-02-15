/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.nerdherd.lib.drivetrain.auto.ResetDriveEncoders;
import com.nerdherd.lib.drivetrain.auto.ResetGyro;
import com.nerdherd.lib.oi.DefaultOI;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.StartFeeder;
import frc.robot.commands.StartFlywheel;
import frc.robot.commands.StopShooting;
import frc.robot.commands.auto.Mamba;
import frc.robot.commands.auto.Ramsete12Ball;
import frc.robot.commands.auto.Ramsete3BallShoot;
import frc.robot.commands.auto.Ramsete5Ball;
import frc.robot.commands.auto.TenBallAuto;

/**
 * Add your docs here.
 */
public class OI extends DefaultOI {

    public JoystickButton intake_1, feeder_2, index_3, startShooter_4, stopShooter_5, stopIntake_6,
                         stowIntake_7, feederOuttake_8, indexOuttake_9, turnToAngle_0, startIndex_3;
    
    
    // intake_1, feeder_2, index_3, shooter_4, stopShooter_5, stopIntake_6,
    //                      stowIntake_7, feederOuttake_8, indexOuttake_9;
    
    public OI(){
        super();
        //intake_1 = new JoystickButton(super.operatorJoy, 1);
        // feeder_2 = new JoystickButton(super.operatorJoy, 2);
        // index_3 = new JoystickButton(super.operatorJoy, 3);
        startShooter_4 = new JoystickButton(super.operatorJoy, 4);
        stopShooter_5 = new JoystickButton(super.operatorJoy, 5);
        startIndex_3 = new JoystickButton(super.operatorJoy, 3);
        // stopIntake_6 = new JoystickButton(super.operatorJoy, 6);
        // stowIntake_7 = new JoystickButton(super.operatorJoy, 7);
        // feederOuttake_8 = new JoystickButton(super.operatorJoy, 8);
        // indexOuttake_9 = new JoystickButton(super.operatorJoy, 9);
        // turnToAngle_0 = new JoystickButton(super.operatorJoy, 1);

        startShooter_4.whenPressed(new StartFlywheel());
        stopShooter_5.whenPressed(new StopShooting());
        startIndex_3.whenPressed(new StartFeeder());
        // intake_1.whenPressed(new IntakeBallToShooter());

        // feeder_2.whenPressed(new SetDualMotorPower(Robot.feeder, 0.45, 0.45));
        // index_3.whenPressed(new SetMotorPower(Robot.index, 0.5));
        // startShooter_4.whenPressed(new SetMotorPower(Robot.shooter, 0.75));
        // stopShooter_5.whenPressed(new SetMotorPower(Robot.shooter, 0.0));
        // stopIntake_6.whenPressed(new SetMotorPower(Robot.intake, 0.0));
        // stowIntake_7.whenPressed(new StowIntake());
        // feederOuttake_8.whenPressed(new SetDualMotorPower(Robot.feeder, -0.3, -0.3));
        // indexOuttake_9.whenPressed(new SetMotorPower(Robot.index, -0.5));
        // turnToAngle_0.whenPressed(new TurnToAngle(0.01));




        // SmartDashboard.putData("Feeder45", new SetDualMotorPower(Robot.feeder, 0.45, 0.45));
        // SmartDashboard.putData("Feeder25", new SetDualMotorPower(Robot.feeder, 0.25, 0.25));
     
        // SmartDashboard.putData("index 20%", new SetMotorPower(Robot.index, 0.3));
        // SmartDashboard.putData("index 250%", new SetMotorPower(Robot.index, 0.3));
        // SmartDashboard.putData("index 30%", new SetMotorPower(Robot.index, 0.3));
        // SmartDashboard.putData("index 35%", new SetMotorPower(Robot.index, 0.3));
        // SmartDashboard.putData("index 40%", new SetMotorPower(Robot.index, 0.3));
        // SmartDashboard.putData("index 45%", new SetMotorPower(Robot.index, 0.4));
        // SmartDashboard.putData("index 50%", new SetMotorPower(Robot.index, 0.45));
        // SmartDashboard.putData("index 55%", new SetMotorPower(Robot.index, 0.55));
        // SmartDashboard.putData("index 60%", new SetMotorPower(Robot.index, 0.6));
      
        // SmartDashboard.putData("IntakeRoller25%", new SetMotorPower(Robot.intakeroll, 0.25));
        // SmartDashboard.putData("IntakeRoller30%", new SetMotorPower(Robot.intakeroll, 0.3));
        // SmartDashboard.putData("IntakeRoller35%", new SetMotorPower(Robot.intakeroll, 0.35));
        // SmartDashboard.putData("IntakeRoller40%", new SetMotorPower(Robot.intakeroll, 0.4));
        // SmartDashboard.putData("IntakeRoller45%", new SetMotorPower(Robot.intakeroll, 0.45));
        // SmartDashboard.putData("IntakeRoller50%", new SetMotorPower(Robot.intakeroll, 0.5));
        // SmartDashboard.putData("IntakeRoller55%", new SetMotorPower(Robot.intakeroll, 0.55));
        // SmartDashboard.putData("IntakeRoller60%", new SetMotorPower(Robot.intakeroll, 0.6));
        // SmartDashboard.putData("IntakeRoller65%", new SetMotorPower(Robot.intakeroll, 0.65));
        // SmartDashboard.putData("IntakeRoller70%", new SetMotorPower(Robot.intakeroll, 0.7));
        // SmartDashboard.putData("IntakeRoller75%", new SetMotorPower(Robot.intakeroll, 0.75));
        // SmartDashboard.putData("IntakeRoller80%", new SetMotorPower(Robot.intakeroll, 0.8));
        // SmartDashboard.putData("IntakeRoller85%", new SetMotorPower(Robot.intakeroll, 0.85));
        // SmartDashboard.putData("IntakeRollerOff%", new SetMotorPower(Robot.intakeroll, 0.0));
      
        // SmartDashboard.putData("ShooterRamp", new MotorVoltageRamping(Robot.shooter, .20));
        // SmartDashboard.putData("Shooter10000", new SetMotorVelocity(Robot.shooter, 10000, 0.0003500*(1023/12)));
        // SmartDashboard.putData("Shooter3000", new SetMotorVelocity(Robot.shooter, 3000, 0.0003500*(1023/12)));
     
        SmartDashboard.putData("Reset Gyro", new ResetGyro(Robot.drive));
        SmartDashboard.putData("ResetXY", new InstantCommand(() -> Robot.drive.resetXY()));
        SmartDashboard.putData("Reset Encoders", new ResetDriveEncoders(Robot.drive));  
        SmartDashboard.putData("Ramsete5", new Ramsete5Ball(Robot.drive));
        SmartDashboard.putData("Mamba", new Mamba(Robot.drive));
        SmartDashboard.putData("Ramsete3", new Ramsete3BallShoot(Robot.drive));
        SmartDashboard.putData("Ramsete10", new TenBallAuto(Robot.drive));
        SmartDashboard.putData("Ramsete12", new Ramsete12Ball(Robot.drive));
        //was 0.0005321 got 10000 ticks to 12000
// 0.0002706 got 10000 ticks to 9000
// 0.0003000 got 10000 ticks to 9300

        


    }
}