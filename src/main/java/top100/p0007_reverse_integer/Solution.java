package top100.p0007_reverse_integer;

/**
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * <p>
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int reverse = solution.reverse1(-123);
        System.out.println(reverse);
    }

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
