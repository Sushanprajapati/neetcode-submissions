class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0 || strs == null) return new ArrayList<>();

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

    private String frequencyString(String str) {
        int[] arr = new int[26];

        for (Character ch: str.toCharArray()) {
            arr[ch - 'a']++;
        }

        StringBuilder tempString = new StringBuilder("");
        Character ch = 'a';
        for (int i : arr){
            tempString.append(ch);
            tempString.append(i);
        }

        return tempString.toString();
    }
}

