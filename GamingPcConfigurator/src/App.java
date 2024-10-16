import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class App {
    /**
     * Prints the banner for the initiation of the program, giving the user a nice welcome!
     */
    public static void printBanner(){
        System.out.println("\n****************************************");
        System.out.println("*                                      *");
        System.out.println("*    Welcome to the PC Configurator    *");
        System.out.println("*                                      *");
        System.out.println("****************************************\n");
    }
    /**
     * This method will print a menu for the user to change their computer parts!
     */
    public static void printMenu(){
        System.out.println("\nWhat would you like to upgrade?");
        System.out.println("1. Processor");
        System.out.println("2. Graphics card");
        System.out.println("3. Memory");
        System.out.println("4. Monitor");
        System.out.println("5. Nothing else, I'm done!");
        System.out.println("Enter the number of your choice");
    }
    /**
     * This method will be called when the user wants to change their processor!
     */
    public static void printProcessor(){
        System.out.println("Upgrade the processor to [1] Intel i7 ($200), [2] intel i9 ($300), [3] AMD 9 5950 ($500): ");
    }
    /**
     * This method will be called when the user wants to change their graphics card!
     */
    public static void printGraphicsCard(){
        System.out.println("Upgrade the graphics card to [1] NVIDIA 3060 ($150), [2] NVIDIA 4060 ($250), [3] NVIDIA 4080 ($350): ");
    }
    /**
     * This method will be called when the user wants to change their memory!
     */
    public static void printMemory(){
        System.out.println("Upgrade the memory to [1] 16Gb ($150), [2] 32Gb ($250): ");
    }
    /**
     * This method will be called when the user wants to change their monitor!
     */
    public static void printMonitor(){
        System.out.println("Add a monitor of size [1] 24 Inches ($200), [2] 27 Inches ($250), [3] 32 Inches ($350): ");
    }
    /**
     * This main function will be what starts the computer configurator program!
     * It will give the user a selection of menus to navigate to the part they want to change.
     * All of the calculations will be done in the main method due to its simplicity.
     * This main function however does not take into account duplicates of specific choices.
     * So if a user selects two graphics cards for example, the printed receipt in the file will contain duplicates.
     * This can be solved by creating a selection of methods that will return a string variable that could be concatenated 
     * to the main description which would be printed to the selected file. This would solve the duplication problem, but does 
     * not need to be used in this program, due to me already emailing Dr. Klump.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    PrintWriter pw = null;
    int howMany = 0, userInput, choiceInput, pcCost, pcAmount = 0;
    double totalCost; 
    String fileName = "", description;
    File myFile = null;
    printBanner();
    
    while (pw == null){
        System.out.println("Please enter the amount of PCs you want to build!");
    try{
        howMany = sc.nextInt();
        sc.nextLine();
    } catch (Exception ex){
        System.out.println("Please make sure you are entering whole numbers!\n\n");
        sc.nextLine();
        continue;
    }
        // Second after we get the amount of PCs.
        System.out.println("Please enter the name of the file you want the receipt saved to.");
        fileName = sc.nextLine();
        pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fileName))));
        // myFile will keep track of the file location for the end of the program!
        myFile = new File(fileName);
    }
    totalCost = 0.0;
    for (int i = 1; i <= howMany; i++){
        System.out.println("Pc #" + i);
        System.out.println("-----");
        pcCost = 1750; // Base price of PC
        description = "";
        do {
            printMenu();
            userInput = sc.nextInt();
            switch (userInput){
                case 1: 
                    printProcessor();
                    choiceInput = sc.nextInt();
                    if (choiceInput == 1){
                        System.out.println("You chose i7\n");
                        description += "Processor: Intel i7 \n";
                        pcCost += 200;
                        System.out.println(pcCost+ "\n");
                    } else if (choiceInput == 2){
                        System.out.println("You chose i9\n");
                        description += "Processor: Intel i9 \n";
                        pcCost += 300;
                        System.out.println(pcCost+ "\n");
                    } else if (choiceInput == 3){
                        System.out.println("You chose AMD 9\n");
                        description += "Processor: AMD 9 5950 \n";
                        pcCost += 500;
                        System.out.println(pcCost+ "\n");
                    } else {
                        System.out.println("Ya messed it up, Try Again!");
                    }
                    break;
                case 2:
                    printGraphicsCard();
                    choiceInput = sc.nextInt();
                    if (choiceInput == 1){
                        System.out.println("You chose 3060\n");
                        description += "Graphics Card: NVIDIA 3060 \n";
                        pcCost += 150;
                        System.out.println(pcCost+ "\n");
                    } else if (choiceInput == 2){
                        System.out.println("You chose 4060\n");
                        description += "Graphics Card: NVIDIA 4060 \n";
                        pcCost += 250;
                        System.out.println(pcCost+ "\n");
                    } else if (choiceInput == 3){
                        System.out.println("You chose 4080\n");
                        description += "Graphics Card: NVIDIA 4080 \n";
                        pcCost += 350;
                        System.out.println(pcCost+ "\n");
                    } else {
                        System.out.println("Ya messed it up, Try Again!");
                    }
                    break;
                case 3: 
                    printMemory();
                    choiceInput = sc.nextInt();
                    if (choiceInput == 1){
                        System.out.println("You chose 16\n");
                        description += "Memory: 16GB \n";
                        pcCost += 150;
                        System.out.println(pcCost+ "\n");
                    } else if (choiceInput == 2){
                        System.out.println("You chose 32\n");
                        description += "Memory: 32GB \n";
                        pcCost += 250;
                        System.out.println(pcCost+ "\n");
                    } else {
                        System.out.println("Ya messed it up, Try Again!");
                    }
                    break;
                case 4: 
                    printMonitor();
                    choiceInput = sc.nextInt();
                    if (choiceInput == 1){
                        System.out.println("You chose 24 In\n");
                        description += "Monitor: 24 Inch Monitor \n";
                        pcCost += 200;
                        System.out.println(pcCost+ "\n");
                    } else if (choiceInput == 2){
                        System.out.println("You chose 27 In\n"); 
                        description += "Monitor: 27 Inch Monitor \n";
                        pcCost += 250;
                        System.out.println(pcCost+ "\n");
                    } else if (choiceInput == 3){
                        System.out.println("You chose 32 In\n");
                        description += "Monitor: 32 Inch Monitor \n";
                        pcCost += 350;
                        System.out.println(pcCost+ "\n");
                    } else {
                        System.out.println("Ya messed it up, Try Again!");
                    }
                    break;
                case 5:
                    if (i == howMany){
                    } else {
                        System.out.println("\nMoving on to the next PC!\n");
                    }
                    break;
                default:
                    System.out.println("\nPlease use the correct input and try again!");
                    break;
            }
        } while (userInput != 5);
            pw.println("Pc #" + i + " ($" + pcCost + ")");
            pw.println(description);
            totalCost += pcCost;
            pcAmount++;

    }
    System.out.println("\nTotal price was: $" + totalCost);
    System.out.println("Thank you for using this program, have a nice day!");
    System.out.println("Your file has been saved to: " + myFile.getAbsolutePath()); // "myFile.getAbsolutePath() Credit: found online, had to create a new variable to do it, because pw was created
    pw.println("Total cost of " + pcAmount + " PCs: $" + totalCost);                // with just the string so it doesn't have any of the methods that File does" 
    pw.close();
    sc.close();
    }
}
