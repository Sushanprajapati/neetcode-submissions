public class Node {
    int row, col, distance;

    Node(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}
class Solution {
    public boolean isValid(int row, int col, int rowLength, int colLength) {
        return (row >= 0 && row < rowLength && col >= 0 && col < colLength);
    }

    public void islandsAndTreasure(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        Queue<Node> queue = new LinkedList<>();
        int[][] directions = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}}; 

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new Node(i, j, 0));
                }
            }
        }

        while (!queue.isEmpty()) {
            Node que = queue.poll();

            for (int[] direction: directions) {
                int newRow = que.row + direction[0];
                int newCol = que.col + direction[1];

                if (isValid(newRow, newCol, rowLength, colLength) &&
                    grid[newRow][newCol] == Integer.MAX_VALUE) {
                    int distance = que.distance + 1;

                    grid[newRow][newCol] = distance;

                    queue.add(new Node(newRow, newCol, distance));
                }
            }
            
        }

    }
}
