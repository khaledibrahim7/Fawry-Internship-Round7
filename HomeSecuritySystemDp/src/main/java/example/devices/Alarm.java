package example.devices;

public class Alarm implements DeviceObserver {
    @Override
    public void update(String message) {
        System.out.println("Alarm activated: " + message);

    }
}
