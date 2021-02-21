package top100.p0448_find_all_numbers_disappeared_in_an_array;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字 （easy）
 * <p>
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * <p>
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [5,6]
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        findDisappearedNumbers(nums);
    }

    /**
     * 1. 遍历数组，对于每个元素num=nums[i]，既然num已经出现过，需要标记起来，于是把nums数组的第num-1个元素加负号；
     * 2. 因为nums[i]可能为负，所以需要使用abs取得绝对值；
     * 3. 已经为负的，不再改变，防止出现重复标记；
     * 4. 遍历完成后，没有被标记的元素的下标+1即是没有出现的数字
     * 5. 为什么1，4会出现-1，+1，因为题目给的要求是1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，正经数组是从0开始的。
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        System.out.println(list);
        return list;
    }
}
/**
 * 4,3,2,7,8,2,3,1
 * <p>
 * 4,3,2,-7,8,2,3,1
 * 4,3,-2,-7,8,2,3,1
 * 4,-3,-2,-7,8,2,3,1
 * 4,-3,-2,-7,8,2,-3,1
 * 4,-3,-2,-7,8,2,-3,-1
 * -4,-3,-2,-7,8,2,-3,-1
 */
