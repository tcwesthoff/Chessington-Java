package training.chessington.model.pieces;

import training.chessington.model.Coordinates;
import training.chessington.model.PlayerColour;

public abstract class AbstractPiece implements Piece {

    protected final Piece.PieceType type;
    protected final PlayerColour colour;
    protected final int heading;

    protected AbstractPiece(Piece.PieceType type, PlayerColour colour) {
        this.type = type;
        this.colour = colour;
        this.heading = getHeading(colour);
    }

    @Override
    public Piece.PieceType getType() {
        return type;
    }

    @Override
    public PlayerColour getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return colour.toString() + " " + type.toString();
    }
    public int getHeading(PlayerColour colour) {
    	if (colour.equals(PlayerColour.WHITE)) {
    		return -1;
    	}
    	else {
    		return 1;
    	}
    }
}
