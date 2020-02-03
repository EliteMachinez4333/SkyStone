package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo          ;

import org.firstinspires.ftc.teamcode.Auto.AutoSubsystems;
import org.firstinspires.ftc.teamcode.TeleOp.TeleOpSubsystems;

@Autonomous(name="Color Decision Test", group="Autonomous")
public class zoomzoom_color_test extends LinearOpMode
{
    private static DcMotor l1, l2, r1, r2, i1, i2, linearSlide;
    private static Servo i3, i4, c1, c2, c3, hook1, hook2;
    private static ColorSensor colorSensor;


    @Override
    public void runOpMode() throws InterruptedException
    {
        l1           = hardwareMap.dcMotor.get(AutoSubsystems.l1) ;
        l2           = hardwareMap.dcMotor.get(AutoSubsystems.l2) ;
        r1           = hardwareMap.dcMotor.get(AutoSubsystems.r1);
        r2           = hardwareMap.dcMotor.get(AutoSubsystems.r2);

        linearSlide  = hardwareMap.dcMotor.get(AutoSubsystems.linearSlide);

        i1           = hardwareMap.dcMotor.get(AutoSubsystems.i1);
        i2           = hardwareMap.dcMotor.get(AutoSubsystems.i2);
        i3           = hardwareMap.servo.get(AutoSubsystems.i3);
        i4           = hardwareMap.servo.get(AutoSubsystems.i4);

        c1           = hardwareMap.servo.get(AutoSubsystems.c1);
        c2           = hardwareMap.servo.get(AutoSubsystems.c2);
        c3           = hardwareMap.servo.get(AutoSubsystems.c3);

        hook1           = hardwareMap.servo.get(AutoSubsystems.hook1);
        hook2           = hardwareMap.servo.get(AutoSubsystems.hook2);

        colorSensor = hardwareMap.get(ColorSensor.class, "c");


        boolean skystone;

        // reverse opposite facing motors
         l1.setDirection(DcMotor.Direction.REVERSE);
         l2.setDirection(DcMotor.Direction.REVERSE) ;
        // r1.setDirection(DcMotor.Direction.REVERSE);
        // r2.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Mode", "waiting");
        telemetry.update();

//--------------------------------------------------------------------------------------------------
        // wait for start button.
        waitForStart();

        telemetry.addData("Mode", "running");
        telemetry.update();

        //start of code

        sleep(2000);

        if (colorSensor.red()*10 + colorSensor.green()*10 > 500)
            //if red + green is greater than 1250, we know that the stone is yellow (not a skystone)
                //therefore it will strafe to the next block
            {
                strafe_left(1000);
            }
            else
                {

                    forward(300);
                    intakeOn(5000);
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

    //intake on method
    public void intakeOn (int ms)
    {
        i1.setPower(1);
        i2.setPower(-1);
        i3.setPosition(1);
        i4.setPosition(-1);
        sleep(ms);
    }

    public void intakeOff (int ms)
    {
        i1.setPower(-1);
        i2.setPower(1);
        i3.setPosition(-1);
        i4.setPosition(1);
        sleep(ms);
    }

//--------------------------------------------------------------------------------------------------




}