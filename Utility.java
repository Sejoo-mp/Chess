package Pieces;

import java.util.Random;
import java.util.Scanner;

public class Utility
{
    static Scanner scanner = new Scanner(System.in);
    public static String getInput(String smg){
        System.out.println(smg);
        return scanner.nextLine();
    }
    public static int GetRandomNumber()
    {
        return (int)(Math.random()*8);
    }
}
