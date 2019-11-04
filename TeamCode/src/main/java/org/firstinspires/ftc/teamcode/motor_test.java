package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor        ;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@TeleOp(name="motor_test", group="TeleOp")
public class motor_test extends OpMode
{

    private static DcMotor t;

    @Override
    public void init()
    {
        t = hardwareMap.dcMotor.get(UniversalConstants.T) ;

        double volts = hardwareMap.voltageSensor.get("Expansion Hub 2").getVoltage();
    }
//--------------------------------------------------------------------------------------------------

    @Override

    public void loop()
    {

            t.setPower(1);

    }

//--------------------------------------------------------------------------------------------------
}
