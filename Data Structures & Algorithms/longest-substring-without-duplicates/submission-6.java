class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> result = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (result.contains(s.charAt(right))) {
                result.remove(s.charAt(left));
                left++;
            }

            result.add(s.charAt(right));
            maxLength = Math.max(maxLength, result.size());
        }

        return maxLength;
    }
}
