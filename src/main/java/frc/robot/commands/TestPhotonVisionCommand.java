
package frc.robot.commands;

import frc.robot.subsystems.vision.PhotonVisionSubsystem;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.photonvision.targeting.PhotonTrackedTarget;

import java.util.Optional;

public class TestPhotonVisionCommand extends Command {

    private final PhotonVisionSubsystem vision;

    public TestPhotonVisionCommand(
        PhotonVisionSubsystem vision
    ) {
        this.vision = vision;

        addRequirements(vision);
    }

    @Override
    public void initialize() {

        System.out.println("=== PHOTONVISION TEST STARTED ===");

        SmartDashboard.putString(
            "Vision/Test Status",
            "RUNNING"
        );
    }

    @Override
    public void execute() {

        // Test FRONT camera (a)
        testFrontCamera();

        // Test REAR camera (b)
        testRearCamera();
    }

    private void testFrontCamera() {

        Optional<PhotonTrackedTarget> target =
            vision.getFrontTarget();

        String prefix = "Vision/Front/";

        if (target.isPresent()) {

            PhotonTrackedTarget trackedTarget =
                target.get();

            SmartDashboard.putBoolean(
                prefix + "Has Target", true
            );

            SmartDashboard.putNumber(
                prefix + "AprilTag ID",
                trackedTarget.getFiducialId()
            );

            SmartDashboard.putNumber(
                prefix + "Yaw",
                trackedTarget.getYaw()
            );

            SmartDashboard.putNumber(
                prefix + "Pitch",
                trackedTarget.getPitch()
            );

            SmartDashboard.putNumber(
                prefix + "Area",
                trackedTarget.getArea()
            );

            SmartDashboard.putString(
                prefix + "Status",
                "TARGET DETECTED"
            );

        } else {

            SmartDashboard.putBoolean(
                prefix + "Has Target", false
            );

            SmartDashboard.putNumber(
                prefix + "AprilTag ID", -1
            );

            SmartDashboard.putString(
                prefix + "Status",
                "NO TARGET"
            );
        }
    }

    private void testRearCamera() {

        Optional<PhotonTrackedTarget> target =
            vision.getRearTarget();

        String prefix = "Vision/Rear/";

        if (target.isPresent()) {

            PhotonTrackedTarget trackedTarget =
                target.get();

            System.out.println("FOUND A TARGET!");
            System.out.println("Its April tag id is: " + trackedTarget.getFiducialId());
        } else {
            System.out.println("No target found!");
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {

        System.out.println("=== PHOTONVISION TEST STOPPED ===");

        SmartDashboard.putString(
            "Vision/Test Status",
            "STOPPED"
        );
    }
}
