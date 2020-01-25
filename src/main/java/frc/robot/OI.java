/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.nerdherd.lib.motor.commands.MotorVoltageRamping;
import com.nerdherd.lib.motor.commands.SetDualMotorPower;
import com.nerdherd.lib.motor.commands.SetMotorPower;
import com.nerdherd.lib.motor.commands.SetMotorVelocity;
import com.nerdherd.lib.oi.DefaultOI;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * Add your docs here.
 */
public class OI extends DefaultOI {

    public JoystickButton intake_1, feeder_2, index_3, shooter_4, stopShooter_5, stopIntake_6,
                         stowIntake_7, feederOuttake_8, indexOuttake_9;
    
    public OI(){
        super();
        intake_1 = new JoystickButton(super.operatorJoy, 1);
        feeder_2 = new JoystickButton(super.operatorJoy, 2);
        index_3 = new JoystickButton(super.operatorJoy, 3);
        shooter_4 = new JoystickButton(super.operatorJoy, 4);
        stopShooter_5 = new JoystickButton(super.operatorJoy, 5);
        stopIntake_6 = new JoystickButton(super.operatorJoy, 6);
        stowIntake_7 = new JoystickButton(super.operatorJoy, 7);
        feederOuttake_8 = new JoystickButton(super.operatorJoy, 8);
        indexOuttake_9 = new JoystickButton(super.operatorJoy, 9);

        // intake_1.whenPressed(new IntakeBallToShooter());
        feeder_2.whenPressed(new SetDualMotorPower(Robot.feeder, 0.45, 0.45));
        index_3.whenPressed(new SetMotorPower(Robot.index, 0.5));
        shooter_4.whenPressed(new SetMotorPower(Robot.shooter, 0.75));
        stopShooter_5.whenPressed(new SetMotorPower(Robot.shooter, 0.0));
        stopIntake_6.whenPressed(new SetMotorPower(Robot.intake, 0.0));
        // stowIntake_7.whenPressed(new StowIntake());
        feederOuttake_8.whenPressed(new SetDualMotorPower(Robot.feeder, -0.3, -0.3));
        indexOuttake_9.whenPressed(new SetMotorPower(Robot.index, -0.5));




        SmartDashboard.putData("Feeder45", new SetDualMotorPower(Robot.feeder, 0.45, 0.45));
        SmartDashboard.putData("Feeder25", new SetDualMotorPower(Robot.feeder, 0.25, 0.25));
        SmartDashboard.putData("Feeder35", new SetDualMotorPower(Robot.feeder, 0.35, 0.35));


        SmartDashboard.putData("backFeeder", new SetDualMotorPower(Robot.feeder, -0.25, -0.25));

        SmartDashboard.putData("Feeder50", new SetDualMotorPower(Robot.feeder, 0.5, 0.5));
        SmartDashboard.putData("Feeder55", new SetDualMotorPower(Robot.feeder, 0.55, 0.55));
        SmartDashboard.putData("Feeder60", new SetDualMotorPower(Robot.feeder, 0.60, 0.60));
        SmartDashboard.putData("Feeder65", new SetDualMotorPower(Robot.feeder, 0.65, 0.65));
        SmartDashboard.putData("Feeder70", new SetDualMotorPower(Robot.feeder, 0.70, 0.70));
        SmartDashboard.putData("Feeder100", new SetDualMotorPower(Robot.feeder, 1.0, 0.0));
        SmartDashboard.putData("FeederOff", new SetDualMotorPower(Robot.feeder, 0.0, 0.0));



        // SmartDashboard.putData("12V single", new SetMotorPower(Robot.motor, 1));
        SmartDashboard.putData("75%Volts", new SetMotorPower(Robot.shooter, 0.75));        
        SmartDashboard.putData("70%Volts", new SetMotorPower(Robot.shooter, 0.7));        
        SmartDashboard.putData("65%Volts", new SetMotorPower(Robot.shooter, 0.65));
        SmartDashboard.putData("65%Volts", new SetMotorPower(Robot.shooter, 0.65));        
        SmartDashboard.putData("50%Volts", new SetMotorPower(Robot.shooter, 0.5));
        SmartDashboard.putData("30%Volts", new SetMotorPower(Robot.shooter, 0.3));  
        SmartDashboard.putData("ShooterOff", new SetMotorPower(Robot.shooter, 0.0));   
 
        
        SmartDashboard.putData("index 20%", new SetMotorPower(Robot.index, 0.3));
        SmartDashboard.putData("index 250%", new SetMotorPower(Robot.index, 0.3));
        SmartDashboard.putData("index 30%", new SetMotorPower(Robot.index, 0.3));
        SmartDashboard.putData("index 35%", new SetMotorPower(Robot.index, 0.3));
        SmartDashboard.putData("index 40%", new SetMotorPower(Robot.index, 0.3));
        SmartDashboard.putData("index 45%", new SetMotorPower(Robot.index, 0.4));
        SmartDashboard.putData("index 50%", new SetMotorPower(Robot.index, 0.45));
        SmartDashboard.putData("index 55%", new SetMotorPower(Robot.index, 0.55));
        SmartDashboard.putData("index 60%", new SetMotorPower(Robot.index, 0.6));
        SmartDashboard.putData("index 65%", new SetMotorPower(Robot.index, 0.65));
        SmartDashboard.putData("index 70%", new SetMotorPower(Robot.index, 0.7));
        SmartDashboard.putData("index Off", new SetMotorPower(Robot.index, 0.0));
        SmartDashboard.putData("BackwardsIndex", new SetMotorPower(Robot.index, 0.4));

        SmartDashboard.putData("IntakeRoller25%", new SetMotorPower(Robot.intakeroll, 0.25));
        SmartDashboard.putData("IntakeRoller30%", new SetMotorPower(Robot.intakeroll, 0.3));
        SmartDashboard.putData("IntakeRoller35%", new SetMotorPower(Robot.intakeroll, 0.35));
        SmartDashboard.putData("IntakeRoller40%", new SetMotorPower(Robot.intakeroll, 0.4));
        SmartDashboard.putData("IntakeRoller45%", new SetMotorPower(Robot.intakeroll, 0.45));
        SmartDashboard.putData("IntakeRoller50%", new SetMotorPower(Robot.intakeroll, 0.5));
        SmartDashboard.putData("IntakeRoller55%", new SetMotorPower(Robot.intakeroll, 0.55));
        SmartDashboard.putData("IntakeRoller60%", new SetMotorPower(Robot.intakeroll, 0.6));
        SmartDashboard.putData("IntakeRoller65%", new SetMotorPower(Robot.intakeroll, 0.65));
        SmartDashboard.putData("IntakeRoller70%", new SetMotorPower(Robot.intakeroll, 0.7));
        SmartDashboard.putData("IntakeRoller75%", new SetMotorPower(Robot.intakeroll, 0.75));
        SmartDashboard.putData("IntakeRoller80%", new SetMotorPower(Robot.intakeroll, 0.8));
        SmartDashboard.putData("IntakeRoller85%", new SetMotorPower(Robot.intakeroll, 0.85));
        SmartDashboard.putData("IntakeRollerOff%", new SetMotorPower(Robot.intakeroll, 0.0));
      
        SmartDashboard.putData("ShooterRamp", new MotorVoltageRamping(Robot.shooter, .20));
        SmartDashboard.putData("Shooter10000", new SetMotorVelocity(Robot.shooter, 10000, 0.0003500*(1023/12)));
        SmartDashboard.putData("Shooter3000", new SetMotorVelocity(Robot.shooter, 3000, 0.0003500*(1023/12)));
        SmartDashboard.putData("Shooter25000", new SetMotorVelocity(Robot.shooter, 25000, 0.0003500*(1023/12)));
        SmartDashboard.putData("Shooter30000", new SetMotorVelocity(Robot.shooter, 30000, 0.0003500*(1023/12)));

        //was 0.0005321 got 10000 ticks to 12000
// 0.0002706 got 10000 ticks to 9000
// 0.0003000 got 10000 ticks to 9300

        


    }
}