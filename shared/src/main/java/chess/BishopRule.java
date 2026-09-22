package chess;

import java.util.ArrayList;
import java.util.Collection;

public class BishopRule extends BaseMovementRule {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition, ChessPiece myPiece) {
        ArrayList<ChessMove> moves = new ArrayList<>();

        ArrayList<ChessMove> upLeft = movesInLine(board, myPosition, myPiece, 1, -1);
        ArrayList<ChessMove> upRight = movesInLine(board, myPosition, myPiece, 1, 1);
        ArrayList<ChessMove> downRight = movesInLine(board, myPosition, myPiece, -1, 1);
        ArrayList<ChessMove> downLeft = movesInLine(board, myPosition, myPiece, -1, -1);

        moves.addAll(upLeft);
        moves.addAll(upRight);
        moves.addAll(downRight);
        moves.addAll(downLeft);

        return moves;
    }
}
