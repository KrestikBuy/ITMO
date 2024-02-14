package commands;

import classes.Routestorage;
import elements.Route;
import interfaces.Command;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountGreaterThanDistanceCommand implements Command {
    Routestorage routestorage;
    CommandContext commandContext;
    public CountGreaterThanDistanceCommand(Routestorage routestorage, CommandContext commandContext){
        this.routestorage = routestorage;
        this.commandContext = commandContext;
    }
    @Override
    public void execute() {
        Float distance = commandContext.getDistance();
        int sum = 0;
        LinkedHashMap<Integer, Route> map = routestorage.getCollection();
        for (Map.Entry<Integer, Route> entry : map.entrySet()) {
            if(Float.compare(entry.getValue().getDistance(), distance) > 0) sum += 1;
        }
        System.out.println("Нашлось " + sum + " таких элементов.");
    }
}
