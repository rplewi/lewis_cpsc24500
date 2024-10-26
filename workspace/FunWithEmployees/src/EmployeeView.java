import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * This view vlass displays the details fo the Employee model.
 * 
 */
public class EmployeeView {
    /**
     * Writes a list of employees to the screen.
     * @param emps - the list of employees
     */
    public void writeToScreen(ArrayList<Employee> emps){
        for (Employee emp : emps){
            System.out.println(emp);
         }

    }
    /**
     * Writes to a file, Returns true if successful
     * @param emps - list of employees
     * @param fileName - name of file that is to be written on
     * @return - true or false if able to write.
     */
    public boolean writeToFile(ArrayList<Employee> emps, String fileName){
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fileName))));
            for (Employee emp : emps){
                pw.println(emp);
            }
            return true;
        } catch (Exception ex){
            return false;
        }

    }
}
