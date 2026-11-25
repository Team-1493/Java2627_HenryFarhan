package frc.robot.utils;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class HelperMethods {

    private final static double[] dataDist1 = {2.10, 2.50, 3.00, 3.50, 4.00};
    private final static double[] dataDist2 = {8.90, 9.26, 9.72, 10.35, 11.3};

    private static double xr;
    private static double yr;
    private static double xh;
    private static double yh;

    private static double angleHub;
    private static double distHub;

    public HelperMethods() {
        SmartDashboard.putNumberArray("Shoot Dist data", dataDist1);
        SmartDashboard.putNumberArray("Shoot Speed data", dataDist2);
    }
    
    // public double calcShootSpeed() {
    //     double dist = HelperMethods.distToHub();
    //             double[] x = HelperMethods.dataDist1;
    //             double[] y = HelperMethods.dataDist2;
        
    //             if (dist <= x[0]) {  
    //                 return y[0];
    //             }
    //             if (dist >= x[-1]) {
    //                 return y[-1];
    //             }
    //                // URGENT CHANGE CHANGE
    //             double i;
        
    //             double x1 = x[i-1]; double x2 = x[i];
    //             double y1 = y[i-1]; double y2 = y[i];
    //             double t = (dist - x1) / (x2 - x1);
        
    //             return y1 + t * (y2 - y1);
    //         }
        
    // public static double distToHub() {
    //     Pose2d pose = HelperMethods.dt.pose;
    //     xr = pose.getX();
    //     yr = pose.getY();

    //     double color = HelperMethods.dt.allianceColor;
    //     if (color == none) {
    //         color = DriverStation.Alliance.Blue;
    //     } else if (color == DriverStation.Alliance.Blue) {
    //         xh = 4.644;
    //         yh = 4.030;
    //     }

    //     double xr1 = xh - xr;
    //     double yr1 = yh - yr;

    //     double xt = -yr1;
    //     double yt = xr1;

    //     angleHub = Math.atan2(xt, xt) - Math.PI/2;
    //     distHub = Math.hypot(xt, yt);
    //     SmartDashboard.putNumber("Distance To Hub", distHub);
    //     return new double[]{angleHub, distHub};
    // }
}