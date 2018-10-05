package com.cmclinnovations.codepalette.maze_solver;

public class Path {


    /**
     * The current location, or last visited location on the current path
     */
    private final Location currentLocation = new Location(0, 0);

    /**
     *
     */
    public void step() {
        if (canStep(up())) {
            step(up());
        } else if (canStep(down())) {
            step(down());
        } else if (canStep(left())) {
            step(left());
        } else if (canStep(right())) {
            step(right());
        }
    }

    private void step(final Location location) {
        currentLocation.setLocation(location);
    }

    //<editor-fold desc="Checks">

    /**
     * Check if the location is a wall, a movement cannot be made if a wall is blocking the path
     *
     * @return false if a wall is blocking the path
     */
    private boolean isWall() { //TODO
        return false;
    }


    /**
     * Check if a movement can be made from one location to another
     *
     * @param location one of the predefined movements
     *                 {@link Path#up()}, {@link Path#down()}, {@link Path#left()}, {@link Path#right()}
     * @return true if a movement can be made to the specified location, otherwise false
     */
    private boolean canStep(final Location location) {
        boolean canTurn = false;
        Location nextLocation = location;
        if (!currentLocation.hasVisited(nextLocation)) {
            if (!isWall()) canTurn = true;
        }
        return canTurn;
    }
    //</editor-fold>

    //<editor-fold desc="Movements">
    private final Location up() {
        return new Location(currentLocation.getX() + -1, currentLocation.getY());
    }

    private final Location down() {
        return new Location(currentLocation.getX() + 1, currentLocation.getY());
    }

    private final Location left() {
        return new Location(currentLocation.getX() + 1, currentLocation.getY());
    }

    private final Location right() {
        return new Location(currentLocation.getX() + 1, currentLocation.getY());
    }
    //</editor-fold>

}
