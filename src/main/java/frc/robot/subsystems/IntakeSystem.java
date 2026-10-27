package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.ConstantValues;
import com.ctre.phoenix6.controls.NeutralOut;

public class IntakeSystem extends SubsystemBase {
    private static IntakeSystem instance = null;
    public static IntakeSystem getInstance() {
        if (instance == null) {
            instance = new IntakeSystem(11);
        }
        System.out.println("********************** SHOOTER **********************");
        return instance;
    }

    private final TalonFX conveyorMotor;
    private NeutralOut brake = new NeutralOut();
    
        public IntakeSystem(int conveyorMotorID) {
            conveyorMotor = new TalonFX(conveyorMotorID);
            brake = new NeutralOut();
        
    }
    public void startConveyor() {
        conveyorMotor.setVoltage(
            ConstantValues.IntakeConstants.INTAKE_CONVEYOR_VOLTAGE
        );
    }
    public void stopConveyor() {
        conveyorMotor.setControl(
            brake
        );
    }

    
}
