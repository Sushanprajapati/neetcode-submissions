class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        if (s1.length() > s2.length() || s2.length() == 0) return false;
        if (s1.length() == 0) return true;

        int left = 0, right = 0;
        while (right < s1.length()) {
            arr1[s1.charAt(right) - 'a']++;
            arr2[s2.charAt(right) - 'a']++;
            right++;
        }
        right--; 

        while (right < s2.length()) {
            if (Arrays.equals(arr1, arr2)) return true;

            right++;
            if (right < s2.length()) arr2[s2.charAt(right) - 'a']++;

            arr2[s2.charAt(left) - 'a']--;
            left++;
        }

        return false;
    }
}
