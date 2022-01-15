package no9_noalindrome_number;

/**
 * 9. 回文数 （easy）
 * <p>
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 *  
 * <p>
 * 示例 1：
 * 输入：x = 12121
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例 3：
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 示例 4：
 * 输入：x = -101
 * 输出：false
 *  
 * 提示：
 * -231 <= x <= 231 - 1
 */
public class Solution {

    public static void main(String[] args) {
        int x = 102;
        System.out.println(isPalindrome3(x));
    }

    /**
     * 使用StringBuilder.reverse()方法
     * <p>
     * 也可以考虑，只要反转字符串的前一半，如果反转后与后一半相同，即表示整个字符串是回文。
     * 但实验证明，性能并没有提升，反正有所下降。
     * <p>
     * 执行用时：11 ms, 在所有 Java 提交中击败了51.39%的用户
     * 内存消耗：38.2 MB, 在所有 Java 提交中击败了16.94%的用户
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        if (x % 10 == 0) return false;
        String s = String.valueOf(x);
        return new StringBuilder(s).reverse().toString().equals(s);
    }

    /**
     * 整数反转后再比较（只对整数有效）
     * <p>
     * 优化思路：可以只反转一半的数字
     * <p>
     * 执行用时：9 ms, 在所有 Java 提交中击败了99.19%的用户
     * 内存消耗：37.5 MB, 在所有 Java 提交中击败了97.61%的用户
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        if (x % 10 == 0) return false;

        int num = 0;
        int temp = x;
        while (temp > 0) {
            num *= 10;
            num += temp % 10;
            temp /= 10;
        }
        return num == x;
        /**
         * int revertedNumber = 0;
         * while (x > revertedNumber) {
         *     revertedNumber = revertedNumber * 10 + x % 10;
         *     x /= 10;
         * }
         *
         * // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
         * // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
         * // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
         * return x == revertedNumber || x == revertedNumber / 10;
         */
    }

    /**
     * 转换为字符串后，逐一比较
     * <p>
     * 执行用时：11 ms, 在所有 Java 提交中击败了51.39%的用户
     * 内存消耗：37.7 MB, 在所有 Java 提交中击败了82.27%的用户
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome3(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        if (x % 10 == 0) return false;

        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i <= j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
