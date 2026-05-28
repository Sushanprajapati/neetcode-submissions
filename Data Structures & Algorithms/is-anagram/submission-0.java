class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> firstString = new HashMap<>();
        Map<Character, Integer> secondString = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            firstString.put(s.charAt(i), firstString.getOrDefault(s.charAt(i), 0) + 1);
            secondString.put(t.charAt(i), secondString.getOrDefault(t.charAt(i), 0) + 1);
            // if(firstString.containsKey(s.charAt(i))) {
            //     firstString.put(s.charAt(i), firstString.get(s.charAt(i)) + 1);
            // } else {
            //     firstString.put(s.charAt(i), 0);
            // }
            // if(secondString.containsKey(t.charAt(i))) {
            //     secondString.put(t.charAt(i), secondString.get(t.charAt(i)) + 1);
            // } else {
            //     secondString.put(t.charAt(i), 0);
            // }
        }

        return firstString.equals(secondString);
    }
}
