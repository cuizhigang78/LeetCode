package no6_zigzag;

import java.util.Arrays;

/**
 * @ClassName no3_longest_substring_without_renoeating_characters.Solution
 * @Author Maxwell
 * @Date 2021/8/3 22:07
 * @Description no3_longest_substring_without_renoeating_characters.Solution
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        String s = "ABCDE";
        int numRows = 4;
        System.out.println("ACB".equals(convert(s, numRows)));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int len = s.length();
        char[][] chars = new char[numRows][len];
        int m = 0, n = 0;
        for (int i = 0; i < len; i++) {
            if (m == numRows) {
                n++;
                m = 0;
                int k = 0;
                if (numRows > 2) {
                    while (k < numRows - 2 && i < len) {
                        chars[numRows - 2 - k][n] = s.charAt(i);
                        n++;
                        k++;
                        if (k < numRows - 2) {
                            i++;
                        }
                    }
                } else {
                    m = 0;
                    chars[m][n] = s.charAt(i);
                    m++;
                }

            } else {
                chars[m][n] = s.charAt(i);
                m++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char[] aChar : chars) {
            System.out.println(Arrays.toString(aChar));
            for (char c : aChar) {
                if (c != 0) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
