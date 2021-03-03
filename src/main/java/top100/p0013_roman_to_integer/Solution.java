package top100.p0013_roman_to_integer;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数 （easy）
 * <p>
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 * <p>
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 * <p>
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 15
 * s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
 * 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
 * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 * IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
 */
public class Solution {

    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println(romanToInt1(s));
    }

    /**
     * 暴力解法
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * 执行用时：6 ms, 在所有 Java 提交中击败了52.89%的用户
     * 内存消耗：39.3 MB, 在所有 Java 提交中击败了5.11%的用户
     *
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int retVal = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int j = i + 1;
            if (i < chars.length - 1 && (
                    (chars[i] == 'I' && (chars[j] == 'V' || chars[j] == 'X')) ||
                            (chars[i] == 'X' && (chars[j] == 'L' || chars[j] == 'C')) ||
                            (chars[i] == 'C' && (chars[j] == 'D' || chars[j] == 'M'))
            )) {
                retVal += map.get(chars[j]) - map.get(chars[i]);
                i++;
            } else {
                retVal += map.get(chars[i]);
            }

        }
        return retVal;
    }

    /**
     * 双指针，正常情况下，对于任意字符s.charAt(i),都有f(s.charAt(i)) > f(s.charAt(i + 1))，除非是出现题目中的6种情况。
     * 借此规律找出这种非正常情况即可。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * 执行用时：4 ms, 在所有 Java 提交中击败了99.99%的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了36.13%的用户
     *
     * @param s
     * @return
     */
    public static int romanToInt1(String s) {
        int retVal = 0;
        char[] chars = s.toCharArray();
        int prev = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            int curr;
            switch (chars[i]) {
                case 'I': curr = 1;
                    break;
                case 'V': curr = 5;
                    break;
                case 'X': curr = 10;
                    break;
                case 'L': curr = 50;
                    break;
                case 'C': curr = 100;
                    break;
                case 'D': curr = 500;
                    break;
                case 'M': curr = 1000;
                    break;
                default: curr = 0;
            }
            if (curr >= prev) {
                retVal += curr;
            } else {
                retVal -= curr;
            }
            prev = curr;
        }
        return retVal;
    }
}
