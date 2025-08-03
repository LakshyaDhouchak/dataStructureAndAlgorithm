package BasicDataStructure.LinkedListDataStructure;

import java.util.Scanner;
public class DoubleLinkedList {
    // define the properties
    Node head = null;
    Node tail = null;

    // calling the Scanner
    Scanner input =  new Scanner(System.in);

    // define the constructor(No-args Constructor)
    public DoubleLinkedList(){}

    // define the node class as inner class
    static class Node{
        // define the properties
        int data;
        Node prev;
        Node next;
        // define the constructor
        public Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // define the create() methord
    /*
     * Inside this methord we have create a feature where we add the data inside 
     * double linkedlist( like a train box ) the advantage as compare to single linkedList
     * the double linkedlist is bidirectional.
     */
    public void create(){
        // define the properties
        while(true){
            System.out.println("*************CHOICE***************\n"+
                               "  PRESS 1: Insert value\n"+
                               "  PRESS 2: Don't Insert value\n"+
                               "**********************************");
            System.out.println("Enter the choice:");
            int choice = input.nextInt();
            
            // define the condition
            if(choice == 1){
                System.out.println("Enter the data:");
                int data = input.nextInt();
                // define the node class
                Node node =  new Node(data);
                if(head == null){
                    head = node;
                    tail = node;
                }
                else{
                    tail.next = node;
                    node.prev = tail;
                    tail = node;
                }
            }
            else if(choice == 2){
                break;
            } 
            else{
                System.out.println("SORRY !! Invalid choice");
            }                  
        }
    }


    // define the display() methord
    /*
     * Inside this methord we have define the feature to traversal of double linkedlist 
     */
    public void display(){
        // define the properties
        Node duplicate = null;
        System.out.println("************CHOICE**************\n"+
                           "  PRESS 1: Forward Traversal\n"+
                           "  PRESS 2: Backward Traversal\n"+
                           "********************************");
        System.out.println("Enter the choice:");
        int choice = input.nextInt();
        // define the switch() case
        switch(choice){
            case 1:
                // define the properties
                duplicate = head;
                // define the for-loop
                System.out.println("The Forward traversal is:");
                while(duplicate != null){
                    System.out.print(duplicate.data+" ");
                    duplicate = duplicate.next;
                }
                System.out.println();
                break;
            case 2:
                // define the properties
                duplicate = tail;
                // define the for -loop
                while(duplicate!= null){
                    System.out.print(duplicate.data+" ");
                    duplicate = duplicate.prev;
                }  
                System.out.println();
                break;

            default:
                System.out.println("SORRY !! No such case available");     
        }
    
    }

    // define the insertion() methord
    /*
     * Inside this methord we have define the properties to insert data in double linked
     * list .we mainly perform three operation:
     * 1) Insert at starting
     * 2) Insert at end
     * 3) Insert at middle
     */
    public void insertion(){
        // define the properties
        Node duplicate = head;
         System.out.println("Enter the data to be inserted:");
        int data = input.nextInt();
        // calling the node class
        Node node =  new Node(data);
        if(duplicate == null){
            head = node;
            return;
        }
        System.out.println("*************CHOICE*************\n"+
                           "  PRESS 1: Insert at starting\n"+
                           "  PRESS 2: Insert at middle\n"+
                           "  PRESS 3: Insert at end\n"+
                           "********************************");
        System.out.println("Enter the choice:");
        int choice = input.nextInt();
       
        
        // switch() case
        switch(choice){
            case 1:
                duplicate = head;
                node.next = head;
                head.prev = node;
                head = node;
                System.out.println("CONGRATULATION!! Element is inserted");
                break;
            case 2:
                // define the properties
                duplicate = head; 
                int flag = 0;
                System.out.println("Enter the index data:");
                int dataIndex = input.nextInt();
                // define the while loop
                while(duplicate !=null){
                    // define the base condition
                    if(duplicate.data == dataIndex){
                        flag =1;
                        break;
                    }
                    duplicate =  duplicate.next;
                }
                if(flag == 0){
                    System.out.println("SOORY !! Index data not found");
                    return;
                }
                System.out.println("*************CHOICE**************\n"+
                                   "  PRESS 1: Insert Before data\n"+
                                   "  PRESS 2: Insert After data\n"+
                                   "*********************************"); 
                System.out.println("Enter the choice:");
                choice = input.nextInt(); 
                
                // define the switch() case
                switch(choice){
                    case 1:
                        // define the condition
                        if(head == tail){
                            head.prev = node;
                            node.next = head;
                            tail = head;
                            head = node;
                        }
                        else{
                            node.next = duplicate;
                            node.prev = duplicate.prev;     
                            duplicate.prev = node;
                            node.prev.next = node;
                            System.out.println("CONGRATULATION !! Element is inserted");
                        }    
                       break;
                    case 2:
                       node.next = duplicate.next;
                       node.prev = duplicate;
                       duplicate.next.prev = node;
                       duplicate.next = node;
                       System.out.println("CONGRATULATION !! Element is inserted");
                       break;   
                }
                break;
            case 3:
                // define the properties
                duplicate = tail;
                node.prev = duplicate;
                duplicate.next = node;
                tail = node;
                System.out.println("CONGRATULATION !! Element is inserted");
                break;
            default:
                System.out.println("SORRY !! No such case avilable");           
        }
   }

   // define the delete() methord
   /*
    * Inside this methord we have created a feature where we have deleted element from double linkedlist
    * There are 3 ways to:
    * 1) Delete at start
    * 2) Delete at middle
    * 3) Delete at end
    */
   public void delete(){
        // define the properties
        Node duplicate = head;
        // define the condition
        if(duplicate == null){
            System.out.println("SORRY!! Double LinkedList is empty");
            return;
        }
        System.out.println("**************CHOICE************\n"+
                           "   PRESS 1: Delete at starting\n"+
                           "   PRESS 2: Delete at middle\n"+
                           "   PRESS 3: Delete at end\n"+
                           "*********************************");
        System.out.println("Enter the choice:");
        int choice = input.nextInt();

        switch(choice){
            case 1: 
                if(head == tail){
                    head = null;
                    tail = null;
                }
                else{
                    head = head.next;
                    head.prev = null;
                }
                System.out.println("CONGRATULATION!! Element is removed Successfully");
                break;
            case 2:
                System.out.println("Enter the data:");
                int data = input.nextInt();
                while(duplicate!=null){
                    // define the condition
                    if(duplicate.data == data){
                        break;
                    }
                    duplicate = duplicate.next;
                }
                duplicate.next.prev = duplicate.prev;
                duplicate.prev.next = duplicate.next;
                System.out.println("CONGRATULATION!! Element is removed Successfully");
                break;
            case 3:
                if(head == tail){
                    head = null;
                    tail = null;
                } 
                else{
                    tail = tail.prev;
                    tail.next = null;
                } 
                System.out.println("CONGRATULATION!! Element is removed Successfully");
                break;  
        }
   }

   // define the search() methord
   /*
    * Inside this methord we have created a feature where we search the element in
    * double linked list if present return Yes if not return No. In linkedList data 
    * is not contigious so only linear search applicable
    */
   public void search(int key){
        // define the properties
        Node duplicate = head;
        int flag =0;
        // define the condition
        if(duplicate == null){
            System.out.println("SORRY !! Double linkedList is empty");
        }
        else{
            while(duplicate != null){
                // define the condition
                if(duplicate.data == key){
                    System.err.println("CONGRATULATION !! Element found");
                    flag =1;
                    break;
                }
                duplicate = duplicate.next;
            }
            if(flag ==0){
                System.out.println("SORRY !! Element not found");
            }
        }
   }
}
