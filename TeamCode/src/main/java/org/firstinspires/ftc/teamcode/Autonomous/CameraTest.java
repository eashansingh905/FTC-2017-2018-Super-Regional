package org.firstinspires.ftc.teamcode.Autonomous;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Autonomous.Methods.Camera;


/**
 * Created by easha on 2/24/2018.
 */



@Autonomous (name = "Camera Test")
public class CameraTest extends LinearOpMode {


    Camera camera = new Camera(telemetry);

    @Override

    public void runOpMode() throws InterruptedException {


        camera.init(hardwareMap);

        waitForStart();

        String key = camera.getKey();
        camera.cameraOff();


    }
}
