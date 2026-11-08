
package frc.robot.subsystems.vision;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import java.util.Optional;

public class PhotonVisionSubsystem extends SubsystemBase {

    // Connect to the two PhotonVision cameras
    private final PhotonCamera frontCamera =
        new PhotonCamera("a");

    private final PhotonCamera rearCamera =
        new PhotonCamera("b");

    public PhotonVisionSubsystem() {
    }

    // Get latest result from front camera
    public Optional<PhotonTrackedTarget> getFrontTarget() {

        PhotonPipelineResult result =
            frontCamera.getLatestResult();

        if (result.hasTargets()) {
            return Optional.of(result.getBestTarget());
        }

        return Optional.empty();
    }

    // Get latest result from rear camera
    public Optional<PhotonTrackedTarget> getRearTarget() {

        PhotonPipelineResult result =
            rearCamera.getLatestResult();

        if (result.hasTargets()) {
            return Optional.of(result.getBestTarget());
        }

        return Optional.empty();
    }

    // Check if front camera sees a target
    public boolean frontHasTarget() {
        return frontCamera.getLatestResult().hasTargets();
    }

    // Check if rear camera sees a target
    public boolean rearHasTarget() {
        return rearCamera.getLatestResult().hasTargets();
    }

    // Get AprilTag ID
    public int getFrontAprilTagID() {
        return getFrontTarget()
            .map(PhotonTrackedTarget::getFiducialId)
            .orElse(-1);
    }

    // Get horizontal offset (degrees)
    public double getFrontYaw() {
        return getFrontTarget()
            .map(PhotonTrackedTarget::getYaw)
            .orElse(0.0);
    }

    // Get horizontal offset from rear camera
    public double getRearYaw() {
        return getRearTarget()
            .map(PhotonTrackedTarget::getYaw)
            .orElse(0.0);
    }
}
