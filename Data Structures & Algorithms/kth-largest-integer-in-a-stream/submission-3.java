class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<Integer>();
        this.k = k;

        for (int num: nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        pq.offer(val);

        if (pq.size() > k) pq.poll();

        return pq.peek();
    }
}
