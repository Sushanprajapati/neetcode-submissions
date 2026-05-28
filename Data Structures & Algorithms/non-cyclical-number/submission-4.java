class Solution {
    public boolean isHappy(int n) {
        Set<Integer> tempSet = new HashSet<>();

        while (true) {
            int sum = 0;

            while (n > 0) {
                int rem = n % 10;
                sum += rem * rem;
                n /= 10;
            }

            n = sum;
 
            if (sum == 1) return true;

            if (tempSet.contains(sum)) return false;

            tempSet.add(sum);
        }
    }
}
