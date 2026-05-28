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

        //1. Create a copy of given list
        Node curr = head;
        while (curr != null) {
            // We create a new node first with the val of head. It'll be then used to create connection between other
            // two nodes (right and left)
            Node tempNode = new Node(curr.val);
            // Point tempNode to 2nd node 
            tempNode.next = curr.next;
            // Point the first Node to tempNode
            curr.next = tempNode;
            // Place the current Node to next Node to tempNode. Moving forward
            curr = tempNode.next;
        }

        // 2) Copy the Random Pointers
        // Reset the curr
        curr = head;
        while (curr != null) {
            // Make sure random is not null. It will by default take random pointer to null if value not exists
            if (curr.random != null) {
                // Associating the random value for our newly created node (which is curr.next.random)
                // the required value is in curr.random.next
                curr.next.random = curr.random.next;
            }
            // Move forward
            curr = curr.next.next;
        }

        // 3) Separate the Two Lists
        // Reset the curr
        curr = head;

        // Create a dummy node to point to our newly created list.
        Node tempHead = curr.next;
        Node tempNode = tempHead;
        // We'll work on tempNode
        while (curr != null) {
            // Point the current to their respective original next pointer, which is next to tempNode
            curr.next = tempNode.next;
            // Place the curr to new node
            curr = curr.next;
            // Its important to check if curr is not null because if its null, we've come to end and there's no any 
            // tempNode left after that
            if (curr != null) {
                // Do the same as for curr . Point the tempNode to respective next address/pointer
                tempNode.next = curr.next;
                tempNode = tempNode.next;
            }
        }
        return tempHead;
    }
}
