class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null) return null;

        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backTrack(candidates, target, new ArrayList<>(), result, 0);
        return result;
    }

    public void backTrack(int[] candidates, int target, List<Integer> tempSet,
                            List<List<Integer>> result, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(tempSet));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > target) return;

            tempSet.add(candidates[i]);
            backTrack(candidates, target - candidates[i], tempSet, result, i + 1);
            tempSet.remove(tempSet.size() - 1);
        }
    }
}
