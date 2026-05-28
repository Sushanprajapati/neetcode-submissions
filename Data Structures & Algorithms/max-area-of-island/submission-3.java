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
                    // We are updating the max value for each occurance of 1 in each loop
                    result = Math.max(result, dfs(i, j, grid));
                }
            }
        }

        return result;
    }

    // helper method for running dfs
    // It will repeatedly run until we can find 1 in any of 4 directions
    public int dfs(int i, int j, int[][] grid) {
        // base condition
        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length ||
            grid[i][j] == 0) {
                return 0;
            }

        // Mark the cell as visited
        grid[i][j] = 0;

        // We do +1 because it is the cell where we are currently standing. 
        // Dont forget to add that
        // Other 4 dfs calls are the possible 4 directions
        // For each new cell, we are exploring their own 4 possible directions and return 0 above (in base condition)
        // once we reach 0 in that particular neighbouring cell.
        // So, basically, we'll keep on adding the occurance of 1 for each cell and finally return
        return 1 + dfs(i+1, j, grid) 
                + dfs(i-1, j, grid)
                + dfs(i, j-1, grid)
                + dfs(i, j+1, grid);
    }
}
