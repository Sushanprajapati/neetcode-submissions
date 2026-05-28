class Solution {
    public boolean hasDuplicate(int[] nums) {
         Set<Integer> tempSet = new HashSet<>();
         for (int value: nums) {
            if (tempSet.contains(value)) {
                return true;
            } else {
                tempSet.add(value);
            }
         }
         return false;
    }
}