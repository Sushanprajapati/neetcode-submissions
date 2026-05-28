class Solution {
    public int maxProfit(int[] prices) {
        int left = 0, right = 1, sell = 0;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                if (prices[right] - prices[left] > sell) {
                    sell = prices[right] - prices[left];
                }
            } else {
                left = right;
            }
            right++;
        }

        return sell;
    }
}
