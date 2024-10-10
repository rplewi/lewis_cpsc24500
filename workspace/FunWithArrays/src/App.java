import java.util.Random;
import java.util.Scanner;


public class App {
    /**
     * Prints menu
     */
    public static void printMenu(){
        System.out.println("\nHere are your options");
        System.out.println("1. Print the numbers (1 per line): ");
        System.out.println("2. Find the sum");
        System.out.println("3. Find the minimum");
        System.out.println("4. Find the maximum");
        System.out.println("5. Find the mean");
        System.out.println("6. Quit");
        System.out.println("Enter your choice ");
    }
    /**
     * Prints numbers in nums array oner per line
     * @param nums - list of numbers to be printed
     */
    public static void printNumbers(int[] nums){
        System.out.println();
        for (int num : nums){
            System.out.print(num + " ");
        }
        System.out.println();
    }
    /**
     * Calculates the sum of the values in the num array
     * @param nums - list of numbers to be aded.
     * @return - the sum.
     */
    public static int findSum(int[] nums){
        int total = 0;
        for (int num : nums){
            total += num;
        }
        return total;
    }
    /**
     * finds the minimum of the values in nnums
     * @param nums - the list to search through for the minimum.
     * @return - the minimum value
     */
    public static int findMin(int[] nums){
        int theMin = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] < theMin){
                theMin = nums[i];
            }
        }
        return theMin;
    }
    /**
     * Finds the maximum of the values in nums
     * @param nums - the list to search through for the maximum
     * @return
     */
    public static int findMax(int[] nums){
        int theMax = nums[0];
        for (int i = 1; i <nums.length; i++){
            if (nums[i] > theMax){
                theMax = nums[i];
            }
        }
        return theMax;
    }
    /**
     * Finds the mean of the values in nums
     * @param nums - the list we're computing the mean for
     * @return - the mean
     */
    public static double findMean(int[] nums){
        return (double)findSum(nums)/nums.length; //Need to case this variable because it wouldn't format correctly.
    }
    /**
     * This builds and loads the array of random numbers
     * @param numNums - how many numbers
     * @param valCap - max value to generate
     * @return - the array with numNums slots, each fileed with a number [0, valCap) --> up to but not including.
     */
    public static int[] buildNumbersArray(int numNums, int valCap){
        Random rnd = new Random();
        int[] result = new int[numNums];
        for (int i = 0; i < result.length; i++){
            result[i] = rnd.nextInt(valCap);
        }
        return result;
    }
    /**
     * This application generates values based on the user's input, also including the boundaries for those numbers.
     * It then allows you to print the numbers, the sum, the min, the max, the mean.
     * The ints will be stored in an array.
     * @param args 
     * @throws Exception
     */

        public static void main(String[] args) throws Exception {
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        int howMany;
        System.out.println("\nHow many numbers do you want?");
        howMany = sc.nextInt();
        System.out.println("What is the max value to generate?");
        int maxVal = sc.nextInt();
        int[] numbers = buildNumbersArray(howMany, maxVal);
        int choice, theMax, theMin, sumOfNumbers;
        double theMean;
        
        do {
            printMenu();
            choice = sc.nextInt();
            if (choice == 1){
                printNumbers(numbers);
            } else if (choice == 2){
                sumOfNumbers = findSum(numbers);
                System.out.printf("the sum of numbers is %d. \n", sumOfNumbers);
            }else if (choice == 3){
                theMin = findMin(numbers);
                System.out.printf("The minimum is %d. \n", theMin);
            } else if (choice == 4){
                theMax = findMax(numbers);
                System.out.printf("The maxmimum is %d. \n", theMax);
            } else if (choice == 5){
                theMean = findMean(numbers);
                System.out.printf("the mean is %.2f. \n", theMean);
            } else if (choice != 6){
                System.out.println("This wasn't a valud choice!");
            }
        } while (choice != 6);
        System.out.println("Have a nice day!");
        sc.close();
    }
}
