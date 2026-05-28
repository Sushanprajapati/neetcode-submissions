class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public final int k;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;

        for (Integer num: nums) {
            add(num);
        }

    }
    
    public int add(int val) {
        pq.offer(val);

        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
