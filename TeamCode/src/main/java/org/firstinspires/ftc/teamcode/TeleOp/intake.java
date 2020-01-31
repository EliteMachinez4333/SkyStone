package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode ;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor        ;

import java.util.Arrays;


@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="intake", group="TeleOp")
public class intake extends OpMode
{

    private static final double TRIGGERTHRESHOLD = .2     ;
    private static final double ACCEPTINPUTTHRESHOLD = .15;
    private static final double SCALEDPOWER = 0.6; //Emphasis on current controller reading (vs current motor power) on the drive train


    //  private static final double SCALEDPOWER = 0.4; //Emphasis on current controller reading (vs current motor power) on the drive train


    private static DcMotor l1, l2, r1, r2, i1, i2;
    private static ColorSensor colorSensor;

    //  private static Servo r, c;

//--------------------------------------------------------------------------------------------------

    @Override
    public void init()
    //this is where the lines for init-ing and reversing goes
    {
        l1           = hardwareMap.dcMotor.get(TeleOpSubsystems.l1) ;
        l2           = hardwareMap.dcMotor.get(TeleOpSubsystems.l2) ;
        r1           = hardwareMap.dcMotor.get(TeleOpSubsystems.r1);
        r2           = hardwareMap.dcMotor.get(TeleOpSubsystems.r2);

        i1           = hardwareMap.dcMotor.get(TeleOpSubsystems.i1);
        i2           = hardwareMap.dcMotor.get(TeleOpSubsystems.i2);

        colorSensor = hardwareMap.get(ColorSensor.class, "c");


        //reverse all but rightFrontWheel, because of the way that the REV motors are oriented
         l1.setDirection(DcMotor.Direction.REVERSE);
         l2.setDirection(DcMotor.Direction.REVERSE) ;
        // r1.setDirection(DcMotor.Direction.REVERSE);
        // r2.setDirection(DcMotor.Direction.REVERSE);

        double volts = hardwareMap.voltageSensor.get("Expansion Hub 1").getVoltage();
    }
//--------------------------------------------------------------------------------------------------

    @Override

    public void loop()

    {
//--------------------------------------------------------------------------------------------------
        if (gamepad1.a)
        {
            i1.setPower(1);
            i2.setPower(-1);
        }
        else if (gamepad1.b)
        {
            i1.setPower(-1);
            i2.setPower(1);
        }
        else if (gamepad1.x)
        {
            i1.setPower(0);
            i2.setPower(0);
        }




        telemetry.addData("Red  ", (colorSensor.red()*10));
        telemetry.addData("Green", (colorSensor.green()*10));
        telemetry.addData("Blue ", (colorSensor.blue()*10));



//--------------------------------------------------------------------------------------------------

        //mecanum drivetrain control

        //moves mecanum wheel motors based on absolute values from the sticks that take into account rotation
        //strafing works
        double inputY = Math.abs(gamepad1.left_stick_y) > ACCEPTINPUTTHRESHOLD ? gamepad1.left_stick_y : 0 ;
        double inputX = Math.abs(gamepad1.left_stick_x) > ACCEPTINPUTTHRESHOLD ? -gamepad1.left_stick_x : 0;
        double inputC = Math.abs(gamepad1.right_stick_x)> ACCEPTINPUTTHRESHOLD ? -gamepad1.right_stick_x: 0;
//left left right
        arcadeMecanum(inputY, inputX, inputC, l1, r1, l2, r2);
    }

    // y - forwards
    // x - side
    // c - rotation
    public static void arcadeMecanum(double y, double x, double c, DcMotor leftFront, DcMotor rightFront, DcMotor leftBack, DcMotor rightBack)
    {
        double leftFrontVal  = y + x + c;       /*r2*/
        double rightFrontVal = y - x - c;       /*r1*/
        double leftBackVal   = y - x + c;       /*l2*/
        double rightBackVal  = y + x - c;       /*l1*/

        //Move range to between 0 and +1, if not already
        double[] wheelPowers = {rightFrontVal, leftFrontVal, leftBackVal, rightBackVal};
        Arrays.sort(wheelPowers);
        if (wheelPowers[3] > 1)
        {
            leftFrontVal  /= wheelPowers[3];
            rightFrontVal /= wheelPowers[3];
            leftBackVal   /= wheelPowers[3];
            rightBackVal  /= wheelPowers[3];
        }

        double scaledPower = SCALEDPOWER;


        leftFront.setPower(leftFrontVal*scaledPower+leftFront.getPower()*(1-scaledPower))    ;
        rightFront.setPower(rightFrontVal*scaledPower+rightFront.getPower()*(1-scaledPower)) ;
        leftBack.setPower(leftBackVal*scaledPower+leftBack.getPower()*(1-scaledPower))       ;
        rightBack.setPower(rightBackVal*scaledPower+rightBack.getPower()*(1-scaledPower))    ;

    }
}