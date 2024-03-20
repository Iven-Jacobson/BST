// Name: Iven Jacobson

// Date 3-15-24

// Project: Lab 6: Binary Search Tree Dictionary

// Purpose : This is the Dictionary class for the Binary Search Tree program.

// This class is a dictionary that uses a binary search tree to store records.

public class Dictionary {
    Node root;

    public Dictionary() {
        root = null;
    }

    // Method to initiate add node process
    public void addNode(int primaryKey, String firstName, String lastName, String streetAddress, 
    String city, String state, int zip, String email, String phoneNumber) {
        root = addRecursive(root, primaryKey, firstName, lastName, 
        streetAddress, city, state, zip, email, phoneNumber);
    }

    // Method to add a node to the tree recursively based on the primary key
    private Node addRecursive(Node current, int primaryKey, String firstName, String lastName, 
    String streetAddress, String city, String state, int zip, String email, String phoneNumber) {
        if (current == null) {
            return new Node(primaryKey, firstName, lastName, 
            streetAddress, city, state, zip, email, phoneNumber);
        }
        if (primaryKey < current.primaryKey) {
            current.left = addRecursive(current.left, primaryKey, firstName, lastName, 
            streetAddress, city, state, zip, email, phoneNumber);
        } else if (primaryKey > current.primaryKey) {
            current.right = addRecursive(current.right, primaryKey, firstName, lastName, 
            streetAddress, city, state, zip, email, phoneNumber);
        } else {
            // Node already exists with this key
            return current;
        }
        return current;
    }

    public void deleteNode(int primaryKey) {
        root = deleteRecursive(root, primaryKey);
    }

    private Node deleteRecursive(Node current, int primaryKey) {
        if (current == null) {
            return null;
        }

        if (primaryKey == current.primaryKey) {
            // Node to delete found
            if (current.left == null && current.right == null) {
                // Node is a leaf
                return null;
            }
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            // Node has two children: Find the smallest value in the right subtree
            int smallestValue = findSmallestValue(current.right);
            current.primaryKey = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (primaryKey < current.primaryKey) {
            current.left = deleteRecursive(current.left, primaryKey);
            return current;
        }
        current.right = deleteRecursive(current.right, primaryKey);
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.primaryKey : findSmallestValue(root.left);
    }
    // Method to initiate modify node process
    public void modifyNode(int primaryKey, String field, String newValue) {
        Node node = findNode(root, primaryKey);
        if (node != null) {
            switch (field.toLowerCase()) {
                case "firstname":
                    node.firstName = newValue;
                    break;
                case "lastname":
                    node.lastName = newValue;
                    break;
                case "streetaddress":
                    node.streetAddress = newValue;
                    break;
                case "city":
                    node.city = newValue;
                    break;
                case "state":
                    node.state = newValue;
                    break;
                case "zip":
                    node.zip = Integer.parseInt(newValue);
                    break;
                case "email":
                    node.email = newValue;
                    break;
                case "phonenumber":
                    node.phoneNumber = newValue;
                    break;
                default:
                    System.out.println("Invalid field.");
                    break;
            }
        } else {
            System.out.println("Node not found.");
        }
    }
    // Method to find a node based on the primary key
    private Node findNode(Node current, int primaryKey) {
        if (current == null) {
            return null;
        }
        if (primaryKey == current.primaryKey) {
            return current;
        }
        return primaryKey < current.primaryKey ? 
        findNode(current.left, primaryKey) : findNode(current.right, primaryKey);
    }
    // Method to initiate lookup process
    public void lookupNode(int primaryKey) {
        Node node = findNode(root, primaryKey);
        if (node != null) {
            System.out.println("Node Found: " + nodeToString(node));
        } else {
            System.out.println("Node not found.");
        }
    }
    // Method to convert a node to a string
    private String nodeToString(Node node) {
        return "Primary Key: " + node.primaryKey + ", Name: " + node.firstName + " "
         + node.lastName + ", Address: " + node.streetAddress + ", " + node.city + 
         ", " + node.state + " " + node.zip + ", Email: " + node.email + ", Phone: "
          + node.phoneNumber;
    }
    // Method to initiate traversal process
    public void traverse(String order) {
        switch (order.toLowerCase()) {
            case "preorder":
                traversePreOrder(root);
                break;
            case "inorder":
                traverseInOrder(root);
                break;
            case "postorder":
                traversePostOrder(root);
                break;
            default:
                System.out.println("Invalid traversal order.");
                break;
        }
    }
    // Method to traverse the tree in pre-order
    private void traversePreOrder(Node node) {
        if (node != null) {
            System.out.println(nodeToString(node));
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }
    // Method to traverse the tree in in-order
    private void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.println(nodeToString(node));
            traverseInOrder(node.right);
        }
    }
    // Method to traverse the tree in post-order
    private void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.println(nodeToString(node));
        }
    }
}
