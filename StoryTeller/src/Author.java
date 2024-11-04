import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Random;

public class Author {
    private LinkedHashMap<String, ArrayList<String>> wordsMapped;
    private Random rnd;
    private int adjective;
    private int adverbs;
    private int prepositions;
    
    /**
     * This is the non-default constructor for Author, which takes in the wordsMapped LinkedHashMap.
     */
    public Author(LinkedHashMap<String, ArrayList<String>> wordsMapped){
        this.wordsMapped = wordsMapped;
        rnd = new Random();
    }
    /**
     * This is the default constructor for Author, if no parameters were specified.
     */
    public Author(){
        this(null);
    }
    /**
     * get method for our linkedHashMap
     * @return - the linkedHashMap
     */
    public LinkedHashMap<String, ArrayList<String>> getWordsMapped() {
        return wordsMapped;
    }
    /**
     * set method for our linkedHashMap
     * @param wordsMapped - takes in the linkedHashMap from the user.
     */
    public void setWordsMapped(LinkedHashMap<String, ArrayList<String>> wordsMapped) {
        this.wordsMapped = wordsMapped;
    }
    /**
     * Gets the Adjective frequency 
     * @return -  returns the adjective frequency
     */
    public int getAdj(){
        return adjective;
    }
    /**
     * Sets the adjective frequency
     * @param adj - takes in the integer provided by the user.
     */
    public void setAdj(int adj){
        if (adj > 10){
            this.adjective = 10;
        } else if (adj < 0){
            this.adjective = 0;
        } else {
            this.adjective = adj;
        }
    }
    /**
     * Gets the adverb frequency.
     * @return - returns the adverb frequency.
     */
    public int getAdv(){
        return adverbs;
    }
    /**
     * Sets the adverb frequency.
     * @param adv - takes in the integer provided by the user.
     */
    public void setAdv(int adv){
        if (adv > 10){
            this.adverbs = 10;
        } else if (adv < 0){
            this.adverbs = 0;
        } else {
            this.adverbs = adv;
        }
    }
    /**
     * Gets the preposition frequency.
     * @return - returns preposition frequency.
     */
    public int getPrepositions(){
        return prepositions;
    }
    /**
     * Sets the preposition frequency.
     * @param prep - Takes in the integer provided by the user.
     */
    public void setPrepositions(int prep){
        if (prep > 10){
            this.prepositions = 10;
        } else if (prep < 0){
            this.prepositions = 0;
        } else {
            this.prepositions = prep;
        }
    }
    /**
     * This method will return the word at the specific specifier, randomizing the word that it selects from the list!
     * @param specifier - This will be the specific type of word (noun, verb, adjective, adverb, preposition)
     * @return - the word that will be used in the sentence.
     */
    public String getWord(String specifier){
        ArrayList<String> words;
        if (wordsMapped.containsKey(specifier)){
            words = wordsMapped.get(specifier);
            // Reassigns the words ArrayList to the arrayList from the HashMap.
            return words.get(rnd.nextInt(words.size())); // This will get us the word randomly from the list.
        } else {
            return "";
        }
    }
    /**
     * This method will generate the senteces that will be displayed on the screen for the user!
     * @param sentenceCount - Amount of sentences in the story, so we can use it for the loop.
     * @return - The arrayList full of the sentences so we can print them.
     */
    public ArrayList<String> tellStory(int sentCount){
        int chance = 0;
        ArrayList<String> story = new ArrayList<String>();
        String sentence = "";
        // OVERALL FLOW OF THE SENTENCE: "The + {Adjective} + {Noun} + {Verb/ Predicate} + {Adverb} + {Preposition} + THE (if any preposition) + {Noun}"
        for (int i = 0; i < sentCount; i++){
            sentence = ""; //reset the sentence so we dont get duplicate concatenated sentences.
            // Start of the sentence
            sentence += "The";
            chance = rnd.nextInt(10); //reset chance variable
            //adjectives, if any
            if (chance < adjective){
                sentence +=  " " + getWord("adj");
            }
            sentence += " " + getWord("n");
            chance = rnd.nextInt(10); //reset chance variable
            sentence += " " + getWord("v");
            //adverbs, if any
            if (chance < adverbs){
                sentence += " " + getWord("adv");
            }
            chance = rnd.nextInt(10); //reset chance variable
            //prepositions, if any
            if (chance < prepositions){
                sentence += " " + getWord("prep");
                sentence += " the " + getWord("n");
            }
            sentence += ".";
            story.add(i, sentence);
        }
        return story;
    }
}
