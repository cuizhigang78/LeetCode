package top100.p0300_longest_increasing_subsequence;

/**
 * 300. 最长递增子序列 （medium）
 * <p>
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * <p>
 * 示例 3：
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * <p>
 * 提示：
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 * <p>
 * 进阶：
 * 你可以设计时间复杂度为 O(n2) 的解决方案吗？
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(nums));
    }

    /**
     * 动态规划解法
     *
     * 对于任意元素nums[i]，在要求nums[i]必选的情况下，
     *
     * opt(i) = opt(prev(i)) + 1
     *
     * prev(i): 在i之前，比nums[i]小的元素下标
     *
     * 时间复杂度：O(n²)
     * 空间复杂度：O(n)
     *
     * 执行用时：67 ms, 在所有 Java 提交中击败了73.63%的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了46.58%的用户
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int[] opt = new int[nums.length];
        opt[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            int len = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    len = Math.max(len, opt[j] + 1);
                }
            }
            opt[i] = len;
            maxLen = Math.max(len, maxLen);
        }
        return maxLen;
    }
}
