package top100.p0003_longest_substring_without_repeating_characters;

import java.util.*;

/**
 * 3. 无重复字符的最长子串 （medium）
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 *  
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */

/**
 * 模式识别：
 *
 * 1. 一旦涉及出现次数，需要用到散列表（构造子串，散列表存下标）
 * 2. 涉及子串，考虑滑动窗口
 */
public class Solution {
    /**
     * 左右两个指针确定一个滑动窗口，hashMap储存已经出现的字符其及下标，
     * 正常情况下，向右逐一推进右指针，当有字符重复出现时，向右推进右指针。
     *
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 79.90% 的用户
     * 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 78.03% 的用户
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || "".equals(s)) return 0;
        int j = 0;
        int maxLength = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 当左指针小于或等于该重复元素的上一次出现的下标时，
                // 将左指针右移
                /*if (j < map.get(s.charAt(i)) + 1) {
                    j = map.get(s.charAt(i)) + 1;
                }*/
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - j + 1);
        }
        return maxLength;
    }

    /**
     * 截取字符串，通过HashSet来判断是否有重复字符
     *
     * 执行结果：通过
     * 显示详情
     * 执行用时：9 ms, 在所有 Java 提交中击败了42.09%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了65.03%的用户
     */
    public int lengthOfLongestSubstring1(String s) {
        if (s == null || "".equals(s)) return 0;
        int right = 1;
        int left = 0;
        int maxLength = 0;
        String substring = "";
        while (left <= right && right <= s.length()) {
            substring = s.substring(left, right);
            int length = substring.length();
            if (length == new HashSet<>(Arrays.asList(substring.split(""))).size()) {
                // 如果没有重复字符串，则继续向右扩大窗口
                right++;
                maxLength = maxLength > length ? maxLength : length;
            } else {
                // 如果有重复字符串，则窗口右移
                int index = substring.indexOf(substring.substring(substring.length() - 1));
                left += index + 1;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "abba";

        System.out.println(solution.lengthOfLongestSubstring2(s));
    }
}
