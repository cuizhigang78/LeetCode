package no5_longest_noalindromic_substring;

/**
 * 5. 最长回文子串 （medium）
 * <p>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 * <p>
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 *  
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 */
public class Solution {

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome1(s));
    }

    /**
     * 暴力解法
     * <p>
     * 时间复杂度：O(n³）
     * 空间复杂度：O(1)
     * <p>
     * 执行用时：1258 ms, 在所有 Java 提交中击败了5.02%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了77.22%的用户
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int begin = 0;
        int maxLen = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (isPalindrome(chars, i, j) && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 判断是否回文
     *
     * @param chars
     * @return
     */
    private static boolean isPalindrome(char[] chars, int i, int j) {
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 动态规划
     * <p>
     * 判断一个字符串是否回文 = 头尾字符相同 并且 去掉头尾之后的子串是回文
     * <p>
     * 执行用时：179 ms, 在所有 Java 提交中击败了51.21%的用户
     * 内存消耗：43.2 MB, 在所有 Java 提交中击败了24.11%的用户
     *
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {
        int begin = 0;
        int maxLen = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[][] memory = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (chars[i] != chars[j]) {
                    memory[j][i] = false;
                } else {
                    if (i - j < 3) {
                        memory[j][i] = chars[i] == chars[j];
                    } else {
                        memory[j][i] = memory[j + 1][i - 1];
                    }
                }
                if (memory[j][i] && i - j + 1 > maxLen) {
                    begin = j;
                    maxLen = i - j + 1;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
