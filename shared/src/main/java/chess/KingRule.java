package chess;

import java.util.Collection;
import java.util.ArrayList;

public class KingRule extends BaseMovementRule{
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition, ChessPiece myPiece) {
        ArrayList<ChessMove> moves = new ArrayList<>();
        ArrayList<ChessPosition> positions = new ArrayList<>();

        int r = myPosition.getRow();
        int c = myPosition.getColumn();

        positions.add(new ChessPosition(r, c-1));
        positions.add(new ChessPosition(r+1, c-1));
        positions.add(new ChessPosition(r+1, c));
        positions.add(new ChessPosition(r+1, c+1));
        positions.add(new ChessPosition(r, c+1));
        positions.add(new ChessPosition(r-1, c+1));
        positions.add(new ChessPosition(r-1, c));
        positions.add(new ChessPosition(r-1, c-1));

        for (ChessPosition position : positions) {
            if (validatePosition(board, position, myPiece)) {
                moves.add(new ChessMove(myPosition, position, null));
            }
        }

        return moves;
    }
}
