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
            System.out.println("What do you want to do:\n1-Delete item\n2-Add element BEFORE\n3-Add element AFTER" +
                    "\n4-Show all elements of a sequence\n5-Is the list sorted in ascending order?\n" +
                    "6-Is the list sorted in descending order?\n8-Exit");
            choose = scanner.nextInt();
            switch (choose) {
                case 1 -> {
                    print();
                    removeElement();
                    print();
                }
                case 2 -> {
                    print();
                    before();
                    print();
                }
                case 3 -> {
                    print();
                    after();
                    print();
                }
                case 4 -> print();
                case 5 -> isAsc();
                case 6 -> isDesc();
                case 7 -> serviceOperations.printListRecursively(head);
                case 8 -> System.exit(1);
            }
        }
    }

    private void print() {
        serviceOperations.printList(head);
    }


    private void removeElement() {
        System.out.println("Enter the number you want to remove:");
        int toDelete = scanner.nextInt();
        if (serviceOperations.remove(head, toDelete) == null) {
            System.out.println("There is no such number (" + toDelete +
                    ") in the sequence that you want to remove " +
                    "or the list was initially empty.");
            return;
        }
        System.out.println("Item successfully deleted.");
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
}