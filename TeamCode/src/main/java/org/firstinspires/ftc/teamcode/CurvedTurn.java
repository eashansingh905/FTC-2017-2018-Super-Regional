package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Autonomous.Methods.Intake;
import org.firstinspires.ftc.teamcode.Autonomous.Methods.Drivetrain;

/**
 * Created by minhl on 3/1/2018.
 */

@Autonomous

public class CurvedTurn extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    Drivetrain drivetrain = new Drivetrain();
    Intake intake = new Intake();

    @Override

    public void runOpMode() throws InterruptedException {

        drivetrain.init(hardwareMap);
        intake.init(hardwareMap);

        waitForStart();

        drivetrain.strafeDistance(1000,0.25);
        runtime.reset();
        sleep(100);

        }
    }

