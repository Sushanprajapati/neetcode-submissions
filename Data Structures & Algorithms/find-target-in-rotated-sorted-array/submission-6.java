class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        return modifiedBinarySearch(nums, target, left, right);
    }

    // We'll try to use recursive method here
    // We'll keep on dividing our array intp two halves till we reach the condn: left > right using binary search technique
    public int modifiedBinarySearch(int[] nums, int target, int left, int right) {
 
        if (left > right) return -1;

        // Basic binary search technique
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;

        // Now we'll check if which side of our array is sorted by the help of mid index
        // if Left Side sorted
        if (nums[mid] >= nums[left]) {
            // if key is in left half
            if (target >= nums[left] && target <= nums[mid]) {
                return modifiedBinarySearch(nums, target, left, mid - 1);
            } else {
                return modifiedBinarySearch(nums, target, mid + 1, right);
            }
        } else { // if right half sorted
        // if key is in right half
            if (target >= nums[mid] && target <= nums[right]) {
                return modifiedBinarySearch(nums, target, mid + 1, right);
            } else {
                return modifiedBinarySearch(nums, target, left, mid - 1);
            }
        }

    }
}
