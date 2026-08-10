class Solution {
    // Time : O(n)
    public int leastInterval(char[] tasks, int n) {
        // instead of using the HashMap, we can directly use the int[] because we know the fixed size i.e. 26 alphabets
        int[] taskArr = new int[26];

        for (char task: tasks) {
            taskArr[task - 'A']++;
        }

        int time = 0;

        // We will create a priority queue and store only the task whose value > 0. 
        // So, basically, the task with higher values will be at the front of the queue.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int task: taskArr) {
            if (task > 0) pq.offer(task);
        }

        // Now, loop till our priority queue is 
        while (!pq.isEmpty()) {

            List<Integer> tempList = new ArrayList<>();
            // Since n is the buffer time, we'll always have to put the task in batches of n+1.
            for (int i = 0; i < n+1; i++) {

                // check again if the queue is empty or not. sometimes, queue might be done even if n+1 is still ongoing.    
                if (!pq.isEmpty()) {
                    int freq = pq.poll();
                    freq--;
                    tempList.add(freq);
                }
            }

            // checking the tempList if there are still some tasks left.
            // if left, put that back to priorityqueue. it will reshuffle the tasks there and loop will continue
            for (int li: tempList) {
                if (li > 0) pq.offer(li);
            }

            if (pq.isEmpty()) {
                time += tempList.size(); 
            } else {
                time += n+1;
            }
        }
        return time;
    }
}
