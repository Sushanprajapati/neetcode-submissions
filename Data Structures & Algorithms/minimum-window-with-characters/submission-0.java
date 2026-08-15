class Solution {
    // Using sliding window approach here
    // time: O(n)
    public String minWindow(String s, String t) {
        // We'll initialize two fixed size array to store the frequency of each character in string.
        // size of 256 because we have lowercase and uppercase characters
        int[] s1Array = new int[256];
        int[] s2Array = new int[256];

        // first we'll go for string t, as it is the one which we'll be comparing
        for (Character ch: t.toCharArray()) {
            s2Array[ch]++;
        }

        int left = 0, right = 0, minWindowLength = Integer.MAX_VALUE, minStart = 0;

        // we will use the same "right" variable and go till its end
        while (right < s.length()) {
            // count the characters in string s and put it to 
            s1Array[s.charAt(right)]++;


            while (contain(s1Array, s2Array)) {
                if (right - left + 1 < minWindowLength) {
                    minWindowLength = right - left + 1;
                    minStart = left;
                }
                s1Array[s.charAt(left++)]--;
            }

            right++;
        }
        // return the string starting from minStart. add minWindowlength to it
        return minWindowLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minWindowLength);
    }

    // helper method to check if the character count of string t exists in string s
    // if the character doesnot exists, return false 
    private boolean contain(int[] arr1, int[] arr2) {
        for (int i = 0; i < 256; i++) {
            if (arr2[i] > arr1[i]) return false;
        }
        return true;
    }
}
