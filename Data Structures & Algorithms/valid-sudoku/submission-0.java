class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        Set<Character>[] rows = new HashSet[n];
        Set<Character>[] cols = new HashSet[n];
        Set<Character>[] box = new HashSet[n];

        for (int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                Character ch = board[r][c];

                if (ch != '.') {
                    if (rows[r].contains(ch)) return false;

                    if (cols[c].contains(ch)) return false;

                    int boxIndex = 3 * (r / 3) + (c / 3);
                    if (box[boxIndex].contains(ch)) return false;

                    rows[r].add(ch);
                    cols[c].add(ch);
                    box[boxIndex].add(ch);
                }
            }
        }

        return true;
    }
}
