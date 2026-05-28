class Solution {
    // Kind of similar to previous one but it doesnot allow the same element
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, result, new ArrayList<>(), 0);
        return new ArrayList<>(result);
    }
    

    public void backTrack(int[] candidates, int target, Set<List<Integer>> result,
                            List<Integer> tempSet, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(tempSet));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                tempSet.add(candidates[i]);

                backTrack(candidates, target - candidates[i], result, tempSet, i+1);

                tempSet.remove(tempSet.size() - 1);
            }
        }
    }


}
