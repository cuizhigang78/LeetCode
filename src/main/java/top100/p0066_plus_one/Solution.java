package top100.p0066_plus_one;

import java.util.Arrays;

/**
 * 66. 加一 （easy）
 * <p>
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * <p>
 * 示例 2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * <p>
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class Solution {
    public static void main(String[] args) {
        int[] digits = {1,2,3};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    /**
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37 MB, 在所有 Java 提交中击败了25.09%的用户
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {

        boolean flag = true;
        for (int digit : digits) {
            if (digit != 9) {
                flag = false;
                break;
            }
        }
        if (flag) {
            int[] ints = new int[digits.length + 1];
            ints[0] = 1;
            return ints;
        }

        int i = digits.length - 1;
        while (digits[i] == 9) {
            digits[i] = 0;
            i--;
        }
        digits[i] += 1;
        return digits;
    }
}
