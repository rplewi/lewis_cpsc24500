/**
 * This models an employee of the organization.
 * It stores the first and last names, hours, worked, and hourly rate for an employee.
 * Exemplifies a blueprint style class.
 */
public class Employee {
    // Taking advantage of information hiding:
    private String firstName;
    private String lastName;
    private double hoursWorked;
    private double payRate;

    // Used right click background "source action" --> generate getters and setters
    // Only problem is, is that hoursWorked CANNOT be negative, so we need a condition to fix that.
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        // Uses this to distinguish the variable that we are using.
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public double getHoursWorked(){
        return hoursWorked;
    }
    public void setHoursWorked(double hoursWorked){
        // Checking if the value of payRate is negative which shouldnt be possible for this function
        if (hoursWorked < 0){
            this.hoursWorked = 0;
        } else {
        this.hoursWorked = hoursWorked;
        }
    }
    public double getPayRate() {
        return payRate;
    }
    public void setPayRate(double payRate) {
        // Checking if the value of payRate is negative which shouldnt be possible for this function
        if (payRate < 0){
            this.payRate = 0;
        } else {
            this.payRate = payRate;
        }
    }
    /**
     * This constructor doesn't take any parameters, just sets all to basic answers.
     */
    public Employee(){
        this("FirstName", "LastName", 0,0); // This calls the other constructor, getting rid of redudant code. A lot more simplified.

        /* Rather than have this redundant code, just use the other constructor method.
        setFirstName("firstName");
        setLastName("lastName");
        setPayRate(0);
        setHoursWorked(0);
        */

        /* Could be done originally, but theres a more proper way to do this, which is shown above.
        firstName = "firstName";
        lastName = "lastName";
        payRate = 0;
        hoursWorked = 0;
        */
    }
    /**
     * This constructor relies on our specific parameters
     * @param firstName - workers first name
     * @param lastName - workers last name
     * @param payRate - workers pay rate
     * @param hoursWorked - workers hours worked
     */
    public Employee(String firstName, String lastName, double payRate, double hoursWorked){
        setFirstName(firstName);
        setLastName(lastName);
        setPayRate(payRate);
        setHoursWorked(hoursWorked);
    }
    // Overrides the default toString memory location which we dont want to show, the object location is shown because it descends the Object object.
    @Override
    public String toString(){
        // This string also includes the java.lang.object.toString() which uses the "Super" keyword, overriding the override.
        return String.format("%s %s %.2f %.2f", firstName, lastName, hoursWorked, payRate);
    }

    
    
}
