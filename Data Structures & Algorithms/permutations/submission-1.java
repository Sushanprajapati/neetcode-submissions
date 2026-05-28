class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums, result, new ArrayList<>());
        return result;
    }

    public void backTrack(int[] nums, List<List<Integer>> result, List<Integer> tempSet) {
        // We'll add to the result only if the tempSet size == nums length
        if (tempSet.size() == nums.length) {
            result.add(new ArrayList<>(tempSet));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Do not add the same element 
            // the question specifies: unique integers. So, we have to generate the permutations only with unique integers
            if (tempSet.contains(nums[i])) continue;

            // 1. Add the element to the list
            tempSet.add(nums[i]);
            // 2. BackTrack
            backTrack(nums, result, tempSet);
            // 3. Remove the element we just added. so that, we can encorporate new number
            tempSet.remove(tempSet.size() - 1);
        }
    }
}
