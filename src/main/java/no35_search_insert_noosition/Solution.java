package no35_search_insert_noosition;

/**
 * 35. 搜索插入位置 （easy）
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        int index = searchInsert(nums, target);
        System.out.println(index);
    }

    /**
     * 二分查找法
     *
     * 时间复杂度：O(㏒n)
     * 空间复杂度：O(1)
     *
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 38.1 MB , 在所有 Java 提交中击败了 73.11% 的用户
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                if (mid > 0 && nums[mid - 1] < target) {
                    return mid;
                }
                r = mid - 1;
            } else {
                if (mid < nums.length - 1 && nums[mid + 1] > target) {
                    return mid + 1;
                }
                l = mid + 1;
            }
        }
        return l;
    }
}
