package org.firstinspires.ftc.teamcode.Autonomous;



import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Autonomous.Methods.Drivetrain;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;

/**
 * Created by easha on 2/22/2018.
 */


@Autonomous (name = "Strafing with Color Sensor")
public class ColorDistance extends LinearOpMode {

    Drivetrain drivetrain = new Drivetrain();

    ColorSensor sensorColor;
    DistanceSensor sensorDistance;



    @Override

    public void runOpMode() throws InterruptedException {

        drivetrain.init(hardwareMap);
        sensorColor = hardwareMap.get(ColorSensor.class, "sensor_color_distance");
        sensorDistance = hardwareMap.get(DistanceSensor.class, "sensor_color_distance");

        waitForStart();




        drivetrain.strafeAtPower(0.4);
 sleep(500);

      while(sensorDistance.getDistance(DistanceUnit.INCH)>3){



      }
      drivetrain.strafeAtPower(0);
      //drivetrain.strafeAtPower(0);


    }

}



