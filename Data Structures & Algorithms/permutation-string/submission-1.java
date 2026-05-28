class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length() || s2.length() == 0) return false;
        if (s1.length() == 0) return true;

        int left = 0, right = 0;
        int[] array1 = new int[26];
        int[] array2 = new int[26];

        while (right < s1.length()) {
            array1[s1.charAt(right) - 'a']++;
            array2[s2.charAt(right) - 'a']++;
            right++;
        }
        right--;

        while (right < s2.length()) {
            if (Arrays.equals(array1, array2)) return true;

            right++;
            if (right < s2.length()) array2[s2.charAt(right) - 'a']++;

            array2[s2.charAt(left) - 'a']--;
            left++;
        }

        return false;
    }
}
