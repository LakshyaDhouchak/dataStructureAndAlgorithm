package BasicDataStructure.StackDataStructure;

import java.util.Scanner;

/*
 * Inside this class we have implemented dynamic stack by the help of linkedlist .And we perform
 * differnt operation:
 * 1) push() methord
 * 2) pop() methord
 * 3) display() methord
 * 4) peek() methord
 * 5) isEmpty() methord
 */

public class dynamicStackImplementation {
    // define the properties
    node head = null;

    // define the Scanner
    Scanner input =  new Scanner(System.in);

    // define the staic class node
    static class node{
        // define the properties
        int data;
        node next;
        // define the constructor
        public node(int data){
            this.data =  data;
            this.next = null;
        }
    }

    // define the push() methord
    /*
     * Inside this methord we have created a feature where we insert data in stack based on FILO 
     * principle 
     */
    public void push(){
        // define the properties
        while(true){
            System.out.println("***********CHOICE***********\n"+
                               "  PRESS 1: Insert data\n"+
                               "  PRESS 2: Don't Insert\n"+
                               "****************************");
            System.out.println("Enter the choice:");
            int choice = input.nextInt();
            
            // define the condition
            if(choice == 2){
                break;
            }
            else if(choice == 1){
                System.out.println("Enter the data:");
                int data = input.nextInt();
                // calling the node class
                node node =  new node(data);
                // define the condition
                if(head == null){
                    head = node;
                }
                else{
                    node.next = head;
                    head = node;
                }
            }
            else{
                System.out.println("SORRY !! No such choice available");
            }
        }
    }


    // define the display() methord
    /*
     * Inside this methord we have created a feature where we display all element present in stack
     * using LinkedList
     */
    public void display(){
        // define the condition
        if(head == null){
            System.out.println("SORRY!! Stack is empty");
        }
        else{
            // define the properties
            System.out.println("The element present in stack is:");
            node duplicate =  head;
            while(duplicate!=null){
                System.out.print(duplicate.data+" ");
                duplicate = duplicate.next;
            }
            System.out.println();
        }
    }


    // define the isEmpty() methord
    /*
     * Inside this methord we have created a feature where we check stack is empty or not
     */
    public void isEmpty(){
        // define the condition
        if(head == null){
            System.out.println("Stack is empty");
        }
        else{
            System.out.println("Stack is not empty");
        }
    }


    // define the pop() methord
    /*
     * Inside this methord we created a feature where we delete the element 
     * from stack based on first in - last out priciple
     */
    public void pop(){
        while(true){
            System.out.println("***********CHOICE***********\n"+
                               "  PRESS 1: Delete Element\n"+
                               "  PRESS 2: Don't Remove\n"+
                               "****************************");
            System.out.println("Enter the choice:");
            int choice = input.nextInt();
            // define the condition
            if(choice ==1){
                if(head == null){
                    System.out.println("Stack underflow condition");
                }
                head = head.next;
                System.out.println("Element is renoved successfully ");
            }  
            else if(choice == 2){
                break;
            } 
            else{
                System.out.println("SORRY!! Invalid choice");
            }                
        }
    }


    // define the peek() methord
    /*
     * Inside this methord we have created a feature where print the last element from the stack
     * without removing the element present in stack;
     */
    public void peek(){
        // define the condition
        if(head == null){
            System.out.println("stack underflow condition");
        }
        else{
            System.out.println("The last element present in stack is:"+ head.data);
        }
    }

}
