import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public int BoardSIZE = 800;//rozmiar planszy

    Board board;

    public MyFrame() {
        JPanel menu = new JPanel();
        menu.setPreferredSize(new Dimension(500, 0));

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(BoardSIZE, BoardSIZE));
        layeredPane.setLayout(null);

        board = new Board(8, 8, 100);
        board.setBounds(0, 0, BoardSIZE, BoardSIZE);
        layeredPane.add(board, new Integer(0));

        BoardArray.boardarr = new int[8][8];

        int numRows = 8;
        int numCols = 8;

        /*ustawia pionki na poczatku gry*/
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if ((i + j) % 2 == 1 && j < 3) { // create and add red pieces
                    Piece piece = new Piece(i * Board.SQUARE_SIZE, j * Board.SQUARE_SIZE, board, Color.RED, this);
                    layeredPane.add(piece, new Integer(2));
                    BoardArray.boardarr[i][j] = 1;
                } else if ((i + j) % 2 == 1 && j > 4) { // create and add blue pieces
                    Piece piece = new Piece(i * Board.SQUARE_SIZE, j * Board.SQUARE_SIZE, board, Color.BLACK, this);
                    layeredPane.add(piece, new Integer(2));
                    BoardArray.boardarr[i][j] = 2;
                }
            }
        }



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(layeredPane, BorderLayout.CENTER);
        this.add(menu, BorderLayout.SOUTH);
        this.setSize(BoardSIZE, BoardSIZE+40);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void makeKing(int kingx, int kingy, Color color){
        JLayeredPane layeredPane = (JLayeredPane) this.getContentPane().getComponent(0);
        KingPiece kingPiece = new KingPiece(kingx * Board.SQUARE_SIZE, kingy * Board.SQUARE_SIZE, board, color, this);
        layeredPane.add(kingPiece, new Integer(2));
    }

    public void deletePieceAt() {
        JLayeredPane layeredPane = (JLayeredPane) this.getContentPane().getComponent(0);

        for (Component comp : layeredPane.getComponentsInLayer(2)) {
            if (comp instanceof Piece) {
                Piece piece = (Piece) comp;
                int i = piece.getX() / Board.SQUARE_SIZE;
                int j = piece.getY() / Board.SQUARE_SIZE;
                if (BoardArray.boardarr[i][j] == 0) {
                    layeredPane.remove(piece);
                }
            }
        }

        layeredPane.repaint();
    }

}
