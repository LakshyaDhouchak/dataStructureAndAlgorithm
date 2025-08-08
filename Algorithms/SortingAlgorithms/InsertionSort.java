package Algorithms.SortingAlgorithms;

import java.util.Scanner;
/*
 * Inside this code i have  use a static array list to showcase how Insertion sort code work on array. And at
 * last i have printed the final array
 * 
 */
public class InsertionSort {
    // define the properties
    int[] arr = {40,20,50,10,30};
    int size = 5;

    // define the sort() methord
    public void sort(){
        System.out.println("Before Sorting!!!");
        display();
        // define the for-loop
        for(int i=1;i<size;i++){
            // define the properties
            int element = arr[i];
            int j = i-1;
            // define the condition
            while(j>=0 && arr[j]>element){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = element;
        }
        System.out.println("After Sorting!!!");
        display();
    }


    // define the display() methord
    public void display(){
        System.out.println("The element present in ana array:");
        // define the for-loop
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
