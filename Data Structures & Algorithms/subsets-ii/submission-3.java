class Solution {
    // It's a mix of Subset I and Combination Sum II problems
    // We need to have the subsets but not duplicates.
    // So, Add the logic of duplicate check for the subset problem

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Sorting to make sure duplicate check logic works
        Arrays.sort(nums);
        backTrack(nums, result, new ArrayList<>(), 0);
        return result;
    }

    public void backTrack(int[] nums, List<List<Integer>> result, List<Integer> tempSet, int start) {
        result.add(new ArrayList<>(tempSet));

        for (int i = start; i < nums.length; i++) {
            // Skipping if the candidate is duplicate
            // If the current candidate equals the previous one, then there's no need of going and generating the subsets
            // we'll be getting the same subsets. So, we'll skip the operation
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Subset logic
            tempSet.add(nums[i]);
            backTrack(nums, result, tempSet, i + 1);
            tempSet.remove(tempSet.size() - 1);
        }
    }
}
