class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int val: stones) {
            pq.offer(val);
        }

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            if (first > second) pq.offer(first - second);
            if (first < second) pq.offer(second - first);
        }

        if (pq.isEmpty()) {
            return 0;
        } else {
            return pq.peek();
        }
    }
}
