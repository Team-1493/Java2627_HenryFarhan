package frc.robot.subsystems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.controls.NeutralOut;
import com.ctre.phoenix6.signals.MotorAlignmentValue;

import frc.robot.ConstantValues;

public class ShooterSystem extends SubsystemBase {

    private static ShooterSystem instance = null;

    public static ShooterSystem getInstance() {
        if (instance == null) {
            instance = new ShooterSystem(
                14,
                new int[] {15},
                new int[] {16, 17},
                12,
                13
            );

            System.out.println("********************** SHOOTER **********************");
        }

        return instance;
    }

    private final TalonFX leaderMotor;
    private final TalonFX feederMotor;
    private final TalonFX feeder2Motor;

    private final List<TalonFX> followers = new ArrayList<>();
    private final List<TalonFX> oppositeFollowers = new ArrayList<>();
    private final List<TalonFX> allMotors = new ArrayList<>();

    private final TalonFXConfiguration leaderCfg =
        new TalonFXConfiguration();

    private final TalonFXConfiguration feederCfg =
        new TalonFXConfiguration();

    private final VelocityVoltage velocityVoltage =
        new VelocityVoltage(0);

    private final VoltageOut voltageControl =
        new VoltageOut(0);

    private final NeutralOut brake =
        new NeutralOut();

    private double conveyorVelocity;
    private double velocity;
    private double conveyorVoltage;

    public ShooterSystem(
        int leaderMotorId,
        int[] followerIds,
        int[] oppositeFollowerIds,
        int feederId,
        int feeder2Id
    ) {
        // Initialize motors
        leaderMotor = new TalonFX(leaderMotorId);
        feederMotor = new TalonFX(feederId);
        feeder2Motor = new TalonFX(feeder2Id);

        // Initialize aligned followers
        for (int motorId : followerIds) {
            TalonFX motor = new TalonFX(motorId);
            motor.setControl(
                new Follower(
                    leaderMotorId,
                    MotorAlignmentValue.Aligned
                )
            );

            followers.add(motor);
        }

        // Initialize opposed followers
        for (int motorId : oppositeFollowerIds) {
            TalonFX motor = new TalonFX(motorId);
            motor.setControl(
                new Follower(
                    leaderMotorId,
                    MotorAlignmentValue.Opposed
                )
            );

            oppositeFollowers.add(motor);
        }

        // Collect all shooter motors
        allMotors.addAll(followers);
        allMotors.addAll(oppositeFollowers);
        allMotors.add(leaderMotor);

        // Configure leader motor
        leaderCfg.Slot0.kV =
            ConstantValues.ShooterConstants.LEADER_KV;
        leaderCfg.Slot0.kP =
            ConstantValues.ShooterConstants.LEADER_KP;
        leaderCfg.Slot0.kS =
            ConstantValues.ShooterConstants.LEADER_KS;

        leaderCfg.CurrentLimits.StatorCurrentLimitEnable = true;
        leaderCfg.CurrentLimits.StatorCurrentLimit = 100;

        leaderMotor.getConfigurator().apply(leaderCfg);

        // Configure feeder motors
        feederCfg.Slot0.kV =
            ConstantValues.ShooterConstants.FEEDER_KV;
        feederCfg.Slot0.kP =
            ConstantValues.ShooterConstants.FEEDER_KP;

        feederMotor.getConfigurator().apply(feederCfg);
        feeder2Motor.getConfigurator().apply(feederCfg);

        // Load constants
        conveyorVelocity =
            ConstantValues.ShooterConstants.CONVEYOR_VELOCITY;

        velocity =
            ConstantValues.ShooterConstants.SHOOTING_VELOCITY;

        // Set status signal update frequencies
        leaderMotor.getVelocity().setUpdateFrequency(200);

        for (TalonFX motor : followers) {
            motor.getVelocity().setUpdateFrequency(10);
        }

        for (TalonFX motor : oppositeFollowers) {
            motor.getVelocity().setUpdateFrequency(10);
        }
    }

    @Override
    public void periodic() {
        // Runs periodically during the robot's scheduler loop.
    }

    /**
     * Set the shooter velocity.
     */
    public void shoot(double vel) {
        velocity = vel;

        leaderMotor.setControl(
            velocityVoltage.withVelocity(velocity)
        );
    }

    /**
     * Stop the shooter.
     */
    public void stopShooter() {
        leaderMotor.setControl(brake);

        // Alternative:
        // leaderMotor.setControl(voltageControl.withOutput(0));
    }

    /**
     * Run both conveyor motors forward immediately.
     */
    public void immediateMoveConveyor() {
        feederMotor.setControl(
            velocityVoltage.withVelocity(conveyorVelocity)
        );

        feeder2Motor.setControl(
            velocityVoltage.withVelocity(conveyorVelocity)
        );
    }

    /**
     * Run both conveyor motors in reverse.
     */
    public void reverseMoveConveyor() {
        feederMotor.setControl(
            velocityVoltage.withVelocity(-conveyorVelocity)
        );

        feeder2Motor.setControl(
            velocityVoltage.withVelocity(-conveyorVelocity)
        );
    }

    /**
     * Run the conveyor when the shooter reaches its target speed.
     */
    public void moveConveyor() {
        double leaderVel =
            leaderMotor.getVelocity().getValueAsDouble();

        if (
            Math.abs(velocity - leaderVel)
                / (leaderVel + 0.0001) <= 0.08
            || leaderVel >= velocity * 0.98
        ) {
            feederMotor.setControl(
                velocityVoltage.withVelocity(conveyorVelocity)
            );

            feeder2Motor.setControl(
                velocityVoltage.withVelocity(conveyorVelocity)
            );
        }
    }

    /**
     * Stop both conveyor motors.
     */
    public void stopConveyor() {
        feederMotor.setControl(brake);
        feeder2Motor.setControl(brake);
    }

    /**
     * Publish shooter velocity to SmartDashboard.
     */
    public void writeToDashboard() {
        SmartDashboard.putNumber(
            "Shooter leader velocity",
            leaderMotor.getVelocity().getValueAsDouble()
        );
    }

    /**
     * Update PID constants and conveyor settings from SmartDashboard.
     */
    public void updateConstants() {
        leaderCfg.Slot0.kV =
            SmartDashboard.getNumber("Leader KV", 0);

        leaderCfg.Slot0.kP =
            SmartDashboard.getNumber("Leader KP", 0);

        leaderCfg.Slot0.kS =
            ConstantValues.ShooterConstants.LEADER_KS;

        leaderMotor.getConfigurator().apply(leaderCfg);

        feederCfg.Slot0.kP =
            SmartDashboard.getNumber("Feeder KP", 0);

        feederCfg.Slot0.kV =
            SmartDashboard.getNumber("Feeder KV", 0);

        feederMotor.getConfigurator().apply(feederCfg);
        feeder2Motor.getConfigurator().apply(feederCfg);

        conveyorVelocity =
            SmartDashboard.getNumber("Conveyor Velocity", 0);

        conveyorVoltage =
            SmartDashboard.getNumber("Shooter conveyor V", 0);
    }
}
