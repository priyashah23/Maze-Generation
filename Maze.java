package MazeGenerator;

import java.awt.*;
import java.util.Random;
import java.util.Stack;
import java.util.ArrayList;

public class Maze {
    private int height;
    private int width;
    private Cell[][] maze;

    //Lets create a random depth first search
    public Maze(int height, int width) {
        this.height = height;
        this.width = width;
        this.maze = generateMaze(height, width);
    }

    private Cell[][] generateMaze(int height, int width) {
        Stack<Cell> mazeStack = new Stack<Cell>();
        Random r = new Random();

        maze = createGrid(height, width);

        //Choose the initial Cell
        int initialX = r.nextInt(height);
        int initialY = r.nextInt(width);

        //Mark initial cell as visited
        maze[initialX][initialY].setHasVisited(true);
        //Push cell into the stack
        mazeStack.push(maze[initialX][initialY]);

        //2. While the stack is not empty
        while (!mazeStack.isEmpty()) {
            Random number = new Random();
            //Pop a cell and make it current
            Cell currentCell = mazeStack.pop();
            //If currentCell has any neighbours which have not been visited.
            //Perhaps a function called hasNeighbours();
            if (currentCell.hasNeighbours(maze, currentCell)) {
                mazeStack.push(currentCell); //Push current cell to the stack
                ArrayList<Cell> neighbours;
                neighbours = currentCell.CellNeighbours(maze, currentCell); //Returns an array of neighbours
                int choose = number.nextInt(neighbours.size());
                //2. Choose one of the unvisited neighbours
                Cell neighbour = neighbours.get(choose);

                // Remove the wall between current cell & chosen cell
                removeWall(currentCell, neighbour);

                //Mark the chosen cell as visited
                neighbour.setHasVisited(true);
                mazeStack.push(neighbour);
            }

        }
        return maze;


    }

    private Cell[][] createGrid(int height, int width) {
        Cell[][] maze = new Cell[height][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                maze[i][j] = new Cell(i, j);
            }
        }
        return maze;
    }

    public Cell[][] getMaze() {
        return maze;
    }

    public void removeWall(Cell current, Cell neighbour) {
        if (current.getI() == neighbour.getI()) { //Checks whether their x positions are the same
            if (current.getJ() > neighbour.getJ()) {
                current.getWalls().put("UP", false);
                neighbour.getWalls().put("DOWN", false);
            } else if (current.getJ() < neighbour.getJ()) {
                current.getWalls().put("DOWN", false);
                neighbour.getWalls().put("UP", false);
            }
        } else {
            if (current.getI() > neighbour.getI()) {
                current.getWalls().put("LEFT", false);
                neighbour.getWalls().put("RIGHT", false);
            } else if (current.getI() < neighbour.getI()){
                current.getWalls().put("RIGHT", false);
                neighbour.getWalls().put("LEFT", false);
            }
        }

    }





}