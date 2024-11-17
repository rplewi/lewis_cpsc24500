import java.util.ArrayList;

public class PetSimulator {

    private ArrayList<Pet> pets;
    /**
     * Getter for our pet ArrayList.
     * @return - our pets ArrayList.
     */
    public ArrayList<Pet> getPets(){
        return pets;
    }
    /**
     * Setter for our pet ArrayList.
     * @param pets - the pet ArrayList being set.
     */
    public void setPets(ArrayList<Pet> pets){
        this.pets = pets;
    }

    /**
     * Our non-default constructor for our Pet Simulator object
     * @param pets - our ArrayList<Pet> that will be used to start creating their actions!
     */
    public PetSimulator(ArrayList<Pet> pets){
        setPets(pets);
    }
    /**
     * Default constructor for our Pet Simulator object.
     */
    public PetSimulator(){
        this(null);
    }
    /**
     * The simulate method will be what creates our pets actions, and then adding them to an ArrayList<ArrayList<String>>.
     * @param hourCount - The amount of hours that we will be simulating.
     * @return - the ArrayList<ArrayList<String> that will be used in our ActivityPrinter.
     */
    public ArrayList<ArrayList<String>> simulate(int hourCount){
        ArrayList<ArrayList<String>> hourlyActivity = new ArrayList<ArrayList<String>>();

        for (int i = 0; i < hourCount; i++){
            ArrayList<String> thisHoursActivities = new ArrayList<String>();
            for (Pet pet : pets){
                ArrayList<String> thisPetsActivitiesThisHour = pet.act();
                thisHoursActivities.addAll(thisPetsActivitiesThisHour);
            }
            hourlyActivity.add(thisHoursActivities);
        }
        return hourlyActivity;
    }
}
