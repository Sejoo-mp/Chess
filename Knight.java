package Pieces;

import Field.FeildChess;
import java.awt.Color;

public class Knight extends ChessPiece {

    public Knight(int x, int y, Color color, FeildChess feildChess) {
        super(x, y, color, "Knight", feildChess);
    }

    @Override
    public boolean move(int xF, int yF) {
        if (!isInsideBoard(xF, yF)) return false;

        int dx = Math.abs(xF - x);
        int dy = Math.abs(yF - y);

        if (!((dx == 2 && dy == 1) || (dx == 1 && dy == 2))) return false;

        ChessPiece target = feildChess.searchBoardByIndex(xF, yF);

        // مهره هم‌رنگ → حرکت ممنوع
        if (target != null && target.getColor() == this.color) return false;

        // مهره حریف → زده می‌شود
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
            return '♞';
        else
            return '♘';
    }
}
