class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
       if (nums == null) return null;

       List<List<Integer>> result = new ArrayList<>();
       backTrack(nums, target, 0, result, new ArrayList<>());
       return result;
    }

    public void backTrack(int[] nums, int target, int start, List<List<Integer>> result,
                            List<Integer> tempSet) {
        if (target == 0) {
            result.add(new ArrayList<>(tempSet));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] <= target) {
                tempSet.add(nums[i]);

                backTrack(nums, target - nums[i], i, result, tempSet);

                tempSet.remove(tempSet.size() - 1);
            }
        }
    }

    
}
