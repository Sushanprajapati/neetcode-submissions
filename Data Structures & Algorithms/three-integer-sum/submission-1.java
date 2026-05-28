class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> tempSet = new HashSet<>();
        Arrays.sort(nums);

        if (nums.length < 3) return new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int currentNum = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = currentNum + nums[left] + nums[right];

                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    tempSet.add(Arrays.asList(currentNum, nums[left], nums[right]));
                    right--;
                    left++;
                }
            }
        }

        return new ArrayList<>(tempSet);
    }
}
