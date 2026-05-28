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

// We can solve this problem simply by creating one result ListNode. We then, loop through the two list 
// Using || operator. We'll keep on calculating sum in each iteration where sum = 0 + carry.
// Carry will be coming from the end, which will be calculated using / 10 .
// We'll keep on calculating the sum for each list checking if that list is null or not 
// Dont forget to move forward the pointer in the list once done

// The input are in reversed order, and our output will also be in reverse order. So no need to think much about that
// Also, when we do the math addition, we start from one's position. So, the reversed order is basically easy point 
// for us. No need to keep on reversing the list to perform addition.
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempNode = new ListNode(-1);
        ListNode dummy = tempNode;

        int carry = 0;

        while (l1 != null || l2 != null) {

            int sum = 0 + carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            sum = sum % 10;
            dummy.next = new ListNode(sum);
            dummy = dummy.next;
        }

        if (carry == 1) dummy.next = new ListNode(1);

        return tempNode.next;
    }
}
