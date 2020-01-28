/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.nerdherd.lib.motor.dual.DualMotorIntake;
import com.nerdherd.lib.motor.motorcontrollers.NerdyTalon;
import com.nerdherd.lib.motor.single.SingleMotorTalonSRX;
import com.nerdherd.lib.motor.single.mechanisms.SingleMotorArm;

import frc.robot.RobotMap;
import frc.robot.constants.IntakeConstants;

/**
 * Add your docs here.
 */
public class Intake extends SingleMotorArm {
  public NerdyTalon intake2;

  public Intake(){
    super(RobotMap.kIntakeID1, "Intake", false, false);

    intake2 = new NerdyTalon(RobotMap.kIntakeID2);
    intake2.follow(this.motor);
    intake2.setInverted(InvertType.OpposeMaster);
    

    super.configPIDF(IntakeConstants.kIntakeRightP, IntakeConstants.kIntakeRightI, 
                      IntakeConstants.kIntakeRightD, IntakeConstants.kIntakeRightF); 
    super.configPIDF(IntakeConstants.kIntakeLeftP, IntakeConstants.kIntakeLeftI, 
                      IntakeConstants.kIntakeLeftD, IntakeConstants.kIntakeLeftF);  
    // super.configMaxVelocity(IntakeConstants.kMaxVelocity);
     
    //  super.configTicksPerFoot(IntakeConstants.kLeftTicksPerFoot, IntakeConstants.kRightTicksPerFoot);
  
    //  super.configStaticFeedforward(IntakeConstants.kLeftStatic, IntakeConstants.kRightStatic);

    // // super();
  
  }

  
  // Put methods for controlling this subsystem
  // here. Call these from Commands.


}
