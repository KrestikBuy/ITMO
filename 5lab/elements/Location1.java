package elements;

import interfaces.Validdatable;

public class Location1 implements Validdatable {
    private int x;
    private Float y; //Поле не может быть null
    private String name; //Строка не может быть пустой, Поле не может быть null



    public Location1(int x, Float y, String name){
        this.x = x;
        this.y = y;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Location1{" +
                "x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean validate() {
        if (y == null) return false;
        if (name == null || name.isEmpty()) return false;
        return true;
    }
}