package chess;
import java.util.ArrayList;
import java.util.Collection;

public class RookRule extends BaseMovementRule {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition, ChessPiece myPiece) {
        ArrayList<ChessMove> moves = new ArrayList<>();

        ArrayList<ChessMove> left = movesInLine(board, myPosition, myPiece, 0, -1);
        ArrayList<ChessMove> up = movesInLine(board, myPosition, myPiece, 1, 0);
        ArrayList<ChessMove> right = movesInLine(board, myPosition, myPiece, 0, 1);
        ArrayList<ChessMove> down = movesInLine(board, myPosition, myPiece, -1, 0);

        moves.addAll(left);
        moves.addAll(up);
        moves.addAll(right);
        moves.addAll(down);

        return moves;
    }
}
