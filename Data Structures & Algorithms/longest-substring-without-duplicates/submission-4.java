class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> chSet = new HashSet<>();
        int maxLength = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            while (chSet.contains(s.charAt(right))) {
                chSet.remove(s.charAt(left));
                left++;
            }

            chSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
