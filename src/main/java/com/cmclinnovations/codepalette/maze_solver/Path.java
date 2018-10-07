package com.cmclinnovations.codepalette.maze_solver;

import java.util.Objects;

public class Path {


    /**
     * The current location, or last visited location on the current path
     */
    private final Location currentLocation;
    private final Maze maze;

    public Path(Maze maze) {
        this.currentLocation = maze.getStart();
        this.maze = (Maze) maze.clone();
    }


    /**
     *
     *
     */
    public Maze.State step() {
        Maze.State state = Maze.State.HAS_MOVES;
        Location oldLocation = (Location) currentLocation.clone();
        if (canStep(up())) {
            step(up());
        } else if (canStep(down())) {
            step(down());
        } else if (canStep(left())) {
            step(left());
        } else if (canStep(right())) {
            step(right());
        }

        if (Objects.equals(currentLocation, maze.getFinish())) {
            state = state.FINISHED;
        } else if (Objects.equals(oldLocation, currentLocation)) {
            state = state.HAS_NO_MOVES_LEFT;
        }
        return state;
    }

    private void step(final Location nextLocation) {
        currentLocation.setLocation(nextLocation);
    }
    //<editor-fold desc="Checks">

    /**
     * Check if a movement can be made from one location to another
     *
     * @param location one of the predefined movements
     *                 {@link Path#up()}, {@link Path#down()}, {@link Path#left()}, {@link Path#right()}
     * @return true if a movement can be made to the specified location, otherwise false
     */
    public boolean canStep(final Location location) {
        boolean canTurn = false;
        Location nextLocation = location;

        if (!currentLocation.hasVisited(nextLocation)) {
            if (maze.isTraversable(nextLocation)) canTurn = true;
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
