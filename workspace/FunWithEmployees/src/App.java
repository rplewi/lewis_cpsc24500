import java.util.ArrayList;
import java.util.Scanner;

public class App {
    /*This plays the role of the Controller (where the model and view come togher
     * Very common in small apps for the main class to be the controller.
    ) */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Specify the name of the file: ");
        String fName = sc.nextLine();
        // Default employee constructor
        Employee emp1 = new Employee();
        // Non-default employee constructor
        Employee emp2 = new Employee("Roman", "Lewis", 55.00, 2);
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(emp1);
        employees.add(emp2);
        EmployeeView view = new EmployeeView();
        view.writeToScreen(employees);

        if (view.writeToFile(employees, fName)){
            System.out.println("The employees were written to a file.");
        } else {
            System.out.println("The employees could not be writter.");
        }
    }
}
