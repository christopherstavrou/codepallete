package com.cmclinnovations.codepalette.maze_solver;

import java.util.Objects;
import java.util.Stack;

public class Location implements Cloneable {

    /**
     * A history of locations visited on the current path
     */
    private final Stack<Location> locationHistory = new Stack<>();


    //current location
    private int x ,y;

    public Location(final int x,final int y) {
        this.x = x;
        this.y = y;
    }


    public void setLocation(final Location location){
        locationHistory.add(new Location(this.x,this.y));
        this.x = location.getX();
        this.y = location.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Check if a location has been visited before in the paths history of locations
     *
     * @param nextLocation
     * @return true if the location is present in the paths history
     */
    public boolean hasVisited(final Location nextLocation) {
        boolean hasBeenVisited = false;
        if (locationHistory.contains(nextLocation)) {
            hasBeenVisited = true;
        }
        return hasBeenVisited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return x == location.x &&
                y == location.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    protected Object clone() {
        Location clone;
        try {
            clone = (Location) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }

        clone = new Location(getX(),getY());
        return clone;
    }
}
