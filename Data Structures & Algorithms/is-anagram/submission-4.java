class Solution {
    public boolean isAnagram(String s, String t) {
     if (s.length() != t.length()) return false;

     Map<Character, Integer> firstString = new HashMap<Character, Integer>();
     Map<Character, Integer> secondString = new HashMap<Character, Integer>();

     for (int i =0; i < s.length(); i++) {
        firstString.put(s.charAt(i), firstString.getOrDefault(s.charAt(i) , 0) + 1);
        secondString.put(t.charAt(i), secondString.getOrDefault(t.charAt(i), 0) + 1);
     }

     return firstString.equals(secondString);
    }
}
