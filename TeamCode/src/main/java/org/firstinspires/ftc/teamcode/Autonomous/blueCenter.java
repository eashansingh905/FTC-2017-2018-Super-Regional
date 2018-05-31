package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Autonomous.Methods.Drivetrain;
import org.firstinspires.ftc.teamcode.Autonomous.Methods.JewelMechanism;

/**
 * Created by easha on 3/8/2018.
 */

@Autonomous(name = "Blue Center", group = "Blue Alliance")

public class blueCenter extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    Drivetrain drivetrain = new Drivetrain();
    //  Intake intake = new Intake(); // Add Intake Code here based off new values
    JewelMechanism jewelMechanism = new JewelMechanism();

    @Override

    public void runOpMode() throws InterruptedException {

        drivetrain.init(hardwareMap);
        //intake.init(hardwareMap);// hardware map intake
        jewelMechanism.init(hardwareMap);

        waitForStart();

        //make sure jewel arm is in the center
        jewelMechanism.rotateArm(0.45);
        //lower servo arm
        jewelMechanism.lowerArm();
        //turn on light
        jewelMechanism.ledOn();
        //read color
        jewelMechanism.colorRed(); //true = red, false = blue
        //turn to knock off jewel using servo arm
        if (jewelMechanism.colorRed() == true) {
            jewelMechanism.rotateArm(0.1);//0.8
        } else {
            jewelMechanism.rotateArm(0.9);//0.2
        }
        sleep(1000);
        //turn off light
        jewelMechanism.ledOff();
        jewelMechanism.rotateArm(0.45);
        //raise servo arm
        jewelMechanism.raiseArm();
        sleep(1000);
    }
}
