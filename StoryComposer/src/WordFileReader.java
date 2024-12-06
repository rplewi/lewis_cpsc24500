import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.LinkedHashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class WordFileReader{
    /**
     * This method will be called when we want to create a LinkedHashMap with the word file provided.
     * This code is also reused from my StoryTeller applicaion
     * @return - the LinkedHashMap that will be used for our StoryWriter object!
     */
    public LinkedHashMap<String, ArrayList<String>> readFile(File file){
        String line, word, specifier;
        String[] parts;
        LinkedHashMap<String, ArrayList<String>> wordsMapped = new LinkedHashMap<String, ArrayList<String>>();
        Scanner fsc = null; // Initialize this so it doesn't throw errors, reassign later.
        try {
            fsc = new Scanner(file);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File not found");
        }
        while (fsc.hasNextLine()){
            line = fsc.nextLine().trim();
            if (line.isEmpty()){
                continue;
            }
            parts = line.split("\t");
            word = parts[0];
            specifier = parts[1]; 
            if (!wordsMapped.containsKey(specifier)){
                wordsMapped.put(specifier, new ArrayList<String>());
            }
            wordsMapped.get(specifier).add(word); 
        }
        fsc.close();
        return wordsMapped;
    }
}
