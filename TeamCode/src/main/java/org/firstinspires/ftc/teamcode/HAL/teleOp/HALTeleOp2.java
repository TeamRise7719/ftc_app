package org.firstinspires.ftc.teamcode.HAL.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.subSystems.Driving.teleOp.mecanumDrivetrain;

@TeleOp(name = "HAL TeleOp", group = "HAL")
public class HALTeleOp2 extends OpMode {

    private mecanumDrivetrain robot;
    DcMotor arm1, arm2;
    DcMotor introtL, introtR;
    CRServo intR, intL;
    CRServo hook;
    Servo lift1, lift2, lift3, lift4;



    Telemetry tele;

    @Override
    public void init() {


        robot = new mecanumDrivetrain(hardwareMap, telemetry);
        robot.runUsingEncoders();
        arm1 = hardwareMap.dcMotor.get("arm1");
        arm2 = hardwareMap.dcMotor.get("arm2");
        arm1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        introtL = hardwareMap.dcMotor.get("introtL");
        introtR = hardwareMap.dcMotor.get("introtR");
        introtL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        introtR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intL = hardwareMap.crservo.get("intL");
        intR = hardwareMap.crservo.get("intR");
        hook = hardwareMap.crservo.get("hook");
        lift1 = hardwareMap.servo.get("lift1");
        lift2 = hardwareMap.servo.get("lift2");
        lift3 = hardwareMap.servo.get("lift3");
        lift4 = hardwareMap.servo.get("lift4");

        //boolean changed = false;

    }

    @Override
    public void loop() {


        //----------------------------------------------=+(Drivetrain)+=----------------------------------------------\\
        robot.drive(gamepad1, telemetry);

        if (gamepad1.x) {
            robot.resetHeading();
        }

        //----------------------------------------------=+(Drivetrain)+=----------------------------------------------\\


        //--------------------------------------------=+(Intake/Hanging)+=--------------------------------------------\\

        //Intake\\
        intL.setPower(gamepad2.left_stick_y);
        intR.setPower(-gamepad2.left_stick_y);

        //X-Rail Extension\\
        arm1.setPower(-gamepad2.right_stick_y);
        arm2.setPower(-gamepad2.right_stick_y);

        //Intake Rotation\\
        if (gamepad2.left_bumper) {
            introtR.setPower(1);
            introtL.setPower(1);
        } else {
            introtR.setPower(0);
            introtL.setPower(0);
        }
        if (gamepad2.right_bumper){
            introtR.setPower(-1);
            introtL.setPower(-1);
        } else {
            introtR.setPower(0);
            introtL.setPower(0);
        }

        //Toggle Hook//

        /*if(gamepad2.a){
            if(servoSpot == .05){
                servo.setPosition(.95);
                servoSpot = .95;
            } else {
                servo.setPosition(.95);
                servoSpot = .05;
            }
        }*/







    }

}