package Pieces;

import java.awt.*;

public class GameController {
    private Turn currentTurn = Turn.WHITE;
    public Turn getCurrentTurn() { return currentTurn; }
    public void nextTurn() { currentTurn = (currentTurn == Turn.WHITE) ? Turn.BLACK : Turn.WHITE; }

    public boolean handleMove(ChessPiece piece, int xTo, int yTo) {
        if (piece == null) return false;
        if ((piece.getColor() == Color.WHITE && currentTurn != Turn.WHITE) ||
                (piece.getColor() == Color.BLACK && currentTurn != Turn.BLACK)) return false;
        boolean moved = piece.move(xTo, yTo);
        if (moved) nextTurn();
        return moved;
    }
}

