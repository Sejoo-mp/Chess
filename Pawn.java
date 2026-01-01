package Pieces;

import Field.FeildChess;
import java.awt.Color;

public class Pawn extends ChessPiece {

    private boolean firstMove = true;

    public Pawn(int x, int y, Color color, FeildChess feildChess) {
        super(x, y, color, "Pawn", feildChess);
    }

    @Override
    public boolean move(int xF, int yF) {
        if (!isInsideBoard(xF, yF)) return false;

        int direction = (color == Color.WHITE) ? 1 : -1;
        int dx = xF - x;
        int dy = yF - y;

        // حرکت مستقیم
        if (dx == 0) {
            // حرکت یک خانه
            if (dy == direction && feildChess.searchBoardByIndex(xF, yF) == null) {
                doMove(xF, yF);
                firstMove = false;
                return true;
            }

            // حرکت دو خانه (فقط حرکت اول)
            if (firstMove && dy == 2 * direction &&
                    feildChess.searchBoardByIndex(x, y + direction) == null &&
                    feildChess.searchBoardByIndex(xF, yF) == null) {
                doMove(xF, yF);
                firstMove = false;
                return true;
            }
        }

        // زدن مورب
        if (Math.abs(dx) == 1 && dy == direction) {
            ChessPiece target = feildChess.searchBoardByIndex(xF, yF);
            if (target != null && target.getColor() != this.color) {
                target.exit();
                doMove(xF, yF);
                firstMove = false;
                return true;
            }
        }

        return false;
    }

    @Override
    public char getSymbol()
    {
        if (this.getColor() == Color.BLACK)
            return '♟';
        else
            return '♙';
    }

    // متد کمکی برای جابجایی واقعی
    private void doMove(int xF, int yF) {
        feildChess.isNull(x, y);
        feildChess.setBoard(this, xF, yF);
        updatePosition(xF, yF);
    }
}
