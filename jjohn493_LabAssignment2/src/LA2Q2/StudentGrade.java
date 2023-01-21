package LA2Q2;

//StudentGrade class implementing Comparable
public class StudentGrade implements Comparable<StudentGrade> {

    //Initializing private variables
    private String firstName;
    private String lastName;
    private Integer grade;

    //Empty constructor
    public StudentGrade(){}

    //Constructor with parameters
    public StudentGrade(String firstName, String lastName, int grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    //Getter & Setter Methods for FirstName, LastName & Grade
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setGrade(int grade){
        this.grade = grade;
    }

    public Integer getGrade(){
        return grade;
    }

    //CompareTo method to compare the student grades
    public int compareTo(StudentGrade stdGrade){
        return this.grade.compareTo(stdGrade.grade);
    }

    //ToString method to print the first names, last names and grades in required allignment
    @Override
    public String toString(){
        String output = String.format("%13s %-3s \t:%5d ",getFirstName(), getLastName(),getGrade());
        return output;
    }
}
