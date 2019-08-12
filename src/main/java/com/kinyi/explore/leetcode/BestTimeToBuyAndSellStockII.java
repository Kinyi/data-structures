package com.kinyi.explore.leetcode;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * @author Kinyi_Chan
 * @since 2019-08-08
 */
public class BestTimeToBuyAndSellStockII {

    public static int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int rst = 0;
        int i = 0;
        for (int j = 0; j < prices.length - 1; j++) {
            if (j == prices.length - 2 && prices[j] <= prices[j + 1]) {
                rst += prices[j + 1] - prices[i];
                break;
            }
            if (prices[j] > prices[j + 1]) {
                rst += prices[j] - prices[i];
                i = j + 1;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 9, 6, 9, 1, 7, 1, 1, 5, 9, 9, 9}));
    }
}
