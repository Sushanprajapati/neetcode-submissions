class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backTrack(0, 0, n, "", result);
        return result;
    }

    public void backTrack(int open, int closed, int n, String tempString, List<String> result) {
        if (open == closed && open == n) {
            result.add(tempString);
            return;
        }

        if (open < n) {
            tempString = tempString + "(";
            backTrack(open + 1, closed, n, tempString, result);
            tempString = tempString.substring(0, tempString.length() - 1);
        }

        if (closed < open) {
            tempString = tempString + ")";
            backTrack(open, closed + 1, n, tempString, result);
            tempString = tempString.substring(0, tempString.length() - 1);        
        }
    }
}
