package chess;

import java.util.ArrayList;
import java.util.Collection;

public class PawnRule extends BaseMovementRule{
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition, ChessPiece myPiece) {
        ArrayList<ChessMove> moves = new ArrayList<>();
        ArrayList<ChessPosition> positions = new ArrayList<>();

        int r = myPosition.getRow();
        int c = myPosition.getColumn();
        ChessGame.TeamColor color = myPiece.getTeamColor();

        if (color == ChessGame.TeamColor.WHITE) {
            ChessPosition up = new ChessPosition(r+1, c);
            if (isEmpty(board, up)) {
                positions.add(up);

                if (r == 2) {
                    ChessPosition twoUp = new ChessPosition(r+2, c);
                    if (isEmpty(board, twoUp)) {
                        positions.add(twoUp);
                    }
                }
            }

            ChessPosition upLeft = new ChessPosition(r+1, c-1);
            ChessPosition upRight = new ChessPosition(r+1, c+1);
            if (validatePosition(board, upLeft, myPiece) && isOccupiedByOther(board, upLeft, myPiece)) {
                positions.add(upLeft);
            }
            if (validatePosition(board, upRight, myPiece) && isOccupiedByOther(board, upRight, myPiece)) {
                positions.add(upRight);
            }

            for (ChessPosition position : positions) {
                if (validatePosition(board, position, myPiece)) {
                    if (position.getRow() == 8) {
                        moves.add(new ChessMove(myPosition, position, ChessPiece.PieceType.QUEEN));
                        moves.add(new ChessMove(myPosition, position, ChessPiece.PieceType.ROOK));
                        moves.add(new ChessMove(myPosition, position, ChessPiece.PieceType.BISHOP));
                        moves.add(new ChessMove(myPosition, position, ChessPiece.PieceType.KNIGHT));
                    } else {
                        moves.add(new ChessMove(myPosition, position, null));
                    }
                }
            }
        }

        if (color == ChessGame.TeamColor.BLACK) {
            ChessPosition down = new ChessPosition(r-1, c);
            if (isEmpty(board, down)) {
                positions.add(down);

                if (r == 7) {
                    ChessPosition twoDown = new ChessPosition(r-2, c);
                    if (isEmpty(board, twoDown)) {
                        positions.add(twoDown);
                    }
                }
            }

            ChessPosition downLeft = new ChessPosition(r-1, c-1);
            ChessPosition downRight = new ChessPosition(r-1, c+1);
            if (validatePosition(board, downLeft, myPiece) && isOccupiedByOther(board, downLeft, myPiece)) {
                positions.add(downLeft);
            }
            if (validatePosition(board, downRight, myPiece) && isOccupiedByOther(board, downRight, myPiece)) {
                positions.add(downRight);
            }

            for (ChessPosition position : positions) {
                if (validatePosition(board, position, myPiece)) {
                    if (position.getRow() == 1) {
                        moves.add(new ChessMove(myPosition, position, ChessPiece.PieceType.QUEEN));
                        moves.add(new ChessMove(myPosition, position, ChessPiece.PieceType.ROOK));
                        moves.add(new ChessMove(myPosition, position, ChessPiece.PieceType.BISHOP));
                        moves.add(new ChessMove(myPosition, position, ChessPiece.PieceType.KNIGHT));
                    } else {
                        moves.add(new ChessMove(myPosition, position, null));
                    }
                }
            }
        }

        return moves;
    }

    private boolean isEmpty(ChessBoard board, ChessPosition position) {
        if (board.getPiece(position) == null) {
            return true;
        } else {
            return false;
        }
    }
}
