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
        // Base case
        if (head == null || head.next == null) return;

        // Find the mid value. Use hare/tortoise approach
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = slow;
        ListNode curr = slow.next;

        // Reverse the right half
        // We're basically swapping curr and current.next
        while (curr.next != null) {
            ListNode tempNode = curr.next;
            curr.next = tempNode.next;
            tempNode.next = prev.next;
            prev.next = tempNode;
        }

        // Merge the two parts
        ListNode p1 = head;
        ListNode p2 = prev.next;
        // Not because prev is Null, but prev is the mid point and we're including that
        // to the left portion, and we didnt include that in our reverse logic

        while (p1 != prev) {
            prev.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;

            // move left pointer forward. 
            p1 = p2.next;

            // move right pointer forward.
            p2 = prev.next;
        }

    }
}
