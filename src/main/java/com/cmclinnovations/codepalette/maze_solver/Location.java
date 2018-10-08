package com.cmclinnovations.codepalette.maze_solver;

import java.util.Objects;
import java.util.Stack;

public class Location implements Cloneable {




    //current location
    private int x ,y;

    public Location(final int x,final int y) {
        this.x = x;
        this.y = y;
    }


    public void setLocation(final Location location){
        this.x = location.getX();
        this.y = location.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
