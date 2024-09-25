/*
 * Name: Roman Lewis
 * Project: Fortune Teller, a basic program that takes in strings of text and displays them on the screen,
 * in this project specifically it will take your name, age, and favorite color. Then it will repeat back those things
 * also while including what percentage your "lucky number" is divided by your age.
 */

import java.util.Scanner;
import java.util.Random;

public class FortuneTeller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        for (int i = 0; i < 45; i++){
            System.out.print("*");
        }
        String centeredText = "FORTUNE TELLER";
        System.out.format("\n%30s", centeredText + "\n" );

        for (int i = 0; i < 45; i++){
            System.out.print("*");
        }

        System.out.print("\nWhat is your name? ");
        String iName = sc.nextLine();

        System.out.print("\nHow old are you? ");
        int iAge = sc.nextInt();
        sc.nextLine(); // Clears input buffer

        System.out.print("\nWhat is your favorite color? ");
        String iColor = sc.nextLine();

        System.out.println("\nWelcome " + iName);

        System.out.println("I see you are " + iAge + " years old");

        System.out.println("Your favorite color is " + iColor);
        int luckyNum = 1 + rnd.nextInt(10);

        System.out.println("Your lucky number is " + luckyNum);
        double numAndAge = (double) luckyNum / iAge;
        double actPercent = (numAndAge * 10);

        String endMess1 = "Your lucky number is";
        String endMess2 = "Percent of your age.";
        System.out.printf("%s %.3f %s", endMess1, actPercent, endMess2);
        System.out.println("\n\nThank you for using this program");

    }
}
