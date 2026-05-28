class Solution {
    public boolean hasDuplicate(int[] nums) {
       Set<Integer> tempSet = new HashSet<>();

       for (int num: nums) {
        if (tempSet.contains(num)){
            return true;
        }
        tempSet.add(num);
       }

       return false;
    }
}