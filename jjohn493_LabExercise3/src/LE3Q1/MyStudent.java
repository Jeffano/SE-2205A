package LE3Q1;

public class MyStudent {
    private String firstName;
    private Double score;

    public MyStudent(){
        firstName = "Jeffano";
        score = 04.08;
    }

    public MyStudent(String firstName, Double score){
        this.firstName = firstName;
        this.score = score;
    }

    @Override
    public String toString(){
        String statement;
        statement = String.format(firstName + ": %.2f", score);
        return statement;
    }

}
