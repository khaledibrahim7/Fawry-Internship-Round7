package example.sensors;


import example.Logs.LogManager;

public class MotionSensor implements Sensor {
    @Override
    public void detect() {
        System.out.println("Motion detected!");
        // Log the detection
        LogManager.getInstance().log("Motion detected by MotionSensor.");
    }
}
