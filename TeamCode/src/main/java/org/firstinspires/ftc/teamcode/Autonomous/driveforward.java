package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Autonomous.Methods.Drivetrain;
import org.firstinspires.ftc.teamcode.Autonomous.Methods.JewelMechanism;
import org.firstinspires.ftc.teamcode.TeleOP.jewelMechanism;

/**
 * Created by easha on 3/8/2018.
 */

@Autonomous(name = "SSR Red Corner")

public class driveforward extends LinearOpMode {
    private CRServo vexMotorBottomRight;
    private CRServo vexMotorTopRight;
    private ElapsedTime runtime = new ElapsedTime();
    Drivetrain drivetrain = new Drivetrain();
    //  Intake intake = new Intake(); // Add Intake Code here based off new values


    @Override

    public void runOpMode() throws InterruptedException {

        drivetrain.init(hardwareMap);
        //intake.init(hardwareMap);// hardware map intake
        vexMotorBottomRight = hardwareMap.crservo.get("Intake1"); //comment out if no Y
        vexMotorTopRight = hardwareMap.crservo.get("Intake2");

        waitForStart();

        drivetrain.forwardsDistance(40, 1);// center
        //drivetrain.forwardsDistance(15, 1);// right
        //
        //drivetrain.forwardsDistance(20,1);
        drivetrain.turnDistance(21, 1); // 90 degrees clockwise
        sleep(700);
        //drivetrain.strafeDistance(-33, 0.7);
        sleep(700);

        vexMotorTopRight.setPower(-0.5); //comment out if no Y cable
        vexMotorBottomRight.setPower(0.5);
        sleep(1000);
        drivetrain.forwardsDistance(7, 1);
        drivetrain.backwardsDistance(13,1);
        drivetrain.turnDistance(42,1);
        vexMotorTopRight.setPower(0.8); //comment out if no Y cable
        vexMotorBottomRight.setPower(-0.8);
        drivetrain.forwardsDistance(45,0.5);
        drivetrain.backwardsDistance(25,1);
        drivetrain.turnDistance(52,1);//45
        drivetrain.forwardsDistance(55,1);
        vexMotorTopRight.setPower(-0.5); //comment out if no Y cable
        vexMotorBottomRight.setPower(0.5);
        sleep(2000);
        drivetrain.backwardsDistance(7,1);

    }
}
