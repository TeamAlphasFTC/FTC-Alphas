package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class MecanumDrive extends LinearOpMode {

    @Override
    public void runOpMode() {

        DcMotor frontLeftMotor;
        DcMotor frontRightMotor;
        DcMotor backLeftMotor;
        DcMotor backRightMotor;
        // Initialize the hardware.
        frontLeftMotor = hardwareMap.get(DcMotor.class, "frontLeftMotor");
        frontRightMotor = hardwareMap.get(DcMotor.class, "frontRightMotor");
        backLeftMotor = hardwareMap.get(DcMotor.class, "backLeftMotor");
        backRightMotor = hardwareMap.get(DcMotor.class, "backRightMotor");

        // Set the motors to the correct direction.
        frontLeftMotor.setDirection(DcMotor.Direction.FORWARD);
        frontRightMotor.setDirection(DcMotor.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotor.Direction.FORWARD);
        backRightMotor.setDirection(DcMotor.Direction.REVERSE);

        // Wait for the start button to be pressed.
        waitForStart();

        while (opModeIsActive()) {
            // Get the joystick values.
            double x = gamepad1.left_stick_x;
            double y = gamepad1.left_stick_y;
            double rotation = gamepad1.right_stick_x;

            // Calculate the motor speeds.
            double frontLeftSpeed = x + y + rotation;
            double frontRightSpeed = x - y - rotation;
            double backLeftSpeed = x - y + rotation;
            double backRightSpeed = x + y - rotation;

            // Set the motor speeds.
            frontLeftMotor.setPower(frontLeftSpeed);
            frontRightMotor.setPower(frontRightSpeed);
            backLeftMotor.setPower(backLeftSpeed);
            backRightMotor.setPower(backRightSpeed);
        }
    }
}
