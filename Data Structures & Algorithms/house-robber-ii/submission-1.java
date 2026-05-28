class Solution {
    public int rob(int[] nums) {
        
        if (nums.length < 2) {
            return nums[0];
        }

        int[] skipFirstHouse = new int[nums.length - 1];
        int[] skipLastHouse = new int[nums.length - 1];

        for (int i = 0; i < nums.length - 1; i++) {
            skipFirstHouse[i] = nums[i+1];
            skipLastHouse[i] = nums[i];
        }

        int skipFirstHouseInt = getMaxRob(skipFirstHouse);
        int skipLastHouseInt = getMaxRob(skipLastHouse);

        return Math.max(skipFirstHouseInt, skipLastHouseInt);
    }

    public int getMaxRob(int[] tempArr) {
        if (tempArr.length < 2) {
            return tempArr[0];
        }
        
        int[] dp = new int[tempArr.length];

        dp[0] = tempArr[0];
        dp[1] = Math.max(dp[0], tempArr[1]);

        for(int i = 2; i < tempArr.length; i++) {
            dp[i] = Math.max(dp[i - 1], tempArr[i] + dp[i-2]);
        }

        return dp[tempArr.length - 1];
    }
}
