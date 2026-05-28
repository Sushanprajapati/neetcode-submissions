class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> tempHashSet = new HashSet<Integer>();

        for (int val: nums) {
            if (tempHashSet.contains(val)) {
              return true;  
            } else {
                tempHashSet.add(val);
            }
        }
        return false;
    }
}