package top100.p0015_3sum;


import java.util.*;

/**
 * 15. 三数之和 (medium)
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * <p>
 * - 关键字：不可以包含重复
 * - 模式识别：利用排序避免重复答案
 * - 降低复杂度变成twoSum
 * - 利用双指针找到所有解
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        //int[] nums = {0, 0, 0};
        List<List<Integer>> lists = solution.threeSum(nums);
        System.out.println(lists);
    }

    /**
     * 对于数组内的任意一个数e，都有数组内其他元素之和target等于-e，
     * 那么这个数e就是符合题目要求的，这样就把三数之和，简化为了两数之和。
     * <p>
     * 这题的难点在于，如何去重？分为以下几步：
     * <p>
     * 1. 数组排序，目的在于一是让相同的数相邻，二是便于寻找target；
     * 2. 遍历原数组，如果相邻的数是相同的，跳到下一个数；
     * 3. 外层循环确定数e后，通过twoSum寻找两数之后为-e的即满足条件，将这三个数加到返回值列表中；
     * 4. 符合条件的解可能不止一组，左指针前进，右指针后退，继续求和，注意，因为去重的原因，此时还需要判断左右指针的值以避免重复
     *
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     *
     * 执行用时：26 ms, 在所有 Java 提交中击败了49.34%的用户
     * 内存消耗：42.5 MB, 在所有 Java 提交中击败了45.97%的用户
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rtList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0) return rtList;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -(nums[i]);
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(-target);
                    cur.add(nums[left]);
                    cur.add(nums[right]);
                    rtList.add(cur);
                    left++;
                    right--;
                    // 左右指针都要跳过相同的数以产生重复结果
                    while (left < nums.length && nums[left] == nums[left - 1]) left++;
                    while (right > 0 && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return rtList;
    }
}
