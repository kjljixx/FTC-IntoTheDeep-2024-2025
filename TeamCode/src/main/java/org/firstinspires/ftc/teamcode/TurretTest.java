package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp
public class TurretTest extends OpMode {
    //    Turret turretLeft;
    DcMotorEx turretRight;
    DcMotorEx turretLeft;
    //    Turret turretRight;
    boolean moveTurretLeft = true;
    boolean started = false;

    @Override
    public void init() {

        turretLeft = hardwareMap.get(DcMotorEx.class, "turretLeft");
        turretRight = hardwareMap.get(DcMotorEx.class, "turretRight");
//        turretLeft = new Turret(hardwareMap.get(DcMotorEx.class, "liftLeft"));
//        turretRight = new Turret(hardwareMap.get(DcMotorEx.class, "liftRight"));
    }

    @Override
    public void loop() {
        if(gamepad1.x){
            moveTurretLeft = true;
            started = true;
        }
        else if(gamepad1.b){
            moveTurretLeft = false;
            started = true;
        }
        DcMotorEx turret = moveTurretLeft ? turretLeft : turretRight;
        telemetry.addLine("X for left turret, B for right turret");
        if(started) {
            turret.setPower(-gamepad1.left_stick_y*0.7);
            telemetry.addData("turret power: ", turret.getPower());
            telemetry.addData("turret position: ", turret.getCurrentPosition());
        }
    }
}
