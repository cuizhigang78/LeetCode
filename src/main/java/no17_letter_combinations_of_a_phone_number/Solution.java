package no17_letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        String digits = "";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        char[][] array = {null, null, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        List<char[]> list = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            list.add(array[digits.charAt(i) - 48]);
        }

        StringBuilder path = new StringBuilder();
        int idx = 0;
        backtracking(digits, res, path, idx, list);
        return res;
    }

    private static void backtracking(String digits, List<String> res, StringBuilder path, int idx, List<char[]> list) {
        if (path.length() == digits.length()) {
            res.add(new String(path));
            return;
        }
        if (path.length() > digits.length()) {
            return;
        }

        for (char c : list.get(idx)) {
            path.append(c);
            backtracking(digits, res, path, idx + 1, list);
            path.deleteCharAt(idx);
        }
    }
}
