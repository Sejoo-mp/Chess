package Pieces;

import Field.FeildChess;
import java.awt.Color;

public class Rook extends ChessPiece {

    public Rook(int x, int y, Color color, FeildChess feildChess) {
        super(x, y, color, "Rook", feildChess);
    }

    @Override
    public boolean move(int xF, int yF) {
        if (!isInsideBoard(xF, yF)) return false;
        if (x != xF && y != yF) return false; // فقط افقی یا عمودی

        int stepX = Integer.compare(xF, x);
        int stepY = Integer.compare(yF, y);

        int curX = x + stepX;
        int curY = y + stepY;
        while (curX != xF || curY != yF) {
            if (feildChess.searchBoardByIndex(curX, curY) != null) return false;
            curX += stepX;
            curY += stepY;
        }

        ChessPiece target = feildChess.searchBoardByIndex(xF, yF);
        if (target != null && target.getColor() == this.color) return false;
        if (target != null) target.exit();

        feildChess.isNull(x, y);
        feildChess.setBoard(this, xF, yF);
        updatePosition(xF, yF);

        return true;
    }

    // بررسی خالی بودن مسیر
    private boolean isPathClear(int xF, int yF) {

        int stepX = Integer.compare(xF, x);
        int stepY = Integer.compare(yF, y);

        int curX = x + stepX;
        int curY = y + stepY;

        while (curX != xF || curY != yF) {
            if (feildChess.searchBoardByIndex(curX, curY) != null)
                return false;

            curX += stepX;
            curY += stepY;
        }
        return true;
    }
    @Override
    public char getSymbol()
    {
        if (this.getColor() == Color.BLACK)
            return '♜';
        else
            return '♖';
    }
}
