package BasicDataStructure.QueueDataStructure;

import java.util.Scanner;
/*
 * Inside this class i have implement CircularQueue so we can use the properly the space which is available after delete element to
 * insert new element like "Circular chain ". This circular Queue is static is nature.
 * The operation we will perform:
 * 1) enQueue() methord
 * 2) deQueue() mehord
 * 3) display() methord
 * 4) isEmpty() methord
 * 5) peek() methord
 */
public class CircularQueue {
    // define the properties
    int size;
    int head =-1;
    int tail  = -1;
    int[] arr = null;

    // define the Scanner
    Scanner input = new Scanner(System.in);

    // define the constructor
    public CircularQueue(){
        size = 5;
        arr = new int[size];
    }
    public CircularQueue(int size){
        this.size = size;
        arr = new int[size];
    }

    // define the Enqueue() methord
    /*
     * Inside this class i have implemented a feature we can add element in circular Queue 
     */
    public void Enqueue(){
        // define the condition
        while(true){
            System.out.println("**************CHOICE*************\n"+
                               "   PRESS 1: Insert data\n"+
                               "   PRESS 2: Don't Insert data\n"+
                               "*********************************");
            System.out.println("Enter the choice:");
            int choice = input.nextInt(); 
            // define the condition
            if(choice == 1){
                if((head == 0 && tail == size-1)|| tail == head-1){
                    System.out.println("SOORY !! Queue overflow condition");
                    break;
                }
                System.out.println("Enter the data:");
                int data = input.nextInt();
                if(head == -1){
                    head = 0;
                    tail = 0;
                    arr[head] = data;
                }
                else{
                    if(tail == size-1){
                        tail = 0;
                    }
                    else{
                        tail++;
                    }
                    arr[tail] = data;
                }
                System.out.println("CONGRATULATION!! Element Insert successfully");
            }
            else if(choice == 2){
                break;
            }
            else{
                System.out.println("SORRY !! Invalid choice");
            }
        }    
    }


    // define the Dequeue() methord
    /*
     * Inside this methord we have  implemented a feature where delete the element present in circular queue
     */
    public void dequeue(){
        while(true){
            System.out.println("*************CHOICE**************\n"+
                               "  PRESS 1: Delete Element\n"+
                               "  PRESS 2: Don't Delete\n"+
                               "*********************************");
            System.out.println("Enter the choice:");
            int choice = input.nextInt();
            
            // define the condition
            if(choice == 1){
                if(head == -1){
                    System.out.println("SORRY!! Queue overflow condition");
                }
                else{
                    if(head == tail){
                        head = -1;
                        tail = -1;
                    }
                    else{
                        if(head == size-1){
                            head = 0;
                        }
                        else{
                            head++;
                        }    
                    }
                    System.out.println("CONGRATULATION!! Element is removed");
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


    // define the Display() methord
    /*
     * Inside this methord we print all element present in circular Queue
     */
    public void display(){
        // define the condition
        if(head == -1){
            System.out.println("SORRY !! Queue is Empty");
        }
        else{
            System.out.println("The element present in queue is:");
            int duplicate = head;
            while(true){
                System.out.print(arr[duplicate]+" ");
                if(duplicate == tail){
                    break;
                }
                else{
                    if(duplicate == size-1){
                        duplicate = 0;
                    }
                    else{
                        duplicate++;
                    }
                }
            }
            System.out.println();
        }    
    }


    // define the isEmpty() methord
    /*
     * Inside this methord we have created a feature where check weather Circular Queue is Empty or not.
     */
    public void isEmpty(){
        // define the condition
        if(head == -1 && tail == -1){
            System.out.println("CONGRATULATION!! Queue is Empty");
        }
        else{
            System.out.println("SORRY !! Queue is not empty");
        }
    }


    // define the peek() methord
    /*
     * Inside this methord we have print the starting element of Circular Queue without remove element
     */
    public void peek(){
        // define the condition
        if(head == -1){
            System.out.println("SORRY!! Queue is empty");
        }
        else{
            System.out.println("The starting element present in queue is: "+ arr[head]);
        }
    }
}
