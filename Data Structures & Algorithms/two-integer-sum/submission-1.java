class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer, Integer> tempHashMap =  new HashMap<Integer, Integer>();

       for (int i = 0 ; i < nums.length; i++) {
        if (tempHashMap.containsKey(target - nums[i])) {
            return new int[]{tempHashMap.get(target - nums[i]), i};
        } else {
            tempHashMap.put(nums[i], i);
        }
       }

       return new int[]{};
    }
}
