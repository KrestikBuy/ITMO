package classes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import elements.Coordinates;
import elements.Location1;
import elements.Location2;
import elements.Route;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
/**
 * Класс отвечающий за чтения данных из файла и ввода их в коллекцию.
 */
public class FileParser {
    /**
     * Класс, хранящий коллекцию.
     */
    private Routestorage routestorage;
    /**
     * Путь к файлу.
     */
    private String fileName;
    public FileParser(Routestorage routestorage, String fileName) {
        this.routestorage = routestorage;
        this.fileName = fileName;
    }
    /**
     * Читает данные с файла в формате json и записывает их в коллекцию.
     */
    public void parse() {
        String json = null;
        try {
            json = new String(Files.readAllBytes(Path.of(fileName)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();
        java.lang.reflect.Type mapType = new com.google.gson.reflect.TypeToken<LinkedHashMap<Integer, Route>>(){}.getType();
        LinkedHashMap<Integer, Route> routesMap = gson.fromJson(json, mapType);

        routestorage.setCollection(routesMap);
    }
}