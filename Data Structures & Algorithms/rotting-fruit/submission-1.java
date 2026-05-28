public class Node {
    int row, col;

    Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {

    public boolean isValid(int row, int col, int rowLength, int colLength) {
        return (row >= 0 && row < rowLength && col < colLength && col >= 0);
    }

    public int orangesRotting(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        Queue<Node> tempQueue = new LinkedList<>();
        int result = 0;
        int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1},{0,-1}};

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == 2) {
                    tempQueue.add(new Node(i, j));
                }
            }
        }

        while (!tempQueue.isEmpty()) {
            int queueSize = tempQueue.size();
            boolean spread = false;

            for (int i = 0; i < queueSize; i++) {
                Node copy = tempQueue.poll();

                for(int[] direction: directions) {
                    int newRow = copy.row + direction[0];
                    int newCol = copy.col + direction[1];

                    if (isValid(newRow, newCol, rowLength, colLength) &&
                        grid[newRow][newCol] == 1) {
                            tempQueue.add(new Node(newRow, newCol));
                            grid[newRow][newCol] = 2;
                            spread = true;
                    }
                }
            }

            if(spread) {
                result++;
            }
        }

        
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return result;
    }
}
