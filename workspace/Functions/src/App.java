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


    }// Or could do this
    public static String ClassifyAgeReturn(int age){
        if (age < 18){
            return "You are a child";
        } else if (age < 30){
            return "You are a young adult";
        } else if (age < 50){
            return "You are getting sick of adulting";
        } else if (age < 65){
            return "time is ticking";
        } else {
            return "Your better days are long behind you.";
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name ");
        String name = sc.nextLine();
        System.out.println("enter your age");
        int age = sc.nextInt();
        App me = new App();
        // This is essentially bypassing the "Static" restriction main places on itself, because 'ClassifyAge' is not static
        // This means that you can access that function from main.
        String description = me.ClassifyAge(age);
        System.out.println(description);
        System.out.println(ClassifyAgeReturn(age));
    }
}
