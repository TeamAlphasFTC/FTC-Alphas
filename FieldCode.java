package org.firstinspires.ftc.robotcontroller;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class M extends LinearOpMode {
    @Override
    public void runOpMode(){
        DcMotor rightRear;
        DcMotor leftRear;
        DcMotor rightFront;
        DcMotor leftFront;
        rightRear = hardwareMap.get(DcMotor.class, "frontLeftMotor");
        leftRear = hardwareMap.get(DcMotor.class, "frontRightMotor");
        rightFront = hardwareMap.get(DcMotor.class, "backLeftMotor");
        leftFront = hardwareMap.get(DcMotor.class, "backRightMotor");


        waitForStart();

        while (opModeIsActive()){
            double x = gamepad1.left_stick_x;
            double y = gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;
            double theta = Math.atan2(y, x);
            double power = Math.hypot(x,y);

            double sin = Math.sin(theta - Math.PI/4);
            double cos = Math.cos(theta - Math.PI/4);
            double max = Math.max(Math.abs(sin),
                    Math.abs(cos));

            double LF = power * cos/max + turn;
            double RF = power * cos/max + turn;
            double LR = power * cos/max + turn;
            double RR = power * cos/max + turn;

            if ((power + Math.abs(turn)) > 1){
                LF /= power + turn;
                RF /= power + turn;
                LR /= power + turn;
                RR /= power + turn;

            }

            leftFront.setPower(LF);
            leftRear.setPower(LR);
            rightFront.setPower(RF);
            rightRear.setPower(RR);

        }
    }
}
