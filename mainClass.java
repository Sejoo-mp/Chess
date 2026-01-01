import Field.*;
import Pieces.*;

import java.awt.*;
import java.util.Scanner;

public class mainClass
{
    static FeildChess p;
    protected static void main(String[] args)
    {
        GameController controller = new GameController();
        FeildChess p = new FeildChess();
        CreateThing create = new CreateThing();
        create.Basic(); // مهره‌ها را می‌سازد

        Scanner scanner = new Scanner(System.in);
        while (true) {
            p.printBoard();
            System.out.println("Current Turn: " + controller.getCurrentTurn());

            int x = Integer.parseInt(Utility.getInput("Enter X of piece: "));
            int y = Integer.parseInt(Utility.getInput("Enter Y of piece: "));
            int xF = Integer.parseInt(Utility.getInput("Enter X destination: "));
            int yF = Integer.parseInt(Utility.getInput("Enter Y destination: "));

            ChessPiece piece = p.searchBoardByIndex(x, y);
            controller.handleMove(piece, xF, yF);
        }

    }

    private static ChessPiece searchPiece(int x, int y)
    {
        return p.searchBoardByIndex(x, y);
    }

    private static void option(ChessPiece chessPiece , int xF , int yF)
    {
        chessPiece.move(xF, yF);
    }
}
