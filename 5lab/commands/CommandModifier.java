package commands;

import classes.Routestorage;
import elements.Route;

import java.io.BufferedInputStream;
/**
 * Класс отвечающий за анализ введенной команды.
 */
public class CommandModifier{
    CommandContext commandContext;
    CommandExecutor executor;
    public CommandModifier(CommandContext commandContext, CommandExecutor executor){
        this.commandContext = commandContext;
        this.executor = executor;
    }
    /**
     * Метод анализирующий пользовательский ввод.
     */
    public void analysis(String command){
        if (command.startsWith("update_id") || command.startsWith("remove_key") || command.startsWith("remove_lower_key")) {
            try {
                int id = Integer.parseInt(command.substring(command.indexOf(' ') + 1).trim());
                commandContext.setId(id);
                command = command.substring(0, command.indexOf(' '));
                executor.executeCommand(command.trim());
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
                executor.executeCommand(command.trim());
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
                executor.executeCommand(command.trim());
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
