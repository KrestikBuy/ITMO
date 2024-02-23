package exceptions;
/**
 * Ошибка, которая возникает, когда введенное пользователем значение выходит за рамки допустимого.
 */
public class OutOfBoundsException extends Exception{
    @Override
    public String getMessage(){
        return "Число выходит за ограничения.";
    }
}
