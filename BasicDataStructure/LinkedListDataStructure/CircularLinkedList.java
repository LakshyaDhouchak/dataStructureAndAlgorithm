package BasicDataStructure.LinkedListDataStructure;

import java.util.Scanner;
public class CircularLinkedList {
    
    // define the properties
    Node head = null;
    Node tail = null;
    // define the Scanner
    Scanner input =  new Scanner (System.in);
    // define the constructor
    public CircularLinkedList(){}

    // define the inner Node class
    /*
     * Inside this methord we have a feature where we have created a node class to store the data in non - contigious memory
     * allocation in form of node
     * SYNTAX :
     * int data;
     * Node next;
     * public Node(int data,Node next)
     */
    static class Node{
        // define the properties
        int data;
        Node next;
        // define the constructor
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }


    // define the create() methord
    /*
     * Inside this methord we have created a feature where we have creating a circular LinkedList by
     * adding node after another (like a train box) but last node contain the address of strating node
     * so they form a circular cycle
     */
    public void create(){
        // define the properties
        while(true){
            System.out.println("*************CHOICE*************\n"+
                               "   PRESS 1: Insert Data\n"+
                               "   PRESS 2: Don't Insert Data\n"+
                               "********************************");
            System.out.println("Enter the choice:");
            int choice = input.nextInt(); 
            
            // define the condition
            if(choice == 1){
                System.out.println("Enter the data:");
                int data = input.nextInt();
                // define the node class
                Node node = new Node(data);
                // define the condition
                if(head == null&& tail == null){
                    head = node;
                    node.next = head;
                    tail = head;
                }
                else{
                    tail.next = node;
                    node.next = head;
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
     * Inside this methord we have created a feature where we traversal to all node and display
     * the data 
     */
    public void display(){
        // define the properties
        Node duplicate = head;

        if(duplicate == null){
            System.out.println("SORRY !! Circular LinkedList is empty");
        }
        else{
            if(duplicate == head){
                System.out.print(duplicate.data+" ");
                duplicate = duplicate.next;
            }
            while(duplicate != head){
                System.out.print(duplicate.data+" ");
                duplicate = duplicate.next;
            }
            System.out.println();
        }
    }


    // define the Search() methord
    /*
     * Inside this methord we have created a feature where we find the given key in circular LinkedList
     * if it present then it return "Element found" Otherwise "Element not found"
     */
    public void search(int key){
        // define the properties
        Node duplicate = head;
        int flag =0;
        if(duplicate == head){
            // define the condition
            if(duplicate.data == key){
                flag =1;
            }
            duplicate = duplicate.next;
        }
        while(duplicate!= head){
            // define the condition
            if(duplicate.data == key){
                
                flag =1;
                break;
            }
        }
        // define the condition
        if(flag == 0){
            System.out.println("SORRY !! No Element found");
        }
        else{
            System.out.println("CONGRATULATION !! Element found");
        }

    }


    // define the insert() methord
    /*
     * Inside this methord where we have created a feature we can update circular LinkedList
     * by adding three ways:
     * 1) Insert at starting
     * 2) Insert at end
     * 3) Insert at middle(Before/After)
     */
    public void insert(){
        // define the properties
        Node duplicate = head;
        System.out.println("Enter the data to be inserted:");
        int data = input.nextInt();
        // define the node class
        Node node =  new Node(data);

        // define the condition if head is null(it means circular linkedList is empty)
        if(duplicate == null){
            head = node;
            node.next =  head;
            System.out.println("CONGRATULATION!! Element is inserted");
            return;
        }

        System.out.println("*************CHOICE*************\n"+
                           "  PRESS 1: Insert at starting\n"+
                           "  PRESS 2: Insert at middle\n"+
                           "  PRESS 3: Insert at end\n"+
                           "********************************");
        System.out.println("Enter the choice:");
        int choice = input.nextInt(); 
        
        switch(choice){
            case 1:
                node.next = head;
                head = node;
                tail.next = head;
                System.out.println("CONGRATULATION !! Element is Inserted");
                break;
            case 2:
                // define the properties
                duplicate = head;
                int flag = 0;
                Node prev = head;
                System.out.println("Enter the index Data:");
                int IndexData = input.nextInt();
                // define the condition
                while(duplicate.next!=head){
                    if(duplicate.data == IndexData){
                        flag =1;
                        break;
                    }
                    prev = duplicate;
                    duplicate = duplicate.next;
                }
                if(duplicate.data == IndexData ){
                    flag =1;
                }

                if(flag == 1){
                    System.out.println("***************CHOICE**********\n"+
                                    "  PRESS 1: Insert Before Data\n"+
                                    "  PRESS 2: Insert After Data\n"+
                                    "*******************************");
                    System.out.println("Enter the choice:");
                    choice = input.nextInt();
                    switch(choice){
                        case 1:
                            if(duplicate == head && duplicate == tail){
                                node.next = head;
                                head = node;
                                tail.next = head;
                            }
                            else{
                                node.next = prev.next;
                                prev.next = node;
                            }
                            System.out.println("CONGRATULATION!! Element is Inserted");
                            
                            break;
                        case 2:
                            if(duplicate == tail && duplicate == head){
                                duplicate.next = node;
                                node.next = head;
                                tail = node;
                            }
                            else{
                                node.next = duplicate.next;
                                duplicate.next = node;
                            }
                            System.out.println("CONGRATULATION!! Element is inserted");
                        
                            break;
                        default:
                            System.out.println("SORRY !! No such Case available");    
                            
                            
                    }
                } 
                else{
                    System.out.println("SORRY !! No Index data available");
                } 
                break;  
            case 3:
                tail.next = node;
                node.next = head;
                tail = node;
                System.out.println("CONGRATULATION !! Element is inserted");
                break;
        }
    }


    // define the delete() methord
    /*
     * Inside this methord we have created a feature where we perform differnt operation to
     * delete the data .The possible way to Delete element:
     * 1) Delete at starting
     * 2) Delete at end
     * 3) Delete at middle
     */
    public void delete(){
        // define the properties
        Node duplicate = head;
        if(duplicate == null){
            System.out.println("SORRY !! Circular LinkedList is Empty");
            return;
        }

        System.out.println("*************CHOICE*************\n"+
                           "  PRESS 1: Delete at starting\n"+
                           "  PRESS 2: Delete at middle\n"+
                           "  PRESS 3: Delete at end\n"+
                           "********************************");
        System.out.println("Enter the choice:");
        int choice = input.nextInt();

        switch(choice){
            case 1:
                // define the condition
                if(head == tail){
                    head = null;
                    tail = null;
                }
                else{
                    head = head.next;
                    tail.next = head;
                }
                System.out.println("CONGRATULATION !! Element is removed successfully");
                break;
            case 2:
                // define the properties
                Node prev = head;
                int flag = 0;
                System.out.println("Enter the data to be deleted:");
                int dataDelete = input.nextInt();
                do{
                    // define the condition
                    if(duplicate.data == dataDelete){
                        flag =1;
                        break;
                    }
                    prev = duplicate;
                    duplicate = duplicate.next;
                }
                while(duplicate!=head);

                // define the condition
                if(flag == 0){
                    System.out.println("SORRY !! Data is not present");
                }
                else{
                    if(head == tail){
                        head =null;
                        tail = null;
                    }
                    else{
                        prev.next = duplicate.next;
                    }
                }
                break;
            case 3:
                // define the condition
                if(head == tail){
                    head = null;
                    tail = null;
                }
                else{
                    while(duplicate.next != tail){
                        duplicate = duplicate.next;
                    }
                    duplicate.next = head;
                }
                break;        
        }
    }

}
