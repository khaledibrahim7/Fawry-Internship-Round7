package example.sensors;


import example.Logs.LogManager;

public class SmokeSensor implements Sensor {

    @Override
    public void detect() {
        System.out.println("Smoke detected!");
        LogManager.getInstance().log("Smoke detected by SmokeSensor.");
    }
}
