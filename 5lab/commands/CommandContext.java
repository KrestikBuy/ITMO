package commands;

public class CommandContext {
    private int id;
    private String name;
    private Float distance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}