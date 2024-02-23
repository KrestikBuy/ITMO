package commands;

import classes.Routestorage;
import interfaces.Command;
/**
 * Вызываемая команда для отчистки коллекции.
 */
public class ClearCommand implements Command {
    private Routestorage routestorage;
    public ClearCommand(Routestorage routestorage){
        this.routestorage = routestorage;
    }
    @Override
    public void execute() {
        routestorage.clear();
    }
}
