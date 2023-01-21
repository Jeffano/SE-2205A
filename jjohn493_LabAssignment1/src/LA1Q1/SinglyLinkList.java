package LA1Q1;

public class SinglyLinkList <T> {

    //Initializing the head,tail nodes for the list and the size variable of the list
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    //constructor for the singlylinklist with parameters
    public SinglyLinkList(Node<T> head, Node<T> tail, int size){
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    //constructor for the singlylinklist with empty parameters
    public SinglyLinkList(){}

    //returns the size of the linked list
    public int getSize(){
        return size;
    }

    //function to check if the linked list is empty or not
    public boolean isEmpty(){
        if (getSize() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    //Method of to print to string with commas and square brackets
    public String toString(){
        Node<T> main = head;
        String output = "";

        if (size > 0)
        {
            while(main.getNext() != null)
            {
                output += main.getElement();
                if (main.getNext() == null)
                {
                    break;
                }
                output += ", ";
                main = main.getNext();
            }
            output += main.getElement();
            output = String.format("[%s]", output);
        }
        else
        {
            output = String.format("[]");
        }
        return (output);
    }

    //Function to add the element to the head to the linked list by creating a new node and assigning to it
    public void addFirst(T t){
        head = new Node<>(t,head);
        if (getSize() == 0){
            tail = head;
        }
        size++;
    }

    //Function to add the element to the tail of the linked list by creating a new node and assigning the value to it
    public void addLast(T t){
        Node<T> newest = new Node<>(t, null);
        if (isEmpty()){
            head = newest;
        }
        else{
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    //Function to remove the first element (the head) of the linked list and assign the second node as the head and decreases the size
    public T removeFirst(){
        if (isEmpty()){
            return null;
        }

        T answer = head.getElement();
        head = head.getNext();
        size--;

        if (size == 0){
            tail = null;
        }
        return answer;
    }

    //Function to loop through the linked list to find the second last and set the tail to null and return it and decreases the size
    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        Node<T> last = head;
        Node<T> secondLast = null;

        while (last.getNext() != null)
        {
            secondLast = last;
            last = last.getNext();
        }
        secondLast.setNext(null);

        tail = secondLast;
        size--;

        return last.getElement();
    }

    //Function to stack the element to the linked list which is done by calling the addFirst function
    public void pushAtHead(T element){
        addFirst(element);
    }

    //Function to remove the first element from the list, calls the remove first function while returning the value that has been removed
    public T popFromHead(){
        return removeFirst();
    }

    //Function to add the element to end of list which is done by calling the addLast function
    public void pushAtTail(T element){
        addLast(element);
    }

    //Function to remove the last element from the linked list by calling the removeLast method and returns the value that has been popped
    public T popFromTail(){
        return removeLast();
    }

    //Function to add the string to the end of the queue using the addLast function
    public void enqueueAtTail(T element){
        addLast(element);
    }

    //Function to remove the first string from the queue using the removeFirst function and returns the string that was removed
    public T dequeueAtHead(){
        return removeFirst();
    }

    //Function to scan through the list using a for loop and searching for the element that was entered by the user, then outputting the location
    public int searchStack(T element){
        if (getSize()==0){
            return 0;
        }
        Node<T> position = head;
        for (int i = 0; i < getSize(); i++) {
            if (position.getElement().equals(element))
            {
                return i + 1;
            }
            else
            {
                position = position.getNext();
            }
        }
        return 0;
    }
}
