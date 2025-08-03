package BasicDataStructure.StackDataStructure;

import java.util.Scanner;
/*
 * Inside this class we have created a feature where we creating a stack which is based
 * on First-In Last-out principle (FILO). To implement that data structure we have used
 * fixed size array to represent fixed size stack implementation
 * The operation we will perform is:
 * 1) Push() methord
 * 2) Pop() methord
 * 3) IsEmpty() methord
 * 4) Peek() methord
 * 5) Display() methord
 */
public class arrayImplementationStack {
    // define the properties
    int size = 10;
    int index= -1;
    int[] arr = new int[size];
    // define the Scanner
    Scanner input =  new Scanner(System.in);

    // define the constructor()
    public arrayImplementationStack(){}

    // define the push() methord
    /*
     * Inside this methord we have created a feature where we inserted data inside the stack and we 
     * only insert element in stack until stack overflow condition don't fullfill
     */
    public void push(){
        // define the condition
        while(true){
            System.out.println("************CHOICE***********\n"+
                               "  PRESS 1: Insert Data\n"+
                               "  PRESS 0: Don't Insert\n"+
                               "*****************************");
            System.out.println("Enter the choice:");
            int choice = input.nextInt();
            // define the condition
            if(choice == 0){
                break;
            }
            else if(choice == 1){
                // define the condition
                index++;
                if(index> size-1){
                    System.out.println("Sorry !! Stack overflow Condition");
                }
                else{
                    System.out.println("Enter the data:");
                    int data = input.nextInt();
                    arr[index] = data;
                }
            } 
            else{
                System.out.println("SORRY !! Invalid choice");
            }                  
        }
           
    }

    // define the isEmpty() methord
    /*
     * Inside this methord we have created a feature to check weather stack is Empty or not. 
     */
    public void isEmpty(){
        // define the condition
        if(index == -1){
            System.out.println("Stack is Empty");
        }
        else{
            System.out.println("stack is not empty");
        }
    }

    // define the pop() methord
    /*
     * Inside this methord we have created a feature where we delete the element from stack
     * based on first In - Last out principle
     */
    public void pop(){
        // define the condition
        while(true){
            System.out.println("************CHOICE*************\n"+
                               "   PRESS 1: Remove Element\n"+
                               "   PRESS 2: Don't Remove\n"+
                               "******************************");
            System.out.println("Enter the choice:"); 
            int choice = input.nextInt();
            if(choice == 2){
                break;
            }  
            else if(choice == 1){             
                if(index == -1){
                    System.out.println("Stack underflow condition");
                    break;
                }
                index--;
                System.out.println("CONGRATULATIONS !! Element is removed");
            }
            else{
                System.out.println("SORRY!! Invalid choice");
            }    
        } 
    }


    // define the peek() methord
    /*
     * Inside this methord we have created a feature where we display the last element
     * present in stack without removing the last element from the stack
     */
    public void peek(){
        if(index == -1){
            System.out.println("SORRY !! Stack underflow condition");
        }
        else{
            System.out.println("The last element present in stack is :"+ arr[index]);
        }    
    }


    // define the display() methord
    /*
     * Inside this methord we have created a feature where we display all element 
     * present in stack based on FILO principle
     */
    public void display(){
        if(index == -1){
            System.out.println("SORRY!! Stack underFlow condition");
        }
        else{
            System.out.println("The element present in stack is:");
            // define the for loop
            for(int i = 0;i<=index;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }    
    }

}
