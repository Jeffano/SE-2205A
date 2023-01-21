package Q1L1;

import java.util.Scanner;

public class TestingExecutionTime {

    //Header Method
    public static void Header(int a) {
        System.out.println("Lab Exercise: 1-Q" + a + "\nPrepared By: Jeffano John " +
                "\nStudent Number: 252130759 \nGoal of Assignment: Finding Execution Time of Factorials Using Iterative Method, Recursion Method & Iterative within the Main Function.  ");
    }
    //Footer Method
    public static void Footer(int b) {
        System.out.println("Completion of Lab 1-Q" + b + " is successful." +
                "\nSigning off - Jeffano John");
    }
    //Iterative Method

    public static double Iterative(int value){
        double result = 1, i =1;
        while (i<=value){
            result = result * i;
            i++;
        }
        return result;
    }
    //Recursive Method
    public static double Recursive(int value){
        if(value == 0){
            return 1;
        }
        else {
            return value * Recursive(value-1);
        }
    }
    //Nano time method
    public static long nanoTime(){
        return System.nanoTime();
    }

    //The Driver method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("----------------------------------------------------------");
        Header(1);
        System.out.println("----------------------------------------------------------");

        //Validating the integer if it's positive or greater than 0.
        int integer = 1;
        do {
            System.out.println("Enter an Integer Number:");
            integer = input.nextInt();
        }
        while ((integer < 0) && (integer != 0));
        System.out.println("----------------------------------------------------------");

        //Iterative within the main function
        double startMain = nanoTime();
        double result = 1, i =1;
        while (i<=integer){
            result = result * i;
            i++;
        }
        double endMain = nanoTime();
        System.out.printf("The Factorial of " + integer + " is:  %.1g ", result);
        double elapsedtimeMain = ((endMain - startMain));
        System.out.printf("\nTime Taken By Iterative within the Main Function: %.3g", (elapsedtimeMain/ 1000000000));
        System.out.println(" SEC\n----------------------------------------------------------");

        //Factorial using Iterative Method
        double startIterative = nanoTime();
        double FactorialIterative = Iterative(integer);
        double endIterative = nanoTime();
        System.out.printf("The Factorial of " + integer + " using the Iterative Method: %.1g ", FactorialIterative);
        double elapsedIterativeTime = ((endIterative - startIterative));
        System.out.printf("\nTime Taken By Iterative Method: %.3g", (elapsedIterativeTime/ 1000000000));
        System.out.println(" SEC\n----------------------------------------------------------");

        //Factorial using Recursive Method
        double startRecursive = nanoTime();
        double FactorialRecursive = Recursive(integer);
        double endRecursive = nanoTime();
        System.out.printf("The Factorial of " + integer + " using the Recursive Method: %.1g ",FactorialRecursive);
        double elapsedRecursiveTime = ((endRecursive - startRecursive));
        System.out.printf("\nTime Taken By Recursive: %.3g", (elapsedRecursiveTime/ 1000000000));
        System.out.println(" SEC\n----------------------------------------------------------");

        Footer(1);
        System.out.println("----------------------------------------------------------");
    }
}