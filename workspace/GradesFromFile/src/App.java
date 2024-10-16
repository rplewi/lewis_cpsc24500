import java.util.Scanner;
import java.io.File;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the file of grades: ");
        String fname = sc.nextLine();
        Scanner fsc = null;
        while (fsc == null){
            try{
                fsc = new Scanner(new File(fname));
            } catch (Exception ex){
                System.out.println("The file could not be opened. Try again!");
            }
        }
        String line, name;
        String[] parts;
        double total, avg;
        while (fsc.hasNextLine()){
            line = fsc.nextLine().trim(); // Read the line, take away leading and trailing white space.
            if (line.length() > 0){ //  If the line is NOT empty.
                parts = line.split("\t");
                name = parts[0];
                total = 0;
                for (int i = 1; i < parts.length; i++){
                    total += Double.parseDouble(parts[i]);
                }
                avg = total / (parts.length - 1);
                System.out.printf("%-12s%5.2f\n", name, avg);
            }
        }
        fsc.close();
    }
}
