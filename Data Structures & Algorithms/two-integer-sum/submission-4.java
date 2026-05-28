class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> tempMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (tempMap.containsKey(target - nums[i])) {
                return new int[]{tempMap.get(target - nums[i]), i};
            } else {
                tempMap.put(nums[i], i);
            }
        }
        
        return new int[2];
    }
}
