package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;

public class FollowController {
    private static final double distance = 2.0;
    private final PIDController forwardPID = new PIDController(0.5, 0.0, 0.0);
    private final PIDController strafePID = new PIDController(0.5, 0.0, 0.0);
    private final PIDController yawPID = new PIDController(1.0, 0.0, 0.0);

    private static final double MAX_SPEED = 0.5;
    private static final double MAX_ROTATION = 0.3;

    public FollowController() {
        forwardPID.setTolerance(0.05);
        strafePID.setTolerance(0.05);
        yawPID.setTolerance(Math.toRadians(2));
    }
    public double[] calculate(ClassNameOfThePhotonVisionTargetLMAO target) {
        if (!target.valid) {
            return new double[] {0, 0, 0};
        }
        
        double forward = forwardPID.calculate(target.x, distance);
        double strafe = strafePID.calculate(target.y, distance);
        double rotation = yawPID.calculate(target.yaw, 0.0);

        forward = MathUtil.clamp(forward, -MAX_SPEED, MAX_SPEED);
        strafe = MathUtil.clamp(strafe, -MAX_SPEED, MAX_SPEED);
        rotation = MathUtil.clamp(rotation, -MAX_ROTATION, MAX_ROTATION);

        return new double[] {forward, strafe, rotation};
    }
    public void reset() {
        forwardPID.reset();
        strafePID.reset();
        yawPID.reset();
    }
}
