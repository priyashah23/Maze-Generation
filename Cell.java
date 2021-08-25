package MazeGenerator;

import java.util.ArrayList;
import java.util.HashMap;

public class Cell {
    private int i, j; //tells us the cells location
    private HashMap<String, Boolean> walls = new HashMap<>();
    private boolean hasVisited;

    public Cell(){
        this.hasVisited = hasVisited;
    }

    public Cell(int i, int j){
        this.i = i;
        this.j = j;
        this.walls.put("LEFT", true);
        this.walls.put("RIGHT", true);
        this.walls.put("UP", true);
        this.walls.put("DOWN", true);

        this.hasVisited = false;
    }

    public boolean isHasVisited() {
        return hasVisited;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public HashMap<String, Boolean> getWalls() {
        return walls;
    }

    public void setHasVisited(boolean hasVisited) {
        this.hasVisited = hasVisited;
    }

    public boolean hasNeighbours(Cell[][] maze, Cell c){

        for (int i = -1; i <= 1; i++){
            for (int j = -1; j <=  1; j++){
                //If it is out of bounds continue
                if (checkBounds(maze, c, i, j)) continue;

                //Returns true if c has at least one visited neighbour
                if (!maze[c.getI() + i][c.getJ() + j].hasVisited){
                    return true;
                }

            }
        }
        return false;
    }

    public ArrayList<Cell> CellNeighbours(Cell[][] maze, Cell c){
        ArrayList<Cell> neighbours = new ArrayList<>();
        for (int i = -1; i <= 1; i++){
            for (int j = -1; j <=  1; j++){
                //If it is out of bounds continue
                if (checkBounds(maze, c, i, j)) continue;

                //Adds to the list of potential neighbours
                if (!maze[c.getI() + i][c.getJ() + j].hasVisited){
                    neighbours.add(maze[c.getI() + i][c.getJ() + j]);
                }

            }
        }
        return neighbours;
    }

    private boolean checkBounds(Cell[][] maze, Cell c, int i, int j) {
        if (c.getI() + i < 0 || c.getI() + i >= maze.length){
            return true;
        }

        if(c.getJ() + j < 0 || c.getJ() + j >= maze.length){
            return true;
        }

        if (i == -1 && j == -1){
            return true;
        }

        if (i == -1 && j == 1){
            return true;
        }

        if (i == 0 && j == 0){
            return true;
        }

        if (i == 1 && j == -1){
            return true;
        }

        if (i == 1 && j == 1){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "i=" + i +
                ", j=" + j +
                ", walls=" + walls +
                ", hasVisited=" + hasVisited +
                '}';
    }
}
