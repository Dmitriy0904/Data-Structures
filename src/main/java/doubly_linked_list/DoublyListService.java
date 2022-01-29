package doubly_linked_list;

import java.util.Scanner;

public class DoublyList {
    private Scanner scanner;

    public DoublyList() {
        this.scanner = new Scanner(System.in);
    }


    public Node createFifo(){
        int info;
        Node top, cur;
        info = scanner.nextInt();
        if(info == 0){
            return null;
        }
        top = new Node();
        top.info = info;
        top.prev = null;
        cur = top;
        info = scanner.nextInt();
        while(info != 0){
            cur.next = new Node();
            cur.next.prev = cur;
            cur = cur.next;
            cur.info = info;
            info = scanner.nextInt();
        }
        cur.next = null;
        return top;
    }

    public void printList(Node top) {
        if(top == null){
            System.out.println("The list is empty.");
            return;
        }
        while(top != null){
            System.out.print(top.info + " ");
            top = top.next;
        }
        System.out.println("\n");
    }

    public Node getLast(Node top){
        if(top == null){
            return null;
        }
        while(top.next != null){
            top = top.next;
        }
        return top;
    }

    public boolean isSymmetric(Node top, Node last){
        while(top != null){
            if(top.info != last.info){
                return false;
            }
            top = top.next;
            last = last.prev;
        }
        return true;
    }

}
