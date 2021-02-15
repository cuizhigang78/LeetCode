package top100.p0014_longest_common_prefix;

/**
 * 14. 最长公共前缀 （easy）
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
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
        System.out.println(longestCommonPrefix(strs));
    }


    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length <= 1) return strs[0];

        int index = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                String str = strs[j];
                if (i > str.length() - 1 || str.charAt(i) != strs[0].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                index++;
            } else {
                break;
            }
        }
        return strs[0].substring(0, index);
    }
}

/**
 *
 * "flower","flow","flight"
 *
 * "flower"
 *
 *
 *
 *
 *
 *
 *
 *
 */

































