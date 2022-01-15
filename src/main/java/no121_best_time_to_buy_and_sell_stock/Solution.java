package no121_best_time_to_buy_and_sell_stock;

/**
 * 121. 买卖股票的最佳时机 （easy）
 * <p>
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
 * 设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * 示例 1：
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * <p>
 * 示例 2：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
public class Solution {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit2(prices));
    }

    /**
     * 暴力解法，双层循环
     * <p>
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     * <p>
     * 执行结果：超出时间限制
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
                }
            }
        }
        return maxProfit;
    }

    /**
     * 动态规划法
     *
     * 定义dp[i]表示从第i位开始，数组的最大值，则有
     *
     * dp[i] = maxProfit(prices[i], dp[i + 1])
     *
     * 此时，prices[i] - dp[i + 1] 的差的最大值，即是题的解
     *
     * 时间复杂度：O(n)
     * 空间复杂订：O(n)
     *
     * 执行用时：4 ms, 在所有 Java 提交中击败了27.88%的用户
     * 内存消耗：54.5 MB, 在所有 Java 提交中击败了5.01%的用户
     *
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        int maxProfit = 0;
        int[] dp = new int[prices.length];
        dp[prices.length - 1] = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], prices[i]);
            maxProfit = Math.max(maxProfit, dp[i + 1] - prices[i]);
        }
        return maxProfit;
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * 执行用时：2 ms, 在所有 Java 提交中击败了77.56%的用户
     * 内存消耗：51.4 MB, 在所有 Java 提交中击败了24.41%的用户
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
        }
        return maxProfit;
    }
}
