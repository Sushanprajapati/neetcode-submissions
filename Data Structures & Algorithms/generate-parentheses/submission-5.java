class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder tempString = new StringBuilder("");
        backTrack(0, 0, n, result, tempString);
        return result;
    }

    public void backTrack(int open, int close, int n, List<String> result, StringBuilder temp) {
        if (open == close && open == n) {
            result.add(temp.toString());
            return;
        }

        if (open < n) {
            temp.append("(");
            backTrack(open + 1, close, n, result, temp);
            temp.deleteCharAt(temp.length() - 1);
        }

        if (close < open) {
            temp.append(")");
            backTrack(open, close + 1, n, result, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
