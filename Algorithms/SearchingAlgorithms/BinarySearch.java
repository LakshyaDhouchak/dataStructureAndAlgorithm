package Algorithms.SearchingAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    // define the properties
    int size = 0;
    int index = 0;
    int[] arr = null;
    int flag = 0;

    // define the Scanner
    Scanner input =  new Scanner(System.in);
    // define the constructor
    public BinarySearch(){
        size = 10;
        arr = new int[size];
    }
    public BinarySearch(int size){
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
                    arr[index++] = data;
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
        create();
        int[] arr1 = new int[index];
        for(int i =0;i<index;i++){
            arr1[i] = arr[i];
        }
        Arrays.sort(arr1);
        System.out.println("Enter the Key:");
        int key = input.nextInt();

        if(index == 0){
            System.out.println("SORRY!! Array is empty");
        }
        else{
            // define the condition
            int flag = 0;
            int start = 0;
            int end = index-1;
            int mid = 0;
            while(start<=end){
                mid = start+(end-start)/2;
                if(arr1[mid] == key){
                    System.out.println("CONGRATULATION!! Element found at index:"+mid);
                    flag = 1;
                    break;
                }
                else if(arr1[mid]<key){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            if(flag == 0){
                System.out.println("CONGRATULATION !! Element not found");
            }
        }    
    }
}
