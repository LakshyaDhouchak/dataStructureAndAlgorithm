package Algorithms.SortingAlgorithms;

import java.util.Scanner;
/*
 * Inside this code i have use a static array list to showcase how Selection sort code work on array and at
 * last i have printed the final array
 * 
 */
public class SelectionSort {
    // define the properties
    int[] arr = {10,30,50,20,40};
    int size = 5;

    // define the Scanner
    Scanner input =  new Scanner(System.in);

    // define the sort() methord
    public void sort(){
        System.out.println("Before Sorting!!!");
        display();
        // define the for-loop
        for(int i =0;i<size;i++){
            int max = i;
            for(int j = i+1;j<size;j++){
                // define the condition;
                if(arr[j]<=arr[max]){
                    max = j;
                }
            }
            int pointer = arr[i];
            arr[i] = arr[max];
            arr[max] = pointer;
            
        }
        System.out.println("After Sorting!!!");
        display();
    }

    // define the display() methord
    public void display(){
        System.out.println("The element present in array:");

        // define the for-loop
        for(int i =0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
