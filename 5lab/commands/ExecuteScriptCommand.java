package commands;

import classes.Routestorage;
import interfaces.Command;

public class ExecuteScriptCommand implements Command {
    Routestorage routestorage;
    CommandContext commandContext;
    public ExecuteScriptCommand(Routestorage routestorage, CommandContext commandContext){
        this.commandContext = commandContext;
        this.routestorage = routestorage;
    }

    @Override
    public void execute() {
        String name = commandContext.getName();
    }
}
