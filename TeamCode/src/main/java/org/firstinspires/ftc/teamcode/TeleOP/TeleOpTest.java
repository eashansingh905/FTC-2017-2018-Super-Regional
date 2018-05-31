package org.firstinspires.ftc.teamcode.TeleOP;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp(name= "TeleOP Test")
public class TeleOpTest extends LinearOpMode {

   // Motor Declarations //
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor flipMotor;
    private DcMotor relicMotor;

    //Lift
    private DcMotor liftRight;
    private DcMotor liftLeft;

    // Vex Motor Intake //

//    private Servo vexMotorBottomRight;
//    //private Servo vexMotorBottomLeft;
//    //private Servo vexMotorTopLeft;
//    private Servo vexMotorTopRight;
    private CRServo vexMotorBottomRight;
    private CRServo vexMotorTopRight;

    // servo declarations //
    private Servo relicArmServo;
    private Servo relicClawServo;
   // Variables //
    double leftStickY;
    double leftStickX;
    double rightStickX;
    double rightSticky;

    double maxIntakeSpeed = 0.83111090;

    ElapsedTime timer = new ElapsedTime();



    @Override
    public void runOpMode() throws InterruptedException {
       //  Motor Hardware Mapping //
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("backLeft");
        backLeft = hardwareMap.dcMotor.get("frontRight");
        backRight = hardwareMap.dcMotor.get("backRight");
        // Servo Hardware Mapping //
//        vexMotorBottomLeft = hardwareMap.servo.get("VMBL"); //can uncomment if no Y
//        vexMotorBottomRight = hardwareMap.servo.get("Intake1");
//        vexMotorTopLeft = hardwareMap.servo.get("VMTL");
//        vexMotorTopRight = hardwareMap.servo.get("Intake2"); //can uncomment if no Y
        vexMotorBottomRight = hardwareMap.crservo.get("Intake1"); //comment out if no Y
        vexMotorTopRight = hardwareMap.crservo.get("Intake2");

        relicArmServo = hardwareMap.servo.get("RA");
        relicClawServo = hardwareMap.servo.get("RC");

        liftLeft = hardwareMap.dcMotor.get("LL");
        liftRight = hardwareMap.dcMotor.get("LR");


        relicMotor = hardwareMap.dcMotor.get("relicMotor");
        flipMotor = hardwareMap.dcMotor.get("motorFlip");

        relicClawServo.setPosition(.2);
        relicArmServo.setPosition(1);
        waitForStart();

        // TeleOP Mode Loop //
        while (opModeIsActive()) {
////////////////////////////////////////////////////////////////////////////////////////////////////
           // drivetrain code //
            leftStickY = gamepad1.left_stick_y;
            leftStickX = gamepad1.left_stick_x;
            rightStickX = gamepad1.right_stick_x;
            rightSticky = gamepad1.right_stick_y;

//            frontLeft.setPower(leftStickY - leftStickX - rightStickX);
//            frontRight.setPower(leftStickY + leftStickX - rightStickX);
//            backLeft.setPower(-leftStickY - leftStickX - rightStickX);
//            backRight.setPower(-leftStickY + leftStickX - rightStickX);

            frontLeft.setPower(leftStickY - leftStickX);
            backLeft.setPower(-rightSticky - leftStickX);

            frontRight.setPower(leftStickY + leftStickX);
            backRight.setPower(-rightSticky + leftStickX);
////////////////////////////////////////////////////////////////////////////////////////////////////
           // relic code //
            if(gamepad1.dpad_right)
                relicMotor.setPower(0.5);
            else if(gamepad1.dpad_left)
                relicMotor.setPower(-0.5);
            else
                relicMotor.setPower(0);

            if(gamepad2.dpad_up) {
                liftLeft.setPower(-0.5);
                liftRight.setPower(0.5);
            }
            else if (gamepad2.dpad_down) {
                liftLeft.setPower(0.5);
                liftRight.setPower(-0.5);
            }
            else{
                liftRight.setPower(0);
                liftLeft.setPower(0);
            }
            if (gamepad2.y)
                flipMotor.setPower(0.5);
            else if(gamepad2.a)
                flipMotor.setPower(-0.5);
            else
                flipMotor.setPower(0);

            if (gamepad1.a)
                relicArmServo.setPosition(.70
                );
            if (gamepad1.y)
                relicArmServo.setPosition(0);
            if (gamepad1.x)
                relicClawServo.setPosition(0);
            if (gamepad1.b)
                relicClawServo.setPosition(0.7);
////////////////////////////////////////////////////////////////////////////////////////////////////


//
// rTopRight.setPosition((gamepad2.left_stick_y+2)/4);
//            //vexMotorTopLeft.setPosition((gamepad2.left_stick_y+2)/4);
//            //vexMotorBottomLeft.setPosition(-(gamepad2.left_stick_y+2)/4);
//            vexMotorBottomRight.setPosition(-(gamepad2.left_stick_y+2)/4);

            if (gamepad2.left_bumper){
                vexMotorTopRight.setPower(-0.5); //comment out if no Y cable
                vexMotorBottomRight.setPower(0.5);
//              vexMotorBottomLeft.setPower(-0.5); //uncomment if no Y cable
//              vexMotorTopRight.setPower(-0.5);  //uncomment if no Y cable
            }
            else if (gamepad2.right_bumper) {
                vexMotorTopRight.setPower(0.5); //comment out if no Y cable
                vexMotorBottomRight.setPower(-0.5);
//              vexMotorBottomLeft.setPower(0.5); //uncomment if no Y cable
//              vexMotorTopRight.setPower(0.5);  //uncomment if no Y cable
            }
            else {
                vexMotorTopRight.setPower(0); //comment out if no Y cable
                vexMotorBottomRight.setPower(0);
//              vexMotorBottomLeft.setPower(0);  //uncomment if no Y cable
//              vexMotorTopRight.setPower(0);  //uncomment if no Y cable
            }
        }
    }
}
//jewel y
//1 up, 0 down

//jewel x
//1, right, 0 left