import java.awt.*;
import java.awt.event.MouseEvent;

public class KingPiece extends Piece {
    public KingPiece(int x, int y, Board board, Color color, MyFrame frame){
        super(x, y, board, color, frame);

    }
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(0, 0, ovalSize, ovalSize);
        g.setColor(color);
        g.fillOval(25,25, ovalSize-50, ovalSize-50);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(color);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        dropcolor = null;
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
    public void mouseReleased(MouseEvent e) {
        dragging = false;
        // round the position to the nearest multiple of the square size
        int newX = (int) (Math.round((double) getX() / 100) * 100);
        int newY = (int) (Math.round((double) getY() / 100) * 100);

        legalMoves lm = new legalMoves(OldX / 100, OldY / 100, color);



        isLegal = lm.isKingMove(newX / 100, newY / 100);
        isJump = lm.isKingJump(newX/100, newY/100);

        if (isJump){
            isLegal = true;
            BoardArray.boardarr[(OldX+newX)/200][(OldY+newY)/200] = 0;
            //removePieceAtPosition((OldX+newX)/200,(OldY+newY)/200);
            //removePieceAtPosition(1,3);



        }

        if(isLegal) {
            setLocation(newX, newY);
            BoardArray.boardarr[OldX/100][OldY/100] = 0;
            BoardArray.boardarr[newX/100][newY/100] = color == Color.BLACK ? 4 : 3;
            frame.deletePieceAt();
        }else{
            setLocation(OldX, OldY);
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
            if (newX >= 0 && newX + size <= board.getWidth() && newY + size <= board.getHeight()) {
                // move the piece to the new position
                setLocation(newX, newY);
            }

        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


}
