import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.io.File;

public class App {
    /**
     * Prints a nice welcome banner for the user!
     */
    public static void printBanner(){
        System.out.println("\n\n********************************************************************");
        System.out.println("                           Story Teller V1.0                            ");
        System.out.println("********************************************************************\n\n");
        System.out.println("Welcome to StoryTeller, a sophisticated electronic");
        System.out.println("author. This program reads from a list of words of");
        System.out.println("various parts of speech and creates a story from");
        System.out.println("them. You can tune the richness of the writing by");
        System.out.println("changing how frequently adjectives, adverbs, and");
        System.out.println("prepositions should be included.\n");
    }
    public static void main(String[] args) throws Exception {
        printBanner();
        Scanner sc = new Scanner(System.in);
        Scanner fsc = null;
        WordFileReader wfr = new WordFileReader();
        String fName;
        while (fsc == null){
            System.out.print("Please enter the name of the file you want to read: ");
            fName = sc.next();
            try{
                fsc = new Scanner(new File(fName));
            } catch (Exception ex){
                System.out.println("Please make sure you are inputting the correct file name and try again!\n");
            }
        }
        System.out.println("File read success!\n");
        LinkedHashMap<String, ArrayList<String>> wordsMapped = wfr.readFile(fsc);
        int sentCount = 0, prep, adv, adj;
        ArrayList<String> story = new ArrayList<String>();
        String done = "y";
        Author author = new Author(wordsMapped);
        // This strategy has waaaaay to many loops, this is n^3 time complexity, easier way to do this?, elimiated unnecesary loop. only n^2 now.
        while (!done.equals("n")){
            System.out.print("How many sentences would you like in your story? \n");
            try{
            sentCount = sc.nextInt();
             
            System.out.println("On a scale of 0 to 10...\n");
            System.out.print("  How frequently should adjectives be used? ");
            adj = sc.nextInt();
            author.setAdj(adj);
            
            System.out.print("  How frequently should adverbs be used? ");
            adv = sc.nextInt();
            author.setAdv(adv);
                
            System.out.print("  How frequently should prepositions be used? ");
            prep = sc.nextInt();
            System.out.println();
            author.setPrepositions(prep);
            } catch (Exception ex){
                System.out.println("\nPlease make sure you are using the correct input and try again!\n");
                sc.next();
                continue;
            }

            story = author.tellStory(sentCount);
            System.out.println("Here it is: ");
            for (String sentence : story){
                System.out.println(sentence);
            }
            System.out.println();// Clear out the terminal space, too crowded.
            System.out.print("Would you like another story (y or n)? ");
            done = sc.next();
        }
        System.out.println("Thank you for using StoryTeller!");
        sc.close();
    }
}
