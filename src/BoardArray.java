public class BoardArray {
    public static int[][] boardarr;

    public BoardArray(){
        // Initialize boardarr here
        //boardarr = new int[Board.numRows][Board.numCols];
        /*for (int i = 0; i < Board.numRows; i++) {
            for (int j = 0; j < Board.numCols; j++) {
                //if ((i + j) % 2 == 1 && j < 3) { // create and add red pieces
                    // ...
                  //  boardarr[i][j] = 1;
                //} else if ((i + j) % 2 == 1 && j > 4) { // create and add blue pieces
                    // ...
                  //  boardarr[i][j] = 2;
                //} else {
                    //if(i>4) {
                    //    boardarr[i][j] = 7;
                   // }
                    //else {
                    //    boardarr[i][j] = 7;
                   // }
            }
        }*/

    }

    public static class PrintBoardArray {//TODO zmienic na metode
        public PrintBoardArray() {

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(BoardArray.boardarr[j][i]);
                }
                System.out.print("    ");
                for (int j = 0; j < 8; j++) {
                    System.out.print(BoardArray.boardarr[7-j][7-i]);
                }
                System.out.println();
            }
            System.out.println();
        }

    }
    // Other methods and variables in the Board class
}