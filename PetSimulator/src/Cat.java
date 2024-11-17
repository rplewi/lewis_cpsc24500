import java.util.ArrayList;

public class Cat extends Pet {
    private int needScratch;
    
    /**
     * Getter for our scratch value
     * @return - scratch level
     */
    public int getNeedScratch(){
        return needScratch;
    }
    /**
     * Setter for our scratch value
     * @param needScratch - new scratch value
     */
    public void setNeedScratch(int needScratch){
        if (needScratch > 10){
            this.needScratch = 10;
        } else if (needScratch < 0){
            this.needScratch = 0;
        } else {
            this.needScratch = needScratch;
        }
    }
    /**
     * Default constructor for our Cat object.
     */
    public Cat (){
        this("Cat");
    }
    /**
     * Non-default constructor for our Cat object.
     * @param catName - The name of the cat.
     */
    public Cat (String catName){
        super(catName);
        initializeCutoffs();
    }

    @Override
    public String getType(){
        return "Cat";
    }

    @Override
    public void initializeCutoffs(){
        setNeedFood(6);
        setNeedSleep(8);
        setNeedScratch(2);
        setNeedScratch(4);
    }

    @Override
    public ArrayList<String> act(){
        ArrayList<String> result = super.act();
        int decider = getBrain().nextInt(10);
        if (decider < needScratch){
            result.add("The " + getType() +", " + getName() + ", " + "scractched the kitty post.");
        }
        return result;
    }
}
