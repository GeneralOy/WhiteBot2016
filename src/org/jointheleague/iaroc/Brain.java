package org.jointheleague.iaroc;

import android.os.SystemClock;

import ioio.lib.api.IOIO;
import ioio.lib.api.exception.ConnectionLostException;
import org.wintrisstech.irobot.ioio.IRobotCreateAdapter;
import org.wintrisstech.irobot.ioio.IRobotCreateInterface;
import org.jointheleague.iaroc.sensors.UltraSonicSensors;

public class Brain extends IRobotCreateAdapter {
    private final Dashboard dashboard;
    public UltraSonicSensors sonar;

    public Brain(IOIO ioio, IRobotCreateInterface create, Dashboard dashboard)
            throws ConnectionLostException {
        super(create);
        sonar = new UltraSonicSensors(ioio);
        this.dashboard = dashboard;
    }

    /* This method is executed when the robot first starts up. */
    public void initialize() throws ConnectionLostException {
        dashboard.log("Hello! I'm a Clever Robot!");
        readSensors(SENSORS_BUMPS_AND_WHEEL_DROPS);
        //what would you like me to do, Clever Human?




    }
    /* This method is called repeatedly. */
    public void loop() throws ConnectionLostException {
        driveDirect(50, 50);
        if(isBumpRight()|| isBumpLeft()){
            SystemClock.sleep(100);
            driveDirect(-10, -10);
            SystemClock.sleep(500);
            turnLeft(1500);
            driveDirect(50,50);
            if(isBumpRight()|| isBumpLeft()){
                SystemClock.sleep(100);
                driveDirect(-10, -10);
                SystemClock.sleep(500);
                turnRight(3000);
                driveDirect(50,50);
                if(isBumpRight()|| isBumpLeft()){
                    SystemClock.sleep(100);
                    driveDirect(-10, -10);
                    SystemClock.sleep(500);
                    turnRight(1500);
                    driveDirect(50,50);


            }


        }
    SystemClock.sleep(100);

    }
    public void turnLeft(int time) throws ConnectionLostException {
        driveDirect(-10,10);
        SystemClock.sleep(time);
    }
    public void turnRight(int time) throws ConnectionLostException {
        driveDirect(10,-10);
        SystemClock.sleep(time);
    }

}