package singly_linked_list;

import java.util.Scanner;


public class Controller {
    private Scanner scanner;
    private ServiceOperations serviceOperations;


    public Controller() {
        scanner = new Scanner(System.in);
        serviceOperations = new ListService();
    }


    public void userInterface() {
        int choose;
        Node head;
        System.out.println("1-LIFO list\n2-FIFO list\n");
        choose = scanner.nextInt();
        if (choose == 1) {
            System.out.println("Enter a sequence of numbers: (input ending - number 0)");
            head = serviceOperations.createLifo();
        } else if (choose == 2) {
            System.out.println("Enter a sequence of numbers: (input ending - number 0)");
            head = serviceOperations.createFifo();
        } else {
            System.out.println("Incorrect number.");
            return;
        }
        print(head);
        while (true) {
            System.out.println("What do you want to do:\n1-Create new FIFO list;\n2-Create new LIFO list;\n" +
                    "3-Delete item;\n4-Add element BEFORE;\n5-Add element AFTER;" +
                    "\n6-Show all elements of a sequence;\n7-Is the list sorted in ascending order?\n" +
                    "8-Is the list sorted in descending order?\n9-Print list recursively;\n10-Exit;");
            choose = scanner.nextInt();
            switch (choose) {
                case 1 -> head = createNewFifo(head);
                case 2 -> head = createNewLifo(head);
                case 3 -> head = removeElement(head);
                case 4 -> head = before(head);
                case 5 -> head = after(head);
                case 6 -> print(head);
                case 7 -> isAsc(head);
                case 8 -> isDesc(head);
                case 9 -> printRecursively(head);
                default -> System.out.println("Unknown operation.");
                case 10 -> System.exit(1);
            }
        }
    }


    private Node createNewFifo(Node head) {
        head = serviceOperations.clear(head);
        System.out.println("Enter a sequence of numbers: (input ending - number 0)");
        return serviceOperations.createFifo();
    }


    private Node createNewLifo(Node head) {
        head = serviceOperations.clear(head);
        System.out.println("Enter a sequence of numbers: (input ending - number 0)");
        return serviceOperations.createLifo();
    }


    private void print(Node head) {
        serviceOperations.printList(head);
    }


    private void printRecursively(Node head) {
        if (head == null) {
            System.out.println("Create the list before.");
            return;
        }
        serviceOperations.printListRecursively(head);
    }


    private Node removeElement(Node head) {
        if (head == null) {
            System.out.println("Create the list before.");
            return null;
        }
        print(head);
        System.out.println("Enter the number you want to remove:");
        int toDelete = scanner.nextInt();
        return serviceOperations.remove(head, toDelete);
    }


    private Node before(Node head) {
        if (head == null) {
            System.out.println("Create the list before.");
            return null;
        }
        print(head);
        System.out.println("Enter the number you want to add:");
        int toAdd = scanner.nextInt();
        System.out.println("Enter the number you want to insert your number before:");
        int before = scanner.nextInt();
        return serviceOperations.insertBefore(head, toAdd, before);
    }


    private Node after(Node head) {
        if (head == null) {
            System.out.println("Create the list before.");
            return null;
        }
        print(head);
        System.out.println("Enter the number you want to add:");
        int toAdd = scanner.nextInt();
        System.out.println("Enter the number after which you want to insert your number:");
        int after = scanner.nextInt();
        return serviceOperations.insertAfter(head, toAdd, after);
    }


    private void isAsc(Node head) {
        if (head == null) {
            System.out.println("Create the list before.");
            return;
        }
        if (!serviceOperations.isOrderedAscending(head)) {
            System.out.println("List not sorted in ascending order.");
            return;
        }
        System.out.println("List sorted in ascending order.");
    }


    private void isDesc(Node head) {
        if (head == null) {
            System.out.println("Create the list before.");
            return;
        }
        if (!serviceOperations.isOrderedDescending(head)) {
            System.out.println("List not sorted in descending order.");
            return;
        }
        System.out.println("List sorted in descending order.");
    }
}