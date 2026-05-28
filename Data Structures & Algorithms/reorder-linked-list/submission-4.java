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
        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = slow;
        ListNode curr = slow.next;

        while (curr.next != null) {
            ListNode tempNode = curr.next;
            curr.next = tempNode.next;
            tempNode.next = prev.next;
            prev.next = tempNode;
        }

        ListNode p1 = head;
        ListNode p2 = prev.next;
        while (p1 != prev) {
            prev.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;

            p1 = p2.next;
            p2 = prev.next;
        }
    }
}
