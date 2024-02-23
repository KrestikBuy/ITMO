package commands;

import interfaces.Command;
/**
 * Вызываемая команда для вывода допустимых значения для полей.
 */
public class InfoObjectsCommand implements Command {
    @Override
    public void execute() {
        System.out.println("id - Значение поля должно быть больше 0 \n" +
                "name - Строка не может быть пустой \n" +
                "Coordindates: x - Максимальное значение поля: 550, Не может быть пустым \n" +
                "Coordindates: y - Не может быть пустым \n" +
                "From: x - Не может быть пустым \n" +
                "From: y - Не может быть пустым \n" +
                "From: name - Строка не может быть пустой \n" +
                "To: x - Не может быть пустым \n" +
                "To: y - Не может быть пустым \n" +
                "To: z - Не может быть пустым \n" +
                "To: name - Строка не может быть пустой \n" +
                "distance - Не может быть пустым, Значение поля должно быть больше 1 \n");
    }
}
