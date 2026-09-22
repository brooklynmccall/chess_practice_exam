package chess;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseMovementRule implements MovementRule {
    public abstract Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition, ChessPiece myPiece);

    protected boolean isOnBoard(ChessPosition position) {
        int r = position.getRow();
        int c = position.getColumn();

        if (r<1 || r>8) {
            return false;
        } else if (c<1 || c>8) {
            return false;
        } else {
            return true;
        }
    }

    protected boolean isOccupiedBySame(ChessBoard board, ChessPosition position, ChessPiece myPiece) {
        ChessPiece other = board.getPiece(position);

        if (other == null) {
            return false;
        } else if (other.getTeamColor() == myPiece.getTeamColor()) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean isOccupiedByOther(ChessBoard board, ChessPosition position, ChessPiece myPiece) {
        ChessPiece other = board.getPiece(position);

        if (other == null) {
            return false;
        } else if (other.getTeamColor() != myPiece.getTeamColor()) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean validatePosition(ChessBoard board, ChessPosition position, ChessPiece myPiece) {
        if (isOnBoard(position) && !isOccupiedBySame(board, position, myPiece)) {
            return true;
        } else {
            return false;
        }
    }

    protected ArrayList<ChessMove> movesInLine(ChessBoard board, ChessPosition myPosition, ChessPiece myPiece, int rDif, int cDif) {
        ArrayList<ChessMove> moves = new ArrayList<>();
        int r = myPosition.getRow() + rDif;
        int c = myPosition.getColumn() + cDif;
        ChessPosition newPos = new ChessPosition(r, c);

        while(validatePosition(board, newPos, myPiece)) {
            moves.add(new ChessMove(myPosition, newPos, null));
            if(isOccupiedByOther(board, newPos, myPiece)) {
                break;
            }
            r+=rDif;
            c+=cDif;
            newPos = new ChessPosition(r, c);
        }

        return moves;
    }
}
