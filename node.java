
// Name: Iven Jacobson

// Date 3-15-24

// Project: Lab 6: Binary Search Tree Dictionary

// Purpose : This is the Node class for the Dictionary program. 
// It provides a structure for the nodes in the binary search tree.
class Node {
    int primaryKey;
    String firstName, lastName, streetAddress, city, state, email, phoneNumber;
    int zip;
    Node left, right;

    public Node(int primaryKey, String firstName, String lastName, String streetAddress, 
    String city, String state, int zip, String email, String phoneNumber) {
        this.primaryKey = primaryKey;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.phoneNumber = phoneNumber;
        left = right = null;
    }
}
