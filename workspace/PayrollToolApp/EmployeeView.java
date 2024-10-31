import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 * This view class displays the details of the Employee model,
 * both to the screen and to a file.
 */
public class EmployeeView {
    /**
     * Writes a list of employees to the screen
     * @param emps - the list of employees
     */
    public static void writeToScreen(ArrayList<Employee> emps) {
        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }
    /**
     * Writes to a file. Returns true if successful
     * @param emps - the employees to print
     * @param fileName - the name of the file to create
     * @return true if successful, false if there was an error
     */
    public static boolean writeToFile(ArrayList<Employee> emps, String fileName) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fileName))));
            for (Employee emp : emps) {
                pw.println(emp);
            }
            pw.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
