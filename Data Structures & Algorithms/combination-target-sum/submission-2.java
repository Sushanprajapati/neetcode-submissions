class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        if (nums == null) return null;

        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums, target, new ArrayList<>(), result, 0);
        return result;
    }

    public void backTrack(int[] nums, int target, List<Integer> tempSet,
                            List<List<Integer>> result, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(tempSet));
            return;
        }

        for (int i = start; i < nums.length; i++){
            if (nums[i] <= target) {
                tempSet.add(nums[i]);
                backTrack(nums, target - nums[i], tempSet, result, i);
                tempSet.remove(tempSet.size() - 1);
            }
        }
    }
}
