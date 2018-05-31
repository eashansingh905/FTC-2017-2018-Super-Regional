package org.firstinspires.ftc.teamcode.TeleOP;


        import com.qualcomm.robotcore.eventloop.opmode.Disabled;
        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.hardware.CRServo;
        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.hardware.Servo;
        import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by easha on 2/25/2018.
 */


@TeleOp(name= "Srimnage Tele-OP Test")
public class ScrimnageCode extends LinearOpMode{


    private DcMotor flipMotor;
    private ElapsedTime runtime = new ElapsedTime();
    private CRServo vexMotor0;
    private CRServo vexMotor1;
    private CRServo vexMotor2;
    private CRServo vexMotor3;
    private CRServo vexMotor4;
    private CRServo vexMotor5;

    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;

    // drive train controller
    double leftStickY;
    double leftStickX;
    double rightStickX;


    private DcMotor liftRight;
    private DcMotor liftLeft;

    ElapsedTime timer = new ElapsedTime();

    public void runOpMode() throws InterruptedException{


        liftLeft = hardwareMap.dcMotor.get("LL");
        liftRight = hardwareMap.dcMotor.get("LR");

        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("backLeft");
        backLeft = hardwareMap.dcMotor.get("frontRight");
        backRight = hardwareMap.dcMotor.get("backRight");




        flipMotor = hardwareMap.dcMotor.get("motorFlip");
        /*
        vexMotor0 = hardwareMap.crservo.get("0");
        vexMotor1 = hardwareMap.crservo.get("1");
        vexMotor2= hardwareMap.crservo.get("2");
        vexMotor3 = hardwareMap.crservo.get("3");
        vexMotor4 = hardwareMap.crservo.get("4");
        vexMotor5 = hardwareMap.crservo.get("5");
*/
        boolean isIntaking = false;



/*
        vexMotor0.setPower(0);
        vexMotor1.setPower(0);
        vexMotor2.setPower(0);
        vexMotor3.setPower(0);
        vexMotor4.setPower(0);
        vexMotor5.setPower(0);
        */
        waitForStart();


        while (opModeIsActive()) {


            // drive train code
            leftStickY = gamepad1.left_stick_y;
            leftStickX = gamepad1.left_stick_x;
            rightStickX = gamepad1.right_stick_x;

            frontLeft.setPower(leftStickY - leftStickX - rightStickX);
            frontRight.setPower(leftStickY + leftStickX - rightStickX);
            backLeft.setPower(-leftStickY - leftStickX - rightStickX);
            backRight.setPower(-leftStickY + leftStickX - rightStickX);


            if (gamepad2.y){

                flipMotor.setPower(0.5);
            }
            else if (gamepad2.a){
                flipMotor.setPower(-0.8);
            }


            else {

              flipMotor.setPower(0);
            }


                vexMotor0.setPower(-0.83111090);//+
                vexMotor1.setPower(0.83111090);
                vexMotor2.setPower(-0.83111090);

/*

            if(gamepad2.x){ // out take
                vexMotor3.setPower(0.83111090);
                vexMotor4.setPower(-0.83111090);
                vexMotor5.setPower(0.83111090);//-


            }


            if(gamepad2.b){  // intake

                vexMotor0.setPower(0.83111090); // left (-)
                vexMotor1.setPower(-0.83111090); //
                vexMotor2.setPower(0.83111090);  //
                vexMotor3.setPower(-0.83111090);  //  left
                vexMotor4.setPower(0.83111090);  // right
                vexMotor5.setPower(-0.83111090); //   right (+)


            }


            if(gamepad2.dpad_left){

                vexMotor0.setPower(-0.83111090);
                vexMotor1.setPower(0.83111090);
                vexMotor2.setPower(-0.83111090);
                vexMotor3.setPower(-0.83111090);
                vexMotor4.setPower(-0.83111090);
                vexMotor5.setPower(-0.83111090);--*



            }

            else {
                vexMotor0.setPower(0);
                vexMotor1.setPower(0);
                vexMotor2.setPower(0);
                vexMotor3.setPower(0);
                vexMotor4.setPower(0);
                vexMotor5.setPower(0);
            }
            */

            liftLeft.setPower(-gamepad2.right_stick_y);
            liftRight.setPower(gamepad2.right_stick_y);





        }

    }

}
