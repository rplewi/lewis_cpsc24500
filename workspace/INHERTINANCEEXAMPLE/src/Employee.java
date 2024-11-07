

public class Employee extends Person{

    private String firstName;
    private String lastName;
    private double hoursWorked;
    private double payRate;

    public double getHoursWorked() {
        return hoursWorked;
    }
    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked < 0) {
            this.hoursWorked = 0;
        } else {
            this.hoursWorked = hoursWorked;
        }
    }
    public double getPayRate() {
        return payRate;
    }
    public void setPayRate(double payRate) {
        if (payRate < 0) {
            this.payRate = 0;
        } else {
            this.payRate = payRate;
        }
    }
    /**
     * Initializes employee to FirstName LastName 0 0 
    */ 
    public Employee() {
        this("FirstName","LastName",0,0);  // this calls the non-default constructor, but with a specified set of default values.
    }
    /**
     * Customizes a new employee based on data passed in
     * @param first
     * @param last
     * @param payRate
     * @param hoursWorked
     */
    public Employee(String first, String last, double payRate, double hoursWorked) {
        super(first,last); // Calls the superclass's constructor that takes in two strings. which then sets our firstName, and lastName.
        setHoursWorked(hoursWorked);
        setPayRate(payRate);
    }    
    @Override 
    public String getType(){
        return "Employee";
    }
    @Override
    public String toString() {
        return String.format("%s\t%.2f\t%.2f", super.toString(), hoursWorked, payRate);
    }
}
