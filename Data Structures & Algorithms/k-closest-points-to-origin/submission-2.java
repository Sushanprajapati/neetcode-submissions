class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        for (int[] point: points) {
            int dist = (point[0] * point[0] ) + (point[1] * point[1]);
            pq.offer(new int[]{dist, point[0], point[1]});
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] temp = pq.poll();

            result[i] = new int[]{temp[1], temp[2]};
        }

        return result;
    }
}
