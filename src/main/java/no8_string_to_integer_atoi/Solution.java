package no8_string_to_integer_atoi;

public class Solution {

    public static void main(String[] args) {
        String s = "words and 987";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        long res = 0;
        int neg = 1;
        boolean start = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ' || c == '-' || c == '+' || (c >= '0' && c <= '9')) {
                // 开始读取
                if (c == ' ') {
                    if (start) {
                        break;
                    } else {
                        continue;
                    }
                }
                if (c == '-') {
                    if (start) {
                        break;
                    } else {
                        neg = -1;
                        start = true;
                    }
                } else if (c == '+') {
                    if (start) {
                        break;
                    } else {
                        neg = 1;
                        start = true;
                    }
                } else {
                    res = res * 10 + (c - 48);
                    if (res > Integer.MAX_VALUE) {
                        if (neg == 1) {
                            return Integer.MAX_VALUE;
                        } else {
                            return Integer.MIN_VALUE;
                        }
                    }
                    start = true;
                }
            } else {
                break;
            }
        }
        res *= neg;
        return (int) res;
    }
}
