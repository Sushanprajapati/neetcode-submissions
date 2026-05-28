class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       List<Integer>[] bucket = new List[nums.length + 1];
       Map<Integer, Integer> freqMap = new HashMap<>();

       for (int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
       }

       for (Integer key: freqMap.keySet()) {
            if (bucket[freqMap.get(key)] == null) {
                bucket[freqMap.get(key)] = new ArrayList<>();  
            }
            bucket[freqMap.get(key)].add(key);
       }

       int[] res = new int[k];
       int counter = 0; 
       for (int i = bucket.length - 1; i >= 0 && counter < k; i--) {
            if (bucket[i] != null) {
                for (Integer in: bucket[i]) {
                    res[counter++] = in;
                }
            }
       }

       return res;
    }
}
