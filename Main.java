// Name: Iven Jacobson

// Date 3-15-24

// Project: Lab 6: Binary Search Tree Dictionary

// Purpose : This is the Main class for the Dictionary program. 
// It provides a menu for the user to interact with the dictionary.

// This program is a dictionary that uses a binary search tree to store records.

import java.util.Scanner;

public class Main {
    private static final Dictionary dictionary = new Dictionary();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\nDictionary Menu:");
            System.out.println("1. Add Record");
            System.out.println("2. Delete Record");
            System.out.println("3. Modify Record");
            System.out.println("4. Lookup Record");
            System.out.println("5. Traverse Tree");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Flush the newline

            switch (choice) {
                case 1:
                    addRecord();
                    break;
                case 2:
                    deleteRecord();
                    break;
                case 3:
                    modifyRecord();
                    break;
                case 4:
                    lookupRecord();
                    break;
                case 5:
                    traverseTree();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
        scanner.close();
    }

    private static void addRecord() {
        System.out.println("Enter the following details to add a new record:");
        System.out.print("Primary Key: ");
        int primaryKey = scanner.nextInt();
        scanner.nextLine(); // Flush the newline
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Street Address: ");
        String streetAddress = scanner.nextLine();
        System.out.print("City: ");
        String city = scanner.nextLine();
        System.out.print("State: ");
        String state = scanner.nextLine();
        System.out.print("Zip: ");
        int zip = scanner.nextInt();
        scanner.nextLine(); // Flush the newline
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        dictionary.addNode(primaryKey, firstName, lastName, 
        streetAddress, city, state, zip, email, phoneNumber);
        System.out.println("Record added successfully.");
    }

    private static void deleteRecord() {
        System.out.print("Enter the primary key of the record to delete: ");
        int primaryKey = scanner.nextInt();
        scanner.nextLine(); // Flush the newline

        dictionary.deleteNode(primaryKey);
        System.out.println("Record deleted successfully.");
    }

    private static void modifyRecord() {
        System.out.print("Enter the primary key of the record to modify: ");
        int primaryKey = scanner.nextInt();
        scanner.nextLine(); // Flush the newline

        System.out.println("Which field would you like to modify?");
        System.out.println("Options: firstname, lastname, streetaddress," + 
         "city, state, zip, email, phonenumber");
        String field = scanner.nextLine();
        System.out.println("Enter the new value:");
        String newValue = scanner.nextLine();

        dictionary.modifyNode(primaryKey, field, newValue);
        System.out.println("Record updated successfully.");
    }

    private static void lookupRecord() {
        System.out.print("Enter the primary key of the record to lookup: ");
        int primaryKey = scanner.nextInt();
        scanner.nextLine(); // Flush the newline

        dictionary.lookupNode(primaryKey);
    }

    private static void traverseTree() {
        System.out.println("Select the order of traversal:");
        System.out.println("1. Pre-order");
        System.out.println("2. In-order");
        System.out.println("3. Post-order");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Flush the newline

        switch (choice) {
            case 1:
                System.out.println("Traversing in pre-order:");
                dictionary.traverse("preorder");
                break;
            case 2:
                System.out.println("Traversing in in-order:");
                dictionary.traverse("inorder");
                break;
            case 3:
                System.out.println("Traversing in post-order:");
                dictionary.traverse("postorder");
                break;
            default:
                System.out.println("Invalid traversal choice.");
                break;
        }
    }
}
