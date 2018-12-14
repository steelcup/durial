package s0101;
/*
123. Best Time to Buy and Sell Stock III
Hard

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.

Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.


 */
public class ST0123 {
    //based on the #121, we divide the prices into two parts and find the
    //max profits O(N^2)
    /*
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, maxProfit0(prices, 0, i)+maxProfit0(prices, i+1, prices.length-1));
        }
        return max;
    }

    public int maxProfit0(int[] prices, int from, int to) {
        if (to == from) {
            return 0;
        }
        int max=0, curSum=0, startIdx=from;
        for (int i = from+1; i <= to; i++) {
            curSum = prices[i]-prices[startIdx];
            if (curSum <=0) {
                startIdx=i;
                curSum=0;
            }
            max = Math.max(max, curSum);
        }
        return max;
    }
    */
    public int maxProfit(int[] prices) {
        int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        //assume you have $0 at start
        //buy: money left after you buy
        //sell: money after sell
        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.max(buy1, 0-prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
