package singly_linked_list_tasks;

public class Service {

    public Node remove(Node top, int toDelete) {
        Node cur;
        Node prev;
        if (top == null) {
            throw new IllegalArgumentException("Can't delete, list is empty.");
        }
        if (toDelete == top.info) {
            cur = top;
            top = top.next;
            cur = null;
            return top;
        }
        prev = top;
        cur = top.next;
        while (cur != null) {
            if (cur.info == toDelete) {
                prev.next = cur.next;
                cur = null;
                return top;
            }
            prev = cur;
            cur = cur.next;
        }
        throw new IllegalArgumentException("You entered the number that isn't in the list.");
    }

    public Node replacement(Node top, int to, int from) {
        Node cur = top;
        if (top == null) {
            throw new IllegalArgumentException("The list is empty.");
        }

        while (cur != null) {
            if (cur.info == from) {
                cur.info = to;
            }
            cur = cur.next;
        }
        return top;
    }

    public int getLength(Node top) {
        int length = 0;
        while (top != null) {
            length++;
            top = top.next;
        }
        return length;
    }


    public boolean compare(Node firstTop, Node secondTop) {
        Node firstCur = firstTop, secondCur = secondTop;
        if (getLength(firstTop) != getLength(secondTop)) {
            return false;
        }
        while (firstCur != null) {
            if (firstCur.info != secondCur.info) {
                return false;
            }
            firstCur = firstCur.next;
            secondCur = secondCur.next;
        }
        return true;
    }


    public Node removeAllElements(Node top) {
        int sum = 0, length = getLength(top);
        Node cur = top;
        float average = 0;
        while (cur != null) {
            sum += cur.info;
            cur = cur.next;
        }
        average = (float) sum / (float) length;
        cur = top;
        while (cur != null) {
            if (cur.info <= average) {
                top = remove(top, cur.info);
                cur = top;
                continue;
            }
            cur = cur.next;
        }
        return top;
    }


    public Node doubleElementOccurrence(Node top, int num) {
        Node cur = top.next;
        Node prev = top;
        Node additional;
        while (cur != null) {
            if (prev.info == num) {
                additional = new Node();
                additional.info = num;
                prev.next = additional;
                additional.next = cur;
            }
            prev = cur;
            cur = cur.next;
        }
        if (prev.info == num) {
            additional = new Node();
            additional.info = num;
            prev.next = additional;
        }
        return top;
    }
}
