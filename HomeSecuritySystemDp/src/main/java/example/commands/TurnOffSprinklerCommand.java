package example.commands;

public class TurnOffSprinklerCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Sprinkler turned off.");
    }
}
