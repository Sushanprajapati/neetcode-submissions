class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Base case if string input is null or empty
        if (strs.length == 0 || strs == null) return new ArrayList<>();

        // HashMap to store frequency of Characters (all 26 alphabets) as key and corresponding strings as value
        Map<String, List<String>> res = new HashMap<>();

        for (String str: strs) {
            String newString = frequencyString(str);

            if (res.containsKey(newString)) {
                res.get(newString).add(str);
            } else{
                List<String> tempString = new ArrayList<>();
                tempString.add(str);
                res.put(newString, tempString);
            }
        }

        return new ArrayList<>(res.values());
    }

    // Helper method to generate a string consisting frequency of each characters (we'll do it for all 26 characters)
    private String frequencyString(String str) {
        int[] arr = new int[26];

        for (Character ch: str.toCharArray()) {
            arr[ch - 'a']++;
        }

        StringBuilder tempString = new StringBuilder("");
        Character ch = 'a';
        for (int i : arr){ // Will give something like "a1b3c5...."
            tempString.append(ch);
            tempString.append(i);
        }

        return tempString.toString();
    }
}

