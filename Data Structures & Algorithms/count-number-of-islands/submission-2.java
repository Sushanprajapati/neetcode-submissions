class Solution {
    // Kind of similar to Word Search problem in BackTracking algorith 
    // Just a difference is that, we dont have to backtrack here, because we are not looking to match anything
    public int numIslands(char[][] grid) {
        // Edge cases/ Sanity check
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        // Initialize a variable to store the island count
        int count = 0;

        // Run the loop
        // Loop through each element in the grid
        // Continue to move forward only if we encounter "1".
        // We're basically performing DFS
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                // Perform the dfs once we encounter 1
                if (grid[i][j] == '1') {
                    // The method is self called below while checking for all directions.
                    performDfs(i, j, grid);

                    // The above method breaks once all directions are checked and island is found
                    count++;
                }
            }
        }

        return count;
    }

    // Helper method for performing dfs
    public void performDfs(int i, int j, char[][] grid) {
        // Check the base conditions
        // Return back if the i and j are out of bounds
        // Return back if the node/element is already visited (we mark as "0" once visited)
        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length ||
            grid[i][j] == '0') {
                return;
            }

        // Mark the visited element
        grid[i][j] = '0';

        // Explore all the directions
        performDfs(i + 1, j, grid);  // Down
        performDfs(i - 1, j, grid);  // Up
        performDfs(i, j + 1, grid);  // Right
        performDfs(i, j - 1, grid);  // Left

        // Here, we dont perform backtrack because, we are already marking the visited element as "0".
        // Because of that, when we go back to the loop, the next element will automatically be "0" and be skipped
    }
}
