class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (word.charAt(0) == board[r][c]) {
                    boolean result = backTrack(board, word, r, c, 0);
                    if (result) return true;
                }
            }
        }

        return false;
    }

    public boolean backTrack(char[][] board, String word, int row, int col, int stringIndex) {
        if (stringIndex == word.length()) return true;

        int r = board.length;
        int c = board[0].length;

        if (row < 0 || row >= r || col < 0 || col >= c) {
            return false;
        }

        if (board[row][col] == ' ' || board[row][col] != word.charAt(stringIndex)) {
            return false;
        }

        char tempChar = board[row][col];
        board[row][col] = ' ';
        if (backTrack(board, word, row - 1, col, stringIndex + 1) ||
            backTrack(board, word, row + 1, col, stringIndex + 1) ||
            backTrack(board, word, row, col - 1, stringIndex + 1) ||
            backTrack(board, word, row, col + 1, stringIndex + 1) ) {
                return true;
            }

        board[row][col] = tempChar;

        return false;
    }

    
}
