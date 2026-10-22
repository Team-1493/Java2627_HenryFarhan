package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ConstantValues {
    private static ConstantValues instance = null;

    public static ConstantValues getInstance() {
        if (instance == null) {
            instance = new ConstantValues();
            System.out.println("**********************  ConstantValues  **********************");
            writeConstantsDashboard();
        }
        return instance;
    }

    public static class DriveConstants {
        public static double TELEOP_kP = 3.45;
        public static double TELEOP_kS = 0;
        public static double TELEOP_kV = 0;
        public static double TELEOP_kA = 0;
        public static double TELEOP_DEADBAND = 0.0025;
        public static double TELEOP_MAX_ANGULAR_RATE = 1;
        public static double TELEOP_SCALE_FACTOR_XY = 0.9;
        public static double TELEOP_SCALE_FACTOR_ROT = 0.9;
        public static double SPEED_AT_12_VOLTS = 3.3;

        public static double AUTO_kP = 5.5;
        public static double AUTO_kS = 0.5;
        public static double AUTO_kV = 0;
        public static double AUTO_kA = 0;
    }

    public static class LimelightConstants {
        public static String[] CAM_NAME = {null, null, null, null};
        public static Double[] CAM_X_OFFSET = {null, null, null, null};
        public static Double[] CAM_Y_OFFSET = {null, null, null, null};
        public static Double[] CAM_Z_OFFSET = {null, null, null, null};
        public static Double[] CAM_THETA_X_OFFSET = {null, null, null, null};
        public static Double[] CAM_THETA_Y_OFFSET = {null, null, null, null};
        public static Double[] CAM_THETA_Z_OFFSET = {null, null, null, null};

        static {
            CAM_NAME[0] = "limelight-b";
            CAM_X_OFFSET[0] = -0.11;
            CAM_Y_OFFSET[0] = 0.0;
            CAM_Z_OFFSET[0] = 0.7652;
            CAM_THETA_X_OFFSET[0] = 0.0;
            CAM_THETA_Y_OFFSET[0] = 23.0;
            CAM_THETA_Z_OFFSET[0] = 0.0;

            CAM_NAME[1] = "limelight-a";
            CAM_X_OFFSET[1] = 0.07;
            CAM_Y_OFFSET[1] = 0.14;
            CAM_Z_OFFSET[1] = 0.7652;
            CAM_THETA_X_OFFSET[1] = 0.0;
            CAM_THETA_Y_OFFSET[1] = 23.0;
            CAM_THETA_Z_OFFSET[1] = 180.0;
        }

        public static double STD_DEV_COEFF_XY = 0.1;
        public static double STD_DEV_COEFF_THETA = 999;
        public static double CAMERA_CUTOFF_DISTANCE_1 = 2;
        public static double CAMERA_CUTOFF_DISTANCE_2 = 4;
        public static double CAMERA_CUTOFF_DIFFERENCE = 0.75;
    }

    public static class AutoBuilderConstants {
        public static double AUTOBUILDER_XY_kP = 5;
        public static double AUTOBUILDER_XY_kD = 0;
        public static double AUTOBUILDER_THETA_kP = 5;
        public static double AUTOBUILDER_THETA_kD = 0;
    }

    public static class HeadingControllerConstants {
        public static double HEADINGCONTROLLER_KP = 4;
        public static double HEADINGCONTROLLER_KD = 0.0;
        public static double HEADINGCONTROLLER_VMAX = 5;
        public static double HEADINGCONTROLLER_TOLERANCE = 0.017;
        public static double HEADINGCONTROLLER_RATE_TOLERANCE = 0.03;
        public static double SNAP_AWAY_FROM_WALL_DISTANCE = 1.1;
        public static double SNAP_WALL_SWING_CLEARANCE = 0.9;
        public static double SNAP_FORCED_KP = 4;
        public static double SNAP_FORCED_MIN_RATE = 0.35;
    }

    public static class IntakeConstants {
        public static double INTAKE_VOLTAGE = -5;
        public static double INTAKE_AUTO_VOLTAGE = -5.5;
        public static double INTAKE_MAX_VEL = 45;
        public static double INTAKE_STATOR_CL = 100;
        public static double INTAKE_SUPPLY_CL = 100;
        public static double INTAKE_LOWERLIMIT_CL = 100;
        public static double INTAKE_LOWERTIME_CL = 1;
        public static double INTAKE_CONVEYOR_VOLTAGE = -10;
        public static double INTAKE_CONVEYOR_SLOW_VOLTAGE = -2;
        public static double MAX_UP_ROTATION = 0.275;
        public static double MAX_DOWN_ROTATION = 0.00;
        public static double ARM_KP = 70;
        public static double ARM_KD = 0;
        public static double ARM_KI = 5;
        public static double ARM_KG = 0.45;
        public static double ARM_PEAK_FORWARD_TORQUE_CURRENT = 40;
        public static double ARM_PEAK_REVERSE_TORQUE_CURRENT = 40;
        public static double ARM_FORWARDTHRESH = 0.28;
        public static double ARM_REVERSETHRESH = 0;
        public static double SENSOR_TO_MECHANISM_RATIO = 16;
    }

    public static class ShooterConstants {
        public static double LEADER_KP = 0.9;
        public static double LEADER_KS = 0;
        public static double LEADER_KV = 0.178;
        public static double FEEDER_KP = 1;
        public static double FEEDER_KV = 0.124;
        public static double SHOOTING_VELOCITY = -1;
        public static double CONVEYOR_VELOCITY = 80;
        public static double TOLERANCE = 1e-3;
    }

    public static void updateConstants() {
        // Drive
        DriveConstants.TELEOP_kP = SmartDashboard.getNumber("Drive Teleop kP", DriveConstants.TELEOP_kP);
        DriveConstants.TELEOP_kS = SmartDashboard.getNumber("Drive Teleop kS", DriveConstants.TELEOP_kS);
        DriveConstants.TELEOP_kV = SmartDashboard.getNumber("Drive Teleop kV", DriveConstants.TELEOP_kV);
        DriveConstants.TELEOP_kA = SmartDashboard.getNumber("Drive Teleop kA", DriveConstants.TELEOP_kA);
        DriveConstants.AUTO_kP = SmartDashboard.getNumber("Drive Auto kP", DriveConstants.AUTO_kP);
        DriveConstants.AUTO_kS = SmartDashboard.getNumber("Drive Auto kS", DriveConstants.AUTO_kS);
        DriveConstants.AUTO_kV = SmartDashboard.getNumber("Drive Auto kV", DriveConstants.AUTO_kV);
        DriveConstants.AUTO_kA = SmartDashboard.getNumber("Drive Auto kA", DriveConstants.AUTO_kA);
        DriveConstants.TELEOP_DEADBAND = SmartDashboard.getNumber("Drive Teleop Deadband", DriveConstants.TELEOP_DEADBAND);
        DriveConstants.TELEOP_MAX_ANGULAR_RATE = SmartDashboard.getNumber("Drive Teleop MaxAngRate", DriveConstants.TELEOP_MAX_ANGULAR_RATE);
        DriveConstants.TELEOP_SCALE_FACTOR_XY = SmartDashboard.getNumber("Drive Teleop Scale XY", DriveConstants.TELEOP_SCALE_FACTOR_XY);
        DriveConstants.TELEOP_SCALE_FACTOR_ROT = SmartDashboard.getNumber("Drive Teleop Scale Rot", DriveConstants.TELEOP_SCALE_FACTOR_ROT);
        DriveConstants.SPEED_AT_12_VOLTS = SmartDashboard.getNumber("Drive Speed 12V", DriveConstants.SPEED_AT_12_VOLTS);

        // Intake
        IntakeConstants.INTAKE_VOLTAGE = SmartDashboard.getNumber("Intake Intake Volt", IntakeConstants.INTAKE_VOLTAGE);
        IntakeConstants.INTAKE_AUTO_VOLTAGE = SmartDashboard.getNumber("Intake Auto Volt", IntakeConstants.INTAKE_AUTO_VOLTAGE);
        IntakeConstants.INTAKE_MAX_VEL = SmartDashboard.getNumber("Intake Max Vel", IntakeConstants.INTAKE_MAX_VEL);
        IntakeConstants.INTAKE_STATOR_CL = SmartDashboard.getNumber("Intake Stator CL", IntakeConstants.INTAKE_STATOR_CL);
        IntakeConstants.INTAKE_SUPPLY_CL = SmartDashboard.getNumber("Intake Suply CL", IntakeConstants.INTAKE_SUPPLY_CL);
        IntakeConstants.INTAKE_LOWERLIMIT_CL = SmartDashboard.getNumber("Intake LowerLimit CL", IntakeConstants.INTAKE_LOWERLIMIT_CL);
        IntakeConstants.INTAKE_LOWERTIME_CL = SmartDashboard.getNumber("Intake LowerTime CL", IntakeConstants.INTAKE_LOWERTIME_CL);
        IntakeConstants.MAX_UP_ROTATION = SmartDashboard.getNumber("Intake Arm Max Up", IntakeConstants.MAX_UP_ROTATION);
        IntakeConstants.MAX_DOWN_ROTATION = SmartDashboard.getNumber("Intake Arm Max Down", IntakeConstants.MAX_DOWN_ROTATION);
        IntakeConstants.INTAKE_CONVEYOR_VOLTAGE = SmartDashboard.getNumber("Intake Conveyor Voltage", IntakeConstants.INTAKE_CONVEYOR_VOLTAGE);
        IntakeConstants.INTAKE_CONVEYOR_SLOW_VOLTAGE = SmartDashboard.getNumber("Intake Conveyor Slow Voltage", IntakeConstants.INTAKE_CONVEYOR_SLOW_VOLTAGE);
        IntakeConstants.ARM_KP = SmartDashboard.getNumber("Intake Arm kP", IntakeConstants.ARM_KP);
        IntakeConstants.ARM_KI = SmartDashboard.getNumber("Intake Arm kI", IntakeConstants.ARM_KI);
        IntakeConstants.ARM_KD = SmartDashboard.getNumber("Intake Arm kD", IntakeConstants.ARM_KD);
        IntakeConstants.ARM_KG = SmartDashboard.getNumber("Intake Arm kG", IntakeConstants.ARM_KG);
        IntakeConstants.ARM_PEAK_FORWARD_TORQUE_CURRENT = SmartDashboard.getNumber("Intake Arm Peak Curr For", IntakeConstants.ARM_PEAK_FORWARD_TORQUE_CURRENT);
        IntakeConstants.ARM_PEAK_REVERSE_TORQUE_CURRENT = SmartDashboard.getNumber("Intake Arm Peak Curr Rev", IntakeConstants.ARM_PEAK_REVERSE_TORQUE_CURRENT);
        IntakeConstants.ARM_FORWARDTHRESH = SmartDashboard.getNumber("Intake Arm For Thresh", IntakeConstants.ARM_FORWARDTHRESH);
        IntakeConstants.ARM_REVERSETHRESH = SmartDashboard.getNumber("Intake Arm Rev Thresh", IntakeConstants.ARM_REVERSETHRESH);
        IntakeConstants.SENSOR_TO_MECHANISM_RATIO = SmartDashboard.getNumber("Intake Arm Mech Ratio", IntakeConstants.SENSOR_TO_MECHANISM_RATIO);

        // Shooter
        ShooterConstants.LEADER_KP = SmartDashboard.getNumber("Leader KP", ShooterConstants.LEADER_KP);
        ShooterConstants.LEADER_KV = SmartDashboard.getNumber("Leader KV", ShooterConstants.LEADER_KV);
        ShooterConstants.LEADER_KS = SmartDashboard.getNumber("Leader KS", ShooterConstants.LEADER_KS);
        ShooterConstants.CONVEYOR_VELOCITY = SmartDashboard.getNumber("Conveyor Velocity", ShooterConstants.CONVEYOR_VELOCITY);
        ShooterConstants.FEEDER_KV = SmartDashboard.getNumber("Feeder KV", ShooterConstants.FEEDER_KV);
        ShooterConstants.FEEDER_KP = SmartDashboard.getNumber("Feeder KP", ShooterConstants.FEEDER_KP);
        ShooterConstants.SHOOTING_VELOCITY = SmartDashboard.getNumber("Shooting Velocity", ShooterConstants.SHOOTING_VELOCITY);

        // Limelight
        LimelightConstants.CAM_NAME[0] = SmartDashboard.getString("LL Cam0 Name", LimelightConstants.CAM_NAME[0]);
        LimelightConstants.CAM_X_OFFSET[0] = SmartDashboard.getNumber("LL CAM0 x_offset", LimelightConstants.CAM_X_OFFSET[0]);
        LimelightConstants.CAM_Y_OFFSET[0] = SmartDashboard.getNumber("LL CAM0 y_offset", LimelightConstants.CAM_Y_OFFSET[0]);
        LimelightConstants.CAM_Z_OFFSET[0] = SmartDashboard.getNumber("LL CAM0 z_offset", LimelightConstants.CAM_Z_OFFSET[0]);
        LimelightConstants.CAM_THETA_X_OFFSET[0] = SmartDashboard.getNumber("LL CAM0 thetaX_offset", LimelightConstants.CAM_THETA_X_OFFSET[0]);
        LimelightConstants.CAM_THETA_Y_OFFSET[0] = SmartDashboard.getNumber("LL CAM0 thetaY_offset", LimelightConstants.CAM_THETA_Y_OFFSET[0]);
        LimelightConstants.CAM_THETA_Z_OFFSET[0] = SmartDashboard.getNumber("LL CAM0 thetaZ_offset", LimelightConstants.CAM_THETA_Z_OFFSET[0]);
        LimelightConstants.CAM_NAME[1] = SmartDashboard.getString("LL CAM1 Name", LimelightConstants.CAM_NAME[1]);
        LimelightConstants.CAM_X_OFFSET[1] = SmartDashboard.getNumber("LL CAM1 x_offset", LimelightConstants.CAM_X_OFFSET[1]);
        LimelightConstants.CAM_Y_OFFSET[1] = SmartDashboard.getNumber("LL CAM1 y_offset", LimelightConstants.CAM_Y_OFFSET[1]);
        LimelightConstants.CAM_Z_OFFSET[1] = SmartDashboard.getNumber("LL CAM1 z_offset", LimelightConstants.CAM_Z_OFFSET[1]);
        LimelightConstants.CAM_THETA_X_OFFSET[1] = SmartDashboard.getNumber("LL CAM1 thetaX_offset", LimelightConstants.CAM_THETA_X_OFFSET[1]);
        LimelightConstants.CAM_THETA_Y_OFFSET[1] = SmartDashboard.getNumber("LL CAM1 thetaY_offset", LimelightConstants.CAM_THETA_Y_OFFSET[1]);
        LimelightConstants.CAM_THETA_Z_OFFSET[1] = SmartDashboard.getNumber("LL CAM1 thetaZ_offset", LimelightConstants.CAM_THETA_Z_OFFSET[1]);
        LimelightConstants.STD_DEV_COEFF_XY = SmartDashboard.getNumber("LL StdDevCoeff_xy", LimelightConstants.STD_DEV_COEFF_XY);
        LimelightConstants.STD_DEV_COEFF_THETA = SmartDashboard.getNumber("LL StdDevCoeff_theta", LimelightConstants.STD_DEV_COEFF_THETA);
        LimelightConstants.CAMERA_CUTOFF_DISTANCE_1 = SmartDashboard.getNumber("LL CutoffDist_1", LimelightConstants.CAMERA_CUTOFF_DISTANCE_1);
        LimelightConstants.CAMERA_CUTOFF_DISTANCE_2 = SmartDashboard.getNumber("LL CutoffDist_2", LimelightConstants.CAMERA_CUTOFF_DISTANCE_2);
        LimelightConstants.CAMERA_CUTOFF_DIFFERENCE = SmartDashboard.getNumber("LL CutoffDifference", LimelightConstants.CAMERA_CUTOFF_DIFFERENCE);

        // AutoBuilder
        AutoBuilderConstants.AUTOBUILDER_XY_kP = SmartDashboard.getNumber("AutoBuilder XY_kP", AutoBuilderConstants.AUTOBUILDER_XY_kP);
        AutoBuilderConstants.AUTOBUILDER_XY_kD = SmartDashboard.getNumber("AutoBuilder XY_kD", AutoBuilderConstants.AUTOBUILDER_XY_kD);
        AutoBuilderConstants.AUTOBUILDER_THETA_kP = SmartDashboard.getNumber("AutoBuilder THETA_kP", AutoBuilderConstants.AUTOBUILDER_THETA_kP);
        AutoBuilderConstants.AUTOBUILDER_THETA_kD = SmartDashboard.getNumber("AutoBuilder THETA_kD", AutoBuilderConstants.AUTOBUILDER_THETA_kD);

        // Heading controller
        HeadingControllerConstants.HEADINGCONTROLLER_KP = SmartDashboard.getNumber("HeadingController kP", HeadingControllerConstants.HEADINGCONTROLLER_KP);
        HeadingControllerConstants.HEADINGCONTROLLER_KD = SmartDashboard.getNumber("HeadingController kD", HeadingControllerConstants.HEADINGCONTROLLER_KD);
        HeadingControllerConstants.HEADINGCONTROLLER_VMAX = SmartDashboard.getNumber("HeadingController Vmax", HeadingControllerConstants.HEADINGCONTROLLER_VMAX);
        HeadingControllerConstants.HEADINGCONTROLLER_TOLERANCE = SmartDashboard.getNumber("HeadingController Tol", HeadingControllerConstants.HEADINGCONTROLLER_TOLERANCE);
        HeadingControllerConstants.HEADINGCONTROLLER_RATE_TOLERANCE = SmartDashboard.getNumber("HeadingController Rate Tol", HeadingControllerConstants.HEADINGCONTROLLER_RATE_TOLERANCE);
    }

    public static void writeConstantsDashboard() {
        // Drive
        SmartDashboard.putNumber("Drive Teleop kP", DriveConstants.TELEOP_kP);
        SmartDashboard.putNumber("Drive Teleop kS", DriveConstants.TELEOP_kS);
        SmartDashboard.putNumber("Drive Teleop kV", DriveConstants.TELEOP_kV);
        SmartDashboard.putNumber("Drive Teleop kA", DriveConstants.TELEOP_kA);
        SmartDashboard.putNumber("Drive Auto kP", DriveConstants.AUTO_kP);
        SmartDashboard.putNumber("Drive Auto kS", DriveConstants.AUTO_kS);
        SmartDashboard.putNumber("Drive Auto kV", DriveConstants.AUTO_kV);
        SmartDashboard.putNumber("Drive Auto kA", DriveConstants.AUTO_kA);
        SmartDashboard.putNumber("Drive Teleop Deadband", DriveConstants.TELEOP_DEADBAND);
        SmartDashboard.putNumber("Drive Teleop MaxAngRate", DriveConstants.TELEOP_MAX_ANGULAR_RATE);
        SmartDashboard.putNumber("Drive Teleop Scale XY", DriveConstants.TELEOP_SCALE_FACTOR_XY);
        SmartDashboard.putNumber("Drive Teleop Scale Rot", DriveConstants.TELEOP_SCALE_FACTOR_ROT);
        SmartDashboard.putNumber("Drive Speed 12V", DriveConstants.SPEED_AT_12_VOLTS);

        // Intake
        SmartDashboard.putNumber("Intake Intake Volt", IntakeConstants.INTAKE_VOLTAGE);
        SmartDashboard.putNumber("Intake Auto Volt", IntakeConstants.INTAKE_AUTO_VOLTAGE);
        SmartDashboard.putNumber("Intake Max Vel", IntakeConstants.INTAKE_MAX_VEL);
        SmartDashboard.putNumber("Intake Stator CL", IntakeConstants.INTAKE_STATOR_CL);
        SmartDashboard.putNumber("Intake Suply CL", IntakeConstants.INTAKE_SUPPLY_CL);
        SmartDashboard.putNumber("Intake LowerLimit CL", IntakeConstants.INTAKE_LOWERLIMIT_CL);
        SmartDashboard.putNumber("Intake LowerTime CL", IntakeConstants.INTAKE_LOWERTIME_CL);
        SmartDashboard.putNumber("Intake Conveyor Voltage", IntakeConstants.INTAKE_CONVEYOR_VOLTAGE);
        SmartDashboard.putNumber("Intake Conveyor Slow Voltage", IntakeConstants.INTAKE_CONVEYOR_SLOW_VOLTAGE);
        SmartDashboard.putNumber("Intake Arm Max Up", IntakeConstants.MAX_UP_ROTATION);
        SmartDashboard.putNumber("Intake Arm Max Down", IntakeConstants.MAX_DOWN_ROTATION);
        SmartDashboard.putNumber("Intake Arm kP", IntakeConstants.ARM_KP);
        SmartDashboard.putNumber("Intake Arm kI", IntakeConstants.ARM_KI);
        SmartDashboard.putNumber("Intake Arm kD", IntakeConstants.ARM_KD);
        SmartDashboard.putNumber("Intake Arm kG", IntakeConstants.ARM_KG);
        SmartDashboard.putNumber("Intake Arm Peak Curr For", IntakeConstants.ARM_PEAK_FORWARD_TORQUE_CURRENT);
        SmartDashboard.putNumber("Intake Arm Peak Curr Rev", IntakeConstants.ARM_PEAK_REVERSE_TORQUE_CURRENT);
        SmartDashboard.putNumber("Intake Arm For Thresh", IntakeConstants.ARM_FORWARDTHRESH);
        SmartDashboard.putNumber("Intake Arm Rev Thresh", IntakeConstants.ARM_REVERSETHRESH);
        SmartDashboard.putNumber("Intake Arm Mech Ratio", IntakeConstants.SENSOR_TO_MECHANISM_RATIO);

        // Limelight
        SmartDashboard.putString("LL CAM0 Cam Name", LimelightConstants.CAM_NAME[0]);
        SmartDashboard.putNumber("LL CAM0 x_offset", LimelightConstants.CAM_X_OFFSET[0]);
        SmartDashboard.putNumber("LL CAM0 y_offset", LimelightConstants.CAM_Y_OFFSET[0]);
        SmartDashboard.putNumber("LL CAM0 z_offset", LimelightConstants.CAM_Z_OFFSET[0]);
        SmartDashboard.putNumber("LL CAM0 thetaX_offset", LimelightConstants.CAM_THETA_X_OFFSET[0]);
        SmartDashboard.putNumber("LL CAM0 thetaY_offset", LimelightConstants.CAM_THETA_Y_OFFSET[0]);
        SmartDashboard.putNumber("LL CAM0 thetaZ_offset", LimelightConstants.CAM_THETA_Z_OFFSET[0]);
        SmartDashboard.putString("LL CAM1 Cam Name", LimelightConstants.CAM_NAME[1]);
        SmartDashboard.putNumber("LL CAM1 x_offset", LimelightConstants.CAM_X_OFFSET[1]);
        SmartDashboard.putNumber("LL CAM1 y_offset", LimelightConstants.CAM_Y_OFFSET[1]);
        SmartDashboard.putNumber("LL CAM1 z_offset", LimelightConstants.CAM_Z_OFFSET[1]);
        SmartDashboard.putNumber("LL CAM1 thetaX_offset", LimelightConstants.CAM_THETA_X_OFFSET[1]);
        SmartDashboard.putNumber("LL CAM1 thetaY_offset", LimelightConstants.CAM_THETA_Y_OFFSET[1]);
        SmartDashboard.putNumber("LL CAM1 thetaZ_offset", LimelightConstants.CAM_THETA_Z_OFFSET[1]);
        SmartDashboard.putNumber("LL StdDevCoeff_xy", LimelightConstants.STD_DEV_COEFF_XY);
        SmartDashboard.putNumber("LL StdDevCoeff_theta", LimelightConstants.STD_DEV_COEFF_THETA);
        SmartDashboard.putNumber("LL CutoffDist_1", LimelightConstants.CAMERA_CUTOFF_DISTANCE_1);
        SmartDashboard.putNumber("LL CutoffDist_2", LimelightConstants.CAMERA_CUTOFF_DISTANCE_2);
        SmartDashboard.putNumber("LL CutoffDiff", LimelightConstants.CAMERA_CUTOFF_DIFFERENCE);

        // AutoBuilder
        SmartDashboard.putNumber("AutoBuilder XY_kP", AutoBuilderConstants.AUTOBUILDER_XY_kP);
        SmartDashboard.putNumber("AutoBuilder XY_kD", AutoBuilderConstants.AUTOBUILDER_XY_kD);
        SmartDashboard.putNumber("AutoBuilder THETA_kP", AutoBuilderConstants.AUTOBUILDER_THETA_kP);
        SmartDashboard.putNumber("AutoBuilder THETA_kD", AutoBuilderConstants.AUTOBUILDER_THETA_kD);

        // Heading controller
        SmartDashboard.putNumber("HeadingController kP", HeadingControllerConstants.HEADINGCONTROLLER_KP);
        SmartDashboard.putNumber("HeadingController kD", HeadingControllerConstants.HEADINGCONTROLLER_KD);
        SmartDashboard.putNumber("HeadingController Vmax", HeadingControllerConstants.HEADINGCONTROLLER_VMAX);
        SmartDashboard.putNumber("HeadingController Tol", HeadingControllerConstants.HEADINGCONTROLLER_TOLERANCE);
        SmartDashboard.putNumber("HeadingController Rate Tol", HeadingControllerConstants.HEADINGCONTROLLER_RATE_TOLERANCE);

        // Shooter
        SmartDashboard.putNumber("Leader KP", ShooterConstants.LEADER_KP);
        SmartDashboard.putNumber("Leader KV", ShooterConstants.LEADER_KV);
        SmartDashboard.putNumber("Leader KS", ShooterConstants.LEADER_KS);
        SmartDashboard.putNumber("Feeder KV", ShooterConstants.FEEDER_KV);
        SmartDashboard.putNumber("Feeder KP", ShooterConstants.FEEDER_KP);
        SmartDashboard.putNumber("Shooting Velocity", ShooterConstants.SHOOTING_VELOCITY);
        SmartDashboard.putNumber("Conveyor Velocity", ShooterConstants.CONVEYOR_VELOCITY);
    }
}
