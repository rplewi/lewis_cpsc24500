/*
 * This application computes a person's final grade from 3 test scores
 * It will also tell them if they got an A, B, etc.
 */
import java.util.Scanner;
public class App {
    public static void printBanner(){
        System.out.println("*******************************");
        System.out.println("             GRADER            ");
        System.out.println("*******************************");
        System.out.println();
    }
    public static double CalculateAverage(int g1, int g2, int g3){
        double sum = g1 + g2 + g3;
        double result = sum / 3;
        return result;
    }
    public static String GetLetterGrade(double avg){
        if (avg >= 90){
            return "A";
        } else if (avg >= 80){
            return "B";
        } else if (avg >= 70){
            return "C";
        } else if (avg >= 60){
            return "D";
        } else {
            return "F";
        }
    }
    public static void main(String[] args) throws Exception {
        printBanner();
        Scanner sc = new Scanner(System.in);
        int grade1, grade2, grade3;
        System.out.print("Enter three grades (separated by spaces): ");
        grade1 = sc.nextInt();
        grade2 = sc.nextInt();
        grade3 = sc.nextInt();
        double avg = CalculateAverage(grade1, grade2, grade3);
        String letterGrade = GetLetterGrade(avg);
        System.out.printf("Your average grade was %.2f and that earned you a %.s \n", avg, letterGrade);
            
        
    }
}
