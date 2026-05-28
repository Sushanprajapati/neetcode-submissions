class Solution {
    // Kind of similar to previous one but it doesnot allow the same element
    // Optimal way without using hashset.
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, result, new ArrayList<>(), 0);
        return new ArrayList<>(result);
    }
    

    public void backTrack(int[] candidates, int target, List<List<Integer>> result,
                            List<Integer> tempSet, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(tempSet));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > target) break;

            tempSet.add(candidates[i]);

            backTrack(candidates, target - candidates[i], result, tempSet, i+1);

            tempSet.remove(tempSet.size() - 1);
        }
    }
}
