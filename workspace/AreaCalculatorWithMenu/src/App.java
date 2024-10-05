import java.util.Scanner;

/**
 * This program calculates the area of circles and rectangles
 * it illustrates using a menu with a do loop
 * @author Roman Lewis
 */

public class App {
    /**
     * This method prints a welcome banner
     */
    public static void printHeading(){
        System.out.println("************************************");
        System.out.println("        AREA CALCULATOR V1.0        ");
        System.out.println("************************************");
    }

    public static void printMenu(){
        System.out.println("What kind of shape do you want?");
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Quit");
        System.out.println("Enter the number of your choice.");
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        printHeading();
        int choice = 0;
        double radius = 0.0, area = 0.0, width = 0.0, length = 0.0;
    
        

        do {
            printMenu();
        while (choice == 0) {
                try {

                // Grabs choice from user.
                choice = sc.nextInt();

                }catch (Exception ex){
                    System.out.println("You needed to enter an integer");
                    choice = 0;
                    sc.nextLine(); // Clear the input channel of the gatbage that's currently on it.
                }
            }
                if (choice == 1){
                    // Process a circle
                    System.out.print("Enter the circle's radius: ");
                    radius = sc.nextDouble();
                    area = Math.PI * radius * radius;
                    System.out.printf("The circle with radius %.2f has area %.2f.\n", radius, area);
                    System.out.println();

                } else if(choice == 2){
                    // Process a rectangle
                    System.out.print("Enter the width and length of the rectangle (Separated by a space): ");
                    width = sc.nextDouble();
                    length = sc.nextDouble();
                    System.out.printf("The rectangle with width %.2f and length %.2f has area %@2f.\n", width, length, area);
                    System.out.println();

                } else if (choice != 3){
                    System.out.println("You ened to follow directions!");
                    System.out.println();
                }

            System.out.println("Goodbye!");
        }
    }

}
