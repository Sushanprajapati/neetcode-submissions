class Solution {
    // Declaring global variables

    // Initializing map to store all the possible mapping for each numbers
    Map<Character, String> map = getMap();
    // Result list
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        // Initializing a stringbuilder to append/delete the characters as we move on
        StringBuilder tempString = new StringBuilder("");

        // edge case: if digits is null, return empty list
        if (digits.length() == 0) return result;

        backTrack(digits, tempString, 0);
        return result;
        
    }
    
    public void backTrack(String digits, StringBuilder tempString, int start) {

        // Base case: we stop the recursion when the length of created string (tempString) equals to length of digit
        // This makes sure, we are not over going the given size of digits
        // for eg: if length of digit = 2, tempString cannot exceed 2. 
        if (tempString.toString().length() == digits.length()) {
            result.add(tempString.toString());
            return;
        }

        // We loop through each values for the given characters in digits
        // For eg: if input is 23: we loop through each values in hashmap 
        for (char c: map.get(digits.charAt(start)).toCharArray()) {

            // for each characters in map, we append it to the tempstring
            tempString.append(c);

            // after adding each character, go back (recurse) and check for other character
            // so, we'are increasing the loop variable (start)
            backTrack(digits, tempString, start + 1);

            // once the recursion is complete, we need to backtrack
            // for that, we have to remove the last character from stack (delete from tempString in our case)
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
