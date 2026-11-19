package frc.robot.commands;

import com.ctre.phoenix6.swerve.SwerveRequest;
import frc.robot.subsystems.vision.PhotonVisionSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CommandSwerveDrivetrain;

public class FollowMe extends Command {
    private final CommandSwerveDrivetrain drivetrain;

    private final FollowController controller;
    private final PhotonVisionSubsystem vision;

    private final SwerveRequest.RobotCentric driveRequest = new SwerveRequest.RobotCentric();
    
    public FollowMe(CommandSwerveDrivetrain drivetrain, FollowController controller, PhotonVisionSubsystem vision) {
        this.drivetrain = drivetrain;
        this.controller = controller;
        this.vision = vision;
        addRequirements(drivetrain, vision);
    }
    @Override
    public void initialize() {
        controller.reset();
    }
    @Override
    public void execute() {
        double[] output = controller.calculate(vision);
        double yawError = controller.getYawError();
        drivetrain.setControl(
            driveRequest
            .withVelocityX(0)
            .withVelocityY(0)
            .withRotationalRate(output[2])
        );
        SmartDashboard.putNumber("yaw error", 5.2);
    }
    public void end(boolean interrupted) {
        drivetrain.setControl(
            driveRequest
            .withVelocityX(0)
            .withVelocityY(0)
            .withRotationalRate(0)
        );
        controller.reset();
    }   
    public boolean isFinished() {
        return false;
    }
}
