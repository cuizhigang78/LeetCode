package top100.undo.p0322_coin_change;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：coins = [1], amount = 2
 * 输出：2
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class Solution {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        // 排序
        Arrays.sort(coins);
        // 找到coins里比amount小的最大元素
        return coinChange(coins, amount, 0);
    }

    public static int coinChange(int[] coins, int amount, int count) {
        if (amount == 0) {
            return 0;
        }
        // 找到coins里比amount小的最大元素
        int coin = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i] <= amount) {
                coin = coins[i];
            }
        }
        count += amount / coin;
        amount = amount % coin;
        if (amount == 0) {
            return count;
        } else {
            return coinChange(coins, amount, count);
        }
    }
}
