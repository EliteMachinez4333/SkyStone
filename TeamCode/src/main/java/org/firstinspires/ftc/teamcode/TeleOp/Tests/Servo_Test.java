package org.firstinspires.ftc.teamcode.TeleOp.Tests;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode ;
import com.qualcomm.robotcore.hardware.Servo          ;

import org.firstinspires.ftc.teamcode.Auto.AutoSubsystems;
import org.firstinspires.ftc.teamcode.TeleOp.TeleOpSubsystems;

@Disabled
@TeleOp(name="Servo Test", group="TeleOp")
public class Servo_Test extends OpMode
{

    private static Servo servo;

    @Override
    public void init()
    {
        servo = hardwareMap.servo.get(TestSubsytems.servo) ;



        double volts = hardwareMap.voltageSensor.get("Expansion Hub 2").getVoltage();
    }
//--------------------------------------------------------------------------------------------------

    @Override

    public void loop()
    {

        servo.setPosition(1);

    }

//--------------------------------------------------------------------------------------------------
}
