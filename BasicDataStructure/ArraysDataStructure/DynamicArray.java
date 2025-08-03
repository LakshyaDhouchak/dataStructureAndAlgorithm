package BasicDataStructure.ArraysDataStructure;



import java.util.Scanner;
public class DynamicArray {
    // calling the Scanner
    Scanner sc = new Scanner(System.in);

    // define the properties
    int capacity =2;
    int[] arr = null;
    int index = -1;
    int fillRatio = 75;

    // define the constructor
    public DynamicArray(){}
    public DynamicArray(int initialCapacity,int fillRatio){
        this.capacity = initialCapacity;
        this.fillRatio = fillRatio;
    }

    // define the create() methord
    /*
     * SITUATION 1:
     * Inside this create() methord we have write a feature if no of element is greater than 
     * capacity it will automatically grow the size by 2x capacity if fill ratio is greater or equal 
     * to 75% OR if index>=capacity-1;
     */
    public void create(){
        // initialization of an array
        arr = new int[capacity];
        while(true){
            // define the condition
            System.out.println("***********CHOICE************\n"+
                               "  PRESS 0: Don't insert\n"+
                               "  PRESS 1: Insert value\n"+
                               "*****************************");
            System.out.println("Enter the choice:");
            int choice = sc.nextInt();
            if(choice == 0){
                break;
            }  
            else if(choice !=1){
                System.out.println("Invalid choice:");
            } 
            else{
                if((index/capacity)*100 >=fillRatio|| index>=capacity-1){
                    Resize();
                }
                System.out.println("Enter the data:");
                int data = sc.nextInt();
                arr[++index] = data;
            }
        }                    
    }

    // define the ReSize() methord
    /*
     * Inside this methord we have written a feature if SITUATION 1 satisfy then it will increase 
     * the capacity by 2x and create and new array with that capacity and copy all element from
     * old array to new array by using:
     *          System.arraycopy(oldArray,StartingIndex,newArray,StartIndex,noOfElement(Size))
     */
    public void Resize(){
        capacity = 2*capacity;
        // define the array
        int[] arr1 = new int[capacity];
        System.arraycopy(arr,0,arr1,0,index+1);
        arr = arr1;
        arr1 = null;
    }

    // define the traversal() methord
    /*
     * Inside this methord we display all the array element in terminal by using for-loop
     */
    public void traversal(){
        System.out.println("The array traversal is:");
        // define the for loop
        for(int i=0;i<=index;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    // define the Search() methord
    /*
     * Inside this methord we have defined a feature where we can search our target value is present
     * or not.
     * By two ways: 
     * 1) Linear Search
     * 2) Binary Search
     */
    public void Search(int target){
        System.out.println("***********CHOICE**********\n"+
                           "  PRESS 1: Linear Search\n"+
                           "  PRESS 2: Binary Search\n"+
                           "***************************");
        System.out.println("Enter the choice:");
        int choice = sc.nextInt();
        
        // define the switch() case
        switch(choice){
            case 1:
                // define the properties
                int flag =0;
                // define the for loop
                for(int i=0;i<=index;i++){
                    // define the base condition
                    if(arr[i] == target){
                        System.out.println("The element found at index:"+i);
                        flag =1;
                        break;
                    }
                }
                if(flag ==0){
                    System.out.println("SORRY!! Element not found");
                }
                break;
            case 2:
                // define the properties
                flag =0;
                int mid =0;
                int l =0;
                int h =index;

                /*
                 * NOTE: Binary Search is applicale only on sorted array and Here, we are assuming
                 * that array is unsorted . so. firstly sort the data in ascending order. by using
                 *          Arrays.sort(array_name);
                 */
                int[] sortedArray = new int[index+1];
                for(int i=0;i<=index;i++){
                    sortedArray[i] = arr[i];
                }
                
                while(l<=h){
                    mid = l+(h-l)/2;
                    // define the condition
                    if(sortedArray[mid]==target){
                        System.out.println("Element found at index:"+mid);
                        flag =1;
                        break;
                    }
                    else if(sortedArray[mid]>target){
                        h = mid-1;
                    }
                    else{
                        l = mid+1;
                    }
                }
                if(flag ==0){
                    System.out.println("SORRY !! Element not found");
                }
                break;
            default:
                System.out.println("No Such case available");
                System.out.println("**********CHOICE***********\n"+
                                   "   PRESS 1: Linear Search\n"+
                                   "   PRESS 2: Binary Search\n"+
                                   "****************************");   
                break;                    
        }
    }

    // define the insertion() methord
    /*
     * Inside this methord we have define the feature to insert value by three ways:
     * 1) Insert at starting
     * 2) Insert at middle(Before/After)
     * 3) Insert at end
     */
    public void insertion(){
        System.out.println("Enter the data to be inserted:");
        int data = sc.nextInt();
        if((index/capacity)*100 == fillRatio || index>=capacity){
            Resize();
        }
        System.out.println("************CHOICE**************\n"+
                           "  PRESS 0: Insert at starting\n"+
                           "  PRESS 1: Insert at middle\n"+
                           "  PRESS 2: Insert at end\n"+
                           "********************************");
        System.out.println("Enter the choice:");
        int choice = sc.nextInt();
        
        // define the switch() case
        switch(choice){
            case 0:
                // define the for loop
                for(int i = index;i>=0;i--){
                    arr[i+1] = arr[i];
                }
                arr[0] = data;
                index++;
                System.out.println("Element is inserted sucessfully ay starting");
                break;
            case 1:
                System.out.println("Enter the index:");
                int position = sc.nextInt();
                // define the condition
                if(position>index){
                    System.out.println("SORRY!! Index out of bound");
                }
                System.out.println("**********CHOICE**********\n"+
                                   "  PRESS 0: Before index\n"+
                                   "  PRESS 1: After index\n"+
                                   "**************************");
                System.out.println("Enter the choice:");
                choice = sc.nextInt();

                // define the switch()
                switch(choice){
                    case 0:
                        // define the for loop
                        for(int i = index;i>=position;i--){
                            arr[i+1] = arr[i];
                        }
                        arr[position] = data;
                        index++;
                        System.out.println("Element is inserted successfully in middle before index");
                        break;
                    case 1:
                        // define the for loop
                        for(int i =index;i>position;i--){
                            arr[i+1]= arr[i];
                        }
                        arr[position+1] = data;
                        index++;
                        System.out.println("Element sucessfully inserted in middle after index");
                        break;
                    default:
                        System.out.println("SORRY!! No such case available"); 
                        System.out.println("**********CHOICE**********\n"+
                                   "  PRESS 0: Before index\n"+
                                   "  PRESS 1: After index\n"+
                                   "**************************");
                        break;              
                }
                break;
            case 2:
                arr[++index]= data;
                System.out.println("Element inserted at last Scucessfully");
                break;
        }
    }


    // define the deletion methord
    /*
     * Inside this methord we have created a feature to delete element from array.By three way:
     * 1) Delete at starting
     * 2) Delete at middle
     * 3) Delete at end
     */
    public void delete(){
        // define the condition
        if(index == -1){
            System.out.println("Stack underflow condition");
        }
        System.out.println("*************CHOICE*************\n"+
                           "  PRESS 0:Delete at starting\n"+
                           "  PRESS 1:Delete at middle\n"+
                           "  PRESS 2:Delete at end\n"+
                           "********************************");
        System.out.println("Enter the choice:");
        int choice = sc.nextInt();  
        
        // define the switch()
        switch(choice){
            case 0:
                // define the for loop
                for(int i=0;i<=index;i++){
                    arr[i] = arr[i+1];
                }
                index--;
                System.out.println("Element is deleted from starting");
                break;
            case 1:
                System.out.println("Enter the index:");
                int index1 = sc.nextInt();
                // define the condition
                for(int i = index1;i<=index;i++){
                    arr[i] = arr[i+1];
                }
                index--;
                System.out.println("Element is deleted from middle");
                break;
            case 2:
                index--;
                System.out.println("Element is Removed from last"); 
                break;
            default:
                System.out.println("SORRY!! NO such case available"); 
                System.out.println("*************CHOICE*************\n"+
                                   "  PRESS 0:Delete at starting\n"+
                                   "  PRESS 1:Delete at middle\n"+
                                   "  PRESS 2:Delete at end\n"+
                                   "********************************");
                break;

        }
    }
}
