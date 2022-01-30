package singly_linked_list;

public interface ServiceOperations {
    Node createLifo();
    void printList(Node top);
    Node remove(Node top, int toDelete);
    Node insertBefore(Node top, int toAdd, int before);
    Node insertAfter(Node top, int toAdd, int after);
    Node createFifo();
    Node deleteNegative(Node top);
    boolean isOrderedAscending(Node top);
    boolean isOrderedDescending(Node top);
    void printListRecursively(Node top);
}
