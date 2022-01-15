package top100.p0014_longest_common_prefix;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 14. 最长公共前缀 （easy）
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * <p>
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * 提示：
 * <p>
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class Solution {

    public static void main(String[] args) {
        //String[] strs = {"flower", "flow", "flight"};
        //String[] strs = {"flower","flower","flower","flower"};
        String[] strs = {"cir","car"};
        System.out.println(longestCommonPrefix2(strs));
    }

    /**
     * brute force 暴力解法
     * <p>
     * 时间复杂度：O(m*n)，m、n分别代表数组长度和字符串长度
     * 空间复杂度：O(1)
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.6 MB, 在所有 Java 提交中击败了39.79%的用户
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length <= 1) return strs[0];

        String prefix = strs[0];
        int index = 1;
        while (index < strs.length) {
            if (strs[index].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            } else {
                index++;
            }
        }
        return prefix;
    }

    /**
     * 排序法
     *
     * 时间复杂度：O(m*n*㏒n)，m、n分别代表字符串长度和数组长度
     * 空间复杂度：O(1)
     *
     * 执行用时：1 ms, 在所有 Java 提交中击败了83.77%的用户
     * 内存消耗：36.6 MB, 在所有 Java 提交中击败了45.46%的用户
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length <= 1) return strs[0];

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];

        while (first.indexOf(last) != 0) {
            last = last.substring(0, last.length() - 1);
        }
        return last;
    }
}

































