import java.util.Scanner;

/**
 * This application processes payroll for a set number of employees
 * It illustrates using a for loop.
 */


public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many employees do you need to do payroll for: ");
        int empCount = sc.nextInt();
        double payRate, hoursWorked, grossPay;
        for (int i = 0; i < empCount; i++){
            System.out.printf("Employee #%d\n", (i + 1));
            System.out.print("Enter hours worked and pay rate (separated by a space)");
            hoursWorked = sc.nextDouble();
            payRate = sc.nextDouble();
            grossPay = hoursWorked * payRate;
            System.out.printf("Pay this employee $%.2f.\n", grossPay);
        }
    }
}
