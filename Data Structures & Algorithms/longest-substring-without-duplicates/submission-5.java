class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> tempSet = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (tempSet.contains(s.charAt(right))) {
                tempSet.remove(s.charAt(left));
                left++;
            }

            tempSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, tempSet.size());
        }
        return maxLength;
    }
}
