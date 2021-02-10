package top100.p0015_3sum;


import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 15. 三数之和 (normal)
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
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * - 关键字：不可以包含重复
 * - 模式识别：利用排序避免重复答案
 * - 降低复杂度变成twoSum
 * - 利用双指针找到所有解
 */
public class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();

        //int[] nums = {-1, 0, 1, 2, -1, -4};
        //int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        int[] nums = {0, 0, 0};

        List<List<Integer>> lists = solution.threeSum(nums);

        System.out.println(lists);
    }

    /**
     *
     * 对于数组内的任意一个数e，都有数组内其他元素之和target等于-e，
     * 那么这个数e就是符合题目要求的，这样就把三数之和，简化为了两数之和。
     *
     * 这题的难点在于，如何去重？分为以下几步：
     *
     * 1. 数组排序，目的在于一是让相同的数相邻，二是便于寻找target；
     * 2. 遍历原数组，如果相邻的数是相同的，跳到下一个数；
     * 3. 外层循环确定数e后，通过twoSum寻找两数之后为-e的即满足条件，将这三个数加到返回值列表中；
     * 4. 符合条件的解可能不止一组，左指针前进，右指针后退，继续求和，注意，因为去重的原因，此时还需要判断左右指针的值以避免重复
     *
     * 时间复杂度：
     *
     * 排序 O(n㏒n)
     * 搜索解 O(n²)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rtList = new ArrayList<>();
        if (nums.length == 0) return rtList;

        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        // -4, -1, -1, 0, 1, 2
        // -5, -5, -4, -4, -4, -2, -2, -2, 0, 0, 0, 1, 1, 3, 4, 4
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -(nums[i]);
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    rtList.add(Arrays.asList(-target, nums[left], nums[right]));
                    left++;
                    right--;
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
