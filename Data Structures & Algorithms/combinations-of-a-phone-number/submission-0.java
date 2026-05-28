class Solution {
    Map<Character, String> map = getMap();
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        StringBuilder tempString = new StringBuilder("");
        if (digits.length() == 0) return result;

        backTrack(digits, tempString, 0);
        return result;
        
    }
    
    public void backTrack(String digits, StringBuilder tempString, int start) {
        if (tempString.toString().length() == digits.length()) {
            result.add(tempString.toString());
            return;
        }

        for (char c: map.get(digits.charAt(start)).toCharArray()) {
            tempString.append(c);
            backTrack(digits, tempString, start + 1);
            tempString.deleteCharAt(tempString.length() - 1);
        }
    }

    public Map<Character, String> getMap() {
        Map<Character, String> temp = new HashMap<>();

        temp.put('2', "abc");
        temp.put('3', "def");
        temp.put('4', "ghi");
        temp.put('5', "jkl");
        temp.put('6', "mno");
        temp.put('7', "pqrs");
        temp.put('8', "tuv");
        temp.put('9', "wxyz");

        return temp;
    }
}
