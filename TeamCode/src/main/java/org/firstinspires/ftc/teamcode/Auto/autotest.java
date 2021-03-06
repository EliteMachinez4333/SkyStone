package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo          ;

import org.firstinspires.ftc.teamcode.Auto.AutoSubsystems;
import org.firstinspires.ftc.teamcode.TeleOp.TeleOpSubsystems;


@Autonomous(name="autotest", group="Autonomous")
public class autotest extends LinearOpMode
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
        // l1.setDirection(DcMotor.Direction.REVERSE);
        // l2.setDirection(DcMotor.Direction.REVERSE) ;
        r1.setDirection(DcMotor.Direction.REVERSE);
        r2.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Mode", "waiting");
        telemetry.update();

//--------------------------------------------------------------------------------------------------
        // wait for start button.
        waitForStart();

        telemetry.addData("Mode", "running");
        telemetry.update();

        //start of code

        //c1 is the *left claw* (from bot's perspective when the claw is facing in), it closes on 0 value
        //hook1 goes up on 1 value, goes down on 0 value
        //hook2 goes up on 1 value, goes down on 0 value

        strafe_left(2000);
        stop(1000);
        strafe_right(2000);





    }

//--------------------------------------------------------------------------------------------------

    //methods

    //forward method
    public void forward (int ms)
    {
        l1.setPower(0.5);
        l2.setPower(0.5);
        r1.setPower(0.5);
        r2.setPower(0.5);

        sleep(ms);
    }

    //backward method
    public void backward (int ms)
    {
        l1.setPower(-0.5);
        l2.setPower(-0.5);
        r1.setPower(-0.5);
        r2.setPower(-0.5);

        sleep(ms);
    }

    //strafe left method
    public void strafe_left (int ms)
    {
        l1.setPower(-0.5);
        l2.setPower(0.5);
        r1.setPower(0.47);
        r2.setPower(-0.5);

        sleep(ms);
    }

    //strafe right method
    public void strafe_right (int ms)
    {
        l1.setPower(0.5);
        l2.setPower(-0.5);
        r1.setPower(-0.5);
        r2.setPower(0.5);

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

    //hook up method
    public void hookUp ()
    {
        hook1.setPosition(0);
        sleep(1000);
        hook2.setPosition(1);
        sleep(1000);
    }

    //hook down method
    public void hookDown ()
    {
        hook1.setPosition(0.7);
        sleep(1000);
        hook2.setPosition(0.25);
        sleep(1000);

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

    //all wheel motors off
    public void stop (int ms)
    {
        l1.setPower(0);
        l2.setPower(0);
        r1.setPower(0);
        r2.setPower(0);

        sleep(ms);
    }


//--------------------------------------------------------------------------------------------------




}