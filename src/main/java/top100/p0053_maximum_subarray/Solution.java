package top100.p0053_maximum_subarray;

/**
 * 53. 最大子序和 （easy）
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 * <p>
 * 输入：nums = [-100000]
 * 输出：-100000
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 *  
 * <p>
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //int[] nums = {-2, 1};
        System.out.println(maxSubArray(nums));
    }

    /**
     * 贪心算法
     * <p>
     * 遍历数组，对于每个元素，如果他之前的元素和小于等于0，就丢弃他们，这个元素开始计数
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * <p>
     * // -2, 1, -3, 4, -1, 2, 1, -5, 4
     * <p>
     * // i=0; sum=-2; max=-2
     * <p>
     * // i=1; sum=1; max=1
     * // i=2; sum=-3; max=1
     * // i=3; sum=4; max=4
     * // i=4; sum=3; max=4
     * // i=5; sum=5; max=5
     * // i=6; sum=6; max=6
     * // i=7; sum=1; max=6
     * // i=8; sum=5; max=6
     * <p>
     * 执行结果： 通过
     * 显示详情
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 93.56% 的用户
     * 内存消耗： 38.6 MB , 在所有 Java 提交中击败了 16.39% 的用户
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum <= 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    /**
     * 动态规划
     * <p>
     * 遍历数组，对于每个元素m，若他前面的元素n大于0，则将m = m + n
     * <p>
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * // -2, 1, -3, 4, -1, 2, 1, -5, 4
     * <p>
     * // i=0; -2, 1, -3, 4, -1, 2, 1, -5, 4
     * <p>
     * // i=1; -2, 1, -3, 4, -1, 2, 1, -5, 4
     * // i=2; -2, 1, -2, 4, -1, 2, 1, -5, 4
     * // i=3; -2, 1, -2, 4, -1, 2, 1, -5, 4
     * // i=4; -2, 1, -2, 4, 3, 2, 1, -5, 4
     * // i=5; -2, 1, -2, 4, 3, 5, 1, -5, 4
     * // i=6; -2, 1, -2, 4, 3, 5, 6, -5, 4
     * // i=7; -2, 1, -2, 4, 3, 5, 6, 1, 4
     * // i=8; -2, 1, -2, 4, 3, 5, 6, -5, 5
     *
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 93.56%
     * 的用户
     * 内存消耗：
     * 38.6 MB
     * , 在所有 Java 提交中击败了
     * 19.13%
     * 的用户
     *
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}































