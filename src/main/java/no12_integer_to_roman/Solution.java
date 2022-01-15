package com.cui.leetcode.no12;

public class Solution {
    public static void main(String[] args) {
        int num = 1000;
        System.out.println(intToRoman(num));
    }

    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int val = values[i];
            String symbol = symbols[i];
            while (num >= val) {
                num -= val;
                sb.append(symbol);
                if (num == 0) {
                    return sb.toString();
                }
            }
        }
        return sb.toString();
    }

    public static String intToRoman1(int num) {
        String s = num + "";
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int v = c - 48;
            int j = len - i;
            if (j == 4) {
                for (int k = 0; k < v; k++) {
                    sb.append('M');
                }
            } else if (j == 3) {
                if (v == 9) {
                    sb.append("CM");
                } else if (v == 4) {
                    sb.append("CD");
                } else {
                    if (v >= 5) {
                        v -= 5;
                        sb.append('D');
                    }
                    for (int k = 0; k < v; k++) {
                        sb.append('C');
                    }
                }

            } else if (j == 2) {
                if (v == 9) {
                    sb.append("XC");
                } else if (v == 4) {
                    sb.append("XL");
                } else {
                    if (v >= 5) {
                        v -= 5;
                        sb.append('L');
                    }
                    for (int k = 0; k < v; k++) {
                        sb.append('X');
                    }
                }

            } else if (j == 1) {
                if (v == 9) {
                    sb.append("IX");
                } else if (v == 4) {
                    sb.append("IV");
                } else {
                    if (v >= 5) {
                        v -= 5;
                        sb.append('V');
                    }
                    for (int k = 0; k < v; k++) {
                        sb.append('I');
                    }
                }
            }
        }
        return sb.toString();
    }
}
