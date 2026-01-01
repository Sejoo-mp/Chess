package Pieces;

import Field.FeildChess;
import java.awt.Color;

public class King extends ChessPiece {

    public King(int x, int y, Color color, FeildChess feildChess) {
        super(x, y, color, "King", feildChess);
    }

    @Override
    public boolean move(int xF, int yF) {
        if (!isInsideBoard(xF, yF)) return false;

        int dx = Math.abs(xF - x);
        int dy = Math.abs(yF - y);

        if ((dx > 1 || dy > 1) || (dx == 0 && dy == 0)) return false;

        ChessPiece target = feildChess.searchBoardByIndex(xF, yF);
        if (target != null && target.getColor() == this.color) return false;
        if (target != null) target.exit();

        feildChess.isNull(x, y);
        feildChess.setBoard(this, xF, yF);
        updatePosition(xF, yF);

        return true;
    }

    @Override
    public char getSymbol()
    {
        if (this.getColor() == Color.BLACK)
            return '♚';
        else
            return '♔';
    }
}
