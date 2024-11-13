package c_data_structures_and_algorithms.linkedlist.single;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 08-Oct-24
 */


public class SingleLinkedList {
    Node head;

    public SingleLinkedList() {
        head = null;
    }

    void addCustomer(Customer customer) {
        Node newNode = new Node(customer);
        if (head == null) {
            head = newNode;
        }
        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to add a VIP customer at the beginning of the list
    void addVIPCustomer(Customer vipCustomer) {
        // TODO: add your code here
        // Create a new node
        Node newNode = new Node(vipCustomer);

        // Point the new node's next to the current head
        newNode.next = head;

        // Make the new node the new head of the list
        head = newNode;
    }

    void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.customer.getName() + " (" + current.customer.getDetails() + ")");
            current = current.next;
            if (current != null) {
                System.out.print(" -> ");
            }
        }
        //System.out.println(" -> null");
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        Customer customer = new Customer("John", "Party of 4");
        list.addCustomer(customer);
        list.printList();
        System.out.println();
        customer = new Customer("VIP Jane", "Party of 8");
        list.addVIPCustomer(customer);
        list.printList();
    }
}
