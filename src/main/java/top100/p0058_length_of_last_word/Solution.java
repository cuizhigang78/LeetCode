package top100.p0058_length_of_last_word;

/**
 * 58. 最后一个单词的长度 （easy）
 *
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 * 示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 *
 * 示例 2：
 * 输入：s = " "
 * 输出：0
 *  
 *
 * 提示：
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 *
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int r = s.length() - 1;

        while (r >= 0 && s.charAt(r) == ' ') {
            r--;
        }

        int l = r;
        while (r >= 0 && s.charAt(r) != ' ') {
            r--;
        }
        return l - r;
    }
}
