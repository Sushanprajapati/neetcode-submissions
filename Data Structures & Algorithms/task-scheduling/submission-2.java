class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskArr = new int[26];

        for (char task: tasks) {
            taskArr[task - 'A']++;
        }

        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int val: taskArr) {
            if (val > 0) pq.offer(val);
        }

        while (!pq.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();

            for (int i = 0; i < n+1; i++) {
                if (!pq.isEmpty()) {
                    int temp = pq.poll();
                    temp--;
                    tempList.add(temp);
                }
            }

            for (int val: tempList) {
                if (val > 0) pq.offer(val);

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
