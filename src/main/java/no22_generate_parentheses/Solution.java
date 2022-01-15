package no22_generate_parentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static void main(String[] args) {
        int n = 2;
        List<String> res = generateParenthesis(n);
        System.out.println(res);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtracking(n, res, new StringBuilder("("), 1, 0);
        return res;
    }

    private static void backtracking(int n, List<String> res, StringBuilder path, int open, int close) {
        if (path.length() == n * 2) {
            res.add(path.toString());
            return;
        }
        if (open < n) {
            path.append("(");
            backtracking(n, res, path, open + 1, close);
            path.deleteCharAt(path.length() - 1);
        }
        if (close < open) {
            path.append(")");
            backtracking(n, res, path, open, close + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }


}
