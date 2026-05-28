class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int actualSum = 0, rangeSum = 0;

        for (int num: nums) {
            actualSum += num;
        }

        rangeSum = (n) * (n + 1) / 2;

        return (rangeSum - actualSum);
    }
}
