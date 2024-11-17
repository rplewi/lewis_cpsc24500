import java.util.Scanner;
import java.util.ArrayList;


public class App {

    /**
     * This method prints a banner for the terminal window!
     */
    public static void printHeading(){
        System.out.println("**********************************************************************************");
        System.out.println("Welcome to Pet Simulator. This tool simulates the activities of three kinds of");
        System.out.println("pets: dogs,cats, and fish. Each pet may sleep, eat, and seek your attention");
        System.out.println("for some part of the day. And each pet will do things specific to what kind of");
        System.out.println("pet they are.");
        System.out.println("**********************************************************************************");
    }
    /**
     * This method will be what will deliver our user's pet simulator!
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        printHeading();
        Scanner sc = new Scanner(System.in);
        int hourCount = 1;
        ArrayList<Pet> pets = new ArrayList<Pet>();

        System.out.print("\nEnter the dog's name: ");
        Dog dog = new Dog(sc.nextLine());
        pets.add(dog);

        System.out.print("\nEnter the cat's name: ");
        Cat cat = new Cat(sc.nextLine());
        pets.add(cat);

        System.out.print("\nEnter the fish's name: ");
        Fish fish = new Fish(sc.nextLine());
        pets.add(fish);

        PetSimulator ps = new PetSimulator(pets);

        ArrayList<ArrayList<String>> activities = new ArrayList<ArrayList<String>>();
        System.out.println("\nNow lets simulate!");
        System.out.println();

        do {
            System.out.print("\nHow many hours of their lives would you like to play out? ");
            try {
            hourCount = sc.nextInt();
            } catch (Exception ex){
                System.out.println("Please make sure you are using the correct input and try again!");
                sc.next(); // Clears input scanner, so we dont get an infinite loop.
                continue;
            }
            if (hourCount >  0 ){
                System.out.println("Heres what the rascals did ...\n");
                activities = ps.simulate(hourCount);
                ActivityPrinter.printActivities(activities);
            }
        } while (hourCount > 0);
        System.out.println("Thank you for using this program.");
        sc.close();


        


    }
}
