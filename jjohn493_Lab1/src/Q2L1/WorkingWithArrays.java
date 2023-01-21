package Q2L1;

import java.util.Arrays;
import java.util.Scanner;

public class WorkingWithArrays {

    //Header Method
    public static void myHeader(int a) {
        System.out.println("Lab Exercise: 1-Q" + a + "\nPrepared By: Jeffano John " +
                "\nStudent Number: 252130759 \nGoal of Assignment: Creating an array of user inputted numbers and then sorting it to find values divisible by 5's and finding the max and min.");
    }
    //Footer Method
    public static void myFooter(int b) {
        System.out.println("Completion of Lab 1-Q" + b + " is successful." +
                "\nSigning off - Jeffano John ");
    }

    //mm5methodJeffano method
    public static double[] mma5MethodJeffano(int [] array){
        int max = array[0], min = array[0], sum = 0, count = 0;

        double[] numbers = new double[4];

        //Setting the initial max and min values to be divisible to 5
        for(int i = 0; i < array.length; i++){
            if ((array[i] % 5) == 0){
                max = array[i];
                min = array[i];
                break;
            }
        }

        //Finding the sum, count, max and min of the values divisible by 5's
        for(int j = 0; j < array.length; j++){
            if ((array[j] % 5) == 0){
                 sum += array[j];
                 count++;
                 max = Math.max(max,array[j]);
                 min = Math.min(min,array[j]);
            }
        }

        //Finding the average
        double average;
        if (count == 0){
           average = 0.00;
        } else{
            average = (double) sum / count;
        }

        //Assigning the new values into a new array Number
        numbers[0] = max;
        numbers[1] = min;
        numbers[2] = average;
        numbers[3] = 251230759;

        //Checking which output is required
        if (count > 0){
            System.out.println("Jeffano found " + count + " number(s) that are divisible by 5");
        }
        else{
            System.out.println("In This Array, there was no number divisible-by-5");
        }
        return numbers;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("----------------------------------------------------------");
        myHeader(2);
        System.out.println("----------------------------------------------------------");

        //Asking the user the array size
        System.out.println("Enter Array Size: ");
        int integer = input.nextInt();

        int[] list = new int[integer];
        double newList[];

        //Storing the values into an array
        for (int i = 0; i < integer; i++){
            list[i] = input.nextInt();
        }

        //Writing the return into a new array
        System.out.println("Here is the result");
        newList = mma5MethodJeffano(list);

        //Printing the stored values from the array
        if (newList[2] != 0){
            System.out.printf("The Max is %.2f", newList[0]);
            System.out.printf("\nThe Min is %.2f", newList[1]);
            System.out.printf("\nThe Average of the Numbers Divisible by 5 is %.2f", newList[2]);
            System.out.println("\nMy Student Number is " + (int) newList[3]);
        }
        System.out.println("----------------------------------------------------------");
        myFooter(2);
        System.out.println("----------------------------------------------------------");
    }
}
