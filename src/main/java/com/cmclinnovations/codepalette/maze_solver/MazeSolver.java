package com.cmclinnovations.codepalette.maze_solver;

import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class MazeSolver {

    public static void main(String[] args) {
        List<Maze> mazes = MazeFileReader.getMazesFromResources();
        for (Maze maze : mazes) {

            Path path = new Path(maze);
            Maze.State state = Maze.State.HAS_MOVES;
            while (state == state.HAS_MOVES) {
                state = path.step();
            }
            System.out.println(mazePathToString(maze,path));
        }
    }

    /**
     * Adds the path to the maze and gets the string representation of the maze
     *
     * @param maze
     * @param path
     * @return
     */
    private static final String mazePathToString(Maze maze, Path path) {
        Stack<Location> locationHistory = path.getLocationHistory();

        // Add path to maze
        for (Location location : locationHistory) {

            if (maze.getLocationFill(location) == 0)
                //Set start
                if (Objects.equals(location, maze.getStart())) path.getMaze().setLocationFill(location, 3);
                    //Set Finish
                else if (Objects.equals(location, maze.getFinish())) path.getMaze().setLocationFill(location, 4);
                    //Set Path
                else path.getMaze().setLocationFill(location, 2);
        }
        //Print Path
        return path.getMaze().toString();
    }

}
