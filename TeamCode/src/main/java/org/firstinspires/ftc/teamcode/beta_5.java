package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode ;
import com.qualcomm.robotcore.hardware.DcMotor        ;
import com.qualcomm.robotcore.hardware.DcMotorSimple  ;
import com.qualcomm.robotcore.hardware.Servo          ;
import java.util.Arrays;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.Arrays;


@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Beta 5", group="TeleOp")
public class beta_5 extends OpMode
{

    private static final double TRIGGERTHRESHOLD = 0.2     ;
    private static final double ACCEPTINPUTTHRESHOLD = 0.1;
    private static final double SCALEDPOWER = 1; //Emphasis on current controller reading (vs current motor power) on the drive train

    private static DcMotor l1, l2, r1, r2, linearSlide;
    private static Servo  centerGripper, rightGripper, leftGripper, hook1, hook2;

    private ElapsedTime runtime = new ElapsedTime();

//--------------------------------------------------------------------------------------------------

    @Override
    public void init()
    //this is where the lines for init-ing and reversing goes
    {
        l1           = hardwareMap.dcMotor.get(UniversalConstants.l1) ;
        l2           = hardwareMap.dcMotor.get(UniversalConstants.l2) ;
        r1           = hardwareMap.dcMotor.get(UniversalConstants.r1);
        r2           = hardwareMap.dcMotor.get(UniversalConstants.r2);

        linearSlide   = hardwareMap.dcMotor.get(UniversalConstants.linearSlide);

        centerGripper   = hardwareMap.servo.get(UniversalConstants.centerGripper);
        rightGripper   = hardwareMap.servo.get(UniversalConstants.rightGripper);
        leftGripper   = hardwareMap.servo.get(UniversalConstants.leftGripper);

        hook1   = hardwareMap.servo.get(UniversalConstants.hook1);
        hook2   = hardwareMap.servo.get(UniversalConstants.hook2);

        // l1.setDirection(DcMotorSimple.Direction.REVERSE);
        // l2.setDirection(DcMotorSimple.Direction.REVERSE) ;
        // r1.setDirection(DcMotorSimple.Direction.REVERSE);
        // r2.setDirection(DcMotorSimple.Direction.REVERSE);

        double volts = hardwareMap.voltageSensor.get("Expansion Hub 2").getVoltage();
    }
//--------------------------------------------------------------------------------------------------

    @Override

    public void loop()

    {
//--------------------------------------------------------------------------------------------------

        //linear slide control

        /*
        if (gamepad2.left_stick_y > 0)
        {
            linearSlide.setPower(-0.7);
        }
        else if (gamepad2.left_stick_y < 0)
        {
            linearSlide.setPower(0.7);
        }
        else
            {
                linearSlide.setPower(0.15);
            }
        */

        //on +1 value, centerGripper goes up
        //on 0.5 value, centerGripper goes down very slowly
        //on 0 value, centerGripper goes down
        //on -0.5 value, centerGripper goes down
        //on -1 value, centerGripper goes down

        //center gripper control
        if (gamepad2.y)
        {
            centerGripper.setPosition(1);
        }
        else if (gamepad2.a)
        {
            centerGripper.setPosition(-1);
        }
        else
        {
            centerGripper.setPosition(0.5);
        }


        //right and center gripper must be reversed (to make all close in)

        //rightGripper closes on 0
        //leftGripper closes on 1

        //left and right gripper control
        if (gamepad2.x)
        {
            rightGripper.setPosition(0);
            leftGripper.setPosition(1);
        }
        else if (gamepad2.b)
        {
            rightGripper.setPosition(1);
            leftGripper.setPosition(0);
        }


        //hook for base control
        if (gamepad1.dpad_up)
        {
            hook1.setPosition(1);
            hook2.setPosition(0);

        }
        else if (gamepad1.dpad_down)
        {
            hook1.setPosition(0);
            hook2.setPosition(1);
        }



//--------------------------------------------------------------------------------------------------

        //mecanum drivetrain control

        //moves mecanum wheel motors based on absolute values from the sticks that take into account rotation
        double inputY = Math.abs(gamepad1.left_stick_y) > ACCEPTINPUTTHRESHOLD ? gamepad1.left_stick_y : 0 ;
        double inputX = Math.abs(-gamepad1.left_stick_x) > ACCEPTINPUTTHRESHOLD ? -gamepad1.left_stick_x : 0;
        double inputC = Math.abs(gamepad1.right_stick_x)> ACCEPTINPUTTHRESHOLD ? -gamepad1.right_stick_x: 0;

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
        leftBack.setPower(leftBackVal*scaledPower+leftBack.getPower()*(1-scaledPower))     ;
        rightBack.setPower(rightBackVal*scaledPower+rightBack.getPower()*(1-scaledPower))    ;

    }
}