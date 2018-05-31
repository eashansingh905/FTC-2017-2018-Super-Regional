package org.firstinspires.ftc.teamcode.TeleOP;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Ranade-HP on 12/11/2017.
 */

@TeleOp (name = "Servo Test", group = "Red Alliance")
public class ServoTest extends LinearOpMode{

    Servo servo1;
//    Servo servo2;
//    Servo servo3;
//    Servo servo4;
//    Servo servo5;
//    Servo servo6;

    @Override
    public void runOpMode() throws InterruptedException {
        servo1 = hardwareMap.servo.get("1");
//        servo2 = hardwareMap.servo.get("2");
//        servo3 = hardwareMap.servo.get("3");
//        servo4 = hardwareMap.servo.get("4");
//        servo5 = hardwareMap.servo.get("5");
//        servo6 = hardwareMap.servo.get("6");

        waitForStart();
        double power = 0;

        while(opModeIsActive()) {
            for (power = 0.0; power <= 1.0; power += 0.1) {
                servo1.setPosition(power);
//                servo2.setPosition(power);
//                servo3.setPosition(power);
//                servo4.setPosition(power);
//                servo5.setPosition(power);
//                servo6.setPosition(power);
                sleep(100);
            }
            for (power = 1.0; power >= 0.0; power -= 0.1) {
                servo1.setPosition(power);
//                servo2.setPosition(power);
//                servo3.setPosition(power);
//                servo4.setPosition(power);
//                servo5.setPosition(power);
//                servo6.setPosition(power);
                sleep(100);
            }
        }
    }
}


