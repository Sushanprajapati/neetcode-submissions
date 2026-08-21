class Solution {
    public String minWindow(String s, String t) {
        int[] s1Arr = new int[256];
        int[] s2Arr = new int[256];

        for (Character ch: t.toCharArray()) {
            s2Arr[ch]++;
        }

        int left = 0, right = 0, minWindowLength = Integer.MAX_VALUE, minStart = 0;

        while (right < s.length()) {
            s1Arr[s.charAt(right)]++;

            while(contain(s1Arr, s2Arr)) {
                if (right - left + 1 < minWindowLength) {
                    minWindowLength = right - left + 1;
                    minStart = left;
                }
                s1Arr[s.charAt(left++)]--;
            }

            right++;
        }
        return minWindowLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minWindowLength);
    }

    private boolean contain(int[] s1Arr, int[] s2Arr) {
        for (int i = 0; i < 256; i++) {
            if (s2Arr[i] > s1Arr[i]) return false;
        }

        return true;
    }
}
