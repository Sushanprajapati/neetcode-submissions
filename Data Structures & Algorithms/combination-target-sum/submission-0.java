class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // Base Condition if nums is null
        if (nums == null) {
            return null;
        }

        List<List<Integer>> resultSet = new ArrayList<>();

        backTrack(resultSet, new ArrayList<>(), nums, target, 0);
        return resultSet;
    }

    public void backTrack(List<List<Integer>> resultSet, List<Integer> tempSet, int[] nums,
                int target, int start) {
        // Check if target is 0
        // If its 0, we are done with further calculations, we got all our possibilties
        if (target == 0) {
            resultSet.add(new ArrayList<>(tempSet));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // We can perform calculations, only if the current element in array
            // is small or equal to target. 
            if (nums[i] <= target) {
                // Add to tempSet
                tempSet.add(nums[i]);

                backTrack(resultSet, tempSet, nums, target - nums[i], i);

                // Removing the element after recursion
                tempSet.remove(tempSet.size() - 1);
            }
        }
    }
}
