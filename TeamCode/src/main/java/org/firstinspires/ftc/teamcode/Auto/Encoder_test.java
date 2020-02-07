package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode ;
import com.qualcomm.robotcore.hardware.DcMotorSimple  ;
import com.qualcomm.robotcore.hardware.Servo          ;

@Autonomous(name="Encoder Test", group="Autonomous")
public class Encoder_test extends LinearOpMode
{
    private static DcMotor l1, l2, r1, r2;

    static final double MOTOR_TICK_COUNT = 1120;

    boolean encodersRunnning;

    @Override
    public void runOpMode() throws InterruptedException
    {
        l1             = hardwareMap.dcMotor.get(AutoSubsystems.l1) ;
        l2             = hardwareMap.dcMotor.get(AutoSubsystems.l2) ;
        r1             = hardwareMap.dcMotor.get(AutoSubsystems.r1);
        r2             = hardwareMap.dcMotor.get(AutoSubsystems.r2);


        // reverse opposite facing motors
         l1.setDirection(DcMotor.Direction.REVERSE);
        // l2.setDirection(DcMotor.Direction.REVERSE) ;
         r1.setDirection(DcMotorSimple.Direction.REVERSE);
         r2.setDirection(DcMotorSimple.Direction.REVERSE);

        telemetry.addData("Mode", "waiting");
        telemetry.update();

//--------------------------------------------------------------------------------------------------
        // wait for start button.
        waitForStart();

        telemetry.addData("Mode", "running");
        telemetry.update();


        //1. Figure out tick count
        //2. Stop and reset encoders
        //3. Set the target position
        //4. Set the desired power
        //5. set to RUN_TO_POSITION
        //6. Wait while isBusy()
        //7. Stop the motors

        //1. Figure out tick count
        int revolution = 1120;

        int newTarget = l1.getTargetPosition() + (int)revolution;


        //2. Stop and reset encoders
        l1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        l2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        r1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        r2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        //3. Set the target position
        l1.setTargetPosition(500);
        r1.setTargetPosition(500);

        //4. Set the desired power
        forwardPower(0.5);


        //5. set to RUN_TO_POSITION
        l1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        r1.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        //6. Wait while isBusy()
        while (l1.isBusy())
        {
            telemetry.addData("Status","Running motor to target position");
            telemetry.update();
        }

        //7. Stop the motors
        forwardPower(0);
















    }

//--------------------------------------------------------------------------------------------------

    //methods

    //set power to motors easily
    public void forwardPower(double power)
        {
            l1.setPower(power);
            l2.setPower(power);
            r1.setPower(power);
            r2.setPower(power);
        }

    //forward method
    public void forwardTicks (int ticks)
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

            l1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            l2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            r1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            r2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        }

//--------------------------------------------------------------------------------------------------




}