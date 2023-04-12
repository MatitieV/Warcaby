import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class Piece extends JLabel implements MouseListener, MouseMotionListener {
    private int x, y;


    public boolean isLegal = false, isJump = false, isKing = false;
    protected int OldX;
    protected int OldY;
    protected int ovalSize = 100; //TODO fieldy na prywatne
    protected static final int size = 50;
    protected boolean dragging = false;
    protected Board board;

    protected MyFrame frame;

    protected Color color;
    protected Color dropcolor;

    public Piece(int x, int y, Board board, Color color, MyFrame frame)  {
        this.x = x;
        this.y = y;
        this.board = board;
        this.color = color;
        this.frame = frame;
        this.setOpaque(true);
        this.setBackground(Color.CYAN);
        this.setBounds(x, y, ovalSize, ovalSize);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(0, 0, ovalSize, ovalSize);
    }
    public int getRow() {
        return y / ovalSize;
    }

    public int getColumn() {
        return x / ovalSize;
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(color);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //dropcolor = null;
        //System.out.println(dropcolor);

        //new legalMoves(getX(),getY(), color);
        OldX = getX();
        OldY = getY();


        dragging = true;
        // get the offset between the mouse click and the top-left corner of the piece
        int offsetX = e.getX() - this.getX();
        int offsetY = e.getY() - this.getY();

        // set the piece's location to the mouse position minus the offset
        setLocation(e.getX() - offsetX, e.getY() - offsetY);

    }



    @Override
    public void mouseReleased(MouseEvent e) { //TODO exceptions
        dragging = false;
        // round the position to the nearest multiple of the square size
        int newX = (int) (Math.round((double) getX() / 100) * 100);
        int newY = (int) (Math.round((double) getY() / 100) * 100);

        legalMoves lm = new legalMoves(OldX / 100, OldY / 100, color);
        isLegal = lm.isMoveLegal(newX / 100, newY / 100);
        isJump = lm.isJump(newX/100, newY/100);

        if (isJump){
            isLegal = true;
            BoardArray.boardarr[(OldX+newX)/200][(OldY+newY)/200] = 0;
        }

        if(isLegal) {
            setLocation(newX, newY);
            BoardArray.boardarr[OldX/100][OldY/100] = 0;
            BoardArray.boardarr[newX/100][newY/100] = color == Color.BLACK ? 2 : 1;
            frame.deletePieceAt();
        }else{
            setLocation(OldX, OldY);
        }

        isKing = lm.isKing(newX / 100, newY / 100);
        if(isKing){
            frame.deletePieceAt();
            frame.makeKing(newX/100,newY/100, color);
            BoardArray.boardarr[newX/100][newY/100] = color == Color.BLACK ? 4 : 3;
        }
        BoardArray.PrintBoardArray printer = new BoardArray.PrintBoardArray();


        //System.out.println(newX + " "+ newY);
    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {




        if (dragging) {
            int newX = getX() + e.getX() - ovalSize/2;
            int newY = getY() + e.getY() - ovalSize/2;

            // check if the new position is within the bounds of the board
            if (newX >= 0 && newX + size <= board.getWidth() && newY>= 0 && newY + size <= board.getHeight()) {
                // move the piece to the new position
                setLocation(newX, newY);
            }

        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


}
