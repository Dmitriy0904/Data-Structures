package doubly_linked_list;

import java.util.Scanner;

public class Controller {
    private Scanner scanner;
    private DoublyListService service;

    public Controller() {
        scanner = new Scanner(System.in);
        service = new DoublyListService();
    }

    public void userInterface() {
        int choose;
        System.out.println("Enter a sequence of numbers: (input ending - number 0)");
        Node head = service.createList();
        while (true) {
            System.out.println("What do you want to do:\n1-Create new list\n2-Delete item;\n3-Add element BEFORE;" +
                    "\n4-Add element AFTER;" + "\n5-Show all elements of a sequence;\n6-Length of the list;\n" +
                    "7-Is the list symmetrical?\n8-List to array\n0-Exit;");
            choose = scanner.nextInt();
            switch (choose) {
                case 1 -> head = createNewList(head);
                case 2 -> head = removeElement(head);
                case 3 -> head = before(head);
                case 4 -> head = after(head);
                case 5 -> print(head);
                case 6 -> length(head);
                case 7 -> isSymmetric(head);
                case 8 -> toArray(head);
                case 0 -> System.exit(1);
                default -> System.out.println("Unknown operation.");
            }
        }
    }

    private void print(Node head) {
        service.printList(head);
    }


    private Node removeElement(Node head) {
        if (head == null) {
            System.out.println("Firstly create a list.");
            return null;
        }
        print(head);
        System.out.println("Enter the number you want to remove:");
        int toDelete = scanner.nextInt();
        return service.remove(head, toDelete);
    }


    private Node before(Node head) {
        if (head == null) {
            System.out.println("Firstly create a list.");
            return null;
        }
        print(head);
        System.out.println("Enter the number you want to add:");
        int toAdd = scanner.nextInt();
        System.out.println("Enter the number you want to insert your number before:");
        int before = scanner.nextInt();
        return service.insertBefore(head, toAdd, before);
    }


    private Node after(Node head) {
        if (head == null) {
            System.out.println("Firstly create a list.");
            return null;
        }
        print(head);
        System.out.println("Enter the number you want to add:");
        int toAdd = scanner.nextInt();
        System.out.println("Enter the number after which you want to insert your number:");
        int after = scanner.nextInt();
        return service.insertAfter(head, toAdd, after);
    }


    private Node createNewList(Node head) {
        head = service.clear(head);
        System.out.println("Enter a sequence of numbers: (input ending - number 0)");
        return service.createList();
    }

    private void length(Node head) {
        System.out.println("The length of the list is " + service.listLength(head) + ".");
    }

    private void toArray(Node head) {
        if (head == null) {
            System.out.println("Firstly create a list.");
            return;
        }
        int[] arr = service.toArray(head);
        if (arr.length == 0) {
            System.out.println("Your array is empty.");
        }
        System.out.println("Your array:");
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println("\n");
    }

    private void isSymmetric(Node head) {
        if (head == null) {
            System.out.println("Firstly create a list.");
            return;
        }
        boolean list = service.isSymmetric(head, service.getLast(head));
        if (!list) {
            System.out.println("The list isn't symmetrical.");
            return;
        }
        System.out.println("The list is symmetrical.");
    }
}
