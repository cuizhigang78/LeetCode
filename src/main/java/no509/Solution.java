package no509;

public class Solution {

    public static void main(String[] args) {
        int n = 4;
        int res = fib(n);
        System.out.println(res);
    }

    public static int fib(int n) {
        if (n == 0 || n == 1) return n;
        int num1 = 0, num2 = 1, curr = 0;
        for (int i = 2; i < n + 1; i++) {
            curr = num1 + num2;
            num1 = num2;
            num2 = curr;
        }
        return curr;
    }
}
