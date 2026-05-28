/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// We can implement two pointer technique to solve this problem
// Step 1: create a dummy node (it will help us to handle the edge cases e.g. only one node)
// Step 2: Initialize two pointers at dumy node.
// Step 3: Keep second pointer to nth position (loop till n and put the 2nd pointer there)
// Step 4: Keep moing both pointers till 2nd pointer points to null (i.e. end of List)
// The value next to 1st pointer is the one we want to remove
// Step 5: Point the 1st pointer to next.next.
// Step 6: Return dummy.next (Made easy to get the desired answer).
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Initialize dummy
        ListNode dummy = new ListNode(-1);
        // Point the dummy to head
        dummy.next = head;

        // Initialize two pointers at dummy
        ListNode p1 = dummy;
        ListNode p2 = dummy;

        // Put 2nd pointer at nth position.
        // Its the simple math that, when we'll move two pointers parallely, the 1st pointer will point to nth position
        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }

        // Traverse through the list moving both the pointers
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        // Remove the node (i.e. point the n - 1th node to next node)
        p1.next = p1.next.next;

        return dummy.next;
    }
}
