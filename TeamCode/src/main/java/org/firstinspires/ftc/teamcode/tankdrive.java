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

    private static DcMotor l1, l2, r1, r2, i1, i2, a;
    //  private static Servo r, c;

//--------------------------------------------------------------------------------------------------

    @Override
    public void init()
    //this is where the lines for init-ing and reversing goes
    {
        l1  = hardwareMap.dcMotor.get(UniversalConstants.l1) ;
        l2   = hardwareMap.dcMotor.get(UniversalConstants.l2) ;
        r1 = hardwareMap.dcMotor.get(UniversalConstants.r1);
        r2  = hardwareMap.dcMotor.get(UniversalConstants.r2);

        i1  = hardwareMap.dcMotor.get(UniversalConstants.i1);
        i2  = hardwareMap.dcMotor.get(UniversalConstants.i2);

        //  a = hardwareMap.dcMotor.get(UniversalConstants.a);

        // r = hardwareMap.servo.get(UniversalConstants.r);

        // c = hardwareMap.servo.get(UniversalConstants.c);

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
        //intake motor control

        if (gamepad1.a)
        {
            i1.setPower(-1);
            i2.setPower(1);
        }
        else
        {
            i1.setPower(0);
            i2.setPower(0);
        }

        if (gamepad1.y)
        {
            i1.setPower(1);
            i2.setPower(-1);
        }
        else
        {
            i1.setPower(0);
            i2.setPower(0);
        }

//--------------------------------------------------------------------------------------------------

    }


}