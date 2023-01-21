package LA2Q1;

import java.util.*;


public class JeffanoTestingSortingMethods {

    //The header method
    public static void Header(int a,int b) {
        System.out.println("====================================================================================");
        System.out.println("Lab Assignment: " + a + "Q" + b + "\nPrepared By: Jeffano John " +
                "\nStudent Number: 252130759 \nGoal of Assignment: Sorting Array of Numbers Using Different Sorting Methods ");
        System.out.println("====================================================================================");
    }

    //The Footer Method
    public static void Footer(int a,int b) {
        System.out.println("====================================================================================");
        System.out.println("Completion of Lab Assignment " + a + "Q" + b + " is successful." +
                "\nSigning off - Jeffano John");
        System.out.println("====================================================================================");
    }

    //Selection sort Method
    public static <T extends Comparable <? super T>>long selectionSort (T [] arr){
        int n = arr.length;

        //Variable to start system timer
        long startTime = System.nanoTime();

        // One by one move boundary of unsorted subArray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min = i;
            for (int j = i+1; j < n; j++){
                //Comparing the array to the first integer
                if (arr[j].compareTo(arr[min])<0){
                    min = j;
                }
            }

            // Swap the found minimum element with the first element
            T temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        //Variable to end system timer
        long endTime = System.nanoTime();

        //Returning the time difference
        return endTime-startTime;
    }

    //Bubble sort Method
    public static < T extends Comparable <? super T >> long bubbleSort(T[] a){
        long startTime = System.nanoTime();

        //Looping the array but starting at index 1
        for (int i = 1; i<a.length; i++){
            //Looping the array but starting at index 0 and ending at length minus i
            for (int j =0; j < a.length - i; j++){
                //Compare the first and second integers
                if (a[j].compareTo(a[j+1])<0){
                    //Swapping the two elements
                    T temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        long endTime = System.nanoTime();
        return endTime-startTime;
    }

    //Insertion Sort Method
    public static < T extends Comparable <? super T >> long insertionSort(T[] a){
        int n = a.length;
        long startTime = System.nanoTime();

        //Looping through array starting at index 1
        for (int i = 1; i < n; ++i) {
            T key = a[i];
            int j = i - 1;

            //Move elements of arr[0..i-1], that are greater than key, to one position ahead
            //of their current position
            while (j >= 0 && a[j].compareTo(key)>0) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
        long endTime = System.nanoTime();
        return endTime-startTime;
    }

    //Merge Sort Method
    public static <T extends Comparable<? super T>> long mergeSort(T[] a){
        int n = a.length;

        long startTime = System.nanoTime();

        //Checks if the length of the array and returns the time difference
        if (n<2){
            long endTime = System.nanoTime();
            return endTime-startTime;
        }

        //Finds the middle index of the array
        int mid = n/2;

        //Creating two separate arrays for values 0 to mid and mid to end of the intial array
        T[] a1 = Arrays.copyOfRange(a,0,mid);
        T[] a2 = Arrays.copyOfRange(a,mid,n);

        //Using recursive to pass a1 and a2 arrays
        mergeSort(a1);
        mergeSort(a2);

        int i = 0, j = 0;
        //Checks if i + j is less than the initial array length, merges back into the original array
        while (i + j < a.length){
            //Checks if j equals the length of a2 array or if i is less than the a1 array length and
            //compares the first value of a1 to the first value of a2
            if (j == a2.length || (i < a1.length && a1[i].compareTo(a2[j]) < 0)){
                //If either is true, a[i+j] is assigned the value from the a1 array of index I++
                a[i+j] = a1[i++];
            }else{
                //Else a[i+j] is assigned the value from the a2[j++] to initial array
                a[i+j] = a2[j++];
            }

        }

        long endTime = System.nanoTime();
        return endTime-startTime;
    }

    //Quick Sort Method
    public static <T extends Comparable<? super T>> long quickSort(T[] s, int a, int b){

        long startTime = System.nanoTime();

        //if the first int is greater than or equal to b, then return timer
        if (a >= b){
            long endTime = System.nanoTime();
            return endTime-startTime;
        }
        //Setting the pivot as the value from the last index
        T p = s[b];
        //Setting left and right as the first and second last index values
        int left = a;
        int right = b - 1;


        while(left <= right){
            while (left <= right && s[left].compareTo(p)<=0){
                //Checks if the left is lower than p, adds one to left
                left = left + 1;
            }
            while (left <= right && s[right].compareTo(p)>=0){
                //Checks if the right is greater than p,subtracts one from right
                right = right - 1;
            }
            //Checks if left is less than right
            if (left < right){
                //Swaps left and right values
                T temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                //Adds one to left and subtracts one to right
                left = left + 1;
                right = right - 1;
            }

        }
        //Swaps left and last value
        T temp = s[left];
        s[left] = s[b];
        s[b] = temp;

        //Recursive method to call the quicksort method again with new first and last indexes
        quickSort(s,a,left-1);
        quickSort(s,left + 1,b);

        long endTime = System.nanoTime();
        return endTime-startTime;
    }

    //Get Digit method to return the first and second digit of a number at an index
    public static Integer getDigit(int number, int i){
        int digit=0;
        for (int j=0; j<=i; j++){
            //Gets the first digit and the second digit
            digit = number % 10;
            number = number/10;
        }
        return digit;
    }

    //BucketSort Method
    public static long bucketSort(Integer[] a, int first, int last, int maxDigits){

        long startTime = System.nanoTime();

        //Creating a vector class array with size 10
        Vector<Integer>[] bucket = new Vector[10];

        //Creating the buckets
        for (int i=0; i<10;i++){
            bucket[i] = new Vector<>();
        }

        //Loop that runs twice due to the size of the integers, 2 digits
        for (int i=0; i<maxDigits; i++){
            //Removing all the values inside the buckets
            for (int j=0; j<10; j++){
                bucket[j].removeAllElements();
            }

            //Loop to get the first and second digit of a value and adding it to the bucket
            for (int index = first; index<= last; index++){
                //Calling teh getDigit method
                Integer digit = getDigit(a[index], i);
                //Adding it to the bucket
                bucket[digit].add(a[index]);
            }
            int index=0;
            //For loop to get the digits and add it to the array
            for (int k=0; k<10; k++){
                for (int m=0; m<bucket[k].size(); m++){
                    a[index++] = bucket[k].get(m);
                }
            }
        }
        long endTime = System.nanoTime();
        return endTime-startTime;
    }

    public static void main(String []args){
        //Calling the header function
        Header(2,1);

        //Initializing the size of the array and start, end and sort time
        int sz = 5;
        double startTime, endtime, sortTime;

        //Creating an Integer object array for the mainlist and a backuplist
        Integer[] mainList = new Integer[sz];
        Integer[] backUpList = new Integer[sz];

        //Loading the mainList with random values
        for (int i = 0; i<mainList.length;i++){
            mainList[i] = (int) Math.floor(Math.random() * (93 - 13 + 1) ) + 13;
        }

        //Copying the mainList array to backUpList array
        System.arraycopy(mainList,0,backUpList,0,mainList.length);


        System.out.println("Testing Execution Time of Different Sorting Methods for Sorting " + sz + " Random Numbers: \n");

        //Creating a List<> for the mainList array
        List<Integer> newList = Arrays.asList(mainList);


        // Sorting Using Collections
        System.out.println("The Unsorted List: " + newList);
        startTime = System.nanoTime();
        //Sorting the list using collections.sort
        Collections.sort(newList);
        endtime = System.nanoTime();
        //Solving for the sort time
        sortTime = (endtime-startTime)/Math.pow(10,6);
        //Printing the sorttime along with the sorted list
        System.out.printf("Collections' Sorting Time: %.2f milliseconds\n", sortTime);
        System.out.println("The Sorted List using Collections' Sort Method: " + newList);


        //Sorting Using Selection Sort
        //Copying the backup Array into the mainList array to keep the unsorted list
        System.arraycopy(backUpList,0,mainList,0,backUpList.length);

        System.out.println("\nThe Unsorted List: " + newList);
        long timeDiff = selectionSort(mainList);
        sortTime = (timeDiff)/Math.pow(10,6);
        System.out.printf("Selection Sort Sorting Time: %.2f milliseconds\n", sortTime);
        System.out.println("The Sorted List using Selection-Sort: " + Arrays.toString(mainList));


        //Sorting Using Bubble Sort
        System.arraycopy(backUpList,0,mainList,0,backUpList.length);

        System.out.println("\nThe Unsorted List: " + newList);
        timeDiff = bubbleSort(mainList);
        sortTime = (timeDiff)/Math.pow(10,6);
        System.out.printf("Bubble Sort Sorting Time: %.2f milliseconds\n", sortTime);
        System.out.println("The Sorted List using Bubble Sort: " + Arrays.toString(mainList));

        //Sorting Using Insertion Sort
        System.arraycopy(backUpList,0,mainList,0,backUpList.length);

        System.out.println("\nThe Unsorted List: " + newList);
        timeDiff = insertionSort(mainList);
        sortTime = (timeDiff)/Math.pow(10,6);
        System.out.printf("Insertion Sort Sorting Time: %.2f milliseconds\n", sortTime);
        System.out.println("The Sorted List using Insertion Sort: " + Arrays.toString(mainList));

        //Sorting Using Merge Sort
        System.arraycopy(backUpList,0,mainList,0,backUpList.length);

        System.out.println("\nThe Unsorted List: " + newList);
        timeDiff = mergeSort(mainList);
        sortTime = (timeDiff)/Math.pow(10,6);
        System.out.printf("Merge Sort Sorting Time: %.2f milliseconds\n", sortTime);
        System.out.println("The Sorted List using Merge Sort: " + Arrays.toString(mainList));

        //Sorting Using Quick Sort
        System.arraycopy(backUpList,0,mainList,0,backUpList.length);

        System.out.println("\nThe Unsorted List: " + newList);
        timeDiff = quickSort(mainList, 0, mainList.length-1);
        sortTime = (timeDiff)/Math.pow(10,6);
        System.out.printf("Quick Sort Sorting Time: %.2f milliseconds\n", sortTime);
        System.out.println("The Sorted List using Quick Sort: " + Arrays.toString(mainList));

        //Sorting Using Bucket Sort
        System.arraycopy(backUpList,0,mainList,0,backUpList.length);

        System.out.println("\nThe Unsorted List: " + newList);
        timeDiff = bucketSort(mainList, 0, mainList.length-1, 2);
        sortTime = (timeDiff)/Math.pow(10,6);
        System.out.printf("Bucket Sort Sorting Time: %.2f milliseconds\n", sortTime);
        System.out.println("The Sorted List using Bucket Sort: " + Arrays.toString(mainList));

        //Calling the Footer method
        Footer(2,1);
    }
}