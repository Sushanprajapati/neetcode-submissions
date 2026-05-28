/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// Brute Force Method will be to crate a new list using .next ListNode method and then loop through each node
// to find the random Node.

// We'll solve this using 3 steps:
// 1) Create a copy of given list without random pointer. THe list will be in the sense that:
    // We'll insert the preceeding value between two nodes. Eh: if Node = 1 -> 2, then we do: 1-> 1 -> 2
// 2) Now, we'll work for random pointer
// 3) Separate the two lists created
class Solution {
    public Node copyRandomList(Node head) {
        // Base Case
        if (head == null) return null;

        Node curr = head;
        while (curr != null) {
            Node tempNode = new Node(curr.val);
            tempNode.next = curr.next;
            curr.next = tempNode;
            curr = tempNode.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node tempNode = curr.next;
        Node workingNode = tempNode;
        while (curr != null) {
            curr.next = tempNode.next;
            curr = curr.next;

            if (curr != null) {
                tempNode.next = curr.next;
                tempNode = tempNode.next;
            }
        }
        return workingNode;
    }
}
