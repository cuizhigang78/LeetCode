package no869;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int n = 24;
        boolean res = reorderedPowerOf2(n);
        System.out.println(res);
    }

    public static boolean reorderedPowerOf2(int n) {
        List<Integer> powerList = new ArrayList<>();
        int i = 1;
        while (i <= Integer.MAX_VALUE / 2) {
            powerList.add(i);
            i *= 2;
        }
        for (Integer num : powerList) {
            if (isAnagrams(n, num)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAnagrams(int num1, int num2) {
        int[] ints = new int[10];
        while (num1 > 0) {
            ints[num1 % 10]++;
            num1 /= 10;
        }
        while (num2 > 0) {
            ints[num2 % 10]--;
            num2 /= 10;
        }
        for (int i : ints) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
