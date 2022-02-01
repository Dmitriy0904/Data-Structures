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
                case 1 -> {
                    createNewList(head);
                }
                case 2 -> {
                    removeElement(head);
                }
                case 3 -> {
                    before(head);
                }
                case 4 -> {
                    after(head);
                }
                case 5 -> print(head);
                case 6 -> length(head);
                case 7 -> isSymmetric(head);
                case 8 -> toArray(head);
                case 0 -> System.exit(1);
            }
        }
    }

    private void print(Node head) {
        service.printList(head);
    }


    private void removeElement(Node head) { //should be remade
        if (head == null) {
            System.out.println("Firstly create a list.");
            return;
        }
        print(head);
        System.out.println("Enter the number you want to remove:");
        int toDelete = scanner.nextInt();
        head = service.remove(head, toDelete);
        print(head);
    }


    private void before(Node head) {
        if (head == null) {
            System.out.println("Firstly create a list.");
            return;
        }
        print(head);
        System.out.println("Enter the number you want to add:");
        int toAdd = scanner.nextInt();
        System.out.println("Enter the number you want to insert your number before:");
        int before = scanner.nextInt();
        head = service.insertBefore(head, toAdd, before);
        print(head);
    }


    private void after(Node head) {
        if (head == null) {
            System.out.println("Firstly create a list.");
            return;
        }
        print(head);
        System.out.println("Enter the number you want to add:");
        int toAdd = scanner.nextInt();
        System.out.println("Enter the number after which you want to insert your number:");
        int after = scanner.nextInt();
        head = service.insertAfter(head, toAdd, after);
        print(head);
    }


    private void createNewList(Node head) {
        System.out.println("Enter a sequence of numbers: (input ending - number 0)");
        head = service.createList();
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
