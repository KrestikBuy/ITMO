package commands;

import interfaces.Command;

import java.util.*;

public class CommandExecutor{
    private Map<String, Command> commands;

    public CommandExecutor() {
        this.commands = new HashMap<>();
    }

    public void registerCommand(String name, Command command) {
        commands.put(name, command);
    }

    public void executeCommand(String name) {
        Command command = commands.get(name);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Нет такой команды.");
        }
    }
}
