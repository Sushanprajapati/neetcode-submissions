class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        // we need to stop once l == r because, once its equal , our smallest element
        // will no longer be there
        // our smallest element will always be on the left
        while (l < r) {
            int mid = l + (r - l) / 2;

            // if nums[mid] < nums[right], then right portion is sorted and 
            // our smallest element will either be at mid or left portion
            // So, we'll have to reduce the window to left moving right pointer to mid.
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
            // If nums[mid] > nums[r], our right portion will definitely contain smallest
            // element
            // So, we'll move our left pointer to mid + 1
            // Mid+1 because, out nums[mid] is already > nums[r].
                l = mid + 1;
            }
        }

        return nums[l];
    }
}
