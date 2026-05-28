class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> tempSet = new HashSet<>();
        for (int num: nums) {
            if (tempSet.contains(num)) {
                return true;
            } else {
                tempSet.add(num);
            }
        }

        return false;
    }
}