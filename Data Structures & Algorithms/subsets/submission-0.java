class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultSet = new ArrayList<>();
        backTracking(resultSet, new ArrayList<>(), nums, 0);
        return resultSet;
    }

    // Helper method for performing recursion 
    public void backTracking(List<List<Integer>> resultSet, List<Integer> tempSet, int[] nums, int start) {
        resultSet.add(new ArrayList<>(tempSet));

        for (int i = start; i < nums.length; i++) {
            // Case where we're involving the candidate/element
            tempSet.add(nums[i]);

            // Once candidate is added, we backtrack the operation. recursion
            // this is the operation that'll cause 2 ^ n
            backTracking(resultSet, tempSet, nums, i + 1);

            // Case where we're not involving the candidate
            // We're removing the latest/last element from list
            tempSet.remove(tempSet.size() - 1);
        }

    }
}
