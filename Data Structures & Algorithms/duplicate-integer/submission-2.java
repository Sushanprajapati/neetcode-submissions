class Solution {
    public boolean hasDuplicate(int[] nums) {
       Set<Integer> tempSet = new HashSet<>();

       for (Integer val: nums) {
        if (tempSet.contains(val)) {
            return true;
        } else {
            tempSet.add(val);
        }
       }
       return false;
    }
}