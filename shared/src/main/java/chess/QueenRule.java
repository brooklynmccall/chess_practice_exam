package chess;

import java.util.ArrayList;
import java.util.Collection;

public class QueenRule extends BaseMovementRule {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition, ChessPiece myPiece) {
        ArrayList<ChessMove> moves = new ArrayList<>();

        ArrayList<ChessMove> left = movesInLine(board, myPosition, myPiece, 0, -1);
        ArrayList<ChessMove> upLeft = movesInLine(board, myPosition, myPiece, 1, -1);
        ArrayList<ChessMove> up = movesInLine(board, myPosition, myPiece, 1, 0);
        ArrayList<ChessMove> upRight = movesInLine(board, myPosition, myPiece, 1, 1);
        ArrayList<ChessMove> right = movesInLine(board, myPosition, myPiece, 0, 1);
        ArrayList<ChessMove> downRight = movesInLine(board, myPosition, myPiece, -1, 1);
        ArrayList<ChessMove> down = movesInLine(board, myPosition, myPiece, -1, 0);
        ArrayList<ChessMove> downLeft = movesInLine(board, myPosition, myPiece, -1, -1);

        moves.addAll(left);
        moves.addAll(upLeft);
        moves.addAll(up);
        moves.addAll(upRight);
        moves.addAll(right);
        moves.addAll(downRight);
        moves.addAll(down);
        moves.addAll(downLeft);

        return moves;
    }
}
