class Solution {
    // Naive Solutions:
    // 1) Two loops and look for each element and return the one which came twice (O(n2))
    // 2) Use HashSet. But uses O(n) space
    // 3) Use Sorting and then loop (O(nlogn))

    // Optimized solution is to make use of Floyd's Algo (Tortoise/Hare). Slow and fast pointers
    // We'll treat each values as pointers in Linked List. and keep on creating list based on values at particular index
    // We'll use the algo two times. 
    // 1) first the fast pointer will point to nums[nums[fast]] and later fast and slow pointer will point to 
    // nums[slow] or nums[fast] respectively. 
    // We can make use of do/while and while loop (till slow != fast)respectively for each of two loops
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        // Find the first point of intersection
        // Use do-while because we want our loop to run atleast once.
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // reset the slow pointer to start new traverse
        slow = 0;
        // Fast pointer is at intersecting point
        // This time fast and slow pointer will move with same pace
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        // Finally the point of intersection will be the duplicate number
        return slow;
    }
}
