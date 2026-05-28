class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    // Apply Binary Search for row and then column.
    int potentialRowIndex = findPotentialRowIndex(matrix, target);
    if (potentialRowIndex != -1) return findTarget(potentialRowIndex, matrix, target);
    return false;
    }

    public int findPotentialRowIndex(int[][] matrix, int target) {
        int low = 0, high = matrix.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length - 1]) {
                return mid;
            } else if (matrix[mid][0] < target) {
                low = mid + 1;
            } else if (matrix[mid][0] > target) {
                high = mid - 1; 
            }
        }
        return -1;
    }

    public boolean findTarget(int potentialRow, int[][] matrix, int target) {
        int low = 0, high = matrix[potentialRow].length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[potentialRow][mid] == target) {
                return true;
            } else if (target > matrix[potentialRow][mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
