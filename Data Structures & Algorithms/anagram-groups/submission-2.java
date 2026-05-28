class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> res = new HashMap<>();

        for (String str: strs) {
            String stringFrequency = getFrequency(str);

            if (res.containsKey(stringFrequency)) {
                res.get(stringFrequency).add(str);
            } else {
                List<String> tempList = new ArrayList<>();
                tempList.add(str);
                res.put(stringFrequency, tempList);
            }
        }   
        return new ArrayList<>(res.values());
    }

    private String getFrequency(String str) {
        int[] arr = new int[26];

        for (Character ch: str.toCharArray()) {
            arr[ch - 'a']++;
        }

        StringBuilder newString = new StringBuilder("");
        Character ch = 'a';
        for (int i : arr) {
            newString.append(ch);
            newString.append(i);
            ch++;
        }

        return newString.toString();
    }
}

