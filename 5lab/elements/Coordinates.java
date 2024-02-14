package elements;

import interfaces.Validdatable;

public class Coordinates implements Validdatable {
    private Integer x; //Максимальное значение поля: 550, Поле не может быть null
    private int y;

    public Coordinates(Integer x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "("+ x + ";" + y + ")";
    }

    @Override
    public boolean validate() {
        if (x > 550) return false;
        return true;
    }
}