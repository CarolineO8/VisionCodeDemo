package org.firstinspires.ftc.teamcode.AAAOpModes;



import static org.firstinspires.ftc.teamcode.teamcode.Subsystems.Constants.cx;
import static org.firstinspires.ftc.teamcode.teamcode.Subsystems.Constants.cy;
import static org.firstinspires.ftc.teamcode.teamcode.Subsystems.Constants.fx;
import static org.firstinspires.ftc.teamcode.teamcode.Subsystems.Constants.fy;

import android.util.Size;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;


import org.firstinspires.ftc.teamcode.teamcode.Utilities.Vision.ExampleProcessor;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;


@TeleOp(name = "VisionTest")
public class VisionOpMode extends OpMode {
    private FtcDashboard dash;

    WebcamName webcam1;
    ExampleProcessor exampleProcessor;

    AprilTagProcessor aprilTagProcessor;

    VisionPortal visionPortal;

    static Size cameraResolution = new Size(1280, 720);

    @Override
    public void init() {
        exampleProcessor = new ExampleProcessor();
        aprilTagProcessor = new AprilTagProcessor.Builder()
                .setLensIntrinsics(fx, fy, cx, cy)
                .build();

        webcam1 = hardwareMap.get(WebcamName.class, "Webcam 1");
        visionPortal = new VisionPortal.Builder()
                //setup for using webcam, there is a different way to set up a phone camera, but that isn't as good for FTC
                .setCamera(webcam1)
                //use addProcessors([processor 1], [processor 2], [so on..]) for adding multiple processors
                .addProcessors(exampleProcessor, aprilTagProcessor)
                //sets the camera resolution to the size we set up earlier
                //Currently 1280x720 because that size works for both a global shutter camera and a logitech camera
                .setCameraResolution(cameraResolution)
                .build();


        FtcDashboard.getInstance().startCameraStream(visionPortal, 0);
        //this is what allows ftc dashboard to work
        telemetry = FtcDashboard.getInstance().getTelemetry();
    }



    public void loop() {

    }
}

