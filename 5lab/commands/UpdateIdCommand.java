package commands;

import classes.Routestorage;
import elements.Route;
import interfaces.Command;

public class UpdateIdCommand implements Command {
    Commands commands;
    Routestorage routestorage;
    CommandContext commandContext;
    public UpdateIdCommand(Routestorage routestorage, Commands commands, CommandContext commandContext){
        this.routestorage = routestorage;
        this.commands = commands;
        this.commandContext = commandContext;
    }
    @Override
    public void execute() {
        if (routestorage.getCollection().containsKey(commandContext.getId())) {
            Route route = commands.insertWithOutKey(commandContext.getId());
            if (route == null) System.out.println("Некорректно введенные данные для объекта.");
            else routestorage.updateobject(route);
        }
        else System.out.println("Элемента с заданным id не существует.");
    }
}
