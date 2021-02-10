package top100.p0018_4sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> lists = solution.fourSum(nums, target);
        System.out.println(lists);
    }

    /**
     * 参考3数之和
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length -3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int t1 = target - nums[i];
            for (int j = i + 1; j < nums.length -2; j++) {
                if (nums[j] == nums[j - 1]) continue;
                int t2 = t1  - nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == t2) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < nums.length && nums[left] == nums[left - 1]) left++;
                        while (right > 0 && nums[right] == nums[right + 1]) right--;
                    } else if (nums[left] + nums[right] > t2) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
