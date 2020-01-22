package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode ;
import com.qualcomm.robotcore.hardware.DcMotor        ;
import com.qualcomm.robotcore.hardware.DcMotorSimple  ;
import com.qualcomm.robotcore.hardware.Servo          ;

@Autonomous(name="Autonomous 2", group="Autonomous")
public class Autonomous_2 extends LinearOpMode
{
    private static DcMotor l1, l2, r1, r2;

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

        //500 ticks = 1 foot

        backward(150);
        sleep(2000);


    }

//--------------------------------------------------------------------------------------------------

    //methods

    //forward method
    public void forward (int ticks)
    {
        l1.setTargetPosition(ticks);
        l2.setTargetPosition(ticks);
        r1.setTargetPosition(ticks);
        r2.setTargetPosition(ticks);

        l1.setPower(-0.5);
        l2.setPower(-0.5);
        r1.setPower(-0.5);
        r2.setPower(-0.5);

        l1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        l2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        r1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        r2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        sleep(5000);

        l1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        l2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        r1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        r2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    //backward method
    public void backward (int ticks)
    {
        l1.setTargetPosition(ticks);
        l2.setTargetPosition(ticks);
        r1.setTargetPosition(ticks);
        r2.setTargetPosition(ticks);

        l1.setPower(0.4);
        l2.setPower(0.4);
        r1.setPower(0.4);
        r2.setPower(0.4);

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

    //strafe left method
    public void strafe_left (int ticks)
    {
        l1.setTargetPosition(ticks);
        l2.setTargetPosition(ticks);
        r1.setTargetPosition(ticks);
        r2.setTargetPosition(ticks);

        l1.setPower(0.5);
        l2.setPower(-0.5);
        r1.setPower(-0.5);
        r2.setPower(0.5);

        l1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        l2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        r1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        r2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        sleep(5000);

        l1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        l2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        r1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        r2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    //strafe right method
    public void strafe_right (int ticks)
    {
        l1.setTargetPosition(ticks);
        l2.setTargetPosition(ticks);
        r1.setTargetPosition(ticks);
        r2.setTargetPosition(ticks);

        l1.setPower(-0.5);
        l2.setPower(0.5);
        r1.setPower(0.5);
        r2.setPower(-0.5);

        l1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        l2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        r1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        r2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        sleep(5000);

        l1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        l2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        r1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        r2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

//--------------------------------------------------------------------------------------------------




}