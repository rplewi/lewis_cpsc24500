import java.util.ArrayList;

public class Dog extends Pet{
    private int needFetch;
    
    /**
     * Get method for our fetch value.
     * @return - fetch level
     */
    public int getNeedFetch(){
        return needFetch;
    }
    /**
     * Set method for our Fetch value
     * @param fetch - new fetch value
     */
    public void setNeedFetch(int fetch){
        if (fetch > 10){
            needFetch = fetch;
        } else if (fetch < 0){
            needFetch = fetch;
        } else {
            needFetch = fetch;
        }
    }
    /**
     * Default constructor for our Dog Object.
     */
    public Dog(){
        this("Dog");
    }
    /**
     * Non-default constructor for our Dog object.
     * @param name - the name of the Dog.
     */
    public Dog(String name){
        super(name);
        initializeCutoffs();
    }
    
    @Override
    public String getType(){
        return "Dog";
    }

    @Override
    public void initializeCutoffs(){
        setNeedFood(4);
        setNeedSleep(7);
        setNeedAttention(9);
        setNeedFetch(6);
    }
    @Override
    public ArrayList<String> act(){
        ArrayList<String> result = super.act();
        int decider = getBrain().nextInt(10);
        if (decider < needFetch){
            result.add("The " + getType() +", " + getName() + ", " + "played fetch!");
        }
        return result;
    }
}