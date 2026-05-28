class Solution {
    public int rob(int[] nums) {
        
        // If there is only one element/house, simply return it
        if (nums.length < 2) {
            return nums[0];
        }

        int[] dp = new int[nums.length];

        // Initializing the first two elements in the dp array.
        // We are storing the maximum value as we move on
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        // We will loop through rest of the elements in the array
        for (int i = 2; i < nums.length; i++) {

            // we take the maximum value between the element that we're currently in and one step earlier.
            // so, if we take the current element then we'll have to add the value which is in (n-2)th place.
            // This is because, we know, we are not allowed to choose the adjacent values.
            // So, we either take only (i-1) or addition of (i-2) + nums[i]
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        return dp[nums.length - 1];
    }
}
