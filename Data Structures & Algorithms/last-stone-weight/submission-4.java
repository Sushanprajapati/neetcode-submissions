class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int st: stones) {
            pq.offer(st);
        }

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            if (first > second) pq.offer(first - second);
            if (second > first) pq.offer(second - first);
        }

        if (pq.size() == 0) {
                return 0;
        } else {
                return pq.peek();
        }
    }
}
