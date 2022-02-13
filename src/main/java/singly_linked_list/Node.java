package singly_linked_list;

public class Node {
    int info;
    Node next;

    public Node() {
    }

    public Node(int value, Node next) {
        this.info = value;
        this.next = next;
    }

    public int getInfo() {
        return info;
    }

    public Node getNext() {
        return next;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}