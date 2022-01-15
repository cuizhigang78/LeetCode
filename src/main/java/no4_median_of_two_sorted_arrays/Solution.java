package no4_median_of_two_sorted_arrays;

import java.util.Arrays;

/**
 * 4. 寻找两个正序数组的中位数 （hard）
 * <p>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * <p>
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * <p>
 * 示例 3：
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * <p>
 * 示例 4：
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * <p>
 * 示例 5：
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 * <p>
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {1};
        System.out.println(findMedianSortedArrays1(nums1, nums2));
    }

    /**
     * 合并数组
     *
     * 时间复杂度：O(m + n)
     * 空间复杂度：O(m + n)
     *
     * 执行用时：2 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.8 MB, 在所有 Java 提交中击败了35.47%的用户
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] newNums = new int[len];
        int mid = len / 2;
        // num1的指针
        int m = 0;
        // num2的指针
        int n = 0;
        // newNums的指针
        int i = 0;
        while (i < newNums.length) {
            if (m == nums1.length) {
                newNums[i] = nums2[n];
                n++;
            } else if (n == nums2.length) {
                newNums[i] = nums1[m];
                m++;
            } else if (nums1[m] <= nums2[n]) {
                newNums[i] = nums1[m];
                m++;
            } else {
                newNums[i] = nums2[n];
                n++;
            }
            if (i == mid) {
                System.out.println(Arrays.toString(newNums));
                if ((len & 1) == 1) {
                    return newNums[i];
                } else {
                    return (double)(newNums[i] + newNums[i - 1]) / 2;
                }
            }
            i++;
        }
        return 0.0;
    }

    /**
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        return 0;
    }
}
