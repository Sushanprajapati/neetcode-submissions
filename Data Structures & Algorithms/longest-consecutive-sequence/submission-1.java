class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> hashMap = new HashMap<>();
        int longestSequence = 0;

        for (int num: nums) {
            hashMap.put(num, false);
        }

        for (int num: nums) {
            int currentLength = 1;
            // checking in forward direction
            int nextNum = num + 1;
            while (hashMap.containsKey(nextNum) && hashMap.get(nextNum) == false) {
                currentLength++;
                hashMap.put(nextNum, true);
                nextNum++;
            }

            // checkcing backward direction
            int prevNum = num - 1;
            while (hashMap.containsKey(prevNum) && hashMap.get(prevNum) == false) {
                currentLength++;
                hashMap.put(prevNum, true);
                prevNum--;
            }

            longestSequence = Math.max(longestSequence, currentLength);
        }
    
        return longestSequence;
    }
}
