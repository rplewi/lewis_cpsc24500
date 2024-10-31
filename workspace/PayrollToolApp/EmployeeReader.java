import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
public class EmployeeReader {
    public ArrayList<Employee> readEmployeesFromSpaceDelimitedTextFile(String fileName) {
        try {
            Scanner fsc = new Scanner(new File(fileName));
            ArrayList<Employee> result = new ArrayList<Employee>();
            String line;
            String[] parts;
            String firstName, lastName;
            double hours, rate;
            Employee emp;
            while (fsc.hasNextLine()) {
                line = fsc.nextLine().trim();
                if (line.length() == 0) {
                    continue;  // go back to the top of the while loop
                }
                parts = line.split(" ");
                firstName = parts[0];
                lastName = parts[1];
                hours = Double.parseDouble(parts[2]);
                rate = Double.parseDouble(parts[3]);
                emp = new Employee(firstName,lastName,rate,hours);
                result.add(emp);
            }
            fsc.close();
            return result;
        } catch (Exception ex) {
            return null;   // I failed to read the file, so return null as an indicator that no list could be returned
        }
    }
}
