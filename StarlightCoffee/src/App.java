import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * Roman Lewis
 * Starlight Coffee (Description Here)
 * Date: Day 7 October 2024
 */

public class App {
    /**
     * this method allows the user to see the nice STARLIGHT COFFEE banner at the beginning of the program.
     * No input here.
     */
    public static void printBanner(){
        for (int i = 0; i < 44; i++){
            System.out.print("*");
        }
        String centeredString = "STARLIGHT COFFEE";
        System.out.format("\n%30s", centeredString + "\n");
        for (int i = 0; i < 44; i++){
            System.out.print("*");
        } 
    }
    /**
     * This prints out the start of the program, and asks the user for their choice of coffee.
     * No input here.
     */
    public static void printMenu(){
        System.out.println("\nWhat kind of coffee do you want?");
        System.out.println("1. Americano");
        System.out.println("2. Italiano");
        System.out.println("3. Espresso");
        System.out.println("4. Cappucino");
        System.out.println("Enter the number of your choice:");
    }
    /**
     * This prints the prompt when it asks the user for the size of the drink, also de-clutters main
     * No input here.
     */
    public static void printSize(){
        System.out.println("What size do you want?");
        System.out.println("1. Tall");
        System.out.println("2. Grande");
        System.out.println("3. Venti");
        System.out.println("Enter then number of your choice: ");

    }
    /**
     * This prints the "tip menu" allowing the person to see it, de-clutters main method
     * No input here
     */
    public static void printTip(){
        System.out.println("What size tip would you like to leave?");
        System.out.println("1. Good Service - 10%");
        System.out.println("2. Great Service - 15%");
        System.out.println("3. Outstanding Service - 20%");
        System.out.println("Enter the number of your choice: ");
    }
    /**
     * This method allows us to calculate the tip that the person chose, this is using the choice that they made
     * and also the cost of their drink to calculate the tip amount.
     * @param drinkCost
     * @param choice
     * @return
     */
    public static double calculateTip(double drinkCost, int choice){
        double tipAmt = 0.0;
        switch (choice){
            case 1:
                    tipAmt = drinkCost * .1;
                    break;
            case 2:
                    tipAmt = drinkCost * .15;
                    break;
            case 3:
                    tipAmt = drinkCost * .2;
                    break;
        }  
        return tipAmt;
    }
    /**
     * This method calculates the price of the drink that you ordered, depending on the specific
     * drink, size, amount of espresso shots. It then returns it to the main method so it can be displayed
     * @param choice
     * @param size
     * @param extraShots
     * @param Member
     * @return
     */
    public static double calculateDrinkCost(int choice, int size, int extraShots, boolean Member){
        double sizeCharge = 0.0, shotsPrice = 0.0, drinkCost = 0.0;
        shotsPrice = extraShots * .5;
        // This switch will calculate how much the drink costs
        switch (size) {
            // No upcharge
            case 1:
                    if (choice == 1){
                        sizeCharge = shotsPrice + 0;
                        drinkCost = sizeCharge + shotsPrice + 2.25;
                        break;
                    } else if (choice == 2){
                        sizeCharge = shotsPrice + 0;
                        drinkCost = sizeCharge + shotsPrice + 2.75;
                        break;
                    } else if (choice == 3){
                        sizeCharge = shotsPrice + 0;
                        drinkCost = sizeCharge + shotsPrice + 3.50;
                        break;
                    } else if (choice == 4){
                        sizeCharge = shotsPrice + 0;
                        drinkCost = sizeCharge + shotsPrice + 3.75;
                        break;
                    }
            // 20% upcharge
            case 2:
                if (choice == 1){
                    sizeCharge = (2.25) * .2;
                    drinkCost = sizeCharge + 2.25 + shotsPrice;
                    break;
                } else if (choice == 2 ){
                    sizeCharge = (2.75) * .2;
                    drinkCost = sizeCharge + 2.75 + shotsPrice;
                    break;
                } else if (choice == 3){
                    sizeCharge = (3.50) * .2;
                    drinkCost = sizeCharge + 3.50 + shotsPrice;
                    break;
                } else if (choice == 4){
                    sizeCharge = (3.75) * .2;
                    drinkCost = sizeCharge + 3.75 + shotsPrice;
                    break;
                }
            // 40% upcharge
            case 3:
                if (choice == 1){
                    sizeCharge = (2.25) * .4 ;
                    drinkCost = sizeCharge + 2.25 + shotsPrice;
                    break;
                } else if (choice == 2 ){
                    sizeCharge = (2.75) * .4;
                    drinkCost = sizeCharge + 2.75 + shotsPrice;
                    break;
                } else if (choice == 3){
                    sizeCharge = (3.50) * .4;
                    drinkCost = sizeCharge + 3.50 + shotsPrice;
                    break;
                } else if (choice == 4){
                    sizeCharge = (3.75) * .4;
                    drinkCost = sizeCharge + 3.75 + shotsPrice;
                    break;
                }
        }
        return drinkCost;

    }
    /**
     * Gives you a nice readable printout of the price of everything in your bill.
     * @param drink
     * @param discount
     * @param tipAmount
     * @param taxes
     * @param total
     */
    public static void printBill(double drink, double discount, double tipAmount, double taxes, double total, String name){
        System.out.println("Here is your bill, " + name);
        System.out.printf("\nBeverage:      $%.2f ", drink);
        System.out.printf("\nClub Discount: $%.2f ", discount);
        System.out.printf("\nTip Amount:    $%.2f ", tipAmount);
        System.out.printf("\nTaxes:         $%.2f ", taxes);
        System.out.printf("\nTotal:         $%.2f ", total);
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int choice, size, extraShots = 0, choiceTip;
        boolean isFinished = false, member = false;
        String memberString = "";
        double tip, drinkCost, taxes, total, memDis;

        String name;

        // While loop that runs if the user inputs anything incorrectly, restarting it to go again.
        while (!isFinished){

            printBanner();

            System.out.println("\nWhat is your name? ");
            name = sc.nextLine();

            printMenu();

            choice = sc.nextInt();
            if (choice <= 0 || choice > 4){
                System.out.println("Please use the correct input and try again!\n");
                // Clears input buffer
                sc.nextLine();
                // Skips current loop and restarts it.
                continue;
            }
            System.out.println();
            printSize();
            size = sc.nextInt();
            // Checks if size is out of bounds
            if (size <= 0 || size > 3){
                System.out.println("Please use the correct input and try again!\n");
                sc.nextLine();
                // Skips current loop and restarts it.
                continue;
            }
            System.out.println();
            System.out.println("\nHow many extra shots of espresso would you like?");
            // Clear Input Buffer
            try {
                extraShots = sc.nextInt();
            } catch (InputMismatchException ex){
                System.out.println("Please use the correct input and try again!\n");
                // Clear buffer
                sc.nextLine();
                continue;
            }
            sc.nextLine();
            // Checks if the extra shots amount is negative or someting is incorrect.
            if (extraShots < 0){
                System.out.println("Please use the correct input and try again!\n");
                continue;
            }
            System.out.println("Are you a member of Starlight Stars? (y or n)");
            memberString = sc.nextLine();
            // Checks which input the user entered
            if (memberString.equalsIgnoreCase("y")){
                member = true;
            } else if (memberString.equalsIgnoreCase("n")){
                member = false;
            } else {
                // Restarts loop if someone entered something wrong
                System.out.println("Please use the correct input and try again!\n");
                // Clears input buffer
                sc.nextLine();
                continue;
            }

            drinkCost = calculateDrinkCost(choice, size, extraShots, member);
            if (member){
                memDis = drinkCost * .10;
            } else {
                memDis = 0;
            }
            
            printTip();

            choiceTip = sc.nextInt();

            tip = calculateTip(drinkCost, choiceTip);

            taxes = (drinkCost - memDis) * .0875;

            total = taxes + tip + drinkCost - memDis;

            printBill(drinkCost, memDis, tip, taxes, total, name);

            isFinished = true;
        }
        System.out.println("\n\nThank you for using Starlight Coffee!\n");
    }
}
