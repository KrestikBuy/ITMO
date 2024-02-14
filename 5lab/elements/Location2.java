package elements;

import interfaces.Validdatable;

public class Location2 implements Validdatable {
    private int x;
    private Double y;
    private Double z; //Поле не может быть null
    private String name; //Длина строки не должна быть больше 488, Поле не может быть null

    public Location2(int x, Double y, Double z, String name){
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Location2{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean validate() {
        if (z == null) return false;
        if (name == null || name.length() > 488) return false;
        return true;
    }
}
