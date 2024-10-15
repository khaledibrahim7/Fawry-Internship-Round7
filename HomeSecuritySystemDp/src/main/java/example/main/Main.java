package example.main;


import example.Logs.LogManager;
import example.commands.Command;
import example.commands.TurnOffAlarmCommand;
import example.commands.TurnOffSprinklerCommand;
import example.devices.Alarm;
import example.devices.Sprinkler;
import example.notifications.SMSNotifierAdapter;
import example.sensors.MotionSensor;
import example.sensors.Sensor;
import example.sensors.SmokeSensor;

public class Main {

    public static void main(String[] args) {
        Sensor smokeSensor = new SmokeSensor();
        Sensor motionSensor = new MotionSensor();

        
        smokeSensor.detect();
        motionSensor.detect();

        Sprinkler sprinkler = new Sprinkler();
        Alarm alarm = new Alarm();

        sprinkler.update("Smoke detected in living room.");
        alarm.update("Motion detected in the hallway.");

        SMSNotifierAdapter smsNotifier = new SMSNotifierAdapter();
        smsNotifier.sendSMS("Smoke detected! Check your living room.");
        smsNotifier.sendSMS("Motion detected! Check the hallway.");

        
        LogManager logger = LogManager.getInstance();
        logger.log("Smoke and motion detected.");

        Command turnOffSprinkler = new TurnOffSprinklerCommand();
        Command turnOffAlarm = new TurnOffAlarmCommand();

        turnOffSprinkler.execute();
        turnOffAlarm.execute();
    }
}
