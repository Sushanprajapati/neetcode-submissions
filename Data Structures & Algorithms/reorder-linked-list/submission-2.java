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

// We'll try to solve it in 3 steps,avoiding the extra space
// 1. find the mid point (using slow and fast pointers)
// 2. Reverse the right half of the list
// 3. Merge the two halves using two pointers
class Solution {
    public void reorderList(ListNode head) {
        // Base cases
        if (head == null || head.next == null) return;

        // Find the mid point
        ListNode p1 = head;
        ListNode p2 = head;

        // Our Slow pointer will be the mid point
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        // Now, our p1 is at the mid point

        // Reverse the right half
        ListNode prev = p1;
        ListNode curr = p1.next;
        
        while (curr.next != null) {
            // First, we'll swap curr and curr.next Node
            // i.e we need to point curr Node from curr.next and 
            // then curr Node will point to curr.next.next
            // For that, we'll store curr.next in tempNode
            ListNode tempNode = curr.next;

            // Now, we can point curr.next to tempNode.next
            // Its basically curr.next.next
            curr.next = tempNode.next;
            // Point the tempNode to our prev.next
            tempNode.next = prev.next;
            // Finally bring the initial node / Prev Node to last (tempNode)
            prev.next = tempNode;
        }
        // Our right half is reversed
        // Remember, our prev is pointing to mid of our LinkedList but its starting with null
        // because we've brought the end of our list (i.e. null) to the front after reversing


        // Finally merge two halves
        // Utilize two pointers method
        // Put one pointer to start of left half and other to the start of right half (Mid)
        // keep on moving the pointers to their right after performing the operation
        // Operation should look like:: 0 -> n-1 -> 1 -> n-2 -> 2 -> n-3 -> 3 ...

        p1 = head; // Start of left half
        p2 = prev.next; // Currently there is a null address in prev

        while (p1 != prev) { // we have to go till mid point
            prev.next = p2.next; // store the next address of mid (like tempNode)
            p2.next = p1.next; // left half pointing to next of right half
            p1.next = p2; // Now, point that whole p2 from left pointer

            p1 = p2.next; // move p1 to slightly right, it should now point to p2.next
            p2 = prev.next; // Finally point p2 to prev.next (tempNode that we stored)
        }
    }
}
