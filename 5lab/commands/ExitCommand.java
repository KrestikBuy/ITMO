package commands;

import classes.Routestorage;
import interfaces.Command;
/**
 * Вызываемая команда для выхода из приложения.
 */
public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Выход из приложения");
        System.exit(0);
    }
}