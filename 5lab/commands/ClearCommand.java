package commands;

import classes.Routestorage;
import interfaces.Command;

public class ClearCommand implements Command {
    Routestorage routestorage;
    public ClearCommand(Routestorage routestorage){
        this.routestorage = routestorage;
    }
    @Override
    public void execute() {
        routestorage.clear();
    }
}
