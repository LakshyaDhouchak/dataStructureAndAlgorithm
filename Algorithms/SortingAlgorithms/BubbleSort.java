package Algorithms.SortingAlgorithms;

/*
 * Inside this sorting technique to represent the we use static array to show case
 *  how sorting work 
 */
public class BubbleSort {
    // define the properties
    int[] arr ={10,40,50,20,30};
    int size = 5;

    // define the sort() methord
    public void sort(){
        System.out.println("Before Sorting!!!");
        display();
        // define the for-loop
        for(int i=0;i<size-1;i++){
            for(int j = 0;j<size-i-1;j++){
                // define the condition
                if(arr[j]>=arr[j+1]){
                    int pointer = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = pointer;
                }
            }
        }
        System.out.println("After Sorting!!!");
        display();
    }

    // define the display() methord
    public void display(){
        System.out.println("The element present in an array:");
        // define the for-loop
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
