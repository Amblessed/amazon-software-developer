package data_structures_and_algorithms.linkedlist.single;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 08-Oct-24
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {

    Customer customer;
    Node next;

    Node(Customer customer) {
        this.customer = customer;
        this.next = null;
    }
}
