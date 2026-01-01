package Pieces;

import Field.FeildChess;
import java.awt.Color;

public abstract class ChessPiece {

    protected int x;
    protected int y;
    protected Color color;
    protected boolean isAlive;
    protected String name;
    protected FeildChess feildChess;

    public ChessPiece(int x, int y, Color color, String name, FeildChess feildChess) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.name = name;
        this.feildChess = feildChess;
        this.isAlive = true;
        feildChess.setBoard(this, x, y);
    }

    // هر مهره باید حرکت خودش را پیاده‌سازی کند
    public abstract boolean move(int xF, int yF);
    public abstract char getSymbol();

    // خروج مهره از بازی (زده شدن)
    public void exit() {
        isAlive = false;
        feildChess.isNull(x, y);
    }

    // بررسی داخل بودن حرکت در صفحه 8×8
    protected boolean isInsideBoard(int xF, int yF) {
        return xF >= 0 && xF < 8 && yF >= 0 && yF < 8;
    }

    // Getterها
    public boolean isAlive() {
        return isAlive;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // آپدیت موقعیت بعد از حرکت موفق
    protected void updatePosition(int xF, int yF) {
        this.x = xF;
        this.y = yF;
    }

    @Override
    public String toString()
    {
        return "ChessPiece{" +
                "x=" + x +
                ", y=" + y +
                ", color=" + color +
                ", isAlive=" + isAlive +
                ", name='" + name + '\'' +
                '}';
    }
}
