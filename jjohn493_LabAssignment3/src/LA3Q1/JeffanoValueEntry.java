package LA3Q1;

public class JeffanoValueEntry {

    //Initializing the key variable
    private Integer key;

    //Setting the key as -1 when there is no argument
    public JeffanoValueEntry(){
        key = -1;
    }

    //Setting the key when there is an argument
    public JeffanoValueEntry(Integer key){
        this.key = key;
    }

    //Function to set the key
    public void setKey(Integer key){
        this.key = key;
    }

    //Function to get the key
    public Integer getKey(){
        return key;
    }
}
