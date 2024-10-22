/*
 * Print Heading,
 * 1.) Ask for number of pcs --> howMany
 * 2.) ask for filename --> fname (Use loop to check if the file works before going into actual code, so "try catch"
 * printwriter pw = null;
 * while (pw == null){
 *      try 
 *          // to find if the file exists, assign the printwriter to the file provided
 *          open the file they named --> pw = new PrintWriter(new BufferedWriter(etc));
 *      catch an exception
 *          ask them for the file name again
 * }
 * 
 * set totalCost = 0; // total cost of pc's equals 0.
 * for howMany times: 
 *          print ("Pc #__");
 *          set costOfPC = 1750; "base price of pc"
 *          set description = "";
 *          do {
 *              print the 5 menu options for configuring
 *              if the choice is one
 *                  show the processor options
 *                  based on the choice, add to cost of pc & description = 
 *                                                  description + "processor = " + whatever they chose + "\n"
 *          } while (configMenuChoice != 5){
 *              write total cost and the descriptoin of options to the screen;
 *              write to the file;
 *          }
 * print the total cost of the order
 * print that the file was saved
 * close the file
 * say thank you.
 */



public class App {
    public static void main(String[] args) throws Exception {
        
    }
}
