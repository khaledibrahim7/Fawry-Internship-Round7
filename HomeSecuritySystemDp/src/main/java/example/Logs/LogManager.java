package example.Logs;

public class LogManager {
    private static LogManager instance;

    // Private constructor to prevent instantiation
    private LogManager() {}

    // Singleton instance method
    public static LogManager getInstance() {
        if (instance == null) {
            instance = new LogManager();
        }
        return instance;
    }

    // Log method to write messages
    public void log(String message) {
        // In a real application, this would append to a file.
        System.out.println("Log: " + message);
    }

}
