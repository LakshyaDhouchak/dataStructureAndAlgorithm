package Main;
import java.util.Scanner;

import BasicDataStructure.QueueDataStructure.CircularQueue;
//import BasicDataStructure.LinkedListDataStructure.CircularLinkedList;
import BasicDataStructure.QueueDataStructure.LinearQueue;
//import BasicDataStructure.LinkedListDataStructure.DoubleLinkedList;
//import BasicDataStructure.LinkedListDataStructure.SingleLinkedList;
//import BasicDataStructure.StackDataStructure.arrayImplementationStack;
//import BasicDataStructure.StackDataStructure.dynamicStackImplementation;

//import ArrayDataStructure.DynamicArray;
//import ArrayDataStructure.StaticArray;
public class App {
    public static void main(String[] args) {
        // calling the Scanner
        Scanner input = new Scanner(System.in);
        // calling the StaticArray class
        CircularQueue a =  new CircularQueue(5);
        a.Enqueue();
        a.display();
        a.dequeue();
        a.display();
        a.Enqueue();
        a.peek();
        a.display();
        a.isEmpty();
        
        // close the Scanner
        input.close();
        
    }
}
