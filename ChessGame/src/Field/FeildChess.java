package Field;

import Pieces.ChessPiece;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FeildChess {

    private HashMap<Point, ChessPiece> board;
    private List<ChessPiece> removedPieces;

    public FeildChess() {
        board = new HashMap<>();
        removedPieces = new ArrayList<>();
    }

    public HashMap<Point, ChessPiece> getBoard()
    {
        return board;
    }

    // قرار دادن مهره در صفحه
    public void setBoard(ChessPiece piece, int x, int y) {
        if (!isInsideBoard(x, y)) return;
        board.put(new Point(x, y), piece);
    }

    // گرفتن مهره از خانه
    public ChessPiece searchBoardByIndex(int x, int y) {
        if (!isInsideBoard(x, y)) return null;
        return board.get(new Point(x, y));
    }

    // خالی کردن یک خانه
    public void isNull(int x, int y) {
        board.remove(new Point(x, y));
        addToArrayRemovePiece(x,y);
    }

    // اضافه کردن مهره زده‌شده
    public void addToRemovePiece(ChessPiece piece) {
        removedPieces.add(piece);
    }

    // گرفتن لیست مهره‌های حذف‌شده
    public List<ChessPiece> getRemovedPieces() {
        return removedPieces;
    }

    // بررسی داخل بودن مختصات در صفحه 8×8
    public boolean isInsideBoard(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    // نمایش صفحه شطرنج در کنسول
    public void printBoard() {
        for (int y = 7; y >= 0; y--) {
            for (int x = 0; x < 8; x++) {
                ChessPiece piece = board.get(new Point(x, y));
                if (piece == null) {
                    System.out.print(" ");
                } else {
                    if(piece.getName().charAt(0) == 'P'){
                        System.out.printf("%-3s", piece == null ? "." : piece.getSymbol());

                    }

                    if(piece.getName().charAt(0) == 'K' && piece.getName().charAt(1) == 'i'){
                        System.out.printf("%-3s", piece == null ? "." : piece.getSymbol());

                    }

                    if(piece.getName().charAt(0) == 'Q'){
                        System.out.printf("%-3s", piece == null ? "." : piece.getSymbol());

                    }

                    if(piece.getName().charAt(0) == 'R'){
                        System.out.printf("%-3s", piece == null ? "." : piece.getSymbol());

                    }

                    if(piece.getName().charAt(0) == 'B'){
                        System.out.printf("%-3s", piece == null ? "." : piece.getSymbol());

                    }

                    if(piece.getName().charAt(0) == 'K' && piece.getName().charAt(1) == 'n'){
                        System.out.printf("%-3s", piece == null ? "." : piece.getSymbol());

                    }
                }
            }
            System.out.println();
        }
    }

    // گرفتن همه مهره‌های داخل صفحه
    public List<ChessPiece> getAllPieces() {
        return new ArrayList<>(board.values());
    }

    @Override
    public String toString()
    {
        return "FeildChess{" +
                "board=" + board +
                ", removedPieces=" + removedPieces +
                '}';
    }
    public void addToArrayRemovePiece(int x , int y){
        removedPieces.add(board.get(new Point(x ,y)));

    }
}
