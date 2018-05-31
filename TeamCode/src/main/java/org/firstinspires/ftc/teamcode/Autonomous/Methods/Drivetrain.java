package org.firstinspires.ftc.teamcode.Autonomous.Methods;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

import static java.lang.Thread.sleep;


/**
 * Created by easha on 2/22/2018.
 */

public class Drivetrain {

    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    ElapsedTime time = new ElapsedTime();
/*
    BNO055IMU imu;
    Orientation angles;
    Acceleration gravity;
*/
    static final double     COUNTS_PER_MOTOR_REV    = 1120 ;    // Andy Mark Motor Encoder
    static final double     DRIVE_GEAR_REDUCTION    = 1.0 ;     // This is < 1.0 if geared UP
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);


    public void init (HardwareMap hardwareMap){

        // Motor //
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
/*
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "AdafruitIMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled = false;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

        // Retrieve and initialize the IMU. We expect the IMU to be attached to an I2C port
        // on a Core Device Interface Module, configured to be a sensor of type "AdaFruit IMU",
        // and named "imu".
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);
*/

    }

    public void strafeAtPower(double power)
    {

        frontLeft.setPower(-power);
        backLeft.setPower(-power);
        frontRight.setPower(power);
        backRight.setPower(power);



    }
/*
    public void turnWithGyro(double Angle)
    {
        angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);

        double kp = (double) 0.35 / 16.6; // 35
        double targetAngle = Angle;
        double error;
        double Power;

        // Loop and update the dashboard

        while(Math.abs(targetAngle-angles.firstAngle)>1)
        {

            error = targetAngle - angles.firstAngle;
            Power = (kp)*(error);

            frontLeft.setPower(Power);
            frontRight.setPower(Power);
            backLeft.setPower(Power);
            backRight.setPower(Power);

            angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
        }


        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);

    }

    // work on //
    public void strafeDistanceGyro(double distance, double BaseSpeed) {

        int newFrontLeftTarget;
        int newFrontRightTarget;
        int newBackLeftTarget;
        int newBackRightTarget;


        angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);

        double targetAngle = 0.0;
        double kp = (double) 0.50 / 15;//35
        double error;
        double Power;

        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        newFrontLeftTarget = frontLeft.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
        newFrontRightTarget = frontRight.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
        newBackLeftTarget = backLeft.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
        newBackRightTarget = backRight.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);

        frontLeft.setTargetPosition(-newFrontLeftTarget);
        backLeft.setTargetPosition(-newBackLeftTarget);
        frontRight.setTargetPosition(newFrontRightTarget);
        backRight.setTargetPosition(newBackRightTarget);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (frontLeft.isBusy() && frontRight.isBusy() && backLeft.isBusy() && backRight.isBusy()) {

            error = (targetAngle - angles.firstAngle);
            Power = (kp) * (error);

            frontLeft.setPower(-BaseSpeed + Power);
            frontRight.setPower(BaseSpeed + Power);
            backLeft.setPower(-BaseSpeed + Power);
            backRight.setPower(BaseSpeed + Power);

            angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);

        }

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);

        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    // work on //
    public void driveDistanceGyro(double distance, double BaseSpeed) {

        int newFrontLeftTarget;
        int newFrontRightTarget;
        int newBackLeftTarget;
        int newBackRightTarget;

        angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);

        double targetAngle = 0.0;
        double kp = (double) 0.65 / 37.5;//35
        double error;
        double Power;


        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        newFrontLeftTarget = frontLeft.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
        newFrontRightTarget = frontRight.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
        newBackLeftTarget = backLeft.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
        newBackRightTarget = backRight.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);

        frontLeft.setTargetPosition(newFrontLeftTarget);
        backLeft.setTargetPosition(-newBackLeftTarget);
        frontRight.setTargetPosition(newFrontRightTarget);
        backRight.setTargetPosition(-newBackRightTarget);


        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (frontLeft.isBusy() && frontRight.isBusy() && backLeft.isBusy() && backRight.isBusy()) {

            error = (targetAngle - angles.firstAngle);
            Power = (kp) * (error);

            frontLeft.setPower(BaseSpeed + Power);
            frontRight.setPower(BaseSpeed + Power);
            backLeft.setPower(-BaseSpeed + Power);
            backRight.setPower(-BaseSpeed + Power);
            angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);

        }

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);

        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }
*/
    public void backwardsDistance(double distance, double BaseSpeed) {

        int newFrontLeftTarget;
        int newFrontRightTarget;
        int newBackLeftTarget;
        int newBackRightTarget;

        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        newFrontLeftTarget = frontLeft.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
        newFrontRightTarget = frontRight.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
        newBackLeftTarget = backLeft.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
        newBackRightTarget = backRight.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);

        frontLeft.setTargetPosition(-newFrontLeftTarget);
        backLeft.setTargetPosition(newBackLeftTarget);
        frontRight.setTargetPosition(-newFrontRightTarget);
        backRight.setTargetPosition(newBackRightTarget);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setPower(-BaseSpeed);
        frontRight.setPower(-BaseSpeed);
        backLeft.setPower(BaseSpeed);
        backRight.setPower(BaseSpeed);

        while (frontLeft.isBusy() && frontRight.isBusy() && backLeft.isBusy() && backRight.isBusy()) {

        }

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);

        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void forwardsDistance(double distance, double BaseSpeed) {

        int newFrontLeftTarget;
        int newFrontRightTarget;
        int newBackLeftTarget;
        int newBackRightTarget;

        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        newFrontLeftTarget = frontLeft.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
        newFrontRightTarget = frontRight.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
        newBackLeftTarget = backLeft.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
        newBackRightTarget = backRight.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);

        frontLeft.setTargetPosition(-newFrontLeftTarget);
        backLeft.setTargetPosition(-newBackLeftTarget);
        frontRight.setTargetPosition(newFrontRightTarget);
        backRight.setTargetPosition(newBackRightTarget);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setPower(-BaseSpeed);
        frontRight.setPower(BaseSpeed);
        backLeft.setPower(-BaseSpeed);
        backRight.setPower(BaseSpeed);

        while (frontLeft.isBusy() && frontRight.isBusy() && backLeft.isBusy() && backRight.isBusy()) {

        }

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);

        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void strafeDistance(double distance, double BaseSpeed) {

        int newFrontLeftTarget;
        int newFrontRightTarget;
        int newBackLeftTarget;
        int newBackRightTarget;

        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        newFrontLeftTarget = frontLeft.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
        newFrontRightTarget = frontRight.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
        newBackLeftTarget = backLeft.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
        newBackRightTarget = backRight.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);

        frontLeft.setTargetPosition(-newFrontLeftTarget);
        backLeft.setTargetPosition(newBackLeftTarget);
        frontRight.setTargetPosition(-newFrontRightTarget);
        backRight.setTargetPosition(newBackRightTarget);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setPower(-BaseSpeed);
        frontRight.setPower(-BaseSpeed);
        backLeft.setPower(BaseSpeed);
        backRight.setPower(BaseSpeed);

        while (frontLeft.isBusy() && frontRight.isBusy() && backLeft.isBusy() && backRight.isBusy()) {

        }

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);

        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


    }

    public void turnDistance(double distance, double BaseSpeed) {

        int newFrontLeftTarget;
        int newFrontRightTarget;
        int newBackLeftTarget;
        int newBackRightTarget;

        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        newFrontLeftTarget = frontLeft.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
        newFrontRightTarget = frontRight.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
        newBackLeftTarget = backLeft.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
        newBackRightTarget = backRight.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);

        frontLeft.setTargetPosition(-newFrontLeftTarget);
        backLeft.setTargetPosition(-newBackLeftTarget);
        frontRight.setTargetPosition(-newFrontRightTarget);
        backRight.setTargetPosition(-newBackRightTarget);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setPower(-BaseSpeed);
        frontRight.setPower(-BaseSpeed);
        backLeft.setPower(-BaseSpeed);
        backRight.setPower(-BaseSpeed);

        while (frontLeft.isBusy() && frontRight.isBusy() && backLeft.isBusy() && backRight.isBusy()) {

        }

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);

        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


    }

    public void forwardTurnDistance(double distance, double BaseSpeed) {

        int newFrontLeftTarget;
        int newFrontRightTarget;
        int newBackLeftTarget;
        int newBackRightTarget;

        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        newFrontLeftTarget = frontLeft.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
        newFrontRightTarget = frontRight.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
        newBackLeftTarget = backLeft.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
        newBackRightTarget = backRight.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);

        frontLeft.setTargetPosition(newFrontLeftTarget);
        backLeft.setTargetPosition(-newBackLeftTarget);
        frontRight.setTargetPosition(newFrontRightTarget/20);
        backRight.setTargetPosition(-newBackRightTarget/20);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setPower(BaseSpeed);
        frontRight.setPower(BaseSpeed/20);
        backLeft.setPower(-BaseSpeed);
        backRight.setPower(-BaseSpeed/20);

        while (frontLeft.isBusy() && frontRight.isBusy() && backLeft.isBusy() && backRight.isBusy()) {

        }

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);

        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }






}
