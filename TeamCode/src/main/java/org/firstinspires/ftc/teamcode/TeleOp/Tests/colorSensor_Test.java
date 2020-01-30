package org.firstinspires.ftc.teamcode.TeleOp.Tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo          ;

import org.firstinspires.ftc.teamcode.Auto.AutoSubsystems;

@Autonomous(name="Color Sensor Yest", group="Autonomous")
public class colorSensor_Test extends LinearOpMode
{
    private static ColorSensor colorSensor;

    @Override
    public void runOpMode() throws InterruptedException
    {
        colorSensor = hardwareMap.get(ColorSensor.class, "c");



        telemetry.addData("Mode", "waiting");
        telemetry.update();

//--------------------------------------------------------------------------------------------------
        // wait for start button.
        waitForStart();

        telemetry.addData("Mode", "running");
        telemetry.update();

        //start of movement

        telemetry.addData("Red  ", (colorSensor.red()*255));
        telemetry.addData("Green", (colorSensor.green()*255));
        telemetry.addData("Blue ", (colorSensor.blue()*255));


    }

//--------------------------------------------------------------------------------------------------







//--------------------------------------------------------------------------------------------------




}