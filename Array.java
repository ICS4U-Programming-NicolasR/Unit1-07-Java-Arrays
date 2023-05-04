
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
* Reads a file and calculates mean median and mode.
*
* @author  Mr. Riscalas
* @version 1.0
* @since   2023-03-22
*/

public final class Array {
    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private Array() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the modeCalc method.
     *
     * @param nums //nums
     * @return MODE
     *
     */
    public static List<Integer> modeCalc(int[] nums) {
        // Store some values in these variables
        int maxNumRep = 0;
        int numRep = -1;
        int timesRep = 0;
        // create a mode list
        final ArrayList<Integer> MODE = new ArrayList<>();
        // for loop to see if num repeats
        for (int i = 0; i < nums.length; i++) {
            // if statement for checking specifically the last value
            if (i == nums.length - 1) {
                // checks if the number repeats
                if (nums[i] == nums[i - 1]) {
                    numRep = nums[i];
                    if (timesRep > maxNumRep) {
                        MODE.clear();
                        MODE.add(numRep);
                        maxNumRep = timesRep;
                    } else if (timesRep == maxNumRep) {
                        MODE.add(numRep);
                    }
                    timesRep = 0;
                }
            } else {
                if (nums[i] == nums[i + 1]) {
                    numRep = nums[i];
                    timesRep++;
                } else {
                    if (timesRep > maxNumRep) {
                        MODE.clear();
                        MODE.add(numRep);
                        maxNumRep = timesRep;
                    } else if (timesRep == maxNumRep) {
                        MODE.add(numRep);
                    }
                    timesRep = 0;
                }
            }
        }
        return MODE;
    }

    /**
     * This is the medCalc method.
     *
     * @param nums //nums
     * @return median
     *
     */
    public static float medCalc(int[] nums) {
        // calculate the median
        float median = 0;
        if (nums.length % 2 == 0) {
            median = (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2;
        } else {
            median = nums[nums.length / 2];
        }
        return median;
    }

    /**
     * This is the medCalc method.
     *
     * @param nums //nums
     * @return mean
     *
     */
    public static float meanCalc(int[] nums) {
        float sum = 0;
        float median = 0;
        // calculate the mean by adding then dividing by the amount of numbers
        for (int num : nums) {
            sum += num;
        }
        median = sum / nums.length;
        return median;
    }

    /**
     * This is the main method.
     *
     * @param args //unused
     *
     */

    public static void main(final String[] args) {
        // repeated Strings to appease check style
        final String INPUT_FILE_NAME = "Unit1-07-set3.txt";
        // Try catch to try to create/edit a file
        try {
            // Create a new File object representing the file to be read
            // Input file
            final File FILE = new File(INPUT_FILE_NAME);

            try (// Create a new Scanner object to read from the file
            Scanner SCANNER = new Scanner(FILE)) {
                // Create the arrayList
                final ArrayList<String> NUM_STR = new ArrayList<>();
                // Read the file line by line using the Scanner object
                while (SCANNER.hasNextLine()) {
                    final String LINE = SCANNER.nextLine();
                    NUM_STR.add(LINE);
                }
                // set arraylist to array
                final int[] NUM_ARR = new int[NUM_STR.size()];
                int counter = 0;
                // convert the values to an int and add to array
                for (String num : NUM_STR) {
                    final int NUM_INT = Integer.parseInt(num);
                    NUM_ARR[counter] = NUM_INT;
                    counter++;
                }
                // sort the array
                Arrays.sort(NUM_ARR);
                // calculate the numbers
                final List<Integer> MODE_ANS = modeCalc(NUM_ARR);
                final float MED_ANS = medCalc(NUM_ARR);
                final float MEAN_ANS = meanCalc(NUM_ARR);
                // display the numbers
                System.out.println("The mode is: " + MODE_ANS);
                System.out.println("The mean is: " + MEAN_ANS);
                System.out.println("The median is: " + MED_ANS);
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException error) {
            System.out.println("File not found!");
        }
    }
}
