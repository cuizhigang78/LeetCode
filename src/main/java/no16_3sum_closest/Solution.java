package no16_3sum_closest;

import java.util.*;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {

        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        int res = threeSumClosest(nums, target);

        System.out.println(res);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestDiff = Integer.MAX_VALUE, closestSum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int currSum = nums[i] + nums[j] + nums[k];
                if (currSum > target) {
                    k--;
                } else if (currSum < target) {
                    j++;
                } else {
                    return currSum;
                }
                int currDiff = Math.abs(currSum - target);
                if (currDiff < closestDiff) {
                    closestDiff = currDiff;
                    closestSum = currSum;
                }
            }
        }
        return closestSum;
    }


}
