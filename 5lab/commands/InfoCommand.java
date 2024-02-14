package commands;

import classes.Routestorage;
import interfaces.Command;

public class InfoCommand implements Command {

    Routestorage routestorage;
    public InfoCommand(Routestorage routestorage) {
        this.routestorage = routestorage;
    }

    public void execute() {
            System.out.println("Информация по данной коллекции: " + "\n"
                    + "Тип коллекции: " + routestorage.getType() + "\n"
                    + "Дата инициализации: " + routestorage.getDate() + "\n"
                    + "Количество элементов: " + routestorage.getLength() + "\n"
                    + "Тип хранимых объектов: " + routestorage.getContainType() + "\n");
    }

}
