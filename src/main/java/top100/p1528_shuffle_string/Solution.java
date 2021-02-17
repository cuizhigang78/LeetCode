package top100.p1528_shuffle_string;

/**
 * 1528. 重新排列字符串 （easy）
 * <p>
 * 给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
 * <p>
 * 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
 * <p>
 * 返回重新排列后的字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "codeleet", indices = [4,5,6,7,0,2,1,3]
 * 输出："leetcode"
 * 解释：如图所示，"codeleet" 重新排列后变为 "leetcode" 。
 * <p>
 * 示例 2：
 * 输入：s = "abc", indices = [0,1,2]
 * 输出："abc"
 * 解释：重新排列后，每个字符都还留在原来的位置上。
 * <p>
 * 示例 3：
 * 输入：s = "aiohn", indices = [3,1,4,2,0]
 * 输出："nihao"
 * <p>
 * 示例 4：
 * 输入：s = "aaiougrt", indices = [4,0,2,6,7,3,1,5]
 * 输出："arigatou"
 * <p>
 * 示例 5：
 * 输入：s = "art", indices = [1,0,2]
 * 输出："rat"
 */
public class Solution {

    public static void main(String[] args) {
        String s = "abc";
        int[] indices = {0, 1, 2};
        restoreString(s, indices);
    }

    /**
     * 重新排列字符串
     *
     * @param s
     * @param indices
     * @return
     */
    public static String restoreString(String s, int[] indices) {
        char[] chars = s.toCharArray();
        char[] newChars = new char[s.length()];
        for (int i = 0; i < chars.length; i++) {
            newChars[indices[i]] = chars[i];
        }
        return new String(newChars);
    }
}
