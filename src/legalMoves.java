import java.awt.*;
import java.util.ArrayList;
public class legalMoves {

    private int x,y;
    private Color color;

    public legalMoves(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }


    public boolean isKing(int newX, int newY){
        if (BoardArray.boardarr[newX][newY]==2 && newY==0){
            System.out.println("ISKING");
            BoardArray.boardarr[newX][newY] = 0;
            return true;
        }
        if (BoardArray.boardarr[newX][newY]==1 && newY==7){
            BoardArray.boardarr[newX][newY] = 0;
            return true;
        }

        return false;
    }
    public boolean isKingJump(int newX, int newY){
        if(BoardArray.boardarr[newX][newY]!=0)return false;
        int middleX = Math.abs(newX + x)/2;
        int middleY = Math.abs(newY + y)/2;
        int PiecColor = BoardArray.boardarr[x][y];
        int JumpedColor = BoardArray.boardarr[middleX][middleY];
        if(!(((JumpedColor==1||JumpedColor==3) && PiecColor==4)||((JumpedColor==2||JumpedColor==4) && PiecColor==3))){
            return false;
        }
        int deltaX = Math.abs(newX - x);
        int deltaY = Math.abs(newY - y);

        if(color == Color.BLACK) {
            if(deltaY == 2 && deltaX == 2) {
                return true;
            }
        }
        else if(color == Color.RED) {
            if(deltaY == 2 && deltaX == 2) {
                return true;
            }
        }
        return false;
    }

    public boolean isKingMove(int newX, int newY) {

        if(BoardArray.boardarr[newX][newY]!=0)return false;
        int deltaX = Math.abs(newX - x);
        int deltaY = Math.abs(newY - y);

        if(deltaY == 1 && deltaX == 1) {
            return true;
        }

        return false;
    }

    public boolean isJump(int newX, int newY){
        if(BoardArray.boardarr[newX][newY]!=0)return false;
        int middleX = Math.abs(newX + x)/2;
        int middleY = Math.abs(newY + y)/2;
        //System.out.println(x + " : " + y + " :: " + newX + " : " + newY);
        //System.out.println(middleX);
        //System.out.println(middleY);
        int PiecColor = BoardArray.boardarr[x][y];
        int JumpedColor = BoardArray.boardarr[middleX][middleY];
        if(!(((JumpedColor==1||JumpedColor==3) && PiecColor==2)||((JumpedColor==2||JumpedColor==4) && PiecColor==1))){
            return false; //TODO podziel metody po jednej funkcjonalnosci
        }


        int deltaX = Math.abs(newX - x);
        int deltaY = newY - y;

        if(color == Color.BLACK) {
            if(deltaY == -2 && deltaX == 2) {
                return true;
            }
        }
        else if(color == Color.RED) {
            if(deltaY == 2 && deltaX == 2) {
                return true;
            }
        }
        return false;
    }


    public boolean isMoveLegal(int newX, int newY) {

        if(BoardArray.boardarr[newX][newY]!=0)return false;
        int deltaX = Math.abs(newX - x);
        int deltaY = newY - y;

        if(color == Color.BLACK) {
            if(deltaY == -1 && deltaX == 1) {
                return true;
            }
        }
        else if(color == Color.RED) {
            if(deltaY == 1 && deltaX == 1) {
                return true;
            }
        }
        return false;
    }

}

