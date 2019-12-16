package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor        ;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@TeleOp(name="linearslide_test", group="TeleOp")
public class linearslide_test extends OpMode
{

    private static DcMotor linearSlide;

    @Override
    public void init()
    {
        linearSlide = hardwareMap.dcMotor.get(UniversalConstants.linearSlide) ;

        double volts = hardwareMap.voltageSensor.get("Expansion Hub 2").getVoltage();
    }
//--------------------------------------------------------------------------------------------------

    @Override

    public void loop()
    {
        if (gamepad1.dpad_up)
        {
            linearSlide.setPower(-1);
        }
            else
                {
                    linearSlide.setPower(0);
                }


        if (gamepad1.dpad_down)
        {
            linearSlide.setPower(0.5);
        }
        else
                {
                    linearSlide.setPower(0);
                }


    }

//--------------------------------------------------------------------------------------------------
}
