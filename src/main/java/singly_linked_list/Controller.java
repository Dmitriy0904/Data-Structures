package singly_linked_list;

import java.util.Scanner;


public class Controller {
    private Scanner scanner;
    private ServiceOperations serviceOperations;
    private Node head;


    public Controller() {
        scanner = new Scanner(System.in);
        serviceOperations = new ListService();
    }


    public void userInterface() {
        int choose;
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
        print();
        while (true) {
            System.out.println("What do you want to do:\n1-Create new FIFO list;\n2-Create new LIFO list;\n" +
                    "3-Delete item;\n4-Add element BEFORE;\n5-Add element AFTER;" +
                    "\n6-Show all elements of a sequence;\n7-Is the list sorted in ascending order?\n" +
                    "8-Is the list sorted in descending order?\n9-Print list recursively;\n10-Exit;");
            choose = scanner.nextInt();
            switch (choose) {
                case 1 -> {
                    createNewFifo();
                    print();
                }
                case 2 -> {
                    createNewLifo();
                    print();
                }
                case 3 -> {
                    print();
                    removeElement();
                    print();
                }
                case 4 -> {
                    print();
                    before();
                }
                case 5 -> {
                    print();
                    after();
                }
                case 6 -> print();
                case 7 -> isAsc();
                case 8 -> isDesc();
                case 9 -> printRecursively();
                case 10 -> System.exit(1);
            }
        }
    }


    private void print() {
        serviceOperations.printList(head);
    }


    private void printRecursively() {
        serviceOperations.printListRecursively(head);
    }


    private void removeElement() {
        System.out.println("Enter the number you want to remove:");
        int toDelete = scanner.nextInt();
        if (serviceOperations.remove(head, toDelete) != null) {
            System.out.println("Item successfully deleted.");
        }
    }


    private void before() {
        System.out.println("Enter the number you want to add:");
        int toAdd = scanner.nextInt();
        System.out.println("Enter the number you want to insert your number before:");
        int before = scanner.nextInt();
        serviceOperations.insertBefore(head, toAdd, before);
    }


    private void after() {
        System.out.println("Enter the number you want to add:");
        int toAdd = scanner.nextInt();
        System.out.println("Enter the number after which you want to insert your number:");
        int after = scanner.nextInt();
        serviceOperations.insertAfter(head, toAdd, after);
    }


    private void isAsc() {
        if (!serviceOperations.isOrderedAscending(head)) {
            System.out.println("List not sorted in ascending order.");
            return;
        }
        System.out.println("List sorted in ascending order.");
    }


    private void isDesc() {
        if (!serviceOperations.isOrderedDescending(head)) {
            System.out.println("List not sorted in descending order.");
            return;
        }
        System.out.println("List sorted in descending order.");
    }


    private void createNewFifo() {
        System.out.println("Enter a sequence of numbers: (input ending - number 0)");
        head = serviceOperations.createFifo();
    }


    private void createNewLifo() {
        System.out.println("Enter a sequence of numbers: (input ending - number 0)");
        head = serviceOperations.createLifo();
    }
}