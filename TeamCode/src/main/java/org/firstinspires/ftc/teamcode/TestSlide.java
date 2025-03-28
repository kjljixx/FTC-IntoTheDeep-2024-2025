package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp
public class TestSlide extends OpMode {
//    Slide slideLeft;
    DcMotorEx slideRight;
    DcMotorEx slideLeft;
//    Slide slideRight;
    boolean moveSlideLeft = true;
    boolean started = false;

    @Override
    public void init() {

        slideLeft = hardwareMap.get(DcMotorEx.class, "liftLeft");
        slideRight = hardwareMap.get(DcMotorEx.class, "liftRight");
//        slideLeft = new Slide(hardwareMap.get(DcMotorEx.class, "liftLeft"));
//        slideRight = new Slide(hardwareMap.get(DcMotorEx.class, "liftRight"));
    }

    @Override
    public void loop() {
        if(gamepad1.x){
            moveSlideLeft = true;
            started = true;
        }
        else if(gamepad1.b){
            moveSlideLeft = false;
            started = true;
        }
        DcMotorEx slide = moveSlideLeft ? slideLeft : slideRight;
        telemetry.addLine("X for left slide, B for right slide");
        if(started) {
            slide.setPower(-gamepad1.left_stick_y*0.7);
            telemetry.addData("slide power: ", slide.getPower());
            telemetry.addData("slide position: ", slide.getCurrentPosition());
        }
    }
}
