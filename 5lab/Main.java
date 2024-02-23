import classes.FileParser;
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
//  --------------------------------------------------- Экземпляры вспомогательных классов
        Routestorage routestorage = new Routestorage();
        Scanner scanner = new Scanner(System.in);
        Commands commands = new Commands();
//  --------------------------------------------------- Экземпляр класса FileReader для чтения из файла
        String filePath = "C:\\Users\\Artem\\Desktop\\Учеба\\Программирование\\First Lab - 2 sem\\src\\script.txt";
        String fileName = "file.json";
        FileParser fileParser = new FileParser(routestorage, fileName);
// ---------------------------------------------------- Несколько примерных объектов в LinkedHashMap
//        routestorage.add(new Route(commands.createId(routestorage.getCollection()), "first", new Coordinates(10, 10),
//                new Location1(15, 15.0F, "Moscow"), new Location2(5, 1.0, 0.0, "SP"), 15.0F));
//        routestorage.add(new Route(commands.createId(routestorage.getCollection()), "second", new Coordinates(70, 19),
//                new Location1(34, 11.0F, "Praga"), new Location2(56, 23.0, 6.0, "Stavropol"), 546.0F));
// ---------------------------------------------------- Работа с командной строкой
        CommandExecutor executor = new CommandExecutor();
        CommandContext commandContext = new CommandContext();
        CommandModifier commandModifier = new CommandModifier(commandContext,executor);

        executor.registerCommand("info_objects", new InfoObjectsCommand());
        executor.registerCommand("help", new HelpCommand());
        executor.registerCommand("exit", new ExitCommand());
        executor.registerCommand("info", new InfoCommand(routestorage));
        executor.registerCommand("show", new ShowCommand(routestorage));
        executor.registerCommand("filter_by_distance", new FilterByDistanceCommand(routestorage, commandContext));
        executor.registerCommand("filter_starts_with_name", new FilterStartsWithNameCommand(routestorage, commandContext));
        executor.registerCommand("count_greater_than_distance", new CountGreaterThanDistanceCommand(routestorage, commandContext));
        executor.registerCommand("insert", new InsertCommand(routestorage, commands));
        executor.registerCommand("save", new SaveCommand(routestorage));
        executor.registerCommand("update_id", new UpdateIdCommand(routestorage, commands, commandContext));
        executor.registerCommand("clear", new ClearCommand(routestorage));
        executor.registerCommand("remove_key", new RemoveKeyCommand(routestorage, commandContext));
        executor.registerCommand("remove_greater", new RemoveGreaterCommand(routestorage, commands, commandContext));
        executor.registerCommand("remove_lower", new RemoveLowerCommand(routestorage, commands, commandContext));
        executor.registerCommand("remove_lower_key", new RemoveLowerKeyCommand(routestorage, commandContext));
        executor.registerCommand("execute_script", new ExecuteScriptCommand(routestorage, commandContext, executor, commandModifier, commands));

        fileParser.parse();


        while (true) {
            System.out.print("Введите Комманду (Сводка по командам help): ");
            String command = scanner.nextLine();
            commandModifier.analysis(command);
        }
    }
}

