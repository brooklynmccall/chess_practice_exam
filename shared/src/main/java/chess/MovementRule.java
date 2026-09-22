package chess;

import java.util.Collection;

public interface MovementRule {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition, ChessPiece myPiece);
}
