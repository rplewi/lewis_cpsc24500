import java.util.ArrayList;
import java.util.Random;

/**
 * Calculate and print the paychecks for a list of employees.
 * This class keeps track of taxes and can assign specified bonuses randomly to employees.
 */

public class PayrollTool {
    private Random rnd;
    private ArrayList<Employee> employees;
    private double taxRate;
    private double bonusPercentage;
    private int bonusFrequency; // 0 - 10 (10 - everyone gets a bonus, 0 - means no one does.)
    public ArrayList<Employee> getEmployee(){
        return employees;
    }
    public void setEmployees(ArrayList<Employee> emps){
        employees = emps;
    }
    public double getTaxRate(){
        return taxRate;
    }
    public void setTaxRate(double taxRate){
        if (taxRate > 1){
            this.taxRate = 1.0;
        } else if (taxRate < 0){
            this.taxRate = 0.0;
        } else {
            this.taxRate = taxRate;
        }
    }
    public double getBonusPercentage(){
        return bonusPercentage;
    }
    public void setBonusPercentage(double bPCT){
        if (bPCT > 1){
            this.bonusPercentage = 1.0;
        } else if (bPCT < 0){
            this.bonusPercentage = 0.0;
        } else {
            this.bonusPercentage = bPCT;
        }
    }
    public int getBonusFrequency(){
        return bonusFrequency;
    }
    public void setBonusFrequency(int bF){
        if (bF > 10){
            this.bonusFrequency = 10;
        } else if(bF < 0){
            this.bonusFrequency = 0;
        } else{
            this.bonusFrequency = bF;
        }
    }
    public PayrollTool(){
        this(new ArrayList<Employee>(),0.1,0.1,5); //Call default constructor but using default values, using the "this" keyword.
    }
    public PayrollTool(ArrayList<Employee> emps, double taxRate, double bonusPercentage, int bonusFrequency){
        setEmployees(emps);
        setTaxRate(taxRate);
        setBonusFrequency(bonusFrequency);
        setBonusPercentage(bonusPercentage);
        rnd = new Random();
    }
    public void processPayroll(){
        double gross, taxes, bonus, adjGross, net;
        int randomNumber;
        for (Employee emp : employees){
            gross = emp.getPayRate() * emp.getHoursWorked();
            randomNumber = rnd.nextInt(10);
            // Very similar to our homework, scale of 1 - 10 , less than the frequency of adjective, include adjective in the sentence, if not then dont.
            if (randomNumber < bonusFrequency){
                bonus = bonusPercentage * gross;
            } else {
                bonus = 0.0;
            }
            adjGross = gross + bonus; 
            taxes = adjGross * taxRate;
            net = adjGross - taxes;
            System.out.printf("%-15s %-15s %10.2f %10.2f %10.2f %10.2f %10.2f\n", emp.getFirstName(), emp.getLastName(), gross, bonus, adjGross, taxes, net);
        }
    }
}
