package Main;
import java.util.Scanner;

import Algorithms.SortingAlgorithms.QuickSort;

//import Algorithms.SearchingAlgorithms.BinarySearch;
//import Algorithms.SortingAlgorithms.InsertionSort;
//import Algorithms.SortingAlgorithms.SelectionSort;
//import Algorithms.SortingAlgorithms.BubbleSort;
//import Algorithms.SortingAlgorithms.MergeSort;
//import Algorithms.SortingAlgorithms.QuickSort;

//import ArrayDataStructure.DynamicArray;
//import ArrayDataStructure.StaticArray;
public class App {
    public static void main(String[] args) {
        // calling the Scanner
        Scanner input = new Scanner(System.in);
        // calling the StaticArray class
        int[] arr = {20,40,60,80,10,30,100,50,90,70,50};
        //MergeSort a =  new MergeSort();
        QuickSort a = new QuickSort();
        a.quickSort(arr,0,10);
        a.display(arr);
        //InsertionSort a =  new InsertionSort();
        //BubbleSort a =  new BubbleSort();
        //a.sort();
        //BinarySearch a =  new BinarySearch(10);
        //a.search();
        /* 
        CircularQueue a =  new CircularQueue(5);
        a.Enqueue();
        a.display();
        a.dequeue();
        a.display();
        a.Enqueue();
        a.peek();
        a.display();
        a.isEmpty();
        */
        // close the Scanner
        input.close();
        
    }
}
