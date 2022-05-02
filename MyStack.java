package assignment1;

import java.util.*;

/**
 * MyStack.java - is a linked structure that must function
 * according to the interface
 *
 * @author Angelynna Pyeatt and Amtoj Kaur
 * @version 10 April 2022
 */

public class MyStack<T> {
   
   /** holds head of stack*/
    Node head;
    
    /** boolean value for if stack is empty*/
    boolean isEmpty;
    
    /** holds size of stack*/
    int size;
    
    /**
      * constructor initializes boolean isEmpty
      */
    public MyStack() {
        this.isEmpty = true;
    }

    /**
      * returns if stack is empty
      *
      * @return boolean: isEmpty
      */
    public boolean isEmpty() {
        return isEmpty;
    }
    
    /**
      * adds the item to the top of the MyStack
      *
      * @param T item
      */
    public void push(T item) {
        if(isEmpty) {
            head = new Node(null, null, item);
            isEmpty = false;
            size++;
            return;
        }
        
        Node node = new Node(null, head, item);
        head.next = node;
        head = node;
        size++;

    }
    
    /**
      * returns the item on the top of the MyStack
      *
      * @ return T: head.value
      */
    public T peek() {
        if(isEmpty()) {
        	throw new EmptyStackException();
        }
        return head.value;
    }
    
    /**
      * removes and returns the item on the top of the MyStack
      * throws EmptyStackException if stack is empty
      *
      * @return T: front
      */
    public T pop() throws EmptyStackException {
        if(head ==  null){
           throw new EmptyStackException();
        }
        
        T front = null;
        if(!isEmpty) {
            front = head.value;
            
            if(head.prev == null) {
                isEmpty = true;
                head = null;
                size--;
                return front;
            }
            
            size--;
            head.prev.next = null;
            head = head.prev;

        }
        return front;
    }
    
    /**
      * returns the number of items in the MyStack
      *
      * return int: size
      */
    public int size() {
        return size;
    }
    
    /**
      * converts the contents of the MyStack to a String for display
      *
      * @return String: sb.toString()
      */
    public String toString() {
        Node hasNext = this.head;
        StringBuilder sb = new StringBuilder();
        
        while(hasNext != null) {
            sb.append(hasNext.value);
            hasNext = hasNext.prev;
        }
        
        return sb.toString();
    }
    
    /**
      * Class Node is a helper class
      * Node holds next and previous references and node values
      */
    class Node {
        /** holds reference to next node*/
        Node next;
        
        /** holds reference to previous node*/
        Node prev;
        
        /** holds T value of node*/
        T value;
        
        /**
          * constructor: instantiates next, prev, value
          *
          * @param Node next
          * @param Node prev
          * @param T value
          */
        public Node(Node next, Node prev, T value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }
}