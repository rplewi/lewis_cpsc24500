import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void getEmployeeInformation(Scanner sc, ArrayList<Employee> employees, int empCount){
        String first, last;
        double payRate, hoursWorked;
        Employee emp;
        
        for (int i = 0; i < empCount; i++){
            System.out.print("\nEnter first and last name followed by hours worked and pay rate: ");
            first = sc.next();
            last = sc.next();
            hoursWorked = sc.nextDouble();
            payRate = sc.nextDouble();
            emp = new Employee(first, last, payRate, hoursWorked);
            employees.add(emp);

        }
    }
    public static void main(String[] args) throws Exception {
        int empCount = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount of employees you have: ");
        empCount = sc.nextInt();
        ArrayList<Employee> employees = new ArrayList<Employee>();
        getEmployeeInformation(sc, employees, empCount);
        EmployeeView.writeToScreen(employees);
        PayrollTool pt = new PayrollTool(employees, 0.1, 0.1, 5);
        pt.processPayroll();
    }
}
