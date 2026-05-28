class Solution {
    public List<String> generateParenthesis(int n) {
        // using classic string methods
        List<String> result = new ArrayList<>();

        backTrack(0, 0, n, "", result);
        return result;
    }

    public void backTrack(int open, int closed, int n, String tempString, List<String> result) {
        // Break the recursion and add to the result once the open bracket = closed bracket = n
        if (open == closed && open == n) {
            result.add(tempString);
            return;
        }

        // We add the open brackets only if openBrackets < n.
        // Because open brackets cannot exceed n
        if (open < n) {
            // add the candidate to the stack
            tempString = tempString + "(";
            backTrack(open + 1, closed, n, tempString, result);
            // removing the last candidate from the stack
            tempString = tempString.substring(0, tempString.length() - 1);
        }

        // We add the close brackets only if closed brackets < open brackets.
        // closed brackets canot come before open brackets
        if (closed < open) {
            // add the candidate to the stack
            tempString = tempString + ")";
            backTrack(open, closed + 1, n, tempString, result);
            // remove the candidate from the stack
            tempString = tempString.substring(0, tempString.length() - 1);        
        }
    }
}
