package LA1Q1;

public class Node <T>{
    //Creating the variables to store the element and the subsequent node
    private T element;
    private Node<T> next;

    //Creating the node constructor with empty parameter
    public Node() {}

    //creating the node constructor with constructors
    public Node(T element, Node<T> next){
        this.element = element;
        this.next = next;
    }

    //function to return the link to the next node
    public Node<T> getNext(){
        return next;
    }

    //function to return the element
    public T getElement(){
        return element;
    }

    //function to set the next node
    public void setNext(Node<T> next){
        this.next = next;
    }
}
