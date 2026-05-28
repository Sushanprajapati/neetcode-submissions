class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (Integer val: freqMap.keySet()) {
            if (bucket[freqMap.get(val)] == null) {
                bucket[freqMap.get(val)] = new ArrayList<>();
            }
            bucket[freqMap.get(val)].add(val);
        }

        int counter = 0;
        int[] result = new int[k];
        for (int i = bucket.length - 1; i >= 0 && counter < k; i--) {
            if (bucket[i] != null) {
                for (int val: bucket[i]) {
                    result[counter++] = val; 
                }
            }
        }

        return result;
    }
}
