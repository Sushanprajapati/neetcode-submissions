class Solution {
    public List<String> generateParenthesis(int n) {
        // using classic string methods
        // we can use StringBuilder/StringBuffer to optimize the performance
        List<String> result = new ArrayList<>();
        StringBuffer str = new StringBuffer("");

        backTrack(0, 0, n, str, result);
        return result;
    }

    public void backTrack(int open, int closed, int n, StringBuffer tempString, List<String> result) {
        // Break the recursion and add to the result once the open bracket = closed bracket = n
        if (open == closed && open == n) {
            result.add(tempString.toString());
            return;
        }

        // We add the open brackets only if openBrackets < n.
        // Because open brackets cannot exceed n
        if (open < n) {
            // add the candidate to the stack
            tempString.append("(");
            backTrack(open + 1, closed, n, tempString, result);
            // removing the last candidate from the stack
            tempString.deleteCharAt(tempString.length() - 1);
        }

        // We add the close brackets only if closed brackets < open brackets.
        // closed brackets canot come before open brackets
        if (closed < open) {
            // add the candidate to the stack
            tempString.append(")");
            backTrack(open, closed + 1, n, tempString, result);
            // remove the candidate from the stack
            tempString.deleteCharAt(tempString.length() - 1);
        }
    }
}
