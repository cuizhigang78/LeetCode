package jianzhi2.p001;

/**
 * @ClassName Solution
 * @Author Maxwell
 * @Date 2022/1/11 23:29
 * @Description Solution
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        int a = 15;
        int b = -2;
        int res = divide(a, b);
        System.out.println(res);
    }

    public static int divide(int a, int b) {
        // 判断是否相同符号
        boolean f = sameSign(a, b);
        int res = 0;
        if (f) {
            if (a > 0) {
                while (a >= b) {
                    a -= b;
                    res++;
                }
            } else {
                while (a <= b) {
                    a -= b;
                    res++;
                }
            }
        } else {
            if (a > 0) {
                while (a <= b) {
                    a += b;
                    res++;
                }
            } else {
                while (a >= b) {
                    a += b;
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * true 相同符号 false 不同符号
     *
     * @param a
     * @param b
     * @return
     */
    private static boolean sameSign(int a, int b) {
        return (a ^ b) >> 31 == 0;
    }
}
