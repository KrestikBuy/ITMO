package commands;

import classes.Routestorage;
import interfaces.Command;

public class RemoveLowerKeyCommand implements Command {
    Routestorage routestorage;
    CommandContext commandContext;
    public RemoveLowerKeyCommand(Routestorage routestorage, CommandContext commandContext){
        this.routestorage = routestorage;
        this.commandContext = commandContext;
    }
    @Override
    public void execute() {
        int key = commandContext.getId();
        routestorage.remove_lower_key(key);
    }
}
