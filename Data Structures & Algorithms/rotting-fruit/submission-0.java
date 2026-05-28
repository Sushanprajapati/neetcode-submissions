public class Node {
    int row,col;

    Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {

    private boolean isValid(int row, int rowLength, int col, int colLength) {
        return (row >= 0 && row < rowLength && col >= 0 && col < colLength);
    }

    public int orangesRotting(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        Queue<Node> queue = new LinkedList<>();
        int result = 0;

        int[][] directions = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Node(i,j));
                }
            }
        }

        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            boolean spread = false;

            for (int i = 0; i < currentLevelSize; i++ ){
                Node temp = queue.poll();
                
                for (int[] direction: directions) {
                    int newRow = temp.row + direction[0];
                    int newCol = temp.col + direction[1];

                    if (isValid(newRow, rowLength, newCol, colLength) &&
                        grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;

                        queue.add(new Node(newRow, newCol));

                        spread = true;
                    }
                }
            }

            if (spread) result++;
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
