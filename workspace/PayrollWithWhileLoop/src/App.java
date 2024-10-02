import java.util.Scanner;

/**
 * User will indicate they have more employees to process.
 * and we'll keep processing them until they tell us to stop.
 * This illustrates a while loop
 */

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String doAgain = "y";
        double payRate, hoursWorked, grossPay;
        while (doAgain.equals("y")){
            System.out.print("Enter hours worked and pay rate (Separated by a space): ");
            hoursWorked = sc.nextDouble();
            payRate = sc.nextDouble();
            grossPay = hoursWorked * payRate;
            System.out.printf("Pay this employee $%.2f.\n", grossPay);
            System.out.print("Do you have another employee (y or n): ");
            doAgain = sc.next().toLowerCase().trim();
        
        }
        System.out.println("Thank you for using the program");

    }
}
