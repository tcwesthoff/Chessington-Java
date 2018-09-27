package training.chessington.model;

import training.chessington.model.pieces.*;
import training.chessington.model.pieces.Piece.PieceType;
import training.chessington.model.pieces.Pawn;

public class Board {

    private Piece[][] board = new Piece[8][8];

    private Board() {
    }

    public static Board forNewGame() {
        Board board = new Board();
        board.setBackRow(0, PlayerColour.BLACK);
        board.setBackRow(7, PlayerColour.WHITE);

        for (int col = 0; col < 8; col++) {
            board.board[1][col] = new Pawn(PlayerColour.BLACK);
            board.board[6][col] = new Pawn(PlayerColour.WHITE);
        }

        return board;
    }

    public static Board empty() {
        return new Board();
    }

    private void setBackRow(int rowIndex, PlayerColour colour) {
        board[rowIndex][0] = new Rook(colour);
        board[rowIndex][1] = new Knight(colour);
        board[rowIndex][2] = new Bishop(colour);
        board[rowIndex][3] = new Queen(colour);
        board[rowIndex][4] = new King(colour);
        board[rowIndex][5] = new Bishop(colour);
        board[rowIndex][6] = new Knight(colour);
        board[rowIndex][7] = new Rook(colour);
    }

    public Piece get(Coordinates coords) {
        return board[coords.getRow()][coords.getCol()];
    }

    public void move(Coordinates from, Coordinates to) {
    	
    	Piece old_piece = board[to.getRow()][to.getCol()];
    	Piece new_piece = board[from.getRow()][from.getCol()];
    	
        board[to.getRow()][to.getCol()] = board[from.getRow()][from.getCol()];
        board[from.getRow()][from.getCol()] = null;
        
        // take piece if en passant rule is true
        // take 
        if ((to.getCol() != from.getCol()) && (new_piece.getType().equals(PieceType.PAWN)))
        {
        	if (old_piece == null)
        	{
        		board[to.getRow()-(new_piece.getHeading(new_piece.getColour()))][to.getCol()] = null;
        	}
        }
    }

    public void placePiece(Coordinates coords, Piece piece) {
        board[coords.getRow()][coords.getCol()] = piece;
    }
}
