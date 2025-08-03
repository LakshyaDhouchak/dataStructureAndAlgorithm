package BasicDataStructure.ArraysDataStructure;

import java.util.Scanner;
import java.util.Arrays;
public class StaticArray{

    // define the properties
    int pointer =-1;
    int size =10;
    int[] arr;
    Scanner sc=  new Scanner(System.in);

    // define the constructor
    public StaticArray(){
        
    }


    // define the create() methord
    /** 
     * Inside this methord we have add the functionality this methord is executed 
     * first before any operation it help to initialize the array properly and 
     * after than we perform operation on it.
     */
    public void create(){
        // define the array
        arr =  new int[size];
        System.out.println("The array is declared successfully with size :"+size);
        System.out.println("************CHOICE***********\n"+
                           "PRESS 0: 0 means don't insert\n"+
                           "PRESS 1: 1 means insert value\n"+
                           "*****************************");
        
        while(true){
            System.out.println("Enter the choice:");
            int choice = sc.nextInt();
            if(choice == 0){
                break;
            }
            else if(choice !=1){
                System.out.println("Invalid choice");
            }
            else{
                if(pointer<size){
                    System.out.println("Enter the data:");
                    int data = sc.nextInt();
                    arr[++pointer] = data;
                }
                else{
                    System.out.println("Stack overflow condition");
                }  
            }      
        }
    }


    // define the the traveral methord
    /*
     * Inside this methord we have added the feature where we can see the all  store
     * result value in array by traversing
     */
    public void traversal(){
        System.out.println("The array traversal is:");
        // define the for-loop
        for(int i=0;i<=pointer;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


    // define the search() methord
    /*
     * Inside this methord we have define the feature. so we can find the target
     * value in given data set by two ways:
     * 1) Linear Search
     * 2) Binary Search 
     */
    public void search(int target){
        System.out.println("***********CHOICE***********\n"+
                           " PRESS 0: Linear Search \n"+
                           " PRESS 1: Binary Search\n"+
                           "****************************");
        System.out.println("Enter the choice:");
        int choice = sc.nextInt();

        // define the switch() case
        switch(choice){
            case 0:
                // define the properties
                boolean flag = false;
                // define the for loop
                for(int i=0;i<=pointer;i++){
                    // define the condition
                    if(arr[i] == target){
                        System.out.println("Element found at index :"+i);
                        flag = true;
                        break;
                    }
                }
                // define the base condition 
                if(flag == false){
                    System.out.println("SORRY!! Element don't found");
                }
                break;
            case 1:
                // before apply binary search on data. NOTE: data most be sorted if not binary search
                // will not perform what actually they perfor means logic don't fit in insorted data.
                int[] arr1 = Arrays.copyOf(arr,pointer+1);
                Arrays.sort(arr1);
                // define the properties
                int l =0;
                int h =pointer;
                int mid =0;
                flag = false;
                while(l<=h){
                    mid = l+(h-l)/2;
                    // define the condition
                    if(arr1[mid]==target){
                        System.out.println("Element found at index:"+mid);
                        flag = true;
                        break;
                    }
                    else if(arr1[mid]>target){
                        h =mid-1;
                    }
                    else{
                        l = mid+1;
                    }
                }
                // define the base condition
                if(flag == false){
                    System.out.println("SORRY!! Element don't found");
                }
                break;
            default:
                System.out.println("SORRY!! NO SUCH CASE AVAILABLE");  
                System.out.println("************CHOICE***********\n"+
                                   "  Press 0: Linear Search\n"+
                                   "  Press 1: Binary Search\n"+
                                   "*****************************"); 
                break;                    

        }
    }


    // define the Insertion() methord
    /*
     * Inside this methord we have define the all  possible way to insert 
     * element in an array :
     * 1) Insert at starting
     * 2) Insert at end
     * 3) Insert at middle(Before/After)
     */
    public void insert(){
        // define the base condition
        if(pointer == size-1){
            System.out.println("Stack overflow condition");
        }
        else{
            System.out.println("Enter the data to be inserted:");
            int data = sc.nextInt();
            System.out.println("************CHOICE************\n"+
                               "  Press 1: Insert at starting\n"+
                               "  Press 2: Insert at middle\n"+
                               "  Press 3: Insert at end\n"+
                               "******************************");
            System.out.println("Enter the choice:");
            int choice= sc.nextInt();

            // define the switch case
            switch(choice){
                case 1:
                    // define the condition
                    if(pointer == size-1){
                        System.out.println("Stack underFlow condition");
                    }
                    else{
                        // define the for loop
                        for(int i = pointer;i>=0;i--){
                            arr[i+1] = arr[i];
                        }
                        arr[0] = data;
                        pointer++;
                        System.out.println("Element Insert Successfully at starting");
                    }
                    break;
                case 2:
                    // define the condition
                    if(pointer == size-1){
                        System.out.println("Stack underFlow condition");
                    }
                    else{
                        System.out.println("Enter the index:");
                        int index = sc.nextInt();
                        //define the base condition
                        if(index>pointer&& index>=0){
                            System.out.println("Sorry Can't insert Index Out of Bound");
                        }
                        else{
                            System.out.println("************CHOICE*************\n"+
                                               "  PRESS 0: Insert Before index\n"+
                                               "  PRESS 1: Insert After index\n"+
                                               "********************************");
                            System.out.println("Enter the choice:");
                            choice = sc.nextInt(); 
                            
                            switch(choice){
                                case 0:
                                    // define the for loop
                                    for(int i = pointer;i>=index;i--){
                                        arr[i+1] = arr[i];
                                    }
                                    arr[index] = data;
                                    pointer++;
                                    System.out.println("Element is insert succesfully before index");
                                    break;
                                case 1:
                                    // define the for loop
                                    for(int i = pointer;i>index;i--){
                                        arr[i+1] = arr[i];
                                    }  
                                    arr[index+1] = data;
                                    pointer++;
                                    System.out.println("Element is insert successfully after index");
                                    break;
                                default:
                                    System.out.println("SORRY!! No Such case available "); 
                                    break;   

                            }
                        }
                    }
                    break;
                case 3:
                    if(pointer==size-1){
                        System.out.println("Stack overflow condition");
                    }
                    else{
                        arr[pointer+1]= data;
                        pointer++;
                        System.out.println("Element is insert successfully at end");
                    }
                    break;
                default:
                    System.out.println("SORRY!! No such case available");
                    System.out.println("************CHOICE************\n"+
                                       "  Press 1: Insert at starting\n"+
                                       "  Press 2: Insert at middle\n"+
                                       "  Press 3: Insert at end\n"+
                                       "******************************"); 
                    break;                            
            }

        }
    }


    // define the deletion methord
    /*
     * Inside this methord we have define thee way to delete element in array and varoius
     * condition to perform operation without any error :
     * 1) Delete at starting
     * 2) Delete at end
     * 3) Delete at middle
     */
    public void delete(){
        // define the condition
        if(pointer == -1){
            System.out.println("Stack underFlow condition");
        }
        else{
            System.out.println("************CHOICE*************\n"+
                               "  PRESS 0: Delete at start\n"+
                               "  PRESS 1: Delete at end\n"+
                               "  PRESS 2: Delete at middle\n"+
                               "*******************************");
            System.out.println("Enter the choice:");
            int choice = sc.nextInt();
            
            switch(choice){
                case 0:
                    // define the for loop
                    for(int i=0;i<pointer;i++){
                        arr[i] = arr[i+1];
                    }
                    pointer--;
                    System.out.println("Element is successfully deleted at starting");
                    break;
                case 1:
                    pointer--;
                    System.out.println("Element is successfully deleted at end");
                    break;
                case 2:
                    System.out.println("Enter the index:");
                    int index = sc.nextInt();
                    // define the condition
                    if(index>pointer&&index>=0){
                        System.out.println("SORRY!! Can't delete because Index out of bound");
                    } 
                    else{
                         // define the for loop
                         for(int i = index;i<pointer;i++){
                            arr[i] =arr[i+1];
                         }
                         pointer--;
                         System.out.println("Element is successfully deleted in middle");
                    }
                    break;
                default:
                    System.out.println("SORRY!! No Such case available"); 
                    System.out.println("Available choice "); 
                    System.out.println("************CHOICE*************\n"+
                                       "  PRESS 0: Delete at start\n"+
                                       "  PRESS 1: Delete at end\n"+
                                       "  PRESS 2: Delete at middle\n"+
                                       "*******************************");
                    break;                            
            }
        }
    }



}
