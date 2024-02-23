package commands;

import classes.Routestorage;
import elements.Coordinates;
import elements.Location1;
import elements.Location2;
import elements.Route;
import interfaces.Command;

import java.io.*;
/**
 * Вызываемая команда для запуска и чтения скрипта.
 */
public class ExecuteScriptCommand implements Command {
    private Routestorage routestorage;
    private CommandContext commandContext;
    private CommandExecutor executor;
    private CommandModifier commandModifier;
    private Commands commands;

    public ExecuteScriptCommand(Routestorage routestorage, CommandContext commandContext, CommandExecutor executor, CommandModifier commandModifier, Commands commands) {
        this.commandContext = commandContext;
        this.routestorage = routestorage;
        this.executor = executor;
        this.commandModifier = commandModifier;
        this.commands = commands;
    }

    @Override
    public void execute() {
        String filePath = commandContext.getName();
        int i = 0;
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            StringBuilder currentLine = new StringBuilder();

            boolean insert = false;
            int c;
            String command = "";
            while ((c = bufferedInputStream.read()) != -1) {
                if (c == '\r') {
                    String line = currentLine.toString().replace((char) 65279, ' ');
                    currentLine.setLength(0);
                    if (line.startsWith("execute_script")) {
                        System.out.println("В скрипте найдена рекурсия, удалите команду execute_script.");
                        break;
                    } else if (line.startsWith("insert") || line.startsWith("update_id") || line.equals("remove_greater") || line.equals("remove_lower")) {
                        Route route = commands.readFile(routestorage, fileInputStream, bufferedInputStream, currentLine, line.startsWith("update_id") ? true : false, line);
                        if (route == null) {
                            System.out.println("Объект создать не удалось из-за неправильно введенных данных. Чтобы узнать какие допустимые значения - введите команду info_objects. \n" +
                                    "Перезапишите данные в Script и заново запустите его.");
                            commandModifier.analysis("exit");
                        } else {
                            if (line.equals("insert")) {
                                routestorage.addobject(route);
                            } else if (line.equals("remove_greater")) {
                                commandContext.setFlagRemove(true);
                                commandContext.setRoute(route);
                                commandModifier.analysis(line);
                                commandContext.setFlagRemove(false);
                            } else if (line.equals("remove_lower")) {
                                commandContext.setFlagRemove(true);
                                commandContext.setRoute(route);
                                commandModifier.analysis(line);
                                commandContext.setFlagRemove(false);
                            } else if (line.startsWith("update_id")) {
                                commandContext.setFlagRemove(true);
                                commandContext.setRoute(route);
                                commandModifier.analysis(line);
                                commandContext.setFlagRemove(false);
                            }
                        }
                    }
                    else commandModifier.analysis(line);
                }
                else {
                    currentLine.append((char) c);
                }
            }
            bufferedInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Данный файл не найден!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
