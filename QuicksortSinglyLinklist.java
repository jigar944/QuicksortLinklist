import java.util.Scanner;

public class QuicksortSinglyLinklist{

    static Node head;

    static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        QuicksortSinglyLinklist Linklist1 = new QuicksortSinglyLinklist();
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Enter 1 for add number");
        System.out.println("2. Enter 2 for exit");
        System.out.println("Enter your choice :");

        while(flag){
            int choice;
            choice = scanner.nextInt();

            switch(choice){
                case 1: System.out.println("Enter number you want to add in to link list :");
                    Linklist1.add(scanner.nextInt());
                    break;
                case 2:  flag = false;
                        break;
            }
        }
        System.out.println("Unsorted Linklist :");   
        printLinklist();
        


        Node current  = head;
        while(current.next!=null){
            current=current.next;
        }

        Quicksort(Linklist1,head,current);
        System.out.println("sorted Linklist :");   

        printLinklist();


    }

    private static void Quicksort(QuicksortSinglyLinklist linklist1, QuicksortSinglyLinklist.Node head2,
            QuicksortSinglyLinklist.Node current) {

              // System.out.println("head :"+head2.data+" end :"+current.data);

                if(head2.next!=null && head2 != current){

                    Node pi = partition(linklist1,head2,current);
                  
                    Quicksort(linklist1, head2, pi);
                    Quicksort(linklist1, pi.next , current);


                }


    }

    private static QuicksortSinglyLinklist.Node partition(QuicksortSinglyLinklist linklist1,
            QuicksortSinglyLinklist.Node head2, QuicksortSinglyLinklist.Node current) {

                Node i = head2;
                int pivot = current.data;
               // System.out.println("pivot :"+pivot);
               // System.out.println("head :" +head2.data );
                
                //System.out.println("end :" +current.data );
                Node j = head2;
                Node changed=head2;

                while(j!=current){
                    
                    if(j.data< pivot){
                        int temp = i.data;
                        i.data = j.data;
                        j.data = temp;
                        changed = i;
                        i = i.next;

                    }
                    j = j.next;

                }

                int temp = i.data;
                i.data = current.data;
                current.data = temp;
               // printLinklist();


        return changed;
    }

    private static void printLinklist() {

        Node current = head;
        while(current.next!=null){
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println(current.data);

    }

    private void add(int i) {
    
        if(head == null){
            head = new Node(i);
            return;
        }
    
        Node current = head;
        while(current.next!=null){
            current = current.next;
        }

        Node new_node = new Node(i);
        current.next = new_node;

    }

    
}
