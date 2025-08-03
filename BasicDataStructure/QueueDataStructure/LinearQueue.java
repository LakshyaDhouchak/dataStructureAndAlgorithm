package BasicDataStructure.QueueDataStructure;

import java.util.Scanner;
/*
 * Inside this methord we have created a feature where we implement Linear Queue data structure using static
 * Array.The methord we have perform in Linear Queue
 * 1) Enqueue() methord
 * 2) Dequeue() methord
 * 3) isEmpty() methord
 * 4) peek() methord
 * 5) Display() methord 
 */
public class LinearQueue {
    // define the prperties
    int size ;
    int head = -1;
    int tail = -1;
    int[] arr = null;

    // define the Scanner
    Scanner input =  new Scanner(System.in);

    // define the constructor
    public LinearQueue(){
        size = 2;
        arr =  new int[size];
    }
    public LinearQueue(int size){
        this.size = size;
        arr = new int[size];
    }

    // define the Enqueue() methord
    public void Enqueue(){
        while(true){
            System.out.println("************CHOICE************\n"+
                               "  PRESS 1: Insert Element\n"+
                               "  PRESS 2: Don't Insert data\n"+
                               "******************************");
            System.out.println("Enter the choice:");
            int choice = input.nextInt();
            // define the condition
            if(choice == 1){
                if(tail >size-1){
                    System.out.println("SORRY!! Queue overflow condition");
                }
                else{
                    System.out.println("Enter the data:");
                    int data = input.nextInt();
                    // define the base condition
                    if(head == -1 && tail == -1 ){
                        arr[++head] = data;;
                        ++tail;
                    }
                    else{
                        arr[++tail] = data;
                    }
                }    
            } 
            else if(choice == 2){
                break;
            }  
            else{
                System.out.println("SORRY!! Invalid choice");
            }                 
        }
    }


    // define the DeQueue() methord
    public void DeQueue(){
        while(true){
            System.out.println("************CHOICE************\n"+
                               "   PRESS 1: Delete Element\n"+
                               "   PRESS 2: Don't Delete\n"+
                               "******************************");
            System.out.println("Enter the choice:");
            int choice = input.nextInt();
            // define the condition
            if(choice == 1){
                // define the condition
                if(head == -1 && tail == -1){
                    System.out.println("SORRY!! Queue is empty");
                }
                else{
                    if(head>tail){
                        System.out.println("Stack underflow condition");
                        head = -1;
                        tail = -1;
                        return;
                    }
                    else if(head == tail){
                        head = -1;
                        tail = -1;
                    }
                    else{
                        head++;
                    }
                    
                }
            }
            else if(choice == 2){
                break;
            } 
            else{
                System.out.println("SORRY !! invalid choice");
            }                   
        }
    }


    // define the display() methord
    public void display(){
        // define the condition
        if(head == -1 && tail== -1){
            System.out.println("SORRY!! Queue is empty");
        }
        else{
            System.out.println("The element present in queue is:");
            // define the for loop
            for(int i =head;i<=tail ;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }


    // define the isEmpty() methord
    public void isEmpty(){
        if(head == -1 && tail == -1){
            System.out.println("SORRY!! Queue is empty");
        }
        else{
            System.out.println("CONGRATULATION!! Queue is not empty");
        }
    }

    // define the peek() methord
    public void peek(){
        // define the condition
        if(head == -1 && tail == -1){
            System.out.println("SORRY !! Queue is empty");
        }
        else{
            System.out.println("The starting element present in queue is:"+arr[head]);
        }
    }
}
