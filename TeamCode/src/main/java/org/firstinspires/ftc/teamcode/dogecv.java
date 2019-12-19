package org.firstinspires.ftc.teamcode;

import com.disnodeteam.dogecv.DogeCV;
import com.disnodeteam.dogecv.detectors.DogeCVDetector;
import com.disnodeteam.dogecv.detectors.skystone.SkystoneDetector;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.opencv.core.Mat;
import org.opencv.core.Point;

@TeleOp(name = "dogecv", group = "Autonmous")
public class CroppingExample extends OpMode {

    //This is an example of an anonymous implementation of the DogeCV Detector
    private DogeCVDetector detector = new DogeCVDetector() {
        @Override
        public Mat process(Mat rgba) {
            return rgba;
        }
        @Override
        public void useDefaults() {}
    };

    @Override
    public void init() {
        telemetry.addData("Status", "DogeCV 2019.1 - Cropping Example");

        // Set up detector
        detector.init(hardwareMap.appContext, CameraViewDisplay.getInstance()); // Initialize it with the app context and camera

        detector.cropTLCorner = new Point(200, 200); //Sets the top left corner of the new image, in pixel (x,y) coordinates
        detector.cropBRCorner = new Point(400, 400); //Sets the bottom right corner of the new image, in pixel (x,y) coordinates

        detector.enable();
    }
    /*
     * Code to run REPEATEDLY when the driver hits INIT
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {

    }

    /*
     * Code to run REPEATEDLY when the driver hits PLAY
     */
    @Override
    public void loop() {
        telemetry.addLine("DogeCV 2019.1 - Cropping Example");
        telemetry.update();
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
        if(detector != null) detector.disable(); //Make sure to run this on stop!
    }
}