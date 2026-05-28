class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> st1 = new HashMap<>();
        HashMap<Character, Integer> st2 = new HashMap<>();

        for (int i = 0; i< s.length(); i++) {
            st1.put(s.charAt(i), st1.getOrDefault(s.charAt(i), 0) + 1);
            st2.put(t.charAt(i), st2.getOrDefault(t.charAt(i), 0) + 1);
        }

    return st1.equals(st2);
    }
}
