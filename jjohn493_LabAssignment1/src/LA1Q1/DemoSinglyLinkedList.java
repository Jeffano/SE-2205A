package LA1Q1;
import java.util.*;
import java.util.Scanner;

public class DemoSinglyLinkedList{

    //Initializing the scanner method
    public static Scanner input = new Scanner(System.in);

    //The header method
    public static void Header(int a) {
        System.out.println("====================================================================================");
        System.out.println("Lab Assignment: " + a + "\nPrepared By: Jeffano John " +
                "\nStudent Number: 252130759 \nGoal of Assignment: Creating a Singly link-list data structure and using it to identify a stack and a queue using integers and strings ");
        System.out.println("====================================================================================");

    }
    //The Footer Method
    public static void Footer(int b) {
        System.out.println("====================================================================================");
        System.out.println("Completion of Lab Assignment " + b + " is successful." +
                "\nSigning off - Jeffano John");
        System.out.println("====================================================================================");
    }

    //Function to stack the list as the head as the top or the tail as the top and popping or pushing the elements depending on the user's choice, accepts the linked list as the parameter
    public static void stackDemo(SinglyLinkList lList){
        int choice;
        System.out.println("Which end of the Linked List you would like to use as the stack top? \nEnter 1 - Head or 2 - Tail");

        //Creating a loop to validate if the user entered 1 or 2 and using a try-catch to check if they entered a non integer
        while(true) {
            try {
                choice = input.nextInt();
                if (choice != 1 && choice != 2) {
                    System.out.println("Invalid Input! Enter 1 - Head or 2 - Tail:");
                    input.nextLine();
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Enter 1 - Head or 2 - Tail");
                input.next();
            }
        }

        if (choice == 1){
            System.out.println("\nStack Top: Head of The Linked List \nLet's Pop All The Elements from The Stack in Sequence:");
            System.out.println("The Current Stack: " + lList + "\n");

            //Pops all the elements from the head until the list is empty while printing the list
            while(!lList.isEmpty()){
                System.out.println(lList.popFromHead() + " has been popped! The Revised Stack: " + lList);
            }

            //Pushes 2 elements to the head of the list by passing the element in the pushAtHead function and prints the new list
            System.out.println("\nLet's Push 39 and -58 in The Stack .... \nThe Current Stack: " + lList);
            lList.pushAtHead(39);
            System.out.println("After 39 is Pushed, The Revised Stack: " + lList);
            lList.pushAtHead(-58);
            System.out.println("After -58 is Pushed, The Revised Stack: " + lList);
        }
        else{
            System.out.println("\nStack Top: Tail of The Linked List \nLet's Pop The First Three Elements from The Stack in Sequence:");
            System.out.println("The Current Stack: " + lList + "\n");

            //Pops the last 3 elements from the tail of the list and prints the updated list
            for (int i = 0; i < 3; i++){
                System.out.println(lList.popFromTail() + " has been popped! The Revised Stack: " + lList);
            }

            //Pushes two elements to the head of the list by passing the element in the pushAtHead function and prints the new list
            System.out.println("\nLet's Push 39 and -58 in The Stack .... \nThe Current Stack: " + lList);
            lList.pushAtTail(39);
            System.out.println("After 39 is Pushed, The Revised Stack: " + lList);
            lList.pushAtTail(-58);
            System.out.println("After -58 is Pushed, The Revised Stack: " + lList);
        }
    }

    //Function to add and remove string to the queue using enqueueAtTail and dequeueAtHead
    public static void queueDemo(SinglyLinkList lList){
        System.out.println("Note: Head is the Q-front, and Tail is the Q-rear");

        //Adding two new strings to the queue which is accomplished by the enqueueAtTail function and passing the string
        System.out.println("\nLet's Enqueue Joelle and Lukas in the Queue in Sequence .... \nThe Current Queue: " + lList);
        lList.enqueueAtTail("Joelle");
        System.out.println("\nAfter Joelle is Enqueued, the Revised Queue: " + lList);

        lList.enqueueAtTail("Lukas");
        System.out.println("After Lukas is Enqueued, the Revised Queue: " + lList);

        //Removing the first three names from the string linked list using the dequeueAtHead function and printing the list
        System.out.println("\nLet's Dequeue First Three Elements From The Queue in Sequence .... \nThe Current Queue: " + lList + "\n");
        for (int i = 0; i < 3; i++){
            System.out.println(lList.dequeueAtHead() + " has been dequeued! The Revised Stack: " + lList);
        }
    }

    public static void main (String []args){
        //Calling the header method
        Header(1);

        //Creating the arraylists for the numbers and names and adding the information to it
        ArrayList<Integer> numArrayList = new ArrayList<>(Arrays.asList(56, -22, 34, 57, 98));
        ArrayList<String> namesArrayList = new ArrayList<>(Arrays.asList("Griffin", "Will", "Isra", "Delaney", "Madison"));

        //Initializing the linked list for the number and names
        SinglyLinkList<Integer> numLinkedList = new SinglyLinkList<>();
        SinglyLinkList<String> namesLinkedList = new SinglyLinkList<>();


        System.out.println("The Given Integer Array: " + numArrayList);
        System.out.println("The Given String Array: " + namesArrayList);

        //Using the for loops to populate the Linked lists and using the addFirst and addLast functions
        for (int i = 0; i < 3; i++){
            numLinkedList.addFirst(numArrayList.get(i));
        }
        for (int i = 2; i >0; i--){
            numLinkedList.addLast(numArrayList.get(i+2));
        }

        for (int i = 0; i < 3; i++){
            namesLinkedList.addFirst(namesArrayList.get(i));
        }
        for (int i = 2; i >0; i--){
            namesLinkedList.addLast(namesArrayList.get(i+2));
        }

        System.out.println("Your Integer List: " + numLinkedList);
        System.out.println("Your String List: " + namesLinkedList);

        //Calling the stackDemo function and passing the integer linked list
        System.out.println("\n------------------------------------------");
        System.out.println("Stack Demo with the Integer Linked List");
        stackDemo(numLinkedList);

        ///Calling the queueDemo and passing the string linked list
        System.out.println("\n------------------------------------------");
        System.out.println("Queue demo with the String Linked List");
        queueDemo(namesLinkedList);

        System.out.println("\n------------------------------------------");
        System.out.println("Let's Search The Stack... \nThe Current Stack: " + numLinkedList);

        //Creating a while loop to keep asking the user to search the integer stack
        boolean shouldContinue = true;
        while(shouldContinue){
            System.out.println("\nEnter The Value You Are Searching For:");
            int value = input.nextInt();

            //Check if the user inputted value is found within the stack and returns the location or a default response if no location is found
            //searchStack function is called by passing the user inputted value
            if (numLinkedList.searchStack(value) == 0){
                System.out.println("The value is not found!");

            }
            else{
                System.out.println("The Value " + value + " is found in location " + numLinkedList.searchStack(value) + " from the top of the stack");
            }

            //Asks the user if they want to continue searching the stack
            System.out.println("Do you want to continue? Type 'Y' to Continue. Type Any Other Letter To Exit");
            String choice = input.next();
            if (choice.equalsIgnoreCase("Y")){
                shouldContinue = true;
            }
            else{
                break;
            }
        }
        //Calling the footer method
        Footer(1);
    }
}
