class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Base case
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> tempMap = new HashMap<>();

        for (String str: strs) {
            String frequencyString = helperFrequencyMethod(str);

            if (tempMap.containsKey(frequencyString)) {
                tempMap.get(frequencyString).add(str);
            } else {
                List<String> valueString = new ArrayList<>();
                valueString.add(str);
                tempMap.put(frequencyString, valueString);
            }
        }

        return new ArrayList<>(tempMap.values());
    }

    public String helperFrequencyMethod(String str) {
        int[] charArr = new int[26];

        for (Character ch: str.toCharArray()) {
            charArr[ch - 'a']++;
        }

        StringBuilder tempString = new StringBuilder("");
        Character ch = 'a';
        for (int i: charArr) {
            tempString.append(ch);
            tempString.append(i);
            ch++;
        }

        return tempString.toString();
    }
}
