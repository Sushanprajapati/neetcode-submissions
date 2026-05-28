class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // base case (always null check at first)
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        // Create a Map to store char frequency and related strings
        // {a1b2.. : [aba,baa..] }
        Map<String, List<String>> tempMap = new HashMap<>();

        for (String str: strs) {
            String strFrequency = helperStringMethod(str);

            if (tempMap.containsKey(strFrequency)) {
                tempMap.get(strFrequency).add(str);
            } else {
                List<String> tempList = new ArrayList<>();
                tempList.add(str);
                tempMap.put(strFrequency, tempList);
            }
        }

        return new ArrayList<>(tempMap.values());
    }

    public String helperStringMethod(String str) {
        int[] charArr = new int[26];

        // assuming all the chars are lowercase
        for (char ch: str.toCharArray()) {
            charArr[ch - 'a']++;
        }

        StringBuilder tempStr = new StringBuilder("");
        Character ch = 'a';
        for (int i = 0; i < charArr.length; i++) {
            tempStr.append(ch);
            tempStr.append(charArr[i]);
            ch++;
        }

        return tempStr.toString();
    }
}
