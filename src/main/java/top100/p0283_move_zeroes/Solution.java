package top100.p0283_move_zeroes;

import java.util.Arrays;

/**
 * 283. 移动零（easy）
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class Solution {

    public static void main(String[] args) {
        //int[] nums = {0, 1, 0, 3, 12};
        int[] nums = {0, 1, 1, 0, 0, 3, 3, 4, 12};
        moveZeroes1(nums);
    }

    /**
     * 类似冒泡排序
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == 0) continue;
                if (nums[i] == 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 定义快慢指针i，j，i指针遍历数组nums：
     * <p>
     * 1. 如果num[i]是0，继续遍历；
     * 2. 如果num[i]非0，将nums[j]置为num[i]，j前进一步；
     * 3. 遍历完成后，将j及以后的元素全部置为0
     *
     * @param nums
     */
    public static void moveZeroes1(int[] nums) {
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
            i++;
        }
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
        System.out.println(Arrays.toString(nums));
    }
}
