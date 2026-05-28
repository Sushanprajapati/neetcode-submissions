class Solution {
    public List<String> generateParenthesis(int n) {
       List<String> result = new ArrayList<>();
       StringBuilder tempString = new StringBuilder("");
       backTrack(result, n, tempString, 0, 0);
       return result;
    }

    public void backTrack(List<String> result, int n, StringBuilder tempString, int open, int closed) {
        if (open == closed && open == n) {
            result.add(tempString.toString());
            return;
        }

        if (open < n) {
            tempString.append("(");
            backTrack(result, n, tempString, open + 1, closed);
            tempString.deleteCharAt(tempString.length() - 1);
        }

        if (closed < open) {
            tempString.append(")");
            backTrack(result, n, tempString, open, closed + 1);
            tempString.deleteCharAt(tempString.length() - 1);
        }
    }
}
