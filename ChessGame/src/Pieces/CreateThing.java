package Pieces;

import Field.FeildChess;

import java.awt.*;
import java.util.Scanner;

public class CreateThing
{
    FeildChess p;
    
    public void Basic(){
        p = new FeildChess();
        Scanner scanner = new Scanner(System.in);

        Rook rook1_White = new Rook(0,0, Color.white,p);
        Knight knight1_White = new Knight(1,0,Color.white ,p);
        Bishop bishop1_White = new Bishop(2,0,Color.white,p);
        King king_White = new King(3,0,Color.white,p);
        Queen queen_White = new Queen(4,0,Color.white,p);
        Bishop bishop2_White = new Bishop(5,0,Color.white,p);
        Knight knight2_White = new Knight(6,0,Color.white ,p);
        Rook rook2_White = new Rook(7,0,Color.white,p);
        Pawn pawn0_White =  new Pawn(0,1, Color.white,p);
        Pawn pawn1_White =  new Pawn(1,1, Color.white,p);
        Pawn pawn2_White =  new Pawn(2,1, Color.white,p);
        Pawn pawn3_White =  new Pawn(3,1, Color.white,p);
        Pawn pawn4_White =  new Pawn(4,1, Color.white,p);
        Pawn pawn5_White =  new Pawn(5,1, Color.white,p);
        Pawn pawn6_White =  new Pawn(6,1, Color.white,p);
        Pawn pawn7_White =  new Pawn(7,1, Color.white,p);

        Rook rook1_Black = new Rook(0,7,Color.BLACK,p);
        Knight knight1_Black = new Knight(1,7,Color.BLACK ,p);
        Bishop bishop1_Black = new Bishop(2,7,Color.BLACK,p);
        King king_Black = new King(3,7,Color.BLACK,p);
        Queen queen_Black = new Queen(4,7,Color.BLACK,p);
        Bishop bishop2_Black = new Bishop(5,7,Color.BLACK,p);
        Knight knight2_Black = new Knight(6,7,Color.BLACK ,p);
        Rook rook2_Black = new Rook(7,7,Color.BLACK,p);
        Pawn pawn0_Black =  new Pawn(0,6, Color.BLACK,p);
        Pawn pawn1_Black =  new Pawn(1,6, Color.BLACK,p);
        Pawn pawn2_Black =  new Pawn(2,6, Color.BLACK,p);
        Pawn pawn3_Black =  new Pawn(3,6, Color.BLACK,p);
        Pawn pawn4_Black =  new Pawn(4,6, Color.BLACK,p);
        Pawn pawn5_Black =  new Pawn(5,6, Color.BLACK,p);
        Pawn pawn6_Black =  new Pawn(6,6, Color.BLACK,p);
        Pawn pawn7_Black =  new Pawn(7,6, Color.BLACK,p);

        int x = -1;
        int y = -1;
        int xF = -1;
        int yF = -1;

        do{
            p.printBoard();
            System.out.println("plz enter loc of your piece : ");
            System.out.print("x : ");
            x = Integer.valueOf(scanner.nextLine());
            System.out.print("y : ");
            y = Integer.valueOf(scanner.nextLine());
            System.out.println("\nplz enter your locF of piece : ");
            System.out.print("xF : ");
            xF = Integer.valueOf(scanner.nextLine());
            System.out.print("yF : ");
            yF = Integer.valueOf(scanner.nextLine());
            option(searchPiece(x,y) , xF ,yF);
            if (x < 0 && y<0 && x >7 && y >7)
                break;
        }while (true);
    }
    private ChessPiece searchPiece(int x, int y)
    {
        return p.searchBoardByIndex(x, y);
    }

    private void option(ChessPiece chessPiece , int xF , int yF)
    {
        chessPiece.move(xF, yF);
    }
}
