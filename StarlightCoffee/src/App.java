/*
 * Roman Lewis
 * Starlight Coffee (Description Here)
 * Date: Day (CHANGE )October 2024
 */
public class App {
    public static void PrintBanner(){
        for (int i = 0; i < 44; i++){
            System.out.print("*");
        }
        String centeredString = "STARLIGHT COFFEE";
        System.out.format("\n%30s", centeredString + "\n");
        for (int i = 0; i < 44; i++){
            System.out.print("*");
        } 
    }
    public static void main(String[] args) throws Exception {
        PrintBanner();
    }
}
