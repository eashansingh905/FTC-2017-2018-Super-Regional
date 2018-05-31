package org.firstinspires.ftc.teamcode.Autonomous.Methods;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by minhl on 3/1/2018.
 */

    public class Intake {

    private DcMotor flipMotor;
    private CRServo vexMotor0;
    private CRServo vexMotor1;
    private CRServo vexMotor2;
    private CRServo vexMotor3;
    private CRServo vexMotor4;
    private CRServo vexMotor5;
    ElapsedTime runtime = new ElapsedTime();

    public void init(HardwareMap hardwareMap) {

        vexMotor0 = hardwareMap.crservo.get("0");
        vexMotor1 = hardwareMap.crservo.get("1");
        vexMotor2 = hardwareMap.crservo.get("2");
        vexMotor3 = hardwareMap.crservo.get("3");
        vexMotor4 = hardwareMap.crservo.get("4");
        vexMotor5 = hardwareMap.crservo.get("5");

    }

    public void Intake() {

            vexMotor0.setPower(0.83111090);
            vexMotor1.setPower(-0.83111090);
            vexMotor2.setPower(0.83111090);
            vexMotor3.setPower(-0.83111090);
            vexMotor4.setPower(-0.83111090);
            vexMotor5.setPower(0.83111090);

        }

    public void SameDirection() {

            vexMotor0.setPower(-0.83111090);
            vexMotor1.setPower(0.83111090);
            vexMotor2.setPower(-0.83111090);
            vexMotor3.setPower(0.83111090);
            vexMotor4.setPower(-0.83111090);
            vexMotor5.setPower(0.83111090);

        }


    public void Outtake() {

            vexMotor0.setPower(-0.83111090);
            vexMotor1.setPower(0.83111090);
            vexMotor2.setPower(-0.83111090);
            vexMotor3.setPower(0.83111090);
            vexMotor4.setPower(0.83111090);
            vexMotor5.setPower(-0.83111090);

        }

    public void halfHalf() {

        vexMotor0.setPower(0.83111090);
        vexMotor1.setPower(-0.83111090);
        vexMotor2.setPower(0.83111090);
        vexMotor3.setPower(0.83111090);
        vexMotor4.setPower(-0.83111090);
        vexMotor5.setPower(0.83111090);

    }

    public void bottomIntake() {

        vexMotor3.setPower(-0.83111090);
        vexMotor4.setPower(-0.83111090);

    }
    }
