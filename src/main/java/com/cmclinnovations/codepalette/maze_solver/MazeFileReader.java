package com.cmclinnovations.codepalette.maze_solver;

import java.io.*;


public class MazeFileReader {

    public static final Maze getMaze(File file) {

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                // process the line.
            }
            // line is not visible here.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Maze maze = new Maze(0, 0, new Location(0, 0), new Location(0, 0));
        return maze;
    }


}
