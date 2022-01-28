package singly_linked_list;

import java.util.Scanner;

public class ListService implements ServiceOperations{
    private Scanner scanner;

    public ListService(){
        scanner = new Scanner(System.in);
    }


    @Override
    public Node createLifo() {
        int info;
        Node cur;       //current
        Node top = null;    //top
        info = scanner.nextInt();
        while (info != 0){
            cur = new Node();
            cur.info = info;        //cur.setInfo(info)
            cur.next = top;
            top = cur;
            info = scanner.nextInt();
        }
        return top;
    }


    @Override
    public Node createFifo() {
        Node top = null, cur;
        int num = scanner.nextInt();
        if(num != 0){
            top = new Node();
            top.info = num;
            top.next = null;
            cur = top;
            num = scanner.nextInt();
            while(num != 0){
                cur.next = new Node();
                cur = cur.next;
                cur.info = num;
                num = scanner.nextInt();
            }
            cur.next = null;
        }
        return top;
    }


    @Override
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


    @Override
    public void printListRecursively(Node top) {
        if(top == null){
            System.out.print("\n");
            return;
        }
        System.out.print(top.info + " ");
        printListRecursively(top.next);
    }


    @Override
    public Node remove(Node top, int toDelete) {
        Node cur;
        Node prev;
        if(top == null){
            return null;
        }
        if(toDelete == top.info){
            cur = top;
            top = top.next;
            cur = null;
            return top;
        }
        prev = top;
        cur = top.next;
        while(cur != null){
            if(cur.info == toDelete){
                prev.next = cur.next;
                cur = null;
                return top;
            }
            prev = cur;
            cur = cur.next;
        }
        return null;
    }

    @Override
    public Node insertBefore(Node top, int toAdd, int before) {
        Node cur = top.next;
        Node prev = top;
        Node additional = new Node();
        additional.info = toAdd;
        if(top.info == before){
            top = additional;
            top.next = prev;
            return top;
        }
        while(cur != null){
            if(cur.info == before) {
                prev.next = additional;
                additional.next = cur;
                return top;
            }
            prev = cur;
            cur = cur.next;
        }
        System.out.println("There is no such number (" + before +
                ") in the sequence before which you want to put a number " + toAdd);
        return top;
    }


    @Override
    public Node insertAfter(Node top, int toAdd, int after) {
        Node cur = top.next;
        Node prev = top;
        Node additional = new Node();
        additional.info = toAdd;
        while(cur != null){ // Block, if you need to insert an element somewhere inside the sequence
            if(prev.info == after) {
                prev.next = additional;
                additional.next = cur;
                return top;
            }
            prev = cur;
            cur = cur.next;
        }
        if(prev.info == after){ // Checking if an element needs to be added at the very end (after the last number in the sequence)
            prev.next = additional;
            return top;
        }
        //If you do not find a number in the sequence, after which you need to add another element, then it displays a message and the original list.
        System.out.println("There is no such number (" + after +
                ") in the sequence after which you want to put a number " + toAdd);
        return top;
    }

    @Override
    public boolean isOrderedAscending(Node top){
        Node cur = top.next;
        Node prev = top;
        while (cur != null){
            if(cur.info < prev.info){
                return false;
            }
            prev = cur;
            cur = cur.next;
        }
        return true;
    }

    @Override
    public boolean isOrderedDescending(Node top){
        Node cur = top.next;
        Node prev = top;
        while (cur != null){
            if(cur.info > prev.info){
                return false;
            }
            prev = cur;
            cur = cur.next;
        }
        return true;
    }


    @Override
    //Remove all negative elements from the list
    public Node deleteNegative(Node top){
        Node cur = top;
        Node prev;
        if(top == null){
            throw new IllegalArgumentException("Can't delete, list is empty.");
        }
        if(cur.info < 0){
            cur = top;
            top = top.next;
            cur = null;
            return top;
        }
        prev = top;
        cur = top.next;
        while(cur != null){
            if(cur.info < 0){
                prev.next = cur.next;
                cur = null;
                cur = prev;
                cur = cur.next;
                //TODO cur = prev.next;
            }
            else{
                prev = cur;
                cur = cur.next;
            }
        }
        return top;
    }

}
