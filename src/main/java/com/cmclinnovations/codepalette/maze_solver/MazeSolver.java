package com.cmclinnovations.codepalette.maze_solver;

import java.util.List;

public class MazeSolver {

    public static void main(String[] args) {
        List<Maze> mazes = MazeFileReader.getMazesFromResources();
        for (Maze maze : mazes) {

            Path path = new Path(maze);
            Maze.State state = Maze.State.HAS_MOVES;
            while (state == state.HAS_MOVES) {
                state = path.step();

            }
            System.out.println(maze.toString());
        }
    }

}
