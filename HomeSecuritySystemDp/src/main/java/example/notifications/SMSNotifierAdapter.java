package example.notifications;

public class SMSNotifierAdapter implements SMSNotifier {
    @Override
    public void sendSMS(String message) {

        System.out.println("Sending SMS: " + message);

    }


}
