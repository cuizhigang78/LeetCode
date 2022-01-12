package top100.p00050_powx_n;

/**
 * 50. Pow(x, n) （medium）
 *
 * https://juejin.cn/post/7052345514708172836
 *
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 * <p>
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * <p>
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * <p>
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * <p>
 * 提示：
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 */
public class Solution {

    public static void main(String[] args) {
        double x = 0.00001;
        int n = 2147483647;
        double res = myPow(x, n);
        System.out.println(res);
    }

    public static double myPow(double x, int n) {
        long m = n;
        return m >= 0 ? quickMul(x, m) : 1.0 / quickMul(x, -m);
    }

    public static double quickMul(double x, long n) {
        if (n == 0) return 1.0;
        double half = quickMul(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }
}
