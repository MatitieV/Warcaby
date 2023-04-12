import javax.swing.*;
import java.awt.*;

public class Board extends JLabel{
    //private static final int BOARD_SIZE = 4;
    public static int SQUARE_SIZE = 100;
    public static int numRows;
    public static int numCols;

    public Board(int numRows, int numCols, int SQUARE_SIZE) {
        this.setPreferredSize(new Dimension(400, 400));
        this.setOpaque(true);
        this.setBounds(0,0,numCols*SQUARE_SIZE,numRows*SQUARE_SIZE);
        this.numRows = numRows;
        this.numCols = numCols;
        this.SQUARE_SIZE = SQUARE_SIZE;

    }





    public void paintComponent(Graphics g) {

        setBackground(Color.GREEN);
        setForeground(Color.GRAY);
        //g.fillRect(40,40,40,40);
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if ((row + col) % 2 != 0) {
                    g.fillRect(col * SQUARE_SIZE, row * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                }
            }
        }
        //System.out.println("Printing...");
    }







}


