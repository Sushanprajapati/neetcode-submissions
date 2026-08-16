class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];

        for (char ch: tasks) {
            arr[ch - 'A']++;
        }

        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int a: arr) {
            if (a > 0) pq.offer(a);
        }

        while (!pq.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();

            for (int i = 0; i < n + 1; i++) {
                if (!pq.isEmpty()) {
                    int val = pq.poll();
                    val--;
                    tempList.add(val);
                }
            }

            for (int i: tempList) {
                if (i > 0) pq.offer(i);
            }

            if (pq.isEmpty()) {
                time += tempList.size();
            } else {
                time += n + 1;
            }
        }
        return time;
    }
}
