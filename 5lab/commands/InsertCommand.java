package commands;

import classes.Routestorage;
import elements.Route;
import interfaces.Command;

public class InsertCommand implements Command {
    Commands commands;
    Routestorage routestorage;
    public InsertCommand(Routestorage routestorage, Commands commands){
        this.routestorage = routestorage;
        this.commands = commands;
    }
    @Override
    public void execute() {
        Route route = commands.insertWithKey();
        if (route == null) System.out.println("Некорректно введенные данные для объекта.");
        else routestorage.addobject(route);
    }
}
