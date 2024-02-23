package commands;

import classes.Routestorage;
import elements.Route;
import interfaces.Command;
/**
 * Вызываемая команда для удаления всех элементов, которые меньше чем введенный.
 */
public class RemoveLowerCommand implements Command {
    private Routestorage routestorage;
    private Commands commands;
    CommandContext commandContext;
    public RemoveLowerCommand(Routestorage routestorage, Commands commands, CommandContext commandContext){
        this.routestorage = routestorage;
        this.commands = commands;
        this.commandContext = commandContext;
    }
    @Override
    public void execute() {
        Route route;
        if (commandContext.getFlagRemove()) route = commandContext.getRoute();
        else route = commands.insertWithKey(true, 0);
        if (route == null) System.out.println("Некорректно введенные данные для объекта.");
        else routestorage.remove_lower(route);
        System.out.println("Все допустимые объекты удалены.");
    }
}
