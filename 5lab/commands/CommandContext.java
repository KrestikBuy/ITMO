package commands;

import elements.Route;
/**
 * Класс для передачи между командами флагов, переменных, которые нужны для правильной работы.
 */
public class CommandContext {
    private int id;
    private String name;
    private Float distance;
    private Boolean flagRemove = false;
    private Route route = null;
    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
    public Boolean getFlagRemove() {
        return flagRemove;
    }

    public void setFlagRemove(Boolean flagRemove) {
        this.flagRemove = flagRemove;
    }
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