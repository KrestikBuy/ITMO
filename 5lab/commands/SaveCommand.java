package commands;

import classes.Routestorage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import elements.Route;
import interfaces.Command;

import java.io.*;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;

/**
 * Вызываемая команда для сохранения коллекции в файл.
 */
public class SaveCommand implements Command {
    Routestorage routestorage;
    public SaveCommand(Routestorage routestorage){
        this.routestorage = routestorage;
    }

    @Override
    public void execute() {
        String fileName = "file.json";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type type = new TypeToken<LinkedHashMap<Integer, Route>>(){}.getType();
        String json = gson.toJson(routestorage.getCollection(), type);
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
