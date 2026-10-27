package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;

import frc.robot.subsystems.ShooterSystem;
// import frc.robot.subsystems.IntakeSystem;
import edu.wpi.first.wpilibj2.command.Command;
// import Utilities.HelperMethods;

public class ConveyorCommand extends Command {

    private final ShooterSystem shooter;
    // private final IntakeSystem intake;
    private final Timer timer;
    

    public ShootCommand() {
        SmartDashboard.putNumber("Shooter Speed Calculated", 0);
        shooter = ShooterSystem.getInstance();
        // intake = IntakeSystem.getInstance();
        timer = new Timer();
        addRequirements(shooter);
    }

    public void Initialize() {
        double shooterSpeed = getShooterSpeed();

        SmartDashboard.putNumber("Shooter Speed Calculator", shooterSpeed);
        shooter.shoot(shooterSpeed);
        // intake.startConveyorReverse();
        timer.reset();
        timer.start();
        SmartDashboard.putString("Shoot State", "SHOOTING");
    }

    public void execute() {
        double currentTime = timer.get();
        shooter.moveConveyor();
        shooter.shoot(2);
        if (currentTime > 0.05 && currentTime < 1) {
            // intake.stopConveyor()
        }

        if (timer.get() > 1) {
            // intake.startConveyor();
            // intake.intake();
            // intake.armToPos(0.1 + 0.1 * Math.sin(1.5 * timer.get() * math.pi));
            double pos = Math.min(0.18, 0.18 * timer.get() / 4.5);
            // intake.armToPos(pos);
        }
    }
    
    public void end() {
        SmartDashboard.putString("Shoot State", "NOT");
        // intake.stopArm();
        // intake.stopConveyor();
        // intake.stopIntake();
        shooter.stopConveyor();
        shooter.stopShooter();
    }

    public boolean isFinished() {
        return false;
    }
}
