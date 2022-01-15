package no20_valid_noarentheses;

import java.util.Stack;

/**
 * 20. 有效的括号 (easy)
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(isValid("(){}}{"));
    }

    /**
     * 栈
     *
     * 遍历字符串，对于每个字符c，如果是“([{”，就存入栈中，如果是“)]}”就从栈中取出一个e，如果此时c和e不相匹配，说明该字符串无效；
     * 直到字符串遍历完成，如果栈非空，说明该字符串无效。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * 执行用时：2ms,在所有Java提交中击败了74.57%的用户
     * 内存消耗：36.4MB,在所有Java提交中击败了87.98%的用户
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {

        if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}') return false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c== '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop == '(' && c == ')') {
                    continue;
                }
                if (pop == '{' && c == '}') {
                    continue;
                }
                if (pop == '[' && c == ']') {
                    continue;
                }
                return false;
            }
        }
        return stack.empty();
    }
}