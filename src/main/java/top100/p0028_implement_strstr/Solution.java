package top100.p0028_implement_strstr;

import java.util.Arrays;

/**
 * 28. 实现 strStr() （easy）
 * <p>
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class Solution {

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(kmpSearch(haystack, needle));
    }

    /**
     * 暴力解法
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if ("".equals(needle)) return 0;
        for (int i = 0, j = 0; i < haystack.length() && j < needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            } else {
                i = i - j;
                j = 0;
            }
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    /**
     * kmp算法
     * @param haystack
     * @param needle
     * @return
     */
    public static int kmpSearch(String haystack, String needle) {
        if ("".equals(needle)) return 0;

        int[] next = new int[needle.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

        for (int i = 0, j = 0; i < haystack.length() && j < needle.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }
}