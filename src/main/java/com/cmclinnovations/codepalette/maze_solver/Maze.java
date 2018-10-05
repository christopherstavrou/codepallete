package com.cmclinnovations.codepalette.maze_solver;

public class Maze {

    private final int[][] maze;

    private final Location start,finish;


    public Maze(int height, int width, Location start, Location finish) {
        this.start = start;
        this.finish = finish;
        this.maze = new int[height][width];
    }

    public int[][] getMaze() {
        return maze;
    }
}
