import java.util.Scanner;
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
     * The main constructor class for our Author object!
     * @param wordsMapped - LinkedHashMap of Strings, and ArrayLists.
     * @param adjective - Frequency of adjectives in the story.
     * @param adverbs - Frequency of adverbs in the story.
     * @param prepositions - Frequency of prepositions in the story.
     */
    public Author(LinkedHashMap<String, ArrayList<String>> wordsMapped, int adjective, int adverbs, int prepositions){
        this.wordsMapped = wordsMapped;
        setAdj(adjective);
        setAdv(adverbs);
        setPrepositions(prepositions);
        rnd = new Random();
    }
    /**
     * This is the default constructor for Author if no prepositions, adjectives, or adverbs were speficied
     * @param wordsMapped
     */
    public Author(LinkedHashMap<String, ArrayList<String>> wordsMapped){
        this(wordsMapped, 5, 5, 5);

    }
    public int getAdj(){
        return adjective;
    }
    public void setAdj(int adj){
        if (adj > 10){
            this.adjective = 10;
        } else if (adj < 0){
            this.adjective = 0;
        } else {
            this.adjective = adj;
        }
    }
    public int getAdv(){
        return adverbs;
    }
    public void setAdv(int adv){
        if (adv > 10){
            this.adverbs = 10;
        } else if (adv < 0){
            this.adverbs = 0;
        } else {
            this.adverbs = adv;
        }
    }
    public int getPrepositions(){
        return prepositions;
    }
    public void setPrepositions(int prep){
        if (prep > 10){
            this.prepositions = 10;
        } else if (prep < 0){
            this.prepositions = 0;
        } else {
            this.prepositions = prep;
        }
    }



}
