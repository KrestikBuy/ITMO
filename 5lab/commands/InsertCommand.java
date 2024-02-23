package commands;

import classes.Routestorage;
import elements.Route;
import interfaces.Command;
/**
 * Вызываемая команда для ввода элемента в коллекцию.
 */
public class InsertCommand implements Command {
    private Commands commands;
    private Routestorage routestorage;
    public InsertCommand(Routestorage routestorage, Commands commands){
        this.routestorage = routestorage;
        this.commands = commands;
    }
    @Override
    public void execute() {
        Route route = commands.insertWithKey(true, 0);
        if (route == null) System.out.println("Некорректно введенные данные для объекта.");
        else routestorage.addobject(route);
    }
}
