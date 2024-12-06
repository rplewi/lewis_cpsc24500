import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

/**
 * Our WordChooser class will be what is used to get the words from our LinkedHashMap, with the kind of word the user specified.
 */
public class WordChooser {
    private LinkedHashMap<String, ArrayList<String>> wordList;
    private Random rnd;

    /**
     * Gets our List of words
     * @return - the LinkedHashMap of <String, ArrayList<String>>
     */
    public LinkedHashMap<String, ArrayList<String>> getList(){
        return wordList;
    }
    /**
     * Sets our list of words
     * @param wordList - the LinkedHashMap of <String, ArrayList<String>>
     */
    public void setList(LinkedHashMap<String, ArrayList<String>> wordList){
        this.wordList = wordList;
    }
    /**
     * Non-default constructor for our wordChooser, we don't really need a default one.
     * @param wordList
     */
    public WordChooser(LinkedHashMap<String, ArrayList<String>> wordList){
        setList(wordList);
        rnd = new Random();
    }
    
    /*
     * This code below is reused from my Story Teller program, just changed a little bit of the variables.
     * This time it takes in just the specifier and makes it easier to get the word requested.
     */
    public String chooseWord(String specifier){
        ArrayList<String> words; 
        rnd = new Random();
        if (wordList.containsKey(specifier)){
            words = wordList.get(specifier);
            // Reassigns the words ArrayList to the arrayList from the HashMap.
            return words.get(rnd.nextInt(words.size())); // This will get us the word randomly from the list.
        } else {
            return "";
        }
            }
}
