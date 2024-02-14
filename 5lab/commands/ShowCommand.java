package commands;

import classes.Routestorage;
import interfaces.Command;

public class ShowCommand implements Command {
    Routestorage routestorage;
    public ShowCommand(Routestorage routestorage){
        this.routestorage = routestorage;
    }
    @Override
    public void execute() {
        routestorage.sort();
        if (routestorage.getCollection().isEmpty()) System.out.println("Коллекция пуста.");
        else System.out.println(routestorage.toString());
    }
}
