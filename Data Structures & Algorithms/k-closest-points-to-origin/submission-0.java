class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // We are passing custom comparator because we need to add array in the queue and have to sort based on the distance from the origin, which is basically first element in the array
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        for(int[] point: points) {
            // calculate distance from the origin using formula (sqrt((x2 - x2)2 + (y2-y1)2))
            // siince we are using origin (0,0) as initial point, our formula will be x2 + y2
            int distance = (point[0] * point[0]) + (point[1] * point[1]);
            pq.offer(new int[]{distance, point[0], point[1]});
        }

        // 2D array for storing the result
        // k = size of outer array
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] temp = pq.poll();
            result[i] = new int[]{temp[1], temp[2]};
        }
        return result;
    }
}
