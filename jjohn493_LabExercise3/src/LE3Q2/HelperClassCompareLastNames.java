package LE3Q2;

import java.util.Comparator;

public class HelperClassCompareLastNames implements Comparator<Student> {
    public int compare(Student f1, Student f2){
        String ln1 = f1.getLastName();
        String ln2 = f2.getLastName();
        int result = ln1.compareTo(ln2);
        return result;
    }
}
