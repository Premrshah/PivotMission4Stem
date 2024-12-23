// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.ControlRequest;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubSystem extends SubsystemBase {
  /** Creates a new IntakeSubSystem. */
  private TalonFX intakeWheelTop = new TalonFX(IntakeConstants.intakeWheelTopId);
  private TalonFX intakeWheelBottom = new TalonFX(IntakeConstants.intakeWheelBottomId);

  private TalonFX intakeArmBottom = new TalonFX(IntakeConstants.intakeArmPrimaryID);
  private TalonFX intakeArmFollower = new TalonFX(IntakeConstants.intakeArmFollowerID);

  public IntakeSubSystem() {
    intakeArmBottom.getConfigurator().apply(IntakeConstants.ARM_CONFIGS);
    intakeArmFollower.getConfigurator().apply(IntakeConstants.ARM_CONFIGS);

    intakeWheelBottom.getConfigurator().apply(IntakeConstants.WHEEL_CONFIGS);
    intakeWheelTop.getConfigurator().apply(IntakeConstants.WHEEL_CONFIGS);

    intakeArmFollower.setControl(new Follower(IntakeConstants.intakeArmPrimaryID, true));
    intakeWheelBottom.setControl(new Follower(IntakeConstants.intakeWheelTopId, true));


  }

  @Override
  public void periodic() {
    
    // This method will be called once per scheduler run
  }

  public void setWheelSpeed(double percentOut) {
    intakeWheelTop.set(percentOut);
  }

  public void setIntakePosition(double position) {
    intakeArmBottom.setPosition(position);
  }

}
