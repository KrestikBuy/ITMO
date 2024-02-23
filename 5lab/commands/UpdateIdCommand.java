package commands;

import classes.Routestorage;
import elements.Route;
import interfaces.Command;
/**
 * Вызываемая команда для перезаписи элемента коллекции.
 */
public class UpdateIdCommand implements Command {
    private Commands commands;
    private Routestorage routestorage;
    private CommandContext commandContext;
    public UpdateIdCommand(Routestorage routestorage, Commands commands, CommandContext commandContext){
        this.routestorage = routestorage;
        this.commands = commands;
        this.commandContext = commandContext;
    }
    @Override
    public void execute() {
        Route route = null;
        if (routestorage.getCollection().containsKey(commandContext.getId())) {
            if (commandContext.getFlagRemove()) {
                route = commandContext.getRoute();
            }
            else route = commands.insertWithKey(false, commandContext.getId());
            if (route == null) System.out.println("Некорректно введенные данные для объекта.");
            else {
                routestorage.updateobject(route);}
        }
        else System.out.println("Элемента с заданным id не существует.");
    }
}
