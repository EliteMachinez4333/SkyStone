package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode ;
import com.qualcomm.robotcore.hardware.DcMotor        ;
import com.qualcomm.robotcore.hardware.DcMotorSimple  ;
import com.qualcomm.robotcore.hardware.Servo          ;

@Autonomous(name="encoder_test", group="Autonomous")
public class encoder_test extends LinearOpMode
{
    private static DcMotor l1;
    private static DcMotor l2;
    private static DcMotor r1;
    private static DcMotor r2;


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void runOpMode() throws InterruptedException
    {
        l1 = hardwareMap.dcMotor.get("l1");
        l2 = hardwareMap.dcMotor.get("l2");
        r1 = hardwareMap.dcMotor.get("r1");
        r2 = hardwareMap.dcMotor.get("r2");



        // reset encoder count kept by left motor.
        l1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        l2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        r1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        r2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);



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



        forward(200);
        strafe_right(200);
        backward(200);
        strafe_left(200);



        /*
         while (opModeIsActive() && l1.getCurrentPosition() + l2.getCurrentPosition() + r1.getCurrentPosition() + r2.getCurrentPosition() > 0)
        {
        telemetry.addData("encoder-back", l1.getCurrentPosition() + l2.getCurrentPosition() + r1.getCurrentPosition() + r2.getCurrentPosition());
        telemetry.update();
        idle();
        }
        */
    }

//--------------------------------------------------------------------------------------------------

    //methods

    public void forward (double ticks)
    {
        l1.setTargetPosition(300);
        l2.setTargetPosition(300);
        r1.setTargetPosition(300);
        r2.setTargetPosition(300);

        l1.setPower(-1);
        l2.setPower(-1);
        r1.setPower(-1);
        r2.setPower(-1);

        l1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        l2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        r1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        r2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        sleep(3000);

        l1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        l2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        r1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        r2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    public void backward (double ticks)
    {
        l1.setTargetPosition(300);
        l2.setTargetPosition(300);
        r1.setTargetPosition(300);
        r2.setTargetPosition(300);

        l1.setPower(1);
        l2.setPower(1);
        r1.setPower(1);
        r2.setPower(1);

        l1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        l2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        r1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        r2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        sleep(3000);

        l1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        l2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        r1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        r2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void strafe_left (double ticks)
    {
        l1.setTargetPosition(300);
        l2.setTargetPosition(300);
        r1.setTargetPosition(300);
        r2.setTargetPosition(300);

        l1.setPower(1);
        l2.setPower(-1);
        r1.setPower(-1);
        r2.setPower(1);

        l1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        l2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        r1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        r2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        sleep(3000);

        l1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        l2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        r1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        r2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void strafe_right (double ticks)
    {
        l1.setTargetPosition(300);
        l2.setTargetPosition(300);
        r1.setTargetPosition(300);
        r2.setTargetPosition(300);

        l1.setPower(-1);
        l2.setPower(1);
        r1.setPower(1);
        r2.setPower(-1);

        l1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        l2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        r1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        r2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        sleep(3000);

        l1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        l2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        r1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        r2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

//--------------------------------------------------------------------------------------------------




}