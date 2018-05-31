package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Autonomous.Methods.Drivetrain;
import org.firstinspires.ftc.teamcode.Autonomous.Methods.Intake;

/**
 * Created by minhl on 2/28/2018.
 */

@Autonomous

public class gyroTest extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    Drivetrain drivetrain = new Drivetrain();
    Intake intake = new Intake();

    @Override

    public void runOpMode() throws InterruptedException {

        drivetrain.init(hardwareMap);
        intake.init(hardwareMap);

        waitForStart();

        // Jewel //


        drivetrain.turnDistance(24,1);
        runtime.reset();
        sleep(100);

        drivetrain.strafeDistance(-38, 1);  // 42 center
        runtime.reset();
        sleep(100);

        // Outake //
        intake.Outtake();
        runtime.reset();
        sleep(1000);

        drivetrain.forwardsDistance(12, 1);
        runtime.reset();
        sleep(100);

        drivetrain.backwardsDistance(10, 1);
        runtime.reset();
        sleep(100);

        drivetrain.turnDistance(45, 1);
        intake.Intake();
        runtime.reset();
        sleep(100);
/*
        drivetrain.turnDistance(-36,1);
        intake.SameDirection();
        runtime.reset();
        sleep(100);

        drivetrain.strafeDistance(-50, 1);
        runtime.reset();
        sleep(100);

        drivetrain.forwardTurnDistance(72,1);
        intake.Outtake();
        runtime.reset();
        sleep(100);

        drivetrain.forwardsDistance(36,1);
        intake.Intake();
        runtime.reset();
        sleep(100);

        drivetrain.forwardsDistance(36,1);
        runtime.reset();
        sleep(100);
*/

        drivetrain.forwardsDistance(36,1);
        intake.Intake();
        runtime.reset();
        sleep(500);

        intake.Intake();
        runtime.reset();
        sleep(500);

        drivetrain.backwardsDistance(10,1);
        runtime.reset();
        sleep(100);

        drivetrain.strafeDistance(14,1);
        runtime.reset();
        sleep(100);

        drivetrain.turnDistance(46, 1);
        runtime.reset();
        sleep(100);

        drivetrain.forwardsDistance(30, 1);
        runtime.reset();
        sleep(1000);

        intake.Outtake();
        runtime.reset();
        sleep(1000);

        drivetrain.strafeDistance(2,1);
        runtime.reset();
        sleep(100);

        drivetrain.forwardsDistance(10, 1);
        runtime.reset();
        sleep(100);

        drivetrain.backwardsDistance(10, 1);
        runtime.reset();
        sleep(100);

        drivetrain.turnDistance(46,1);
        intake.SameDirection();
        runtime.reset();
        sleep(100);

    }
}
