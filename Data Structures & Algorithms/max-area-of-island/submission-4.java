class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result = Math.max(result, dfs(i, j, grid));
            }
        }

        return result;
    }

    public int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length ||
            grid[i][j] == 0) {
                return 0;
        }

        grid[i][j] = 0;

        return 1 + dfs(i + 1, j, grid) +
                    dfs(i - 1, j, grid) +
                    dfs(i, j + 1, grid) +
                    dfs(i, j - 1, grid);
    }
}
