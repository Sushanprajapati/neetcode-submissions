class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> tempSet = new HashSet<>();

        for (int num: nums) {
            tempSet.add(num);
        }

        for (int i = 0; i <= nums.length; i++) {
            if (!tempSet.contains(i)) return i;
        }

        return -1;
    }
}
