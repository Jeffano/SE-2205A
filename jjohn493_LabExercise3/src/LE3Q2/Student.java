package LE3Q2;

public class Student implements Comparable<Student>{

    private Double score;
    private String firstName;
    private String lastName;

    public Student(){
        firstName = "Jeffano";
        lastName = "John";
        score = 04.08;
    }

    public Student(String firstName, String lastName, Double score){
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    public void setScore(Double score){
        this.score=score;
    }

    public Double getScore(){
        return score;
    }

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

    public String toString(){
        String statement;
        statement = String.format(firstName + " " + lastName + ": %.2f", score);
        return statement;
    }

    public int compareTo(Student stdScore){
        return this.score.compareTo(stdScore.score);
    }
}
