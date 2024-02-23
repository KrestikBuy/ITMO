package commands;

import classes.Routestorage;
import interfaces.Command;

import java.util.LinkedHashMap;
import java.util.Scanner;
/**
 * Вызываемая команда для удаления элемента с заданным ключом.
 */
public class RemoveKeyCommand implements Command {
    private Routestorage routestorage;
    private CommandContext commandContext;
    public RemoveKeyCommand(Routestorage routestorage, CommandContext commandContext){
        this.routestorage = routestorage;
        this.commandContext = commandContext;
    }
    @Override
    public void execute() {
        int key = commandContext.getId();
        routestorage.removeobject(key);
    }
}
