class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {

            // Using basic binary search technique to find the target index
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid; 

            // Check if left portion is sorted
            if (nums[left] <= nums[mid]) {
                // Check if target is there within the range of left portion
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1; 
                } else {
                    right = mid - 1;
                }
            } else { // Right side is sorted
                if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
}
