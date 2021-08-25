package MazeGenerator;
import javax.swing.*;

public class Canvas extends JFrame {
    public Canvas(){
        Panel panel = new Panel();
        this.setTitle("Maze Generator");
        this.setSize(500, 500);
        this.add(panel);
        this.pack();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);
    }

    public static void main(String[] args){
        new Canvas();
    }
}
