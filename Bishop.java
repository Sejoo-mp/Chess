package Pieces;

import Field.FeildChess;

import java.awt.*;

public class Bishop extends ChessPiece {

    public Bishop(int x, int y, Color color, FeildChess feildChess) {
        super(x, y, color, "Bishop", feildChess);
    }

    @Override
    public boolean move(int xF, int yF) {
        if (!isInsideBoard(xF, yF)) return false;
        if (Math.abs(xF - x) != Math.abs(yF - y)) return false; // فقط مورب

        int stepX = Integer.compare(xF, x);
        int stepY = Integer.compare(yF, y);

        int curX = x + stepX;
        int curY = y + stepY;
        while (curX != xF && curY != yF) {
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


    private boolean isPathClear(int xF, int yF) {
        int stepX = Integer.compare(xF, x);
        int stepY = Integer.compare(yF, y);

        int curX = x + stepX;
        int curY = y + stepY;

        while (curX != xF && curY != yF) {
            if (feildChess.searchBoardByIndex(curX, curY) != null) {
                return false;
            }
            curX += stepX;
            curY += stepY;
        }
        return true;
    }
    private boolean isDiagonalMove(int xF, int yF) {
        return Math.abs(xF - x) == Math.abs(yF - y);
    }
    @Override
    public char getSymbol()
    {
        if (this.getColor() == Color.BLACK)
            return '♝';
        else
            return '♗';
    }
}

