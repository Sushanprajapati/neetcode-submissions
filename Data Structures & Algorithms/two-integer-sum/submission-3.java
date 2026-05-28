class Solution {
    public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> tempHash = new HashMap<>();

      for (int i =0; i < nums.length; i++) {
        if (tempHash.containsKey(target - nums[i])) {
            return new int[]{tempHash.get(target - nums[i]), i};
        } else {
            tempHash.put(nums[i], i);
        }
      }

      return new int[]{};
    }
}
