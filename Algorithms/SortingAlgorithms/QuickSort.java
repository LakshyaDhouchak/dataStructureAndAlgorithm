package Algorithms.SortingAlgorithms;

public class QuickSort {

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);  
            quickSort(arr, partitionIndex + 1, high); 
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  
        int start = low;        
        int end = high - 1;     

        while (start <= end) {
            while (start <= end && arr[start] < pivot) {
                start++;
            }
        
            while (start <= end && arr[end] > pivot) {
                end--;
            }

            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }

    
        swap(arr, start, high);
        return start; 
    }

    // Helper method to swap elements
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Display the array
    public void display(int[] arr) {
        System.out.println("Sorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}