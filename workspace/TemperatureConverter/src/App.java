import java.util.Scanner;

/*
 * This program converts between celsius and fahrenheit temperatuer scales
 */

public class App {

    /*
     * Prints a glorious heading more beautiful than iceland.
     */
    public static void PrintHeading(){
        System.out.println("*********************************************");
        System.out.println("         Temperature Converter V1.0");
        System.out.println("*********************************************");
    }
    /**
     * Converts a fahrenheit temperature to celcius
     * @param temp in degrees farhenheit
     * @return the converted temperature in degrees celcius
     */

    public static double convertToCelcius(double temp){
        double result = 5.0/9 * temp + 32;
        return result;
    }
    /**
     * Converts a celcius temperature to fahrenheit
     * @param temp in degrees celcius
     * @return the converted temeprature in degrees fahrenheit
     */
    public static double convertToFahrenheit(double temp){
        double result = 9.0/5 * temp + 32;
        return result;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintHeading();
        System.out.println("Please enter the temperature and the scale separated by a space (F or C)");
        double ogTemp;
        String scale;
        double newTemp;
        ogTemp = sc.nextDouble();
        scale = sc.next();
        if (scale.equalsIgnoreCase("F")){
            newTemp = convertToCelcius(ogTemp);
            System.out.printf("The new temp is %.2f degrees %s.\n", newTemp, "C");
        } else if (scale.equalsIgnoreCase("c")){
            newTemp = convertToFahrenheit(ogTemp);
            System.out.printf("The new temp is %.2f degrees %s.\n", newTemp, "F");
        } else {
            System.out.println("You need to follow directions, Only F and C are allowed.");
        }
    

    }
}
