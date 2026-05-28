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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Character ch = board[i][j];

                if (ch != '.') {
                    if (rows[i].contains(ch)) return false;

                    if (cols[j].contains(ch)) return false;

                    int boxIndex = 3 * (i / 3) + (j / 3);
                    if (box[boxIndex].contains(ch)) return false;

                    rows[i].add(ch);
                    cols[j].add(ch);
                    box[boxIndex].add(ch);
                }
            }
        }

        return true;
    }
}
