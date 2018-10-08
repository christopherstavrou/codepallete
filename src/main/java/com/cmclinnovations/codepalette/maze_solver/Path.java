package com.cmclinnovations.codepalette.maze_solver;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Path {


    /**
     * The current location, or last visited location on the current path
     */
    private final Location currentLocation;
    private final Maze maze;

    /**
     * A history of locations visited on the current path
     */
    private final Stack<Location> locationHistory = new Stack<>();

    public Path(Maze maze) {
        this.currentLocation = maze.getStart();
        this.maze = (Maze) maze.clone();
    }


    /**
     * Traverse the maze
     */
    public Maze.State step() {
        Maze.State state = Maze.State.HAS_MOVES;
        Object previousLocation = currentLocation.clone();

        if (Objects.equals(currentLocation, maze.getFinish())) {
            state = state.FINISHED;
            //TODO get the location history stack and apply the fill to the maze
            //maze.setLocationFill(maze.getFinish(), 4);
        }// else maze.setLocationFill(currentLocation, 2);


        final List<Location> choices = new ArrayList<>();

        if (canStep(up())) {
            choices.add(up());
        }
        if (canStep(down())) {
            choices.add(down());
        }
        if (canStep(left())) {
            choices.add(left());
        }
        if (canStep(right())) {
            choices.add(right());
        }

        if (choices.isEmpty()) {
            state = state.HAS_NO_MOVES_LEFT;
            //TODO try again from last decision point
        } else {
            for (Location choice : choices) {
                //setCurrentLocation(choice);
                //TODO the following
                //1. do the path with first choice
                //2. if it hits a dead end pop current location till its back to the previousLocation
                //3. attempt the next choice to follow a new path
                //4. break loop if state equals finished
            }
        }

        return state;
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

        if (!hasVisited(nextLocation)) {
            if (maze.isTraversable(nextLocation)) canTurn = true;
        }
        return canTurn;
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
    //</editor-fold>

    //<editor-fold desc="Movements">
    private final Location up() {
        return new Location(currentLocation.getX() + -1, currentLocation.getY());
    }

    private final Location down() {
        return new Location(currentLocation.getX() + 1, currentLocation.getY());
    }

    private final Location left() {
        return new Location(currentLocation.getX(), currentLocation.getY() - 1);
    }

    private final Location right() {
        return new Location(currentLocation.getX(), currentLocation.getY() + 1);
    }
    //</editor-fold>


    public Location getCurrentLocation() {
        return currentLocation;
    }

    public Maze getMaze() {
        return maze;
    }

    public Stack<Location> getLocationHistory() {
        return locationHistory;
    }


    private void setCurrentLocation(final Location nextLocation) {
        locationHistory.add((Location) nextLocation.clone());
        currentLocation.setLocation(nextLocation);
    }
}
