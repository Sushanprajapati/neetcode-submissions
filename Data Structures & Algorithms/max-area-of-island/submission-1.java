class Solution {
    // Similar to prevous problem of finding no. of island
    // Here, We need to keep track of number of 1's we encounter for each DFS
    // Then update the result with maximum value
    int result = 0;
    public int maxAreaOfIsland(int[][] grid) {
        // sanity check
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result = Math.max(result, dfs(i, j, grid, 0));
                }
            }
        }

        return result;
    }

    // helper method for running dfs
    public int dfs(int i, int j, int[][] grid, int current) {
        // base condition
        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length ||
            grid[i][j] == 0) {
                return 0;
            }

        grid[i][j] = 0;
        current++;

        return 1 + dfs(i+1, j, grid, current) 
                + dfs(i-1, j, grid, current)
                + dfs(i, j-1, grid, current)
                + dfs(i, j+1, grid, current);
    }
}
