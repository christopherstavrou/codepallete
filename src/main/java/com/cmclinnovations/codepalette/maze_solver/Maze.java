package com.cmclinnovations.codepalette.maze_solver;

import java.util.Arrays;

public class Maze implements Cloneable {
    private final String name;

    private int[][] maze;

    private final Location start, finish;


    public Maze(String name, int height, int width, Location start, Location finish) {
        this.name = name;
        this.start = start;
        this.finish = finish;
        this.maze = new int[height][width];
    }

    public void fillLocation(Location location, int value) {
        try {
            maze[location.getX()][location.getY()] = value;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public int[][] getMaze() {
        return maze;
    }

    public void setMaze(int[][] maze) {
        this.maze = maze;
    }

    public Location getStart() {
        return start;
    }

    public Location getFinish() {
        return finish;
    }

    /**
     * Check if the location is a wall, a movement cannot be made if a wall is blocking the path
     *
     * @param location a location on the map
     * @return false if a wall is blocking the path
     */
    public boolean isTraversable(Location location) {
        boolean isTraversable = false;
        try {
            if (location.getX() < maze.length) {
                if (location.getY() < maze[location.getX()].length) {
                    isTraversable = maze[location.getX()][location.getY()] != 1;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return isTraversable;
    }

    @Override
    protected Object clone() {
        Maze clone;
        try {
            clone = (Maze) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }

        clone = new Maze(name, maze.length, maze[0].length,
                new Location(start.getX(), start.getY()),
                new Location(finish.getX(), finish.getY()));
        clone.setMaze(maze.clone());
        return clone;
    }

    @Override
    public String toString() {
        int pathLength = 0;
        String map = "";
        for (int x = 0; x < maze.length; x++) {
            for (int y = 0; y < maze[x].length; y++) {
                int value = maze[x][y];
                if (value == 2) {
                    pathLength++;
                }
                map += value + " ";
            }
            map += "\n";
        }
        return (pathLength > 0 ? "Path length: " + pathLength + "\n": "") + map;
    }


    public enum State{
        HAS_MOVES,
        HAS_NO_MOVES_LEFT,
        FINISHED;
    }
}
