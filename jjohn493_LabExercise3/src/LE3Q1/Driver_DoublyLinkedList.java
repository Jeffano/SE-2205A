package LE3Q1;

public class Driver_DoublyLinkedList {

    //Header Method
    public static void myHeader(int labE_number, int q_number) {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Lab Exercise: " + labE_number+"-Q" + q_number + "\nPrepared By: Jeffano John " +
                "\nStudent Number: 252130759 \nGoal of Assignment: Using Double Linked List To Add Names To THe Last & Between The List");
        System.out.println("-----------------------------------------------------------");
    }

    //Footer Method
    public static void myFooter(int labE_number, int q_number){
        System.out.println("-----------------------------------------------------------");
        System.out.println("Completion of Lab Exercise " + labE_number + "-Q" + q_number +  " is successful." +
                "\nSigning off - Jeffano John");
        System.out.println("-----------------------------------------------------------");
    }


    public static void main(String[] args){

        //Creating a DoublyLikedList<> reference variable of MyStudent type called jeffanoList
        DoublyLinkedList<MyStudent> jeffanoList = new DoublyLinkedList<>();

        //Creating five MyStudent-type reference variables
        MyStudent s0 = new MyStudent();
        MyStudent s1 = new MyStudent("Harry", 67.50);
        MyStudent s2 = new MyStudent("Luna", 87.50);
        MyStudent s3 = new MyStudent("Vincent", 60.50);
        MyStudent s4 = new MyStudent("Hermione", 89.20);

        //Adding first four students to the linked list using the addLast() method.
        jeffanoList.addLast(s0);
        jeffanoList.addLast(s1);
        jeffanoList.addLast(s2);
        jeffanoList.addLast(s3);

        myHeader(3,2);
        System.out.println("Adding 4 Students To The List");
        System.out.println("\nThe List Content:");
        System.out.println(jeffanoList);

        System.out.println("\nAdding Hermione To The List In Between Luna & Vincent...");

        //Finding the node info for s2 and then for s3 using findNode() method
        //Since Node<> class has been declared as a nested class of DoublyLinkedList<> Class,
        //the following statement must be used to create a reference variable of MyStudent type Node<> class
        DoublyLinkedList.Node<MyStudent> node2 = jeffanoList.findNode(s2);
        DoublyLinkedList.Node<MyStudent> node3 = jeffanoList.findNode(s3);

        //Adding the name between two other names
        jeffanoList.addBetween(s4,node2,node3);
        System.out.println(jeffanoList);

        myFooter(3,2);
    }
}
