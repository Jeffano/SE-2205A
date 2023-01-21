package LE3Q2;

import java.util.Comparator;

public class HelperClassCompareFirstNames implements Comparator<Student> {
    public int compare(Student f1, Student f2){
        String fn1 = f1.getFirstName();
        String fn2 = f2.getFirstName();

        int result = fn1.compareTo(fn2);

        if (result == 0){
            return 0;
        } else if (result < 0){
            return -1;
        }
        else{
            return 1;
        }
    }
}
