package example.devices;

public class Sprinkler implements DeviceObserver {
    @Override
    public void update(String message) {
        System.out.println("Sprinkler activated: " + message);

    }
}
