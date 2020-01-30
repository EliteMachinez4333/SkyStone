package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo          ;

import org.firstinspires.ftc.teamcode.Auto.AutoSubsystems;

@Autonomous(name="Autonomous Platform Only", group="Autonomous")
public class Autonomous_Platform_Only extends LinearOpMode
{
    private static DcMotor l1, l2, r1, r2, linearSlide;
    private static Servo  rightGripper, leftGripper, centerGripper, hook1, hook2;

    @Override
    public void runOpMode() throws InterruptedException
    {
        l1             = hardwareMap.dcMotor.get(AutoSubsystems.l1) ;
        l2             = hardwareMap.dcMotor.get(AutoSubsystems.l2) ;
        r1             = hardwareMap.dcMotor.get(AutoSubsystems.r1);
        r2             = hardwareMap.dcMotor.get(AutoSubsystems.r2);

        linearSlide    = hardwareMap.dcMotor.get(AutoSubsystems.linearSlide);

        leftGripper    = hardwareMap.servo.get(AutoSubsystems.leftGripper);
        rightGripper   = hardwareMap.servo.get(AutoSubsystems.rightGripper);
        centerGripper  = hardwareMap.servo.get(AutoSubsystems.rightGripper);

        hook1          = hardwareMap.servo.get(AutoSubsystems.hook1);
        hook2          = hardwareMap.servo.get(AutoSubsystems.hook2);

        // reverse opposite facing motors
        // l1.setDirection(DcMotorSimple.Direction.REVERSE);
        // l2.setDirection(DcMotorSimple.Direction.REVERSE);
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

        hookUp();
        backward(1000);
        strafe_right(1000);
        backward(500);
        hookDown();
        strafe_right(300);
        forward(1900);
        hookUp();
      //  strafe_left(4500);
    }

//--------------------------------------------------------------------------------------------------

    //methods

    //forward method
    public void forward (int ms)
    {
        l1.setPower(-1);
        l2.setPower(-1);
        r1.setPower(-1);
        r2.setPower(-1);

        sleep(ms);
    }

    //backward method
    public void backward (int ms)
    {
        l1.setPower(1);
        l2.setPower(1);
        r1.setPower(1);
        r2.setPower(1);

        sleep(ms);
    }

    //strafe left method
    public void strafe_left (int ms)
    {
        l1.setPower(0.8);
        l2.setPower(-1);
        r1.setPower(-0.8);
        r2.setPower(1);

        sleep(ms);
    }

    //strafe right method
    public void strafe_right (int ms)
    {
        l1.setPower(-0.7);
        l2.setPower(0.7);
        r1.setPower(0.7);
        r2.setPower(-1);

        sleep(ms);
    }

    //linear slide up method
    public void linearSlideUp (int ms)
    {
        linearSlide.setPower(-0.5);
        sleep(ms);
    }

    //linear slide down method
    public void linearSlideDown (int ms)
    {
        linearSlide.setPower(0.5);

        sleep(ms);
    }

    //hooks for base up method
    public void hookUp ()
    {
        hook1.setPosition(1);
        hook2.setPosition(0);
    }

    //hook for base down
    public void hookDown ()
    {
        hook1.setPosition(0);
        hook2.setPosition(1);
    }





//--------------------------------------------------------------------------------------------------




}