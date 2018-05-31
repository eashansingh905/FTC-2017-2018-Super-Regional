package org.firstinspires.ftc.teamcode.TeleOP;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by easha on 2/14/2018.
 */

@TeleOp(name = "Intake Flip")
public class intakeflip extends LinearOpMode
{
    private DcMotor flipMotor;
    private ElapsedTime runtime = new ElapsedTime();
    private CRServo vexMotor0;
    private CRServo vexMotor1;
    private CRServo vexMotor2;
    private CRServo vexMotor3;
    private CRServo vexMotor4;
    private CRServo vexMotor5;



    @Override
    public void runOpMode() throws InterruptedException{

        flipMotor = hardwareMap.dcMotor.get("motorFlip");
        vexMotor0 = hardwareMap.crservo.get("0");
        vexMotor1 = hardwareMap.crservo.get("1");
        vexMotor2= hardwareMap.crservo.get("2");
        vexMotor3 = hardwareMap.crservo.get("3");
        vexMotor4 = hardwareMap.crservo.get("4");
        vexMotor5 = hardwareMap.crservo.get("5");

        boolean isIntaking = false;


        vexMotor0 = hardwareMap.get(CRServo.class, "0");
        vexMotor1 = hardwareMap.get(CRServo.class, "1");
        vexMotor2 = hardwareMap.get(CRServo.class, "2");
        vexMotor3 = hardwareMap.get(CRServo.class, "3");
        vexMotor4 = hardwareMap.get(CRServo.class, "4");
        vexMotor5 = hardwareMap.get(CRServo.class, "5");

        vexMotor0.setPower(0);
        vexMotor1.setPower(0);
        vexMotor2.setPower(0);
        vexMotor3.setPower(0);
        vexMotor4.setPower(0);
        vexMotor5.setPower(0);
        waitForStart();

        while (opModeIsActive()){

            if (gamepad1.y){

                flipMotor.setPower(0.5);
            }


            //else if (gamepad1.a){

             //   flipMotor.setPower(-0.8);
            //}

            else{
                flipMotor.setPower(0);
            }


            if(gamepad1.x){ // out take

                vexMotor0.setPower(0.83111090);
                vexMotor1.setPower(0.83111090);
                vexMotor2.setPower(-0.83111090);
                vexMotor3.setPower(0.83111090);
                vexMotor4.setPower(-0.83111090);
                vexMotor5.setPower(-0.83111090);


            }


            if(gamepad1.b){  // intake

                vexMotor0.setPower(-0.83111090); // left
                vexMotor1.setPower(-0.83111090); //
                vexMotor2.setPower(0.83111090);  //
                vexMotor3.setPower(-0.83111090);  //  left
                vexMotor4.setPower(0.83111090);  // right
                vexMotor5.setPower(0.83111090); //   right 


            }


            if(gamepad1.a){

                vexMotor0.setPower(-0.83111090);
                vexMotor1.setPower(0.83111090);
                vexMotor2.setPower(-0.83111090);
                vexMotor3.setPower(-0.83111090);
                vexMotor4.setPower(-0.83111090);
                vexMotor5.setPower(-0.83111090);



            }

            else {
                vexMotor0.setPower(0);
                vexMotor1.setPower(0);
                vexMotor2.setPower(0);
                vexMotor3.setPower(0);
                vexMotor4.setPower(0);
                vexMotor5.setPower(0);
            }


        }



    }



}