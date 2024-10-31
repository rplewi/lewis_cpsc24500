import java.util.Scanner;
import java.util.LinkedHashMap;

public class App {
    /**
     * Prints a nice welcome banner for the user!
     */
    public static void printBanner(){
        System.out.println("\n\n********************************************************************");
        System.out.println("                           Story Teller V1.0                            ");
        System.out.println("********************************************************************\n\n");
        // Sorry about this print statement, its kind of long!
        System.out.println("Welcome Welcome to StoryTeller, a sophisticated electronicauthor. \nThis program reads from a list of words ofvarious parts of speech\nand creates a story fromthem. You can tune the richness of the writing\nby changing how frequently adjectives, adverbs, andprepositions should be included.");
    }
    public static void main(String[] args) throws Exception {
        printBanner();
        Scanner sc = new Scanner(System.in);
        WordFileReader wfr = new WordFileReader();
        LinkedHashMap wordsMapped = wfr.readFile();
        int sentCount = 0, prep, adv, adj;
        System.out.print("How many sentences would you like in your story? \n");
        sentCount = sc.nextInt();
        for (int i = 0; i < sentCount; i++){
            System.out.print("On a scale of 0 to 10...\n");
            System.out.print("\t How frequently should adjectives be used? \n");
            adj = sc.nextInt();
            System.out.print("\t How frequently should adverbs be used? \n");
            adv = sc.nextInt();
            System.out.print("\t How frequently shold prepositions be used? \n");
            prep = sc.nextInt();
            Author author = new Author(wordsMapped, adj, adv, prep);
        }

        
    }
}
