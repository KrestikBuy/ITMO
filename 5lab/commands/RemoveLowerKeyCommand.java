package commands;

import classes.Routestorage;
import interfaces.Command;
/**
 * Вызываемая команда для удаления всех элементов из коллекции, ключ которых меньше чем заданный.
 */
public class RemoveLowerKeyCommand implements Command {
    private Routestorage routestorage;
    private CommandContext commandContext;
    public RemoveLowerKeyCommand(Routestorage routestorage, CommandContext commandContext){
        this.routestorage = routestorage;
        this.commandContext = commandContext;
    }
    @Override
    public void execute() {
        int key = commandContext.getId();
        routestorage.remove_lower_key(key);
        System.out.println("Все возможные объекты удалены.");
    }
}
