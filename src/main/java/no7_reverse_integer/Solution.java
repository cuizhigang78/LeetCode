package no7_reverse_integer;

/**
 * 7. 整数反转 (easy)
 *
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 * <p>
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 *
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 *
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 *
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 *  
 * 提示：
 * -231 <= x <= 231 - 1
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int reverse = solution.reverse1(-123);
        System.out.println(reverse);
    }

    /**
     * 使用StringBuilder的reverse()方法翻转字符串，
     * try...catch的目的是防止字符串转数字时超限
     * @param x
     * @return
     */
    public int reverse2(int x) {
        int ret = 0;
        int neg = x > 0 ? 1: -1;
        x *= neg;
        StringBuilder reverse = new StringBuilder(String.valueOf(x)).reverse();
        try {
            ret = Integer.parseInt(reverse.toString());
        } catch (Exception e) {
        }
        return ret * neg;
    }

    /**
     * 反转数字，正常情况下只需要%和/两种操作即可，
     * 但是题目提及可能会出现数字超范围，故意需要特殊处理
     * @param x
     * @return
     */
    public int reverse1(int x) {
        int ret = 0;
        while (x != 0) {
            // 记录ret,方便下面比较
            int n = ret;
            ret *= 10;
            // 如果ret乘10再除10不是原来的数，说明已经溢出了
            if (ret / 10 != n) return 0;
            ret += x % 10;
            x /= 10;
        }
        return ret;
    }
}
