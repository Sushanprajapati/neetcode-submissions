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
            // Skip the duplicate entry here itself. avoids the use of hashset.
            // Since we already sorted the array, the comparison works here.
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            // come out if element is bigger than target
            if (candidates[i] > target) break;

            tempSet.add(candidates[i]);

            backTrack(candidates, target - candidates[i], result, tempSet, i+1);

            tempSet.remove(tempSet.size() - 1);
        }
    }
}
