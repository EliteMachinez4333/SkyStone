package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor        ;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@TeleOp(name="Motor Test", group="TeleOp")
public class Motor_Test extends OpMode
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
