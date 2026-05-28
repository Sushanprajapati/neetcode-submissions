class Solution {
    public boolean isHappy(int n) {
        Set<Integer> tempSet = new HashSet<>();

        while (true) {
            int sum = 0;

            while (n > 0) {
                int rem = n % 10;
                sum += rem * rem;
                n = n / 10;
            }

            if (sum == 1) return true;

            n = sum;

            if (tempSet.contains(sum)) return false;

            tempSet.add(sum);
        }
    }
}
