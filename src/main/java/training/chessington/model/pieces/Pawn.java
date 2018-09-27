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
    
    public boolean outOfBounds(Coordinates coord) 
    {
    	if (((coord.getRow() <= 7) && (coord.getRow() >=0)) &&
    			((coord.getCol() <= 7) && (coord.getCol() >= 0)))
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
    	List<Move> allowedMoves = new ArrayList<>();

    	if (!outOfBounds(from.plus(1, 0)) && !outOfBounds(from.plus(-1, 0))) 
    	{
	    	if ((board.get(from.plus(this.heading, 0)) == null))
	    	{
	    		if (((colour.equals(PlayerColour.WHITE) && from.getRow() == 6) || (colour.equals(PlayerColour.BLACK) && from.getRow() == 1))
	    				&& board.get(from.plus((this.heading *2), 0)) == null)
		    	{
		    		allowedMoves.add(new Move(from, from.plus((this.heading*2), 0)));
		    	}
		    	allowedMoves.add(new Move(from, from.plus(this.heading, 0)));
	    	}
	    	if (!(outOfBounds(from.plus(this.heading, 1))) && board.get(from.plus(this.heading, 1)) != null)
	    	{
	    		Piece piece = board.get(from.plus(this.heading, 1));
	    		
	    		if (!piece.getColour().equals(this.colour))
	    		{		
	    			allowedMoves.add(new Move(from, from.plus(this.heading, 1)));
	    		}
	    	}
	    	if (!(outOfBounds(from.plus(this.heading, -1))) && board.get(from.plus(this.heading, -1)) != null )
	    	{
	    		Piece piece = board.get(from.plus(this.heading, -1));
	    		
	    		if (!piece.getColour().equals(this.colour))
	    		{		
	    			allowedMoves.add(new Move(from, from.plus(this.heading, -1)));
	    		}
	    	}
	    	if (!(outOfBounds(from.plus(this.heading, -1))) && board.get(from.plus(this.heading, -1)) == null )
	    	{
	    		Piece piece = board.get(from.plus(0, -1));
	    		
	    		if ((piece != null) && (!piece.getColour().equals(this.colour)))
	    		{		
	    			allowedMoves.add(new Move(from, from.plus(this.heading, -1)));
	    		}
	    	}
	    	if (!(outOfBounds(from.plus(this.heading, +1))) && board.get(from.plus(this.heading, +1)) == null )
	    	{
	    		Piece piece = board.get(from.plus(0, +1));
	    		
	    		if ((piece != null) && (!piece.getColour().equals(this.colour)))
	    		{		
	    			allowedMoves.add(new Move(from, from.plus(this.heading, +1)));
	    		}
	    	}
    	}
    	
        return allowedMoves;
    }
}
