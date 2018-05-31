package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by easha on 3/9/2018.
 */

@TeleOp (name = "NullConfigTest")
public class NullTest extends LinearOpMode{

    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;

    private ColorSensor colorSensor;
// Variables //
    double leftStickX;
    double rightStickX;
    double rightSticky;

    private Servo relicArmServo;
    private Servo relicClawServo;

    private CRServo vexMotorTopRight;

    @Override

    public void runOpMode() throws InterruptedException {

         // Motor Hardware Mapping //
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("backLeft");
        backLeft = hardwareMap.dcMotor.get("frontRight");
        backRight = hardwareMap.dcMotor.get("backRight");
        colorSensor = hardwareMap.colorSensor.get("CS");

        vexMotorTopRight = hardwareMap.crservo.get("Intake2");

        relicArmServo = hardwareMap.servo.get("RA");
        relicClawServo = hardwareMap.servo.get("RC");

        relicClawServo.setPosition(.2);
        relicArmServo.setPosition(1);

        waitForStart();

        while (opModeIsActive()) {


        }

    }
}
