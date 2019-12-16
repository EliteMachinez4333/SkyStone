package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode ;
import com.qualcomm.robotcore.hardware.DcMotor        ;
import com.qualcomm.robotcore.hardware.DcMotorSimple  ;
import com.qualcomm.robotcore.hardware.Servo          ;
import java.util.Arrays;
import com.qualcomm.robotcore.hardware.ColorSensor;
import java.util.Arrays;


@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="tankdrive", group="TeleOp")
public class tankdrive extends OpMode
{

    private static final double TRIGGERTHRESHOLD = .2     ;
    private static final double ACCEPTINPUTTHRESHOLD = .15;
    private static final double SCALEDPOWER = 1; //Emphasis on current controller reading (vs current motor power) on the drive train

    private static DcMotor l1, l2, r1, r2;

//--------------------------------------------------------------------------------------------------

    @Override
    public void init()
    //this is where the lines for init-ing and reversing goes
    {
        l1 = hardwareMap.dcMotor.get("l1");
        l2 = hardwareMap.dcMotor.get("l2");
        r1 = hardwareMap.dcMotor.get("r1");
        r2 = hardwareMap.dcMotor.get("r2");

        //reverse all but rightFrontWheel, because of the way that the REV motors are oriented
        l1.setDirection(DcMotorSimple.Direction.REVERSE);
        l2.setDirection(DcMotorSimple.Direction.REVERSE) ;
        r1.setDirection(DcMotorSimple.Direction.REVERSE);
        r2.setDirection(DcMotorSimple.Direction.REVERSE);

        double volts = hardwareMap.voltageSensor.get("Expansion Hub 2").getVoltage();
    }
//--------------------------------------------------------------------------------------------------

    @Override

    public void loop()

    {
//--------------------------------------------------------------------------------------------------

        l1.setPower(gamepad1.left_stick_y);
        l2.setPower(gamepad1.left_stick_y);
        r1.setPower(gamepad1.left_stick_y);
        r2.setPower(gamepad1.left_stick_y);


//--------------------------------------------------------------------------------------------------

    }


}