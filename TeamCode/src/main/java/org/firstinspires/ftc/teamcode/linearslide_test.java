package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor        ;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@TeleOp(name="linearslide_test", group="TeleOp")
public class linearslide_test extends OpMode
{

    private static DcMotor linearSlide1, linearSlide2;

    @Override
    public void init()
    {
        linearSlide1 = hardwareMap.dcMotor.get(UniversalConstants.linearSlide1) ;
        linearSlide2 = hardwareMap.dcMotor.get(UniversalConstants.linearSlide2) ;

        double volts = hardwareMap.voltageSensor.get("Expansion Hub 2").getVoltage();
    }
//--------------------------------------------------------------------------------------------------

    @Override

    public void loop()
    {
        if (gamepad1.dpad_up)
        {
            linearSlide1.setPower(-1);
            linearSlide2.setPower(1);
        }
            else
                {
                    linearSlide1.setPower(0);
                    linearSlide2.setPower(0);
                }


        if (gamepad1.dpad_down)
        {
            linearSlide1.setPower(-1);
            linearSlide2.setPower(1);
        }
        else
                {
                    linearSlide1.setPower(0);
                    linearSlide2.setPower(0);
                }


    }

//--------------------------------------------------------------------------------------------------
}
