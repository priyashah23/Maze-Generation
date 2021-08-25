
package MazeGenerator;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    int size; //Sets the sides of each cell.

    public Panel(){
        this.setPreferredSize(new Dimension(500, 500));
    }

    public void paint(Graphics g){
        size = 40;
        Graphics2D g2D = (Graphics2D) g;

        Maze m  = new Maze(10, 10);
        Cell[][] grid  = m.getMaze();

        // Create a grid...
        for (int i = 0; i < 10; i ++){
            for (int j = 0; j < 10; j ++){
                g2D.setStroke(new BasicStroke(2));

                int x =  i * size;
                int y = j * size;

                if (grid[i][j].getWalls().get("RIGHT")){
                    g2D.drawLine(x + size, y, x + size, y + size); // right
                }

                if (grid[i][j].getWalls().get("UP")){
                    g2D.drawLine(x, y, x + size, y); //top
                }

                if (grid[i][j].getWalls().get("LEFT")){
                    g2D.drawLine(x, y + size, x, y); //left
                }

                if (grid[i][j].getWalls().get("DOWN")){
                    g2D.drawLine(x + size, y + size, x, y + size); //down

                }

            }
        }

    }
}
