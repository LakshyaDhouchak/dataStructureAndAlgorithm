package Algorithms.SortingAlgorithms;

public class MergeSort {

    // define the mergeSort() methord
    public void mergeSort(int[] arr,int l,int h){
        // define the properties
        int mid = 0;
        if(l<h){
            mid = l+(h-l)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, h);
            sort(arr,l,h,mid);
        }
    }

    // define the sort() methord
    public void sort(int[] arr, int l,int h, int mid){
        // define the properties
        int l1 = mid-l+1;
        int l2 = h-mid;
        int i = 0;
        int j = 0;
        int k = l;

        // define the array
        int[] left = new int[l1];
        int[] right = new int[l2];
        // define the for loop
        for(int i1 = 0;i1<l1;i1++){
            left[i1] = arr[i1+l];
        }
        for(int i1=0;i1<l2;i1++){
            right[i1] = arr[i1+mid+1];
        }

        while(i<l1 && j<l2){
            if(left[i]<=right[j]){
                arr[k++] = left[i++];
            }
            else{
                arr[k++] = right[j++];
            }
        }
        while(i<l1){
            arr[k++] = left[i++];
        }
        while(j<l2){
            arr[k++] = right[j++];
        }
    }

    // define the display() methord
    public void display(int[] arr){
        System.out.println("The element present in an array:");
        for(int i=0;i<10;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
