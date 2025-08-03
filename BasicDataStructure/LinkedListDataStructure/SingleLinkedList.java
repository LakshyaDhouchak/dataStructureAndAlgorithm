package BasicDataStructure.LinkedListDataStructure;

import java.util.Scanner;
public class SingleLinkedList {
    // define the node class
    /*
     * Inside this node class we have define two properties data of node and address of next node bydefault
     * it is null
     */
    static class node{
        // define the properties
        int data;
        node next;
        // define the constructor
        public node(int data){
            this.data = data;
            this.next = null;
        }
    }

    // define the properties
    node head = null;
    node duplicate = null;
    node node = null;

    // calling the Scanner
    Scanner input = new Scanner(System.in);

    // define the constructor
    public SingleLinkedList(){}

    // define the create() methord
    /* 
     * Inside this methord we have created a list of node which store the address of it next node
     * (like a train box) and last node next pointer is null and node start from pointer head
     */
    public void create(){
        while(true){
            System.out.println("************CHOICE*************\n"+
                           " Press 1: Insert node\n"+
                           " Press 2: Don't insert node\n"+
                           "*******************************");
            System.out.println("Enter the choice:");
            int choice = input.nextInt();
            // define the condition
            if(choice == 1){
                System.out.println("Enter the data:");
                int data = input.nextInt();
                // calling the node class
                node node =  new node(data);
                if(head == null){
                    head =node;
                    duplicate = node;
                }
                else{
                    duplicate.next = node;
                    duplicate = node;
                }
            }
            else if(choice == 2){
                break;
            }
            else{
                System.out.println("SORRY !! Invalid choice ");
            }
        }
    }


    // define the display() methord
    /*
     * Inside this methord we are performing traversal on linkedlist
     */
    public void display(){
        // define the properties
        duplicate = head;
        // define the while loop
        System.out.println("The display of linkedList is:");
        if(duplicate == null){
            System.out.println("The linkedList is empty");
        }
        else{
            while(duplicate != null){
                System.out.print(duplicate.data+" ");
                duplicate = duplicate.next;
            }
            System.out.println();
        }    

    }

    // define the Search() methord
    /*
     * Inside this methord we have created a feature where we are finding target value is present
     * or not. In gernal two ways are 
     * 1)Linear Search
     * 2)Binary Search
     * But in case of linked list if we perform binary search data must  present in continious memory
     * allocation but in linked list it is non-continious memory allocation so directy can't apply
     * binary search so first convert it into array which take O(N) time and Binary Search O(log N)
     * so overall time complexity is O(N) which is eqaul to linear Search O(N) time complexity.
     * NOTE : NO Diff in linear and Binary Search.
      */
    public void search(int target){
        // define the properties
        duplicate = head;
        int flag =0;
        int count =0;
        // define the condition
        if(duplicate == null){
            System.out.println("SORRY !!The linked list is empty ");
        }
        else{
            while(duplicate !=null){
                // define the condition
                if(duplicate.data == target){
                    System.out.println("Element found at position:"+ ++count);
                    flag =1;
                    break;
                }
                count++;
                duplicate  = duplicate.next;
            }
            if(flag == 0){
                System.out.println("SORRY !! Element not found");
            }
        }
    }


    // define the insertion() methord
    /*
     * Inside this methord we have created a feature where we perform insertion
     * By three ways:
     * 1) Insertion at starting
     * 2) Insertion at end
     * 3) Insertion at middle(Before/After)
     */
    public void insertion(){
        // define the properties
        duplicate =  head;
        System.out.println("Enter the data to be inserted:");
        int data = input.nextInt();
        // define the node
        node =  new node(data);

        // define the base condition
        /*
         * Inside this condition we have make check if head == null then node will insert at starting only
         * so now no need to ask the case simply insert and break it
         */
        if(duplicate == null){
            duplicate = node;
            head = duplicate;
            return;
        }
        System.out.println("************CHOICE************\n"+
                           "  PRESS 1: Insert at starting\n"+
                           "  PRESS 2: Insert at middle\n"+
                           "  PRESS 3: Insert at end\n"+
                           "******************************");
        System.out.println("Enter the choice:");
        int choice = input.nextInt();
        
        // define the switch()
        switch(choice){
            case 1:
                node.next = duplicate;
                head = node;
                System.out.println("Congratulations !!Element is inserted sucessfully");
                break;
            case 2:
                System.out.println("Enter the index data:");
                int indexData = input.nextInt(); 
                System.out.println("***********CHOICE************\n"+
                                   " PRESS 1: Insert Before data\n"+
                                   " PRESS 2: Insert After data\n"+
                                   "******************************");    
                System.out.println("Enter the choice:");
                choice = input.nextInt();

                switch(choice){
                    case 1:
                        // define the properties
                        node current = head;
                        node prev = head;
                        int flag =0;

                        // define the condition
                        if(current.data == indexData){
                            node.next = current;
                            head = node;
                            break;
                        }
                        // define the while loop
                        while(current!=null){
                            // define the condition
                            if(current.data == indexData){
                                flag =1;
                                break;
                            }
                            prev = current;
                            current = current.next;
                        }
                        if(flag == 0){
                            System.out.println("SORRY !! Element not found");
                        }
                        else{
                            node.next = prev.next;
                            prev.next = node;
                        }
                    break;
                    case 2:
                        // define the properties
                        duplicate = head;
                        // define the while loop
                        while(duplicate != null){
                            // define the condition
                            if(duplicate.data == indexData){
                                node.next = duplicate.next;
                                duplicate.next = node;
                                break;
                            }
                            duplicate = duplicate.next;
                        }    
                }
                break;
            case 3:
                // define the properties
                duplicate = head;
                // define the while loop
                while(duplicate != null){
                    // define the condition
                    if(duplicate.next == null){
                        duplicate.next = node;
                        System.out.println("Congratulations !! Element is inserted successfully");
                        break;
                    }
                    duplicate = duplicate.next;
                } 
                break;   
        }
    }

    // define the delete() methord
    public void delete(){
        // define the properties
        duplicate =  head;
        // define the base condition
        if(duplicate == null){
            System.out.println("LinkedList is empty !! No deletion operation can't perform");
        }
        System.out.println("**************CHOICE***************\n"+
                           "  PRESS 0: Delete at starting\n"+
                           "  PRESS 1: Delete at middle\n"+
                           "  PRESS 2: Delete at end\n"+
                           "***********************************");
        System.out.println("Enter the choice:");
        int choice = input.nextInt();
        
        // define the switch()
        switch(choice){
            case 0:
                head = head.next;
                System.out.println("Congratulations !! Element is removed successfully");
                break;
            case 1:
                // define the properties
                node nodeAddress = null;
                duplicate =  head;
                int flag =0;

                System.out.println("Enter the data to be deleted:");
                int data = input.nextInt();
                // define the condition
                if(head.data == data){
                    head = head.next;
                    System.out.println("Congratulations !! Element is removed successfully");
                    break;
                }
                // define the for loop
                while(duplicate!= null){
                    // define the condition
                    if(duplicate.data == data){
                        nodeAddress = duplicate;
                        flag =1;
                        break;

                    }
                    duplicate = duplicate.next;
                } 
                if(flag == 0){
                    System.out.println("Sorry !! Data not found to delete in linkedList");
                }
                else{
                    duplicate =  head;
                    // define the while()
                    while(duplicate!= null){
                        if(duplicate.next == nodeAddress){
                            duplicate.next = nodeAddress.next;
                            System.out.println("Congratulations !! Element is removed successfully");
                            break;
                        }
                        duplicate = duplicate.next;
                    }
                }
                break;
            case 2:
                // define the properties
                duplicate = head;
                node duplicate1 = head;
                nodeAddress = null;
                // define the condition
                if(duplicate.next == null){
                    head = null;
                    System.out.println("Congratulations !! Element is removed successfully");
                    break;
                }
                // define the while loop
                while(duplicate != null){
                    // define the condition
                    if(duplicate.next == null){
                        nodeAddress = duplicate;
                    }
                    duplicate = duplicate.next;
                }
                while(duplicate1!=null){
                    if(duplicate1.next.next == null){
                        duplicate1.next = null;
                        System.out.println("Congratulations !! Element is removed successfully");
                        break;
                    }
                    duplicate1 = duplicate1.next;
                }     
                  
        }
    }
}
