package LE4Q1;

import java.io.File;
import java.util.*;

public class JeffanoExerciseOnFileMapSet {

    //Header Method
    public static void Header(int a) {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Lab Exercise: " + a + "\nPrepared By: Jeffano John " +
                "\nStudent Number: 252130759 \nGoal of Assignment: Using TreeMaps to Sort First & Last Names from a txt File while counting how many times it repeats. ");
        System.out.println("-----------------------------------------------------------");
    }

    //Footer Method
    public static void Footer(int b) {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Completion of Lab Exercise " + b + " is successful." +
                "\nSigning off - Jeffano John");
        System.out.println("-----------------------------------------------------------");
    }

    public static void printList(TreeMap map){
        Set<Map.Entry<String, Integer>> entry_Set = map.entrySet();

        for(Map.Entry<String, Integer> entry: entry_Set){
            if (entry.getValue()>1){
                System.out.printf("%13s %3d\n",entry.getKey(),entry.getValue());
            }
        }
    }

    public static void populateTreeMap(int index, TreeMap map, String [] array){
            String key = array[index];
            if (map.get(key) == null) {
                map.put(key, 1);
            } else {
                int value = (int) map.get(key);
                value++;
                map.put(key, value);
            }
    }

    public static void main(String []args) throws Exception{

        Header(4);

        //Creating the tree map
        TreeMap<String, Integer> lastName = new TreeMap<>();
        TreeMap<String, Integer> firstName = new TreeMap<>();

        //Creating a File object-reference and checking whether the file exists
        File file = new File("SE2205Students.txt");
        Scanner fileInput = new Scanner(file);

        if (!file.exists()){
            System.out.println("File Not Found!");
            System.exit(0);
        }

        while(fileInput.hasNext()){
            String[] fullNames = fileInput.nextLine().split(" ");
            populateTreeMap(0,lastName,fullNames);
            populateTreeMap(fullNames.length-1,firstName,fullNames);
        }

        //Closing the file
        fileInput.close();


        System.out.println("List of the Number of students With The Same Last Names:");
        System.out.println("\tLast Name \tNumbers");
        System.out.println("\t-------------------");
        printList(lastName);

        System.out.println("\nList of the Number of students With The Same First Names:");
        System.out.println("\tFirst Name \tNumbers");
        System.out.println("\t-------------------");
        printList(firstName);

        Footer(4);

    }
}
