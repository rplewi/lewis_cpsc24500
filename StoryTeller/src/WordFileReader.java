import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.ArrayList;

public class WordFileReader{
    /**
     * This method will be called when we want to create a LinkedHashMap with the word file provided.
     * @return - the LinkedHashMap that will be used for our Author object!
     */
    public LinkedHashMap<String, ArrayList<String>> readFile(Scanner fsc){
        String line, word, specifier;
        String[] parts;
        LinkedHashMap<String, ArrayList<String>> wordsMapped = new LinkedHashMap<String, ArrayList<String>>();
        
        while (fsc.hasNextLine()){
            line = fsc.nextLine().trim(); // Code is based from passwordGenerator src file!
            if (line.isEmpty()){
                continue;
            }
            parts = line.split(" ");
            word = parts[0];
            specifier = parts[1]; 
            if (!wordsMapped.containsKey(specifier)){ // actually made sure to use the correct list this time for comparison!
                wordsMapped.put(specifier, new ArrayList<String>());
            }
            wordsMapped.get(specifier).add(word); //This is so fascinating, the ".get" method returns the arrayList so that we can add the word to the arrayList at the specififc key in the hashmap.
        }
        fsc.close();
        return wordsMapped;
    }
}