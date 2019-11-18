package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode ;
import com.qualcomm.robotcore.hardware.DcMotor        ;
import com.qualcomm.robotcore.hardware.DcMotorSimple  ;
import com.qualcomm.robotcore.hardware.Servo          ;
import java.util.Arrays;
import com.qualcomm.robotcore.hardware.ColorSensor;
import java.util.Arrays;

@TeleOp(name="servo_test", group="TeleOp")
public class servo_test extends OpMode
{

    private static Servo testServo;

    @Override
    public void init()
    {
        testServo = hardwareMap.servo.get(UniversalConstants.testServo) ;



        double volts = hardwareMap.voltageSensor.get("Expansion Hub 2").getVoltage();
    }
//--------------------------------------------------------------------------------------------------

    @Override

    public void loop()
    {

        testServo.setPosition(1);

    }

//--------------------------------------------------------------------------------------------------
}
