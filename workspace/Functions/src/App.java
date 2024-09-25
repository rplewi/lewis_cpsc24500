import java.util.Scanner;


public class App {
    public static String ClassifyAge(int age){
        String result; 
        if (age < 18){
            result = "You are a child";
        } else if (age < 30){
            result = "You are a young adult";
        } else if (age < 50){
            result = "You are getting sick of adulting";
        } else if (age < 65){
            result = "time is ticking";
        } else {
            result  = "Your better days are long behind you.";
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name ");
        String name = sc.nextLine();
        System.out.println("enter your age");
        int age = sc.nextInt();
        String description = ClassifyAge(age);
        System.out.println(description);
    }
}
