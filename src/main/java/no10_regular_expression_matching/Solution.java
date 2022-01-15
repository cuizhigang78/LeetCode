package no10_regular_expression_matching;

public class Solution {

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b*";
        System.out.println(isMatchByIndex(s, p, 0, 0));
    }

    public static boolean isMatch(String s, String p) {
        int j = 0;
        int[][] dp = new int[p.length()][2];
        if (isMatchByIndex(s, p, 0, 0)) {
            dp[0] = new int[]{0, 0};
        }
        for (int i = 1; i < dp.length; i++) {

        }

        return false;
    }

    public static boolean isMatchByIndex(String s, String p, int i, int j) {
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') return true;
        if (p.charAt(j) == '*') return isMatchByIndex(s, p, i, j - 1);
        return false;
    }
}
