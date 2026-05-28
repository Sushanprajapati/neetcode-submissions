class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] tempList = new List[nums.length + 1];

        Map<Integer, Integer> tempMap = new HashMap<>();

        for (int num: nums) {
            tempMap.put(num, tempMap.getOrDefault(num, 0)+1);
        }

        for (Integer i: tempMap.keySet()) {
            if (tempList[tempMap.get(i)] == null) {
                tempList[tempMap.get(i)] = new ArrayList<>();
            }
            tempList[tempMap.get(i)].add(i);
        }

        int[] finalList = new int[k];
        int counter = 0;
        for (int i = tempList.length - 1; i >= 0 && counter < k; i--) {
            if (tempList[i] != null) {
                for (int j: tempList[i]) {
                    finalList[counter++] = j;
                }
            }
        }

        return finalList;
    }
}
