// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.FeedbackConfigs;
import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.TorqueCurrentConfigs;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.StaticFeedforwardSignValue;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class IntakeConstants {
    // these two positions are not being used as of now
    public static final int deployPosition = 0; // Degrees
    public static final int shootingPosition = 130; // Degrees

    public static final int intakeWheelTopId = 17;
    public static final int intakeWheelBottomId = 18;

    public static final int intakeArmPrimaryID = 22;
    public static final int intakeArmFollowerID = 21;

    public static final double intakeSpeed = 0.85;

    public static final double lowSpeed = 0.2;
    public static final double middleSpeed = 0.5;
    public static final double highSpeed = 0.9;

    public static final double intakeGearRatio = 60;
    public static final double intakeRotsToDegrees = 360 / intakeGearRatio;
    public static final double intakeDegreesToRotations = 1 / intakeRotsToDegrees;


    public static final TalonFXConfiguration ARM_CONFIGS = new TalonFXConfiguration()
                                .withSlot0(new Slot0Configs() // PID
                                                .withKP(75)
                                                .withKI(0)
                                                .withKD(0)
                                                .withKS(0)
                                                .withStaticFeedforwardSign(StaticFeedforwardSignValue.UseVelocitySign)
                                                .withKV(0))
                                .withMotorOutput(new MotorOutputConfigs()
                                                .withNeutralMode(NeutralModeValue.Brake) 
                                                .withInverted(InvertedValue.Clockwise_Positive))
                                .withCurrentLimits(new CurrentLimitsConfigs()
                                                .withStatorCurrentLimit(80)
                                                .withStatorCurrentLimitEnable(true))
                                .withTorqueCurrent(new TorqueCurrentConfigs()
                                                .withPeakForwardTorqueCurrent(80)
                                                .withPeakReverseTorqueCurrent(-80))
                                .withFeedback(new FeedbackConfigs().withSensorToMechanismRatio(intakeGearRatio));


    public static final TalonFXConfiguration WHEEL_CONFIGS = new TalonFXConfiguration();

    public static int maxDegreesArm = 128;


  }

  public static class ControllerConstants {
    public static class Driver {
      public static final double deadband = 0.01;
    }

    public static class Operator {
            public static final double deadband = 0.1;
    }
}

}
