import java.util.Random;
import java.util.ArrayList;

public abstract class Pet {
    private String name;
    private Random brain;
    private int needFood, needSleep, needAttention;

    /**
     * Default constructor for the abstract pet.
     */
    public Pet (){
        this("Name");
    }
    /**
     * Non-default constructor for the abstract pet.
     * @param name
     */
    public Pet (String name){
        setName(name);
        brain = new Random();
    }
    /**
     * Getter for the brain object.
     * @return - the random object.
     */
    public Random getBrain(){
        return brain;
    }
    /**
     * Getter for the name of the pet.
     * @return - name of the pet.
     */
    public String getName(){
        return name;
    }
    /**
     * Setter for the name of the pet.
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Getter for our needFood level in the pet.
     * @return - the needFood level.
     */
    public int getNeedFood(){
        return needFood;
    }
    /**
     * Setter for our needFood level in the pet.
     * @param needFood - the needFood level being changed.
     */
    public void setNeedFood(int needFood){
        if (needFood > 10){
            needFood = 10;
        } else if (needFood < 0){
            needFood = 0;
        } else {
            this.needFood = needFood;
        }
    }

    /**
     * Getter for our needSleep level in the pet.
     * @return - the needSleep level.
     */
    public int getNeedSleep(){
        return needSleep;
    }
    /**
     * Setter for our needSleep level in the pet.
     * @param needSleep - the needSleep level being changed.
     */
    public void setNeedSleep(int needSleep){
        if (needSleep > 10){
            needSleep = 10;
        } else if (needSleep < 0){
            needSleep = 0;
        } else {
            this.needSleep = needSleep;
        }
    }

    /**
     * Getter for our needAttention level in the pet.
     * @return - the needAttention level being changed.
     */
    public int getNeedAttention(){
        return needAttention;
    }
    /**
     * Setter for our needAttention level in the pet.
     * @param needAttention - the needAttention level being changed.
     */
    public void setNeedAttention(int needAttention){
        if (needAttention > 10){
            needAttention = 10;
        } else if (needAttention < 0){
            needAttention = 0;
        } else {
            this.needAttention = needAttention;
        }
    }

    /**
     * Our act method for our abstract pet, that will put the pets actions inside of the ArrayList<String>.
     * @return - the ArrayList full of the pets activities.
     */
    public ArrayList<String> act(){
        ArrayList<String> actions = new ArrayList<String>();
        int decider = brain.nextInt(10);
        if (decider < needFood){
            actions.add("The " + getType() +", " + getName() + ", " + "ate.");
        }
        decider = brain.nextInt(10);
        if (decider < needSleep){
            actions.add("The " + getType() +", " + getName() + ", " + "slept.");
        }
        decider = brain.nextInt(10);
        if (decider < needAttention){
            actions.add("The " + getType() +", " + getName() + ", " + "sought your attention.");
        }
        return actions;
    }
    /**
     * The toString method for our pet.
     */
    public String toString(){
        return String.format("%s", name);
    }
    /**
     * The abstract initializeCutoffs that will be created separately in our descendant classes.
     * This will set our needFood, needSleep, and needAttention levels for each instantiation of the pets.
     */
    public abstract void initializeCutoffs(); // Set needFood, needSleep, needAttention

    /**
     * The abstract getType method that will be created separately in our descendant classes.
     * @return - the type of the animal.
     */
    public abstract String getType(); // What kind of pet this is

}
