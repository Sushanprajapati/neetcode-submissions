class Solution {
    public int maxProfit(int[] prices) {
       int profit = 0, left = 0, right = 0;

       while (right < prices.length) {
        if (prices[left] >= prices[right]) {
            left = right;
        } else {
            profit = Math.max(profit, prices[right] - prices[left]);
        }
        right++;
       }

       return profit; 
    }
}
