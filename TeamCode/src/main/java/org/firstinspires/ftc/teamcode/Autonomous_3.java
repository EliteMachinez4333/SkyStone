package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode ;
import com.qualcomm.robotcore.hardware.DcMotor        ;
import com.qualcomm.robotcore.hardware.DcMotorSimple  ;
import com.qualcomm.robotcore.hardware.Servo          ;

@Autonomous(name="Autonomous 3", group="Autonomous")
public class Autonomous_3 extends LinearOpMode
{
    private static DcMotor l1, l2, r1, r2, linearSlide1, linearSlide2;
    private static Servo  rightGripper, leftGripper, centerGripper, hook1, hook2;

    @Override
    public void runOpMode() throws InterruptedException
    {
        l1             = hardwareMap.dcMotor.get(UniversalConstants.l1) ;
        l2             = hardwareMap.dcMotor.get(UniversalConstants.l2) ;
        r1             = hardwareMap.dcMotor.get(UniversalConstants.r1);
        r2             = hardwareMap.dcMotor.get(UniversalConstants.r2);

        linearSlide1   = hardwareMap.dcMotor.get(UniversalConstants.linearSlide1);
        linearSlide2   = hardwareMap.dcMotor.get(UniversalConstants.linearSlide2);

        leftGripper   = hardwareMap.servo.get(UniversalConstants.leftGripper);
        rightGripper   = hardwareMap.servo.get(UniversalConstants.rightGripper);
        centerGripper   = hardwareMap.servo.get(UniversalConstants.rightGripper);

        hook1   = hardwareMap.servo.get(UniversalConstants.hook1);
        hook2   = hardwareMap.servo.get(UniversalConstants.hook2);





        // reverse opposite facing motors
        // l1.setDirection(DcMotorSimple.Direction.REVERSE);
        // l2.setDirection(DcMotorSimple.Direction.REVERSE) ;
        // r1.setDirection(DcMotorSimple.Direction.REVERSE);
        // r2.setDirection(DcMotorSimple.Direction.REVERSE);

        telemetry.addData("Mode", "waiting");
        telemetry.update();

//--------------------------------------------------------------------------------------------------
        // wait for start button.
        waitForStart();

        telemetry.addData("Mode", "running");
        telemetry.update();

        //start of movement

        stopAllServos(100);

        forward(300);

        strafe_left(500);
        strafe_right(500);



    }

//--------------------------------------------------------------------------------------------------

    //methods

    //forward method
    public void forward (int ms)
        {
            l1.setPower(-0.5);
            l2.setPower(-0.5);
            r1.setPower(-0.5);
            r2.setPower(-0.5);

            sleep(ms);
        }

    //backward method
    public void backward (int ms)
        {
            l1.setPower(0.5);
            l2.setPower(0.5);
            r1.setPower(0.5);
            r2.setPower(0.5);

            sleep(ms);
        }

    //strafe left method
    public void strafe_left (int ms)
        {
            l1.setPower(0.5);
            l2.setPower(-0.5);
            r1.setPower(-0.5);
            r2.setPower(0.5);

            sleep(ms);
        }

    //strafe right method
    public void strafe_right (int ms)
        {
            l1.setPower(-0.5);
            l2.setPower(0.5);
            r1.setPower(0.5);
            r2.setPower(-0.5);

            sleep(ms);
        }


    public void stopAllServos (int ms)
    {
        rightGripper.setPosition(0.5);
        leftGripper.setPosition(0.5);
        centerGripper.setPosition(0.5);
        hook1.setPosition(0.5);
        hook2.setPosition(0.5);

        sleep(ms);
    }

//--------------------------------------------------------------------------------------------------




}