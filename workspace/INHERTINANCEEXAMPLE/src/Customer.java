public class Customer extends Person{
    // Specific things that I want to store about a customer.
    private String shippingAddress;
    private String phoneNumber;

    public String getShippingAddress(){
        return shippingAddress;
    }
    public void setShippingAddress(String addr){
        shippingAddress = addr;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phone){
        // Could do stuff to validate the phone number, but didn't do it here.
        phoneNumber = phone;
    }
    public Customer(){
        this("FirstName", "LastName", "", ""); //Default constructor
    }
    public Customer(String firstName, String lastName, String shippingAddress, String phoneNumber){
        super(firstName, lastName); // asks superclass "person" to initialize our names for us since we already have them
        setShippingAddress(shippingAddress);
        setPhoneNumber(phoneNumber);
    }
    @Override 
    public String getType(){
        return "Customer";
    }
    @Override
    public String toString(){
        return String.format("%s\t%s\t%s", super.toString(), shippingAddress, phoneNumber);
    }
    
}