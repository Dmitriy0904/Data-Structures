package singly_linked_list;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Node top = fifo();
        printList(top);
    }


    public static void printList(Node top){
        while(top != null){
            System.out.print(top.info + " ");
            top = top.next;
        }
        System.out.println("\n");
    }

    public static Node lifo() {
        Scanner scanner = new Scanner(System.in);
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

    public static Node fifo() {
        Scanner scanner = new Scanner(System.in);
        int info;
        Node cur;
        Node top = null;
        info = scanner.nextInt();
        if(info != 0){
            top = new Node();
            top.info = info;
            top.next = null;
        }
        info = scanner.nextInt();
        cur = top;
        while (info != 0) {
            cur.next = new Node();
            cur = cur.next;
            cur.info = info;
            info = scanner.nextInt();
        }
        cur.next = null;
        return top;
    }

}






