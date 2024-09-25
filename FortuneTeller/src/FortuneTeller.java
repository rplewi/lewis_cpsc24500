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

        System.out.println("\nWhat is your name?");
        String iName = sc.nextLine();

        System.out.println("How old are you?");
        int iAge = sc.nextInt();
        sc.nextLine(); // Clears input buffer

        System.out.println("What is your favorite color?");
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
        System.out.println("\nThank you for using this program");
    }
}
