package org.firstinspires.ftc.teamcode.TeleOP;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;



/**
 * Created by easha on 2/20/2018.
 */

@TeleOp(name = " Pecan 2.0 TeleOp")
public class Drivetrain extends LinearOpMode {

 // drive train motors names
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;

 // drive train controller
    double leftStickY;
    double leftStickX;
    double rightStickX;

    ElapsedTime timer = new ElapsedTime();





    public void runOpMode() throws InterruptedException {


        // drive train configure
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("backLeft");
        backLeft = hardwareMap.dcMotor.get("frontRight");
        backRight = hardwareMap.dcMotor.get("backRight");


        waitForStart();

        while(opModeIsActive()) {

               // drive train code
            leftStickY = gamepad1.left_stick_y;
            leftStickX = gamepad1.left_stick_x;
            rightStickX = gamepad1.right_stick_x;

            frontLeft.setPower(leftStickY - leftStickX - rightStickX);
            frontRight.setPower(leftStickY + leftStickX - rightStickX);
            backLeft.setPower(-leftStickY - leftStickX - rightStickX);
            backRight.setPower(-leftStickY + leftStickX - rightStickX);

        }

    }








}







