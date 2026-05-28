class Solution {
    public int rob(int[] nums) {
        
        // Base case. if there is only one element in the array then, simply return that element
        if (nums.length < 2) {
            return nums[0];
        }

        // create two separate arrays
        // one array that will avoid the first element and 2nd array will avoid the last element
        // for that technically, we need array of size 1 less than the original array length
        int[] skipFirstHouse = new int[nums.length - 1];
        int[] skipLastHouse = new int[nums.length - 1];

        // populate the elements in the two new arrays
        for (int i = 0; i < nums.length - 1; i++) {
            skipFirstHouse[i] = nums[i+1];
            skipLastHouse[i] = nums[i];
        }

        // we'll call helper method that will return the maximum cost/value 
        // the helper method is nothing but the same house robber problem, where houses are in straight line
        // now since we avoided either first/last house, our solution will come from two different chunks
        // one straight line without first house
        // one without last house
        int skipFirstHouseInt = getMaxRob(skipFirstHouse);
        int skipLastHouseInt = getMaxRob(skipLastHouse);

        return Math.max(skipFirstHouseInt, skipLastHouseInt);
    }

    // helper method to carry out the house robber problem
    public int getMaxRob(int[] tempArr) {
        // check if the new size is greater than or equals to 2.
        // simply return the element if the array size is 1
        if (tempArr.length < 2) {
            return tempArr[0];
        }

        int[] dp = new int[tempArr.length];

        // now our base case if we have more than one element
        // first elemtn will be the same itself
        // for second element, it'll be the max of first element in the dp array and the incoming array.
        dp[0] = tempArr[0];
        dp[1] = Math.max(dp[0], tempArr[1]);

        for(int i = 2; i < tempArr.length; i++) {
            dp[i] = Math.max(dp[i - 1], tempArr[i] + dp[i-2]);
        }

        return dp[tempArr.length - 1];
    }
}
