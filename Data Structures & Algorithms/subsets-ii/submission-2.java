class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums, result, new ArrayList<>(), 0);
        return result;
    }

    public void backTrack(int[] nums, List<List<Integer>> result, List<Integer> tempSet, int start) {
        result.add(new ArrayList<>(tempSet));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            tempSet.add(nums[i]);
            backTrack(nums, result, tempSet, i + 1);
            tempSet.remove(tempSet.size() - 1);
        }
    }
}
