package commands;

import classes.Routestorage;
import elements.Route;
import interfaces.Command;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FilterStartsWithNameCommand implements Command {

    Routestorage routestorage;
    CommandContext commandContext;
    public FilterStartsWithNameCommand(Routestorage routestorage, CommandContext commandContext){
        this.routestorage = routestorage;
        this.commandContext = commandContext;
    }

    @Override
    public void execute() {
        StringBuilder sb = new StringBuilder();
        Boolean flag = false;
        String s = commandContext.getName();
        LinkedHashMap<Integer, Route> map = routestorage.getCollection();
        for (Map.Entry<Integer, Route> entry : map.entrySet()) {
            if(entry.getValue().getName().startsWith(s)) {
                sb.append("Ключ: ").append(entry.getKey()).append("\nЗначение: ").append(entry.getValue()).append("\n");
                flag = true;
            }
        }
        if (flag) System.out.print(sb.toString());
        else System.out.println("Таких элементов нет.");
    }
}
