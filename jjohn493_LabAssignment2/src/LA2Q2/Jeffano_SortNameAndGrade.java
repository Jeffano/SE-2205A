package LA2Q2;

import java.util.Collections;
import java.util.Vector;

public class Jeffano_SortNameAndGrade {

    //Header Method
    public static void Header(int a,int b) {
        System.out.println("====================================================================================");
        System.out.println("Lab Assignment: " + a + "Q" + b + "\nPrepared By: Jeffano John " +
                "\nStudent Number: 252130759 \nGoal of Assignment: Sorting A List of of Students Depending on their First Name, Last Name & Grade");
        System.out.println("====================================================================================");
    }

    //The Footer Method
    public static void Footer(int a,int b) {
        System.out.println("====================================================================================");
        System.out.println("Completion of Lab Assignment " + a + "Q" + b + " is successful." +
                "\nSigning off - Jeffano John");
        System.out.println("====================================================================================");
    }

    //Insertion sort method, Takes the array and key (first name or last name) as parameter
    public static void insertionSort(StudentGrade[] arr, int key){
        int n = arr.length;

        //Checks if the User is asking to sort first names
        if (key == 1){
            //Loop of the array
            for (int i = 1; i < n; ++i) {
                //Stores the second name under name variable
                StudentGrade name = arr[i];
                int j = i - 1;

                //Move elements of arr[0..i-1], the first names, that are greater than name, to one position ahead
                //of their current position
                while (j >= 0 && arr[j].getFirstName().compareTo(name.getFirstName())>0) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                //Name is assigned to arr[j+1]
                arr[j + 1] = name;
            }
        }
        //Sorts the Last Names
        else{
            for (int i = 1; i < n; ++i) {
                StudentGrade name = arr[i];
                int j = i - 1;

                //Move elements of arr[0..i-1], the first names, that are greater than name, to one position ahead
                //of their current position
                while (j >= 0 && arr[j].getLastName().compareTo(name.getLastName())>0) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = name;
            }
        }
    }

    //Method to print the new array in the required format
    public static void printArray(StudentGrade []arr){
        for (int i= 0; i < arr.length; i++){
            System.out.printf("%13s %-3s \t:%5s \n", arr[i].getFirstName(), arr[i].getLastName(), arr[i].getGrade());
        }
    }


    public static void main(String[] args) {
        //Calling the header method
        Header(2,2);

        //Creating the Array for first and last names and grade
        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny", "Draco", "Dean", "Fred"};
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood", "Weasley", "Malfoy", "Thomas", "Weasley"};
        Integer[] grd = {(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26)};

        //Creating a Vector<> class instance ‘sg’ with StudentGrade tag
        Vector<StudentGrade> sg = new Vector<>();

        //Adding each StudentGrade object to the Vector class with its add method
        for(int i = 0; i < fnArray.length; i++){
            StudentGrade studGrade = new StudentGrade(fnArray[i],lnArray[i],grd[i]);
            sg.add(studGrade);
        }

        //Printing the unsorted array using the get method
        System.out.println("The Unsorted Array:");
        for (int i = 0; i < sg.size(); i++){
            System.out.println(sg.get(i));
        }

        //Using collections.sort to sort the names using the grades
        Collections.sort(sg);
        //Printing the sorted array using the get method
        System.out.println("\nSorted By Grades:");
        for (int i = 0; i < sg.size(); i++){
            System.out.println(sg.get(i));
        }

        //Creating a new StudentGrade type array and copying the information from sg into new array, stdGrade
        StudentGrade[] stdGrade = new StudentGrade[fnArray.length];
        sg.copyInto(stdGrade);


        System.out.println("\nSorted By First Names:");
        //Calling the insertionSort method and passing the array and 1 to sort the first names
        insertionSort(stdGrade,1);
        //Calling printArray to print the Array
        printArray(stdGrade);

        System.out.println("\nSorted By Last Names:");
        //Calling the insertionSort method and passing the array and 2 to sort the last names
        insertionSort(stdGrade,2);
        //Calling printArray to print the Array
        printArray(stdGrade);

        //Calling the footer method
        Footer(2,2);
    }
}
