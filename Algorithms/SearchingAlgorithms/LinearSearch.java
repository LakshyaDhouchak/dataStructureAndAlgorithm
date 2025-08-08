package Algorithms.SearchingAlgorithms;

import java.util.Scanner;
public class LinearSearch {
    // define the properties
    int size = 0;
    int index = -1;
    int[] arr;
    // calling the Scanner
    Scanner input =  new Scanner(System.in);

    // define the constructor
    public LinearSearch(){
        size = 5;
        arr =  new int[size];
    }
    public LinearSearch(int size){
        this.size = size;
        arr = new int[size];
    }

    // define the create() methord
    public void create(){
        while(true){
            System.out.println("**************CHOICE**************\n"+
                               "  PRESS 1: Insert Data\n"+
                               "  PRESS 2: Don't Insert Data\n"+
                               "*********************************");
            System.out.println("Enter the choice:");
            int choice = input.nextInt(); 
            // define the condition
            if(choice == 1){
                if(index == size-1){
                    System.out.println("SORRY !! Array overflow condition");
                    break;
                }
                else{
                    System.out.println("Enter the data:");
                    int data = input.nextInt();
                    arr[++index] = data;
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

    // define the search() methord
    public void search(){
        // define the properties
        int flag = 0;
        create();
        System.out.println("Enter the key:");
        int key = input.nextInt();

        if(index == 0){
            System.out.println("SORRY!! Array is Empty");
        }
        else{
            int i;
            // define the for loop
            for(i = 0;i<index;i++){
                // define the condition
                if(arr[i] == key){
                    flag = 1;
                    break;
                }
            }
            // define the condition
            if(flag == 0){
                System.out.println("SORRY!! Element not found");
            }
            else{
                System.out.println("CONGRATULATION!! Element found at index: "+i);
            }
        }    
    }
}
