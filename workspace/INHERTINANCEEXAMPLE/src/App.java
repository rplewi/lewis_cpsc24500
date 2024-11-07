import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Customer customer = new Customer("Roman", "Lewis", "1100 E Treeline Dr.", "815-999-5304");
        Employee employee = new Employee("Max", "Lewis", 50, 45);
        //Person person = new Person("Plain", "Joe");
        /* Could do this but theres an easier way.
        ArrayList<Customer> customers = new ArrayList<Customer>();
        ArrayList<Employee> employees = new ArrayList<Employee>();
        customers.add(customer);
        employees.add(employee);
        */

        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(customer);
        persons.add(employee);
        for (Person p : persons){
            /* Polymorphism saves us from having to cast the type of "p" into each toString() function for their specific class.
            if (p instanceof Employee){
                System.out.println(((Employee)p).toString());
            } else if (p instanceof Employee){
                System.out.println(((Employee)p).toString());
            }
                */
            System.out.println(p);
        }
    }
}
