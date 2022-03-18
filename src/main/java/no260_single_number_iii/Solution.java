package no260_single_number_iii;

import java.util.Arrays;

/**
 * 260. 只出现一次的数字 III (medium)
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * 
 * 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * 
 * 示例 1：
 * 
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 * 示例 2：
 * 
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 * 示例 3：
 * 
 * 输入：nums = [0,1]
 * 输出：[1,0]
 * 提示：
 * 
 * 2 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * 除两个只出现一次的整数外，nums 中的其他数字都出现两次
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] res = singleNumber(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] singleNumber(int[] nums) {
        if (nums == null || nums.length < 3) return nums;
        // 设两个只出现一次的数分为 a、b，运行完成后 xor = a ^ b
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        // 右起第一位 1，说明a 的 firstOne 位与 b 的 firstOne 位不相等
        int firstOne = xor & (~xor + 1); // 0000 0010
        int xor1 = 0;
        for (int num : nums) {
            // 通过 firstOne 位是否为 0，将 nums 一分为二，运行完成后 xor1 = a 或者 b
            if ((num & firstOne) == 0) {
                xor1 ^= num;
            }
        }
        return new int[]{xor1, xor1 ^ xor};
    }
}





























