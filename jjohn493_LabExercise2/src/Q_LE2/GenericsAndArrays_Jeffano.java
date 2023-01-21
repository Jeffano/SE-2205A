 package Q_LE2;
import java.util.*;

import java.util.ArrayList;

public class GenericsAndArrays_Jeffano {


    //Header Method
    public static void Header(int a) {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Lab Exercise: 2-Q" + a + "\nPrepared By: Jeffano John " +
                "\nStudent Number: 252130759 \nGoal of Assignment: Finding student names depending on their academic year using Arraylist & try-catch exception");
        System.out.println("-----------------------------------------------------------");
    }

    //Footer Method
    public static void Footer(int b) {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Completion of Lab 2-Q" + b + " is successful." +
                "\nSigning off - Jeffano John");
        System.out.println("-----------------------------------------------------------");
    }

    public static class Pair <Y,N>{
        private Y key;
        private N value;

        public Pair(Y key,N value){
            this.key = key;
            this.value = value;
        }
        public void setKey(Y key){
            this.key = key;
        }
        public void setValue(N value){
            this.value = value;
        }
        public Y getKey(){
            return key;
        }
        public N getValue(){
            return value;
        }
    }

    public static int tryCatch(){
        Scanner input = new Scanner(System.in);
        int academicYear;
        System.out.println("Enter Academic Year (2, 3 or 4):");

        while(true) {
            try {
                academicYear = input.nextInt();
                if (academicYear >= 2 && academicYear <= 4) {
                    break;
                } else {
                    System.out.println("Invalid Input! Enter Academic Year (2, 3 or 4):");
                    input.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Enter Academic Year (2, 3 or 4):");
                input.next();
            }
        }
        return academicYear;
    }

    public static void main (String [] args){
        Scanner input = new Scanner(System.in);

        ArrayList<Integer> yearList = new ArrayList(Arrays.asList(2,3,4,3,2,2));
        ArrayList<String> nameList = new ArrayList(Arrays.asList("Harry", "Lavender", "Ron", "Hermione", "Luna", "Vincent"));


        Header(1);
        System.out.println("This Program Prints The Names of The Student Leaders from Year 2, 3 & 4." +
                "\nTo See The List of The Students From A Specific Year Enter an Integer Between 2 and 4 When Prompted.");

        //Creating a Pair object array to store the name and years.
        Pair<Integer,String>[] leaderYear= new Pair[yearList.size()];

        //Creating an arraylist to output the names of the students
        ArrayList<String> outputNames = new ArrayList<>();

        //Storing the list of years and names into the leader year array
        for(int i = 0; i< yearList.size();i++){
            leaderYear[i] = new Pair(yearList.get(i),nameList.get(i));
        }

        boolean shouldContinue = true;
        while(shouldContinue){
            int schoolYear = tryCatch();
            int numNames = 0;


            for (int j = 0; j < yearList.size();j++){
                //Uses the getKey method to check if the year from the user matches the year from the leader year array
                if (leaderYear[j].getKey() == schoolYear){
                    //Uses the getValue method to get the name of the student and store it into the output names Array
                    outputNames.add(leaderYear[j].getValue());
                    numNames++;
                }
            }
            System.out.println("Found " + numNames + " Leader(s) from Year " + schoolYear + "\n Here Is THe List:");
            System.out.println(outputNames);

            System.out.println("Do you wish to continue? Type 'Y' to Continue. Type Any Other Letter To Exit");
            String choice = input.nextLine();
            if (choice.equalsIgnoreCase("Y")){
                shouldContinue = true;
                outputNames.clear();
            }
            else{
                break;
            }
        }
        Footer(1);
    }
}