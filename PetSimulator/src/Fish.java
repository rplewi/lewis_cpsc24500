import java.util.ArrayList;

public class Fish extends Pet {
    private int needSwim;

    /**
     * Getter for our swim value
     * @return - swim level
     */
    public int getNeedSwim(){
        return needSwim;
    }
    /**
     * Setter for our swim value
     * @param needSwim - new swim value
     */
    public void setNeedSwim(int needSwim){
        if (needSwim > 10){
            this.needSwim = 10;
        } else if (needSwim < 0){
            this.needSwim = 0;
        } else {
            this.needSwim = needSwim;
        }
    }
    /**
     * Default constructor for our Fish object.
     */
    public Fish(){
        this("Fish");
    }
    /**
     * Non-default constructor for our Fish object.
     * @param fishName - The name of the fish.
     */
    public Fish (String fishName){
        super(fishName);
        initializeCutoffs();
    }

    @Override
    public String getType(){
        return "Fish";
    }

    @Override
    public void initializeCutoffs(){
        setNeedFood(3);
        setNeedSleep(1);
        setNeedAttention(0);
        setNeedSwim(9);
    }

    @Override
    public ArrayList<String> act(){
        ArrayList<String> result = super.act();
        int decider = getBrain().nextInt(10);
        if (decider < needSwim){
            result.add("The " + getType() +", " + getName() + ", " + "swam around its bowl.");
        }
        return result;
    }
}
