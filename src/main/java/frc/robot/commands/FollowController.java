package frc.robot.commands;

import frc.robot.subsystems.vision.PhotonVisionSubsystem;

import java.util.Optional;

import org.photonvision.targeting.PhotonTrackedTarget;
import frc.robot.ConstantValues;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;

public class FollowController {
    private static final double distance = 2.0;
    private final PIDController forwardPID = new PIDController(
        ConstantValues.FollowerConstants.FORWARD_KP,
        ConstantValues.FollowerConstants.FORWARD_KI,
        ConstantValues.FollowerConstants.FORWARD_KD
    );
    private final PIDController strafePID = new PIDController(
        ConstantValues.FollowerConstants.STRAFE_KP,
        ConstantValues.FollowerConstants.STRAFE_KI,
        ConstantValues.FollowerConstants.STRAFE_KD
    );
    private final ProfiledPIDController yawPID = new ProfiledPIDController(
        ConstantValues.FollowerConstants.YAW_KP,
        ConstantValues.FollowerConstants.YAW_KI,
        ConstantValues.FollowerConstants.YAW_KD,
        new TrapezoidProfile.Constraints(
            ConstantValues.FollowerConstants.YAW_TRAPEZOIDAL_MAX_VEL,
            ConstantValues.FollowerConstants.YAW_TRAPEZOIDAL_MAX_ACC
        )
    );

    private static final double MAX_SPEED = 0.5;
    private static final double MAX_ROTATION = 0.3;
    private double forwardError = 0.0;
    private double strafeError = 0.0;
    private double yawError = 0.0;

    public FollowController() {
        forwardPID.setTolerance(    0.05);
        strafePID.setTolerance(0.05);
        yawPID.setTolerance(Math.toRadians(2));
    }
    public double[] calculate(PhotonVisionSubsystem vision) {

        Optional<PhotonTrackedTarget> target = vision.getFrontTarget();
        if (target.isEmpty()) {
            return new double[] {0, 0, 0};
        }
        
        PhotonTrackedTarget trackedTarget = target.get();
        
        double forwardDist = trackedTarget.getBestCameraToTarget().getX();
        double strafeDist = trackedTarget.getBestCameraToTarget().getY();
        double yaw = trackedTarget.getYaw();

        double forward = forwardPID.calculate(forwardDist, distance);
        double strafe = strafePID.calculate(strafeDist, 0.0);
        double rotation = yawPID.calculate(yaw, 0.0);

        forward = MathUtil.clamp(forward, -MAX_SPEED, MAX_SPEED);
        strafe = MathUtil.clamp(strafe, -MAX_SPEED, MAX_SPEED);
        rotation = MathUtil.clamp(rotation, -MAX_ROTATION, MAX_ROTATION);

        return new double[] {forward, strafe, rotation};
    }
    public double getForwardError() { return forwardError; }
    public double getStrafeError() { return strafeError; }
    public double getYawError() { return yawError; }
    public void reset() {
        forwardPID.reset();
        strafePID.reset();
        yawPID.reset(new TrapezoidProfile.State(0.0, 0.0));
        forwardError = 0.0;
        strafeError = 0.0;
        yawError = 0.0;
    }
}
