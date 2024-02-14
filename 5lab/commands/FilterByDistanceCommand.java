package commands;

import classes.Routestorage;
import elements.Route;
import interfaces.Command;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FilterByDistanceCommand implements Command {
    Routestorage routestorage;
    CommandContext commandContext;
    public FilterByDistanceCommand(Routestorage routestorage, CommandContext commandContext){
        this.routestorage = routestorage;
        this.commandContext = commandContext;
    }
    @Override
    public void execute() {
        StringBuilder sb = new StringBuilder();
        Boolean flag = false;
        Float distance = commandContext.getDistance();
        LinkedHashMap<Integer, Route> map = routestorage.getCollection();
        for (Map.Entry<Integer, Route> entry : map.entrySet()) {
            if(Float.compare(entry.getValue().getDistance(), distance) == 0) {
                sb.append("Ключ: ").append(entry.getKey()).append("\nЗначение: ").append(entry.getValue()).append("\n");
                flag = true;
            }
        }
        if (flag) System.out.print(sb.toString());
        else System.out.println("Таких элементов нет.");
    }
}
