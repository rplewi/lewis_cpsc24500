import java.util.Scanner;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.ArrayList;

public class WordFileReader{
    public LinkedHashMap<String, ArrayList<String>> readFile(){
        String fName, line, word, specifier;
        String[] parts;
        ArrayList<String> listWords = new ArrayList<String>();
        LinkedHashMap<String, ArrayList<String>> wordsMapped = new LinkedHashMap<String, ArrayList<String>>();
        Scanner sc = new Scanner(System.in);
        Scanner fsc = null;
        while (fsc == null){
            System.out.print("Please enter the name of the file you want to read: ");
            fName = sc.next();
            try{
                fsc = new Scanner(new File(fName));
            } catch (Exception ex){
                System.out.println("Please make sure you are inputting the correct file name and try again!");
            }
        }
        while (fsc.hasNextLine()){
            parts = fsc.nextLine().split(" ");
                if (parts[0].isEmpty() || parts[1].isEmpty()){
                    continue;
                }
            word = parts[0];
            specifier = parts[1]; 
            if (!listWords.contains(specifier)){
                wordsMapped.put(specifier, new ArrayList<String>());
            }
            wordsMapped.get(specifier).add(word); //This is so fascinating, the ".get" method returns the arrayList so that we can add the word to the arrayList at the specififc key in the hashmap.

        }
        System.out.println("File read success!");
        fsc.close();
        return wordsMapped;
    }
}