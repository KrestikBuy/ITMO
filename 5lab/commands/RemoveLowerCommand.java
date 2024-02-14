package commands;

import classes.Routestorage;
import elements.Route;
import interfaces.Command;

public class RemoveLowerCommand implements Command {
    Routestorage routestorage;
    Commands commands;
    public RemoveLowerCommand(Routestorage routestorage, Commands commands){
        this.routestorage = routestorage;
        this.commands = commands;
    }
    @Override
    public void execute() {
        Route route = commands.insertWithKey();
        if (route == null) System.out.println("Некорректно введенные данные для объекта.");
        else routestorage.remove_lower(route);
    }
}
