package org.firstinspires.ftc.teamcode.teamcode.Utilities.Telemetry;

import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.util.RobotLog;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ThrowbackTelemetry {

    MultipleTelemetry telemetry;

    public ThrowbackTelemetry(MultipleTelemetry telemetry){
        this.telemetry = telemetry;
    }

    public Telemetry.Item addData(String s, Object o){
        try{
            return telemetry.addData(s, o);
        }catch(NullPointerException e){
            System.out.println("TelemetryError Caught");
            RobotLog.aa("TelemError", s);
        }
        return null;
    }

    public Telemetry.Item addBoolData(String s, boolean o){
        try{
            return telemetry.addData(s, o ? 1 : 0);
        }catch(NullPointerException e){
            System.out.println("TelemetryError Caught");
            RobotLog.aa("TelemError", s);
        }
        return null;
    }

    public void addLine(String s){
        try{
            telemetry.addLine(s);
        }catch(NullPointerException e){
            System.out.println("TelemetryError Caught");
            RobotLog.aa("TelemError", s);

        }
    }

    public void addLine(String... args){
        String s = "";
        for(String a : args){
            s += a;
        }
        try{
            telemetry.addLine(s);
        }catch(NullPointerException e){
            System.out.println("TelemetryError Caught");
            RobotLog.aa("TelemError", s);

        }
    }

    public void update(){
        telemetry.update();
    }

    public MultipleTelemetry getTelemetry(){
        return telemetry;
    }

    public void setTelemetry(MultipleTelemetry telemetry){
        this.telemetry = telemetry;
    }



}