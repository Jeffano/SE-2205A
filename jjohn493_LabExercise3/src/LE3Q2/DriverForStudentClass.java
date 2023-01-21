package LE3Q2;

import java.util.ArrayList;
import java.util.Collections;

public class DriverForStudentClass {
    //Header Method
    public static void myHeader(Student myInfo, int labE_number, int q_number) {
        System.out.println("-----------------------------------------------------------");
        String output;
        output = String.format("Lab Exercise: " + labE_number+"-Q" + q_number + "\nPrepared By: %s %s", myInfo.getFirstName(),myInfo.getLastName());
        System.out.println(output + "\nStudent Number: 252130759 \nGoal of Assignment: Sorting and Printing Names Depending on Their First Names, Last Names & Score ");
        System.out.println("-----------------------------------------------------------");
    }

    //Footer Method
    public static void myFooter(int labE_number, int q_number){
        System.out.println("-----------------------------------------------------------");
        System.out.println("Completion of Lab Exercise " + labE_number + "-Q" + q_number +  " is successful." +
                "\nSigning off - Jeffano John");
        System.out.println("-----------------------------------------------------------");
    }

    public static void main(String []args){

        ArrayList<Student> list = new ArrayList<>();

        Student s0 = new Student();
        Student s1 = new Student("Harry", "Potter", 75.5);
        Student s2 = new Student("Ronald", "Weasley", 86.0);
        Student s3 = new Student("Hermione", "Granger", 91.7);
        Student s4 = new Student("Parvati", "Patil", 93.75);

        list.add(s0);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        myHeader(s0,3,2);
        System.out.println("The Score Card: ");

        for (int i = 0; i < list.size(); i++){
            System.out.println("\t" + list.get(i));
        }

        System.out.println("\nThe Sorted List in Terms of Score in Descending Order:");
        Collections.sort(list);

        for (int i = list.size()-1; i >= 0; i--){
            System.out.println("\t" + list.get(i));
        }

        System.out.println("\nThe Sorted List in Terms of Last Names:");
        HelperClassCompareLastNames lastNames = new HelperClassCompareLastNames();
        Collections.sort(list, lastNames);
        for (int i = 0; i < list.size(); i++){
            System.out.println("\t" + list.get(i));
        }

        System.out.println("\nThe Sorted List in terms of First Names:");
        HelperClassCompareFirstNames firstNames = new HelperClassCompareFirstNames();
        Collections.sort(list, firstNames);
        for (int i = 0; i < list.size(); i++){
            System.out.println("\t" + list.get(i));
        }

        myFooter(3,2);
    }
}
