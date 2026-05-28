class Solution {
    public boolean exist(char[][] board, String word) {
        int rowLength = board.length;
        int colLength = board[0].length;

        for(int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                // start the traversal only if the first element is found
                if (board[row][col] == word.charAt(0)) {
                    boolean result = dfsBackTrack(row, col, board, word, 0);
                    if (result) return true;
                }
            }
        }

        return false;
    }

    public boolean dfsBackTrack(int r, int c, char[][] board, String word, int wordIndex) {

        // Base case to stop the backtrack
        if (wordIndex == word.length()) return true;

        // Invalid cases: if row or col index are out of bounds
        int rowLength = board.length;
        int colLength = board[0].length;
        if (r < 0 || c < 0 || r >= rowLength || c >= colLength) return false;

        // Invalid case: If the box/element is already visited or the word != word[wordIndex]
        if (board[r][c] == ' ' || board[r][c] != word.charAt(wordIndex)) return false;

        // If row and col is within the range, then mark the place/box as visited
        char tempChar = board[r][c];
        board[r][c] = ' ';

        // Valid Case
        // Looking for all the possible sides for next character
        if (dfsBackTrack(r-1, c, board, word, wordIndex + 1) ||
            dfsBackTrack(r, c+1, board, word, wordIndex + 1) ||
            dfsBackTrack(r+1, c, board, word, wordIndex + 1) ||
            dfsBackTrack(r, c-1, board, word, wordIndex + 1)){
                return true;
        }

        // If word is not found , then undo the visited element
        board[r][c] = tempChar;

        // finally
        return false;
    } 
}
