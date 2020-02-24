/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;



import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.VisionConstants;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Limelight extends SubsystemBase {
  /**
   * Creates a new Limelight.
   */
  
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry tx;
  NetworkTableEntry ty;
  NetworkTableEntry ta;
  NetworkTableEntry ts;
  NetworkTableEntry pipeline;
  NetworkTableEntry ledMode;
  NetworkTableEntry camMode;

  public Limelight() {
    tx = table.getEntry("tx");
    ty = table.getEntry("ty");
    ta = table.getEntry("ta");
    ts = table.getEntry("ts");
    pipeline = table.getEntry("pipeline");
    camMode = table.getEntry("camMode");
    ledMode = table.getEntry("ledMode");

    pipeline.setValue(7);
    camMode.setValue(1);

  }

  public double getXOffsetFromTarget() {
    double x = tx.getDouble(0.0) + 1;
    return x;
  }

  public double getYOffsetFromTarget() {
    double y = ty.getDouble(0.0);
    return y;
  }

  public double getTargetArea() {
    double area = ta.getDouble(0.0);
    return area;
  }

  public double getTargetAngle(){
    double skew = ts.getDouble(0.0);
    return skew;
  }

  public double getDistance(){
    double dist = (VisionConstants.kTargetHeight-VisionConstants.kCameraMountHeight) / Math.tan(getYOffsetFromTarget());
    return dist;
}

  public void blink() {
    ledMode.setNumber(2);
  }

  public void setOff(){
    ledMode.setNumber(1);
  }

  public void reportToSmartDashboard() {
    SmartDashboard.putNumber("Limelight X", getXOffsetFromTarget());
    SmartDashboard.putNumber("Limelight Y", getYOffsetFromTarget());
    SmartDashboard.putNumber("Limelight Area", getTargetArea());
    SmartDashboard.putNumber("Limelight Distance", getDistance());
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}