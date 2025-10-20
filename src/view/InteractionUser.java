package view;

import java.util.Scanner;

public class InteractionUser {
    private static Scanner input = new Scanner(System.in);

    public static int intInput(){
        return input.nextInt();
    }

    public static String stringInput(){
        return input.nextLine();
    }

}
