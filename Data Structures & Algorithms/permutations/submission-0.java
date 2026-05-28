class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums, result, new ArrayList<>());
        return result;
    }

    public void backTrack(int[] nums, List<List<Integer>> result, List<Integer> tempSet) {
        if (tempSet.size() == nums.length) {
            result.add(new ArrayList<>(tempSet));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (tempSet.contains(nums[i])) continue;
            
            tempSet.add(nums[i]);
            backTrack(nums, result, tempSet);
            tempSet.remove(tempSet.size() - 1);
        }
    }
}
