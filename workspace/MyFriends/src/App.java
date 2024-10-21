import java.util.ArrayList;
import java.util.Scanner;
/**
 * Maintains a list of friends' names using an ArrayList
 */
public class App {
    public static void printMenu(){
        System.out.println("\nHere are your options:");
        System.out.println("1. Add a friend.");
        System.out.println("2. Remove a friend.");
        System.out.println("3. List of friends.");
        System.out.println("4. Find a friend.");
        System.out.println("5. Edit a friend.");
        System.out.println("6. Clear our list of friends.");
        System.out.println("7. Exit.");
        System.out.print("Enter the number of your choice: ");
    }

    public static void printFriends(ArrayList<String> friends, ArrayList<String> phones){
        for (int i = 0; i < friends.size(); i++){
            System.out.printf("%d. %s - %s\n", (i+1), friends.get(i), phones.get(i));
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
        ArrayList<String> phones = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        int choice = 0, foundAt = 0, editNum = 0;
        String friendName, phone = "";

        do {
            printMenu();
            choice = sc.nextInt();
            if (choice == 1){
                System.out.print("Enter the name of the friend you want to add: ");
                sc.nextLine();
                friendName = sc.nextLine();
                System.out.print("Enter their phone number: ");
                phone = sc.nextLine();
                friends.add(friendName);
                phones.add(phone);

            } else  if (choice == 2){
                System.out.print("Enter the name of the person whos politics you disagree with: ");
                sc.nextLine();
                friendName = sc.nextLine();
                foundAt = findFriend(friends, friendName);
                if (foundAt >= 0){
                    friends.remove(foundAt);
                    phones.remove(foundAt);
                } else {
                    System.out.println("That friend was not found.");
                }
            } else if (choice == 3){
                printFriends(friends, phones);
            } else if (choice == 4){
                System.out.print("Enter the friend to find: ");
                sc.nextLine();
                friendName = sc.nextLine();
                foundAt = findFriend(friends, friendName);
                if (foundAt < 0){
                    System.out.println("Not found!");
                } else{
                    System.out.printf("Found at %d.\n", (foundAt + 1));
                }
            } else if (choice == 5){
                printFriends(friends, phones);
                System.out.print("Enter the number of the friend to edit: ");
                editNum = sc.nextInt();
                while (editNum > friends.size() || editNum <= 0){
                    System.out.println("There is no such friend. Try again.");
                    System.out.print("Enter the name of the friend to edit.");
                    editNum = sc.nextInt();
                }
                System.out.print("Enter the new name for that friend");
                sc.nextLine();
                friendName = sc.nextLine();
                friends.set(editNum-1, friendName);
            } else if(choice == 6){
                friends.clear();
            } else if (choice != 7){
                System.out.println("That is an invalid choice.");
            }
        } while(choice != 7);
    }
}
