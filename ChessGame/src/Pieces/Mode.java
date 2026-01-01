package Pieces;

import javax.swing.*;

public class Mode
{
    public void mode(){
        System.out.println("plz Select the game mode you want");
        System.out.println("1. player vs player");
        System.out.println("2. bot vs player");
        System.out.println("3. bot vs bot");
        int choice = Integer.valueOf( Utility.scanner.nextLine());
        Option(choice);
    }

    private void Option(int choice)
    {
        switch (choice){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
}

