class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) return mid;

            // We;ll now see if either right or left portion is sorted (any one of them
            // will be sorted)

            // Check in left portion (see if left is sorted)
            // to check that, we'll see if nums[left] <= nums[mid]
            if (nums[l] <= nums[mid]) {

                // check if target is within the range (left portion) or not
                // we'll reduce the portion size accordingly
                if (target < nums[l] || target > nums[mid]) {

                    // reduce the left window,i.e. shift left pointer to mid
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else { // if right portion is sorted

                // check if target is within the range (right portion) or not
                // we'll reduce the portion size accordingly
                if (target > nums[r] || target < nums[mid]) {

                    // Logically, if above condn are satisfied, we'll have to 
                    // reduce the right window,i.e. shift right pointer to mid
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return -1;
    }
}
