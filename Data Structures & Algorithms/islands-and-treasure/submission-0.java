// create a helper class to model out a data to save in queue. Something like: (row, col, distance)
class Node {
    int row, col, distance;

    Node(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

class Solution {

    // helper method to check if a cell is valid or not
    // cell is valid if the cell is within range in all four direction.
    private boolean isValid(int row, int col, int rowLength, int colLength) {
        return (row >= 0 && row < rowLength && col >= 0 && col < colLength);
    }

    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        // Declaring a queue to store each cell value
        // It will make sure, we are using BFS
        Queue<Node> que = new LinkedList<>();
        int[][] directions = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};

        // Loop through each cell and add the initial data to the queue.
        // Initial data is nothing but the cell which has treasure chest (i.e. 0)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    que.add(new Node(i, j, 0));
                }
            }
        }

        // Now, our queue is ready to traversing
        // We'll traverse till queue is empty: i.e. we'll look into all possible direction for each cell
        while (!que.isEmpty()) {
            // Get the first node in queue
            Node queueNode = que.poll();

            // Looping through directions
            // Go through each possible directions and check
            for (int[] direction: directions) {
                // Initialize the new row & col
                // We get that by adding the base directions that we defined above
                int newRow = queueNode.row + direction[0];
                int newCol = queueNode.col + direction[1];

                // Check if the cell is valid
                // Check if the value in the cell is the INF / Integer value (not -1 or 0)
                if (isValid(newRow, newCol, rows, cols) && grid[newRow][newCol] == Integer.MAX_VALUE) {
                    // Increment the distance
                    int distance = queueNode.distance + 1;

                    // Update the cell with the calculated distance
                    grid[newRow][newCol] = distance;
                    
                    // Add the cell data to the queue. we'll process it later again.
                    que.add(new Node(newRow, newCol, distance));
                }
            }
        }        
    }
}
