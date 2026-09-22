package chess;

import java.util.ArrayList;
import java.util.Collection;

public class KnightRule extends BaseMovementRule {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition, ChessPiece myPiece) {
        ArrayList<ChessMove> moves = new ArrayList<>();
        ArrayList<ChessPosition> positions = new ArrayList<>();

        int r = myPosition.getRow();
        int c = myPosition.getColumn();

        positions.add(new ChessPosition(r-1, c-2)); // Left down
        positions.add(new ChessPosition(r+1, c-2)); // Left up
        positions.add(new ChessPosition(r+2, c-1)); // Up left
        positions.add(new ChessPosition(r+2, c+1)); // Up right
        positions.add(new ChessPosition(r+1, c+2)); // Right up
        positions.add(new ChessPosition(r-1, c+2)); // Right down
        positions.add(new ChessPosition(r-2, c+1)); // Down right
        positions.add(new ChessPosition(r-2, c-1)); // Down left

        for (ChessPosition position : positions) {
            if (validatePosition(board, position, myPiece)) {
                moves.add(new ChessMove(myPosition, position, null));
            }
        }

        return moves;
    }
}
