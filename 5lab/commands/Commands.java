package commands;

import classes.Routestorage;
import elements.Coordinates;
import elements.Location1;
import elements.Location2;
import elements.Route;
import exceptions.OutOfBoundsException;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
/**
 * Класс хранящий вспомогательные команды.
 */
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
    /**
     * Ввод элемента.
     */
    public Route insertWithKey(Boolean flag, int key1) {
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
        if (flag) {
            while (true) {
                try {
                    System.out.print("Введите key (число): ");
                    key = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Неправильное значение key, повторите ввод.");
                }
            }
        } else key = key1;
        while (true) {
            try {
                System.out.print("Введите name (name не может быть пустым): ");
                name1 = scanner.nextLine();
                if (name1.isEmpty()) name1 = null;
                else break;
            } catch (Exception e) {
                System.out.println("Неправильное значение name, повторите ввод.");
            }
        }
        System.out.println("Введите coordinates");
        while (true) {
            try {
                System.out.print("Введите x (число, максимальное значение 550): ");
                x1 = Integer.parseInt(scanner.nextLine());
                if (x1 > 550) throw new OutOfBoundsException();
                else break;
            } catch (OutOfBoundsException e) {
                System.out.println(e.getMessage() + " (максимальное значение 550) Введите еще раз.");
            } catch (Exception e) {
                System.out.println("Неправильный формат числа.");
            }
        }
        while (true) {
            try {
                System.out.print("Введите y (число): ");
                y1 = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Неправильное значение y, повторите ввод.");
            }
        }
        System.out.println("Введите данные для from");
        while (true) {
            try {
                System.out.print("Введите x для from (число): ");
                x2 = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Неправильное значение x, повторите ввод.");
            }
        }
        while (true) {
            try {
                System.out.print("Введите y для from (число): ");
                y2 = Float.parseFloat(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Неправильное значение x, повторите ввод.");
            }
        }
        while (true) {
            try {
                System.out.print("Введите name для from (name не может быть пустым): ");
                name2 = scanner.nextLine();
                if (name2.isEmpty()) name2 = null;
                else break;
            } catch (Exception e) {
                System.out.println("Неправильное значение name, повторите ввод.");
            }
        }
        System.out.println("Введите данные для to");
        while (true) {
            try {
                System.out.print("Введите x для to (число): ");
                x3 = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Неправильное значение x, повторите ввод.");
            }
        }
        while (true) {
            try {
                System.out.print("Введите y для to (число): ");
                y3 = Double.parseDouble(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Неправильное значение y, повторите ввод.");
            }
        }
        while (true) {
            try {
                System.out.print("Введите z для to (число): ");
                z3 = Double.parseDouble(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Неправильное значение z, повторите ввод.");
            }
        }
        while (true) {
            try {
                System.out.print("Введите name для to (name не может быть пустым, длина не должна превышать 488): ");
                name3 = scanner.nextLine();
                if (name3.isEmpty() || name3.length() > 488) name3 = null;
                else break;
            } catch (Exception e) {
                System.out.println("Неправильное значение name, повторите ввод.");
            }
        }
        while (true) {
            try {
                System.out.print("Введите distance: ");
                distance = Float.parseFloat(scanner.nextLine());
                if (distance < 1) throw new OutOfBoundsException();
                else break;
            } catch (OutOfBoundsException e) {
                System.out.println(e.getMessage() + " (значение должно быть больше 1) Введите еще раз.");
            } catch (Exception e) {
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
    /**
     * Ввод элемента со скрипта.
     */
    public Route readFile(Routestorage routestorage, FileInputStream fileInputStream, BufferedInputStream bufferedInputStream, StringBuilder currentLine, boolean flag, String line) {
        try {
            int key = 0;
            String name1 = null;
            Integer x1 = 551;
            int y1 = 123;
            float y2 = 123;
            int x2 = 123;
            String name2 = null;
            int x3 = 123;
            double y3 = 123;
            double z3 = 123;
            String name3 = null;
            float distance = 123;
            int i;
            if (flag){
                i = 1;
                key = Integer.parseInt(line.substring(line.indexOf(' ') + 1).trim());
            } else i = 0;
            int c;

            while ((c = bufferedInputStream.read()) != -1) {
                if (c == '\r') {
                    String command = currentLine.toString().replace((char) 65279, ' ');
                    currentLine.setLength(0);
                    if (i == 0) {
                        key = Integer.parseInt(command);
                        i++;
                    } else if (i == 1) {
                        name1 = command;
                        i++;
                    } else if (i == 2) {
                        x1 = Integer.parseInt(command);
                        i++;
                    } else if (i == 3) {
                        y1 = Integer.parseInt(command);
                        i++;
                    } else if (i == 4) {
                        y2 = Float.parseFloat(command);
                        i++;
                    } else if (i == 5) {
                        x2 = Integer.parseInt(command);
                        i++;
                    } else if (i == 6) {
                        name2 = command;
                        i++;
                    } else if (i == 7) {
                        x3 = Integer.parseInt(command);
                        i++;
                    } else if (i == 8) {
                        y3 = Double.parseDouble(command);
                        i++;
                    } else if (i == 9) {
                        z3 = Double.parseDouble(command);
                        i++;
                    } else if (i == 10) {
                        name3 = command;
                        i++;
                    } else if (i == 11) {
                        distance = Float.parseFloat(command);
                        Coordinates coordinates = new Coordinates(x1, y1);
                        Location1 location1 = new Location1(x2, y2, name2);
                        Location2 location2 = new Location2(x3, y3, z3, name3);
                        Route route = new Route(key, name1, coordinates, location1, location2, distance);
                        if (coordinates.validate() & location1.validate() & location2.validate() & route.validate()) {
                            return route;
                        }
                    }
                } else {
                    currentLine.append((char) c);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Данный файл не найден!");
        } catch (NumberFormatException e) {
            System.out.println("Неверно введенный формат для численных переменных!");
        } catch (IOException e) {
            System.out.println("Значения в файл введены неверно!");
        }
        return null;
    }
}
