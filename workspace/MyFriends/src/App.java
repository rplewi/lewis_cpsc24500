import java.util.ArrayList;
import java.util.Scanner;
/**
 * Maintains a list of friends' names using an ArrayList
 */
public class App {
    public static void printMenu(){
        System.out.println("Here are your options:");
        System.out.println("1. Add a friend.");
        System.out.println("2. Remove a friend.");
        System.out.println("3. List of friends.");
        System.out.println("4. Find a friend.");
        System.out.println("5. Exit.");
        System.out.print("Enter the number of your choice: ");
    }

    public static void printFriends(ArrayList<String> friends){
        // "String friend" is the shapeshifter variable that will take the identity of the friends variable it is in.
        for (String friend : friends){
            System.out.println(friend);
        }
    }
    /**
     * returns the place in the ArrayList where the name was found or -1 if not found.
     * @param friends - list of friends names
     * @param toFind - name to find
     * @return - "-1" if not found, position if found
     */
    public static int findFriend(ArrayList<String> friends, String toFind){
        return friends.indexOf(toFind);
    }
    public static void main(String[] args) throws Exception {
        ArrayList<String> friends = new ArrayList<String>(); // Size is 0 because it is first initialized.
        Scanner sc = new Scanner(System.in);
        int choice = 0, foundAt = 0;
        String friendName;

        do {
            printMenu();
            sc.nextInt();
            if (choice == 1){
                System.out.print("Enter the name of the friend you want to add: ");
                sc.nextLine();
                friendName = sc.nextLine();
                friends.add(friendName);

            } else  if (choice == 2){
                System.out.print("Enter the name of the person whos politics you disagree with: ");
                sc.nextLine();
                friendName = sc.nextLine();
                friends.remove(friendName);

            } else if (choice == 3){
                printFriends(friends);

            } else if (choice == 4){
                System.out.print("Enter the friend to find: ");
                sc.nextLine();
                friendName = sc.nextLine();
                foundAt = findFriend(friends, friendName);
                if (foundAt < 0){
                    System.out.println("Not found!");
                } else{
                    System.out.printf("Found at %d.\n", foundAt);
                }
            }
        } while(choice != 5);
    }
}
