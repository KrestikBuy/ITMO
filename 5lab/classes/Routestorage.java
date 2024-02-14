package classes;

import elements.Coordinates;
import elements.Location1;
import elements.Location2;
import elements.Route;

import java.util.*;
import java.util.stream.Collectors;

public class Routestorage {
    Scanner scanner = new Scanner(System.in);
    private Date date;
    private LinkedHashMap<Integer, Route> map;

    public Routestorage() {
        map = new LinkedHashMap<Integer, Route>();
        this.date = new Date();
    }

    public int getLength() {
        return map.size();
    }

    public Date getDate() {
        return date;
    }

    public void add(Route route) {
        if (route.validate()) map.put(route.getId(), route);
        else System.out.println("Некорректно введенные данные.");
    }

    public void removeobject(int key) {
        if (map.containsKey(key)) {
            System.out.println("Объект удален.");
            map.remove(key);
        } else System.out.println("ОШИБКА: Данного ключа не найдено!");
    }

    public void clear() {
        map.clear();
        System.out.println("Коллекция отчищена.");
    }

    public void remove_greater(Route route) {
        for (Map.Entry<Integer, Route> entry : map.entrySet()) {
            if (route.compareTo(entry.getValue()) > 0) {
                map.remove(entry.getKey());
            }
        }
    }
    public void remove_lower(Route route) {
        for (Map.Entry<Integer, Route> entry : map.entrySet()) {
            if (route.compareTo(entry.getValue()) < 0) {
                map.remove(entry.getKey());
            }
        }
    }

    public void remove_lower_key(int id) {
        Set<Integer> keysToRemove = new HashSet<>();
        for (Map.Entry<Integer, Route> entry : map.entrySet()) {
            if (entry.getKey() < id) {
                keysToRemove.add(entry.getKey());
            }
        }
        for (Integer key : keysToRemove) {
            map.remove(key);
        }
    }

    public void updateobject(Route route) {
        map.put(route.getId(), route);
        System.out.println("Объект Обновлен.");
    }

    public void addobject(Route route) {
        map.put(route.getId(), route);
        System.out.println("Объект создан.");
    }

    public String getContainType() {
        return Route.class.getSimpleName();
    }

    public String getType() {
        return "LinkedHashMap";
    }

    public LinkedHashMap getCollection() {
        return map;
    }

    public void sort() {
        LinkedHashMap<Integer, Route> sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        map = sortedMap;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Коллекция Routestorage хранит в себе: " + "\n");
        map.forEach((key, value) -> {
            sb.append("Ключ: ").append(key).append("\nЗначение: ").append(value).append("\n");
        });
        return sb.toString();
    }
}
