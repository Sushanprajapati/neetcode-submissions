class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> res = new HashSet<>();
        int longestSequence = 0;

        for (int num: nums) {
            res.add(num);
        }

        for (int num: nums) {
            if (!res.contains(num - 1)) {
                int diff = 1;
                while (res.contains(num + diff)) {
                    diff++;
                }
                longestSequence = Math.max(longestSequence, diff);
            }
        }
    
        return longestSequence;
    }
}
