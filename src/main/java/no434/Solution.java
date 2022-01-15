package no434;

public class Solution {

    public static void main(String[] args) {
        String s = "Hello, my name is John";
        int countSegments = countSegments(s);
        System.out.println("输出： " + countSegments);
    }

    public static int countSegments(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int count = 0;
        char prev = s.charAt(0);
        for (int i = 1; i < len; i++) {
            char c = s.charAt(i);
            if (c == ' ' && prev != ' ') {
                count++;
            }
            prev = c;
        }
        return s.charAt(len - 1) == ' ' ? count : count + 1;
    }
}
