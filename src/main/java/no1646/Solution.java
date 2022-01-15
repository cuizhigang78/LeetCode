package no1646;

public class Solution {

    public static void main(String[] args) {
        int n = 7;
        int res = getMaximumGenerated(n);
        System.out.println(res);
    }

    public static int getMaximumGenerated(int n) {
        if (n == 0 || n == 1) return n;
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 0; i < nums.length; i++) {
            if (2 <= 2 * i && 2 * i <= n) {
                nums[2 * i] = nums[i];
            }
            if (2 <= 2 * i + 1 && 2 * i + 1 <= n) {
                nums[2 * i + 1] = nums[i] + nums[i + 1];
            }
        }
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
