package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
    	List<Move> allowedMoves = new ArrayList<>();
    	
    	if ((colour.equals(PlayerColour.WHITE) && from.getRow() == 6) || (colour.equals(PlayerColour.BLACK) && from.getRow() == 1))
    	{
    		allowedMoves.add(new Move(from, from.plus((this.heading*2), 0)));
    	}
    	allowedMoves.add(new Move(from, from.plus(this.heading, 0)));
        return allowedMoves;
    }
}
