package view;

import java.util.Scanner;

public class InteractionUser {
    private static Scanner input = new Scanner(System.in);

    /**
     * Method for inputting int
     * @return (int) input by the player
     */
    public static int intInput(){
        return input.nextInt();
    }

    /**
     * Method for inputting string
     * @return (string) input by the player
     */
    public static String stringInput(){
        return input.nextLine();
    }

}
