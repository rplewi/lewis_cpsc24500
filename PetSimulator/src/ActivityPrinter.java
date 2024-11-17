import java.util.ArrayList;

public class ActivityPrinter {
    /**
     * The activity printer that will be used in our main method after we have added the pet's activities to the list.
     * @param activities - the ArrayList<ArrayList<String>> that we will be printing. 
     */
    public static void printActivities(ArrayList<ArrayList<String>> activities){

        for (int i = 0; i < activities.size(); i++){
            System.out.format("%25s *** Hour: %d ***%n", "", (i+1));
            ArrayList<String> thisHour = activities.get(i);
            for (String act : thisHour){
                System.out.println(act);
            }
            System.out.println();
        }
    
    }
    
}
