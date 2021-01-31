package top100.p0001_two_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 这题这正常的思路是双层for循环遍历两次nums（如twoSum1），枚举出所有可能的和看是否有符合条件的，此时
 *      时间复杂度 O(n²) ：遍历2次
 *      空间复杂度 O(1) ：只有i，j两个变量
 * 优化的思路是以空间换时间，使用hash来存储已遍历过的值，因为hash的时间复杂度是O(1)，所以会优化整体的时间复杂度，此时
 *      时间复杂度 O(n) ：遍历1次
 *      空间复杂度 O(n) ：hash的空间复杂度
 *
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length - 1);
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);

        }
        throw new RuntimeException("no such sum");
    }

    /**
     * 暴力解法：双层for循环
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        // 因为第一个数不会是nums中的最后一位，所以只需要遍历到倒数第二位即可
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        throw new RuntimeException("no such sum");
    }
}
