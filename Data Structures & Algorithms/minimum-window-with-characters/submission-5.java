class Solution {
    public String minWindow(String s, String t) {
        int[] s1Array = new int[256];
        int[] s2Array = new int[256];

        for (Character ch: t.toCharArray()) {
            s2Array[ch]++;
        }

        int right = 0, left = 0, minWindowLength = Integer.MAX_VALUE, minStart = 0;

        while (right < s.length()){
            s1Array[s.charAt(right)]++;

            while(contain(s1Array, s2Array)) {
                if (right - left + 1 < minWindowLength) {
                    minWindowLength = right - left + 1;
                    minStart = left;
                }
                s1Array[s.charAt(left++)]--;
            }

            right++;
        }
        return minWindowLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minWindowLength);
    }

    private boolean contain(int[] arr1, int[] arr2) {
        for (int i = 0; i < 256; i++) {
            if (arr2[i] > arr1[i]) return false;  
        }
        return true;
    }
}
