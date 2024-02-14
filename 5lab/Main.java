import classes.FileReader;
import classes.Routestorage;
import commands.*;
import elements.Coordinates;
import elements.Location1;
import elements.Location2;
import elements.Route;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        run();
    }

    public static void run(){
//  --------------------------------------------------- Экземпляр класса FileReader для чтения из файла
        FileReader fileReader = new FileReader();
        String filePath = "C:\\Users\\Artem\\Desktop\\Учеба\\Программирование\\First Lab - 2 sem\\src\\script.json";
//  --------------------------------------------------- Экземпляры вспомогательных классов
        Routestorage routestorage = new Routestorage();
        Scanner scanner = new Scanner(System.in);
        Commands commands = new Commands();
// ---------------------------------------------------- Несколько примерных объектов в LinkedHashMap
        routestorage.add(new Route(commands.createId(routestorage.getCollection()), "first", new Coordinates(10, 10),
                new Location1(15, 15.0F, "Moscow"), new Location2(5, 1.0, 0.0, "SP"), 15.0F));
        routestorage.add(new Route(commands.createId(routestorage.getCollection()), "second", new Coordinates(70, 19),
                new Location1(34, 11.0F, "Praga"), new Location2(56, 23.0, 6.0, "Stavropol"), 546.0F));
// ---------------------------------------------------- Работа с командной строкой
        CommandExecutor executor = new CommandExecutor();
        CommandContext commandContext = new CommandContext();

        executor.registerCommand("help", new HelpCommand());
        executor.registerCommand("exit", new ExitCommand());
        executor.registerCommand("info", new InfoCommand(routestorage));
        executor.registerCommand("show", new ShowCommand(routestorage));
        executor.registerCommand("filter_by_distance", new FilterByDistanceCommand(routestorage, commandContext));
        executor.registerCommand("filter_starts_with_name", new FilterStartsWithNameCommand(routestorage, commandContext));
        executor.registerCommand("count_greater_than_distance", new CountGreaterThanDistanceCommand(routestorage, commandContext));
        executor.registerCommand("insert", new InsertCommand(routestorage, commands));
        executor.registerCommand("update_id", new UpdateIdCommand(routestorage, commands, commandContext));
        executor.registerCommand("clear", new ClearCommand(routestorage));
        executor.registerCommand("remove_key", new RemoveKeyCommand(routestorage, commandContext));
        executor.registerCommand("remove_greater", new RemoveGreaterCommand(routestorage, commands));
        executor.registerCommand("remove_lower", new RemoveLowerCommand(routestorage, commands));
        executor.registerCommand("remove_lower_key", new RemoveLowerKeyCommand(routestorage, commandContext));
        executor.registerCommand("execute_script", new ExecuteScriptCommand(routestorage, commandContext));

        while (true) {
            System.out.print("Введите Комманду (Сводка по командам help): ");
            String command = scanner.nextLine();

            if (command.startsWith("update_id") || command.startsWith("remove_key") || command.startsWith("remove_lower_key")) {
                try {
                    int id = Integer.parseInt(command.substring(command.indexOf(' ') + 1).trim());
                    commandContext.setId(id);
                    command = command.substring(0, command.indexOf(' '));
                    executor.executeCommand(command);
                }
                catch (Exception e){
                    System.out.println("Значение id/key введено неверно!");
                }
            }
            else if (command.startsWith("count_greater_than_distance") || command.startsWith("filter_by_distance")) {
                try {
                    Float distance = Float.parseFloat(command.substring(command.indexOf(' ') + 1).trim());
                    commandContext.setDistance(distance);
                    command = command.substring(0, command.indexOf(' '));
                    executor.executeCommand(command);
                }
                catch (Exception e){
                    System.out.println("Значение distance введено неверно!");
                }
            }
            else if (command.startsWith("filter_starts_with_name") || command.startsWith("execute_script")) {
                try {
                    String name = command.substring(command.indexOf(' ') + 1).trim();
                    commandContext.setName(name);
                    command = command.substring(0, command.indexOf(' '));
                    executor.executeCommand(command);
                }
                catch (Exception e){
                    System.out.println("Значение name введено неверно!");
                }
            }
            else {
                command = command.replaceAll("\\s", "");
                executor.executeCommand(command);
            }
        }
    }
}

