package LE3Q1;

import java.util.ArrayList;

public class DoublyLinkedList <E>{
    public static class Node<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> prev, Node<E> next){
            this.element = e;
            this.prev = prev;
            this.next = next;
        }
        public E getElement(){
            return element;
        }

        public Node<E> getPrev(){
            return prev;
        }

        public Node<E> getNext(){
            return next;
        }

        public void setPrev(Node<E> prev){
            this.prev = prev;
        }

        public void setNext(Node<E> next){
            this.next = next;
        }
    }

    private Node<E> trailer;
    private Node<E> header;
    private int size;

    public DoublyLinkedList(){
        header = new Node<>(null,null,null);
        trailer = new Node<>(null,header,null);
        header.setNext(trailer);
    }

    public void addLast(E e){
        addBetween(e,trailer.getPrev(),trailer);
    }

    public void addBetween(E e, Node<E> predecessor, Node<E> successor){
        Node<E> newest = new Node<>(e,predecessor,successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public Node<E> findNode(E e){
        Node<E> head = header;
        while(head != null){
            if(head.getElement() == e){
                return head;
            }
            head = head.getNext();
        }
        return null;
    }

    public String toString(){
        ArrayList<E> output = new ArrayList<>();
        Node<E> head = header.getNext();
        for(int i = 0; i< size; i++){
            output.add(head.getElement());
            head = head.getNext();
        }
        return output.toString();
    }


}

