package doubly_linked_list;

import java.util.Scanner;

public class DoublyListService {
    private Scanner scanner;

    public DoublyListService() {
        this.scanner = new Scanner(System.in);
    }


    public Node createList() {
        int info;
        Node top, cur;
        info = scanner.nextInt();
        if (info == 0) {
            throw new IllegalArgumentException("The list is empty.");
        }
        top = new Node();
        top.info = info;
        top.prev = null;
        cur = top;
        info = scanner.nextInt();
        while (info != 0) {
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
        if (top == null) {
            System.out.println("The list is empty.");
            return;
        }
        while (top != null) {
            System.out.print(top.info + " ");
            top = top.next;
        }
        System.out.println("\n");
    }

    public Node getLast(Node top) {
        if (top == null) {
            throw new IllegalArgumentException("The list is empty.");
        }
        while (top.next != null) {
            top = top.next;
        }
        return top;
    }

    public boolean isSymmetric(Node top, Node last) {
        while (top != null) {
            if (top.info != last.info) {
                return false;
            }
            top = top.next;
            last = last.prev;
        }
        return true;
    }

    public int listLength(Node top) {
        int length = 0;
        while (top != null) {
            length++;
            top = top.next;
        }
        return length;
    }


    public Node remove(Node top, int toDelete) {
        Node cur, last = getLast(top);
        if (top == null) {
            throw new IllegalArgumentException("The list is empty.");
        }
        if (toDelete == top.info) {
            if (top.next == null) { //to delete single element
                top = null;
                return null;
            }
            cur = top;
            top = top.next;
            cur = null;
            top.prev = null;
            return top;
        }
        if (last.info == toDelete) {
            cur = last;
            last = last.prev;
            cur = null;
            last.next = null;
            return top;
        }
        cur = top.next;
        while (cur.next != null) {
            if (cur.info == toDelete) {
                cur.next.prev = cur.prev;
                cur.prev.next = cur.next;
                cur = null;
                return top;
            }
            cur = cur.next;
        }
        throw new IllegalArgumentException("You entered the number that isn't in the list.");
    }


    public Node insertBefore(Node top, int toAdd, int before) {
        Node cur, previous, additional;
        if (top == null) {
            throw new IllegalArgumentException("The list is empty.");
        }
        if (top.info == before) {
            additional = new Node();
            additional.info = toAdd;
            additional.prev = null;
            additional.next = top;
            top.prev = additional;
            top = additional;
            return top;
        }
        cur = top.next;
        while (cur != null) {
            if (cur.info == before) {
                previous = cur.prev;
                additional = new Node();
                additional.info = toAdd;
                additional.prev = previous;
                additional.next = cur;
                previous.next = additional;
                cur.prev = additional;
                return top;
            }
            cur = cur.next;
        }
        throw new IllegalArgumentException("There is no such number (" + before +
                ") in the sequence before which you want to put a number " + toAdd);
    }

    public Node insertAfter(Node top, int toAdd, int after) {
        Node cur, last = getLast(top), additional, following;
        if (top == null) {
            throw new IllegalArgumentException("The list is empty.");
        }
        if (last.info == after) {
            additional = new Node();
            additional.info = toAdd;
            additional.next = null;
            additional.prev = last;
            last.next = additional;
            return top;
        }
        cur = top;
        while (cur != null) {
            if (cur.info == after) {
                following = cur.next;
                additional = new Node();
                additional.info = toAdd;
                additional.prev = cur;
                additional.next = following;
                cur.next = additional;
                following.prev = additional;
                return top;
            }
            cur = cur.next;
        }
        throw new IllegalArgumentException("There is no such number (" + after +
                ") in the sequence before which you want to put a number " + toAdd);
    }

    public int[] toArray(Node top) {
        if (top == null) {
            return new int[0];
        }
        int size = listLength(top);
        int[] arr = new int[size];
        int i = 0;
        while (top != null) {
            arr[i] = top.info;
            i++;
            top = top.next;
        }
        return arr;
    }
}
