// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.IntakeConstants;
import frc.robot.subsystems.IntakeSubSystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class ControlIntakeCommand extends Command {
  private IntakeSubSystem intakeSubSystem;
  private double position;
  /** Creates a new DeployIntakeCommand. */
  public ControlIntakeCommand(IntakeSubSystem intakeSubSystem, double position) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.intakeSubSystem = intakeSubSystem;
    this.position = position;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakeSubSystem.setWheelSpeed(IntakeConstants.intakeSpeed);
    intakeSubSystem.setIntakePosition(position * IntakeConstants.intakeDegreesToRotations);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}