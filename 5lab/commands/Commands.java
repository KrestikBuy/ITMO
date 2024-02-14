package commands;

import elements.Coordinates;
import elements.Location1;
import elements.Location2;
import elements.Route;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Commands {
    Scanner scanner = new Scanner(System.in);
    public int createId(LinkedHashMap map) {
        int id = (int) (Math.random() * 10000);
        if (map.containsKey(id)) {
            while (map.containsKey(id)) {
                if (map.containsKey(id)) id = (int) (Math.random() * 10000);
                else return id;
            }
        }
        return id;
    }
    public Route insertWithKey() {
// ----------------------------------------------------
        int key;
        String name1;
        Integer x1;
        int y1;
        float y2;
        int x2;
        String name2;
        int x3;
        double y3;
        double z3;
        String name3;
        float distance;
// ----------------------------------------------------
        while (true) {
            try {
                System.out.print("Введите key (число): ");
                key = Integer.parseInt(scanner.nextLine());
                break;
            }
            catch (Exception e){
                System.out.println("Неправильное значение key, повторите ввод.");
            }
        }
        while (true) {
            try {
                System.out.print("Введите name (name не может быть пустым): ");
                name1 = scanner.nextLine();
                if (name1.isEmpty()) name1 = null;
                else break;
            }
            catch (Exception e){
                System.out.println("Неправильное значение name, повторите ввод.");
            }
        }
        System.out.println("Введите coordinates");
        while (true) {
            try {
                System.out.print("Введите x (число, максимальное значение 550): ");
                x1 = Integer.parseInt(scanner.nextLine());
                if (x1 <= 550) break;
            }
            catch (Exception e){
                System.out.println("Неправильное значение x, повторите ввод.");
            }
        }
        while (true) {
            try {
                System.out.print("Введите y (число): ");
                y1 = Integer.parseInt(scanner.nextLine());
                break;
            }
            catch (Exception e){
                System.out.println("Неправильное значение y, повторите ввод.");
            }
        }
        System.out.println("Введите данные для from");
        while (true) {
            try {
                System.out.print("Введите x для from (число): ");
                x2 = Integer.parseInt(scanner.nextLine());
                break;
            }
            catch (Exception e){
                System.out.println("Неправильное значение x, повторите ввод.");
            }
        }
        while (true) {
            try {
                System.out.print("Введите y для from (число): ");
                y2 = Float.parseFloat(scanner.nextLine());
                break;
            }
            catch (Exception e){
                System.out.println("Неправильное значение x, повторите ввод.");
            }
        }
        while (true) {
            try {
                System.out.print("Введите name для from (name не может быть пустым): ");
                name2 = scanner.nextLine();
                if (name2.isEmpty()) name2 = null;
                else break;
            }
            catch (Exception e){
                System.out.println("Неправильное значение name, повторите ввод.");
            }
        }
        System.out.println("Введите данные для to");
        while (true) {
            try {
                System.out.print("Введите x для to (число): ");
                x3 = Integer.parseInt(scanner.nextLine());
                break;
            }
            catch (Exception e){
                System.out.println("Неправильное значение x, повторите ввод.");
            }
        }
        while (true) {
            try {
                System.out.print("Введите y для to (число): ");
                y3 = Double.parseDouble(scanner.nextLine());
                break;
            }
            catch (Exception e){
                System.out.println("Неправильное значение y, повторите ввод.");
            }
        }
        while (true) {
            try {
                System.out.print("Введите z для to (число): ");
                z3 = Double.parseDouble(scanner.nextLine());
                break;
            }
            catch (Exception e){
                System.out.println("Неправильное значение z, повторите ввод.");
            }
        }
        while (true) {
            try {
                System.out.print("Введите name для to (name не может быть пустым, длина не должна превышать 488): ");
                name3 = scanner.nextLine();
                if (name3.isEmpty() || name3.length() > 488) name3 = null;
                else break;
            }
            catch (Exception e){
                System.out.println("Неправильное значение name, повторите ввод.");
            }
        }
        while (true) {
            try {
                System.out.print("Введите distance (число, значение должно быть больше 1): ");
                distance = Float.parseFloat(scanner.nextLine());
                if (distance > 1) break;
            }
            catch (Exception e){
                System.out.println("Неправильное значение distance, повторите ввод.");
            }
        }
// ----------------------------------------------------
        Coordinates coordinates = new Coordinates(x1, y1);
        Location1 location1 = new Location1(x2, y2, name2);
        Location2 location2 = new Location2(x3, y3, z3, name3);
        Route route = new Route(key, name1, coordinates, location1, location2, distance);
// ----------------------------------------------------
        if (coordinates.validate() & location1.validate() & location2.validate() & route.validate()) {
            return route;
        }
        return null;
    }

    public Route insertWithOutKey(int key) {
// ----------------------------------------------------
        String name1;
        Integer x1;
        int y1;
        float y2;
        int x2;
        String name2;
        int x3;
        double y3;
        double z3;
        String name3;
        float distance;
// ----------------------------------------------------
        while (true) {
            try {
                System.out.print("Введите name (name не может быть пустым): ");
                name1 = scanner.nextLine();
                if (name1.isEmpty()) name1 = null;
                else break;
            }
            catch (Exception e){
                System.out.println("Неправильное значение name, повторите ввод.");
            }
        }
        System.out.println("Введите coordinates");
        while (true) {
            try {
                System.out.print("Введите x (число, максимальное значение 550): ");
                x1 = Integer.parseInt(scanner.nextLine());
                if (x1 <= 550) break;
            }
            catch (Exception e){
                System.out.println("Неправильное значение x, повторите ввод.");
            }
        }
        while (true) {
            try {
                System.out.print("Введите y (число): ");
                y1 = Integer.parseInt(scanner.nextLine());
                break;
            }
            catch (Exception e){
                System.out.println("Неправильное значение y, повторите ввод.");
            }
        }
        System.out.println("Введите данные для from");
        while (true) {
            try {
                System.out.print("Введите x для from (число): ");
                x2 = Integer.parseInt(scanner.nextLine());
                break;
            }
            catch (Exception e){
                System.out.println("Неправильное значение x, повторите ввод.");
            }
        }
        while (true) {
            try {
                System.out.print("Введите y для from (число): ");
                y2 = Float.parseFloat(scanner.nextLine());
                break;
            }
            catch (Exception e){
                System.out.println("Неправильное значение x, повторите ввод.");
            }
        }
        while (true) {
            try {
                System.out.print("Введите name для from (name не может быть пустым): ");
                name2 = scanner.nextLine();
                if (name2.isEmpty()) name2 = null;
                else break;
            }
            catch (Exception e){
                System.out.println("Неправильное значение name, повторите ввод.");
            }
        }
        System.out.println("Введите данные для to");
        while (true) {
            try {
                System.out.print("Введите x для to (число): ");
                x3 = Integer.parseInt(scanner.nextLine());
                break;
            }
            catch (Exception e){
                System.out.println("Неправильное значение x, повторите ввод.");
            }
        }
        while (true) {
            try {
                System.out.print("Введите y для to (число): ");
                y3 = Double.parseDouble(scanner.nextLine());
                break;
            }
            catch (Exception e){
                System.out.println("Неправильное значение y, повторите ввод.");
            }
        }
        while (true) {
            try {
                System.out.print("Введите z для to (число): ");
                z3 = Double.parseDouble(scanner.nextLine());
                break;
            }
            catch (Exception e){
                System.out.println("Неправильное значение z, повторите ввод.");
            }
        }
        while (true) {
            try {
                System.out.print("Введите name для to (name не может быть пустым, длина не должна превышать 488): ");
                name3 = scanner.nextLine();
                if (name3.isEmpty() || name3.length() > 488) name3 = null;
                else break;
            }
            catch (Exception e){
                System.out.println("Неправильное значение name, повторите ввод.");
            }
        }
        while (true) {
            try {
                System.out.print("Введите distance (число, значение должно быть больше 1): ");
                distance = Float.parseFloat(scanner.nextLine());
                if (distance > 1) break;
            }
            catch (Exception e){
                System.out.println("Неправильное значение distance, повторите ввод.");
            }
        }
// ----------------------------------------------------
        Coordinates coordinates = new Coordinates(x1, y1);
        Location1 location1 = new Location1(x2, y2, name2);
        Location2 location2 = new Location2(x3, y3, z3, name3);
        Route route = new Route(key, name1, coordinates, location1, location2, distance);
// ----------------------------------------------------
        if (coordinates.validate() & location1.validate() & location2.validate() & route.validate()) {
            return route;
        }
        return null;
    }
}
