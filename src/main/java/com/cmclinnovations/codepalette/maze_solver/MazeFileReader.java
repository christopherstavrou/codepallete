package com.cmclinnovations.codepalette.maze_solver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class MazeFileReader {

    public static final Maze getMazeFromFile(File file){
        Maze maze = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int height = 0, width = 0;
            int startX = 0, startY = 0;
            int endX = 0, endY = 0;
            int linesRead = 0;
            for (String line; (line = br.readLine()) != null; ) {
                String[] lines = line.split(" ");
                if (linesRead <= 2 && lines.length == 2) {
                    if (linesRead == 0) {
                        height = Integer.parseInt(lines[0]);
                        width = Integer.parseInt(lines[0]);
                    } else if (linesRead == 1) {
                        startX = Integer.parseInt(lines[0]);
                        startY = Integer.parseInt(lines[0]);
                    } else if (linesRead == 2) {
                        endX = Integer.parseInt(lines[0]);
                        endY = Integer.parseInt(lines[0]);
                        maze = new Maze(height, width, new Location(startX, startY), new Location(endX, endY));
                    }
                } else {
                    int x = linesRead - 3;
                    for (int y = 0; y < lines.length && x < maze.getMaze().length; y++) {
                        maze.getMaze()[x][y] = Integer.parseInt(lines[y]);
                    }
                }
                linesRead++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maze;
    }

    public static final List<Maze> getMazesFromResources() {
        ArrayList<Maze> mazes = new ArrayList<>();
        try {
            for (String resourceFile : getResourceFiles()) {
                String path = MazeFileReader.class.getResource("/mazes/" + resourceFile).getFile();
                mazes.add(getMazeFromFile(new File(path)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mazes;
    }


    public static void main(String[] args) {
        getMazesFromResources();
    }


    private static final List<String> getResourceFiles() throws IOException {
        List<String> filenames = new ArrayList<>();

        try (InputStream in = getResourceAsStream("mazes");
             BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String resource;

            while ((resource = br.readLine()) != null) {
                filenames.add(resource);
            }
        }

        return filenames;
    }

    private static final InputStream getResourceAsStream(String resource) {
        final InputStream in
                = getContextClassLoader().getResourceAsStream(resource);

        return in == null ? MazeFileReader.getResourceAsStream(resource) : in;
    }

    private static final ClassLoader getContextClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

}
