import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.Collections;
/*
 * Author - Roman Lewis
 * Date: 10 - 26 - 2024
 * Project: Text Analyzer
 * - Takes in a text provided by the user and analyzes it for its unique words, the occurence of those words, and will even calculate the average length of the words!
 */

public class App {
    /**
     * PrintBanner method that will print the banner for the user!
     */
    public static void printBanner(){
        System.out.println("\n\n********************************************************************");
        System.out.println("                       Writing Analyzer V1.0                        ");
        System.out.println("********************************************************************\n\n");
    }
    /**
     * This method gets the scanner file associated with the file we want to read.
     * @param fsc - file scanner we want to use in the main method
     * @param fileName - name of the file the user wants to use.
     * @return - the file scanner now linked to the file name.
     */
    public static Scanner getScannerFile(Scanner fsc, String fileName){
        Scanner sc = new Scanner(System.in);
        while (fsc == null){
            System.out.println("Please enter the name of the file to analyze: ");
            fileName = sc.nextLine();
            try {
                fsc = new Scanner(new File(fileName));
            } catch (Exception ex){
                System.out.println("Please make sure you are inputting the correct file name and try again!\n");
            }
        }
        return fsc;
    }
    /**
     * This method will sort the array so we can print it out in order!
     * @param uniqueWords - The ArrayList we will be sorting.
     * @return - A sorted ArrayList!
     */
    public static ArrayList<String> sortArray(ArrayList<String> uniqueWords){
        Collections.sort(uniqueWords);
        return uniqueWords;
    }
    /**
     * This method will return the average word length of all the words in the text file.
     * @param counts - The linkedHashMap that we will be using to do all the calculations.
     * @return - average word length in the form of a double.
     */
    public static double avgWordLength(LinkedHashMap<String, Integer> counts){
        int totalLetters = 0;
        double totalWords = 0.0;
        /*
         * This for loop uses the keySet() that gives you a list of keys in the hashMap, then use the keys in the hashmap to search for the value at the key
         * then we multiply it by the length of the word at the key to get the total amount of letters. It also uses counts.get() to get the occurence of words
         * thus giving us the total amount of words. With these two values we can get the average word length.
         */
        for (String key : counts.keySet()){
            totalLetters += key.length() * counts.get(key);
            totalWords += counts.get(key);
        }
        return (double) totalLetters / totalWords;
    }
    public static void main(String[] args) throws Exception {
        ArrayList<String> uniqueWords = new ArrayList<String>();
        LinkedHashMap<String, Integer> counts = new LinkedHashMap<String, Integer>();
        Scanner fsc = null;
        String fileName = "";
        String[] parts = null;
        int wordCount = 0;
        double avgLength = 0.0;
        printBanner();
        fsc = getScannerFile(fsc, fileName);
        System.out.println("File Read Success!");
        while (fsc.hasNextLine()){
            parts = fsc.nextLine().toLowerCase().replaceAll("[\\p{Punct}]","").split(" ");
            for (String part : parts){
                /*
                 * This if statement will only run if parts[] has something in it, thus catching the instance where parts has nothing in it, stopping it from counting non-words.
                 */
                if(!part.isEmpty()){  
                    if (uniqueWords.contains(part)){
                        counts.put(part, counts.get(part) + 1);
                    } else {uniqueWords.add(part);
                        counts.put(part, 1);
                    }
                    wordCount++;
                }
            }
        }
        uniqueWords = sortArray(uniqueWords);

        System.out.println("There are " + wordCount + " words in the text.");
        System.out.println("There are " + uniqueWords.size() + " unique words in the text.");
        System.out.println("Here are the unique words and how many times each appeared:");
        // Iterate through and display the unique words and their occurence.
        for (int i = 0; i < counts.size(); i++){
            System.out.format("%-15s %10d\n", uniqueWords.get(i), counts.get(uniqueWords.get(i))); //  formatted printout of the owrds and their occurence.
        }
        // Get average length of words.
        avgLength = avgWordLength(counts);
        System.out.printf("The average word length is: %.2f.", avgLength); // formatted average length of words!
        System.out.println("\nThank you for using this program!");

        
    }
}
