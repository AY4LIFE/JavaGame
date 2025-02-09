/**
 * CPSC 233 W25 Assignment 1 Starter to use to make Board.java
 * @author Jonathan Hudson
 * @email jwhudson@ucalgary.ca
 * @version 1.0
 */
public class Board {

    /**
     * No piece in board (empty)
     */
    public static final int EMP = Game.EMP;
    /**
     * Connect-L Red Piece
     */
    public static final int RED = Game.RED;
    /**
     * Connect-L Blue Piece
     */
    public static final int BLU = Game.BLU;

    //Students should enter their functions below here
public static int[][] createBoard(int rows, int cols){
    int[][] board = new int[rows][cols];
    if ((rows >= 4) && (cols >= 4) && (rows <= 8) && (cols <= 8)){
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                board[i][j] = 0;
            }
        }
    }
    return board;
}
public static int rowCount(int[][] board){
    return board.length;
}

public static int columnCount(int[][] board){
    return board[0].length;
}
public static boolean valid(int[][] board, int rows, int columns){
if ((rows > 0) && (rows < rowCount(board)) && (columns > 0) && (columns < columnCount(board))){
    return true;
}
else{
    return false;
}
}
public static boolean canPlay(int[][] board, int column){
    if (board[0][column] == 0){
        return true;
    }
    else{
        return false;
    }
}

public static int play(int[][] board, int column, int piece){
    for (int i = board.length - 1; i >= 0; i--){
        if (board[i][column] == 0){
            board[i][column] = piece;
            return i;
        }
    }
    return -1;

}
    //Students should enter their functions above here
    /**
     * Is there a win in given board in any row of board
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @param piece The piece to look for length in a row for any row
     * @return True if there is length in any row, False otherwise
     */
    private static boolean winInAnyRow(int[][] board, int piece, int length) {
        for (int row = 0; row < board.length; row++) {
            if (winInRow(board, row, piece, length)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Is there a win in given board in any column of board
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @param piece The piece to look for length in a row for any column
     * @return True if there is length in any column, False otherwise
     */
    private static boolean winInAnyColumn(int[][] board, int piece, int length) {
        for (int col = 0; col < board[0].length; col++) {
            if (winInColumn(board, col, piece, length)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Is there a win in given board in any diagonal of board
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @param piece The piece to look for length in a row for any diagonal
     * @return True if there is length in any diagonal /\, False otherwise
     */
    private static boolean winInAnyDiagonal(int[][] board, int piece, int length) {
        return winInDiagonalBackslash(board, piece, length) || winInDiagonalForwardSlash(board, piece, length);
    }

    /**
     * Has the given piece won the board
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @param piece The piece to check for a win
     * @return True if piece has won
     */
    public static boolean won(int[][] board, int piece, int length) {
        return winInAnyRow(board, piece, length) || winInAnyColumn(board, piece, length) || winInAnyDiagonal(board, piece, length);
    }

    /**
     * This function determines if the game is complete due to a win or tie by either player
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @return True if game is complete, False otherwise
     */
    public static boolean isGameOver(int[][] board, int length) {
        return full(board) || won(board, RED, length) || won(board, BLU, length);
    }
}
