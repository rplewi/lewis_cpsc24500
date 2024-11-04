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
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }   
    /**
     * INitializes employee to FirstName LastName 0 0 
    */ 
    public Employee() {
        this("FirstName","LastName",0,0);  // this calls the non-default constructor
    }
    /**
     * Customizes a new employee based on data passed in
     * @param first
     * @param last
     * @param payRate
     * @param hoursWorked
     */
    public Employee(String first, String last, double payRate, double hoursWorked) {
        super(first,last); // Calls the superclass's constructor that takes in two strings.
        setHoursWorked(hoursWorked);
        setPayRate(payRate);
    }    
    @Override
    public String toString() {
        return String.format("%s\t%.2f\t%.2f", super.toString(), hoursWorked, payRate);
    }
}
