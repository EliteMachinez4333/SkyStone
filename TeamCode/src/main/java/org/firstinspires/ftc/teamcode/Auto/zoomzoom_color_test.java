package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo          ;

import org.firstinspires.ftc.teamcode.Auto.AutoSubsystems;

@Autonomous(name="Color Decision Test", group="Autonomous")
public class zoomzoom_color_test extends LinearOpMode
{
    private static DcMotor l1, l2, r1, r2, linearSlide;
    private static Servo  rightGripper, leftGripper, centerGripper, hook1, hook2;
    private static ColorSensor colorSensor;


    @Override
    public void runOpMode() throws InterruptedException
    {
        l1             = hardwareMap.dcMotor.get(AutoSubsystems.l1) ;
        l2             = hardwareMap.dcMotor.get(AutoSubsystems.l2) ;
        r1             = hardwareMap.dcMotor.get(AutoSubsystems.r1);
        r2             = hardwareMap.dcMotor.get(AutoSubsystems.r2);

        linearSlide   = hardwareMap.dcMotor.get(AutoSubsystems.linearSlide);

        leftGripper   = hardwareMap.servo.get(AutoSubsystems.leftGripper);
        rightGripper   = hardwareMap.servo.get(AutoSubsystems.rightGripper);
        centerGripper   = hardwareMap.servo.get(AutoSubsystems.rightGripper);

        hook1   = hardwareMap.servo.get(AutoSubsystems.hook1);
        hook2   = hardwareMap.servo.get(AutoSubsystems.hook2);

        colorSensor = hardwareMap.get(ColorSensor.class, "c");


        boolean skystone;

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

        //start of code

        sleep(2000);

        if (colorSensor.red()*10 + colorSensor.green()*10 > 800)
            {
                l1.setPower(1);
                sleep(700);
            }
        else
            {
                r1.setPower(1);
                sleep(700);
            }


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
        l1.setPower(-1);
        l2.setPower(1);
        r1.setPower(1);
        r2.setPower(-1);

        sleep(ms);
    }

    //linear slide up method
    public void linearSlideUp (int ms)
    {
        linearSlide.setPower(-1);
        sleep(ms);
    }

    //linear slide down method
    public void linearSlideDown (int ms)
    {
        linearSlide.setPower(1);

        sleep(ms);
    }

    //hooks for base up method
    public void hookUp ()
    {
        hook1.setPosition(1);
        hook2.setPosition(0);
        sleep(2000);
    }

    //hook for base down
    public void hookDown ()
    {
        hook1.setPosition(0);
        hook2.setPosition(1);
        sleep(2000);
    }





//--------------------------------------------------------------------------------------------------




}