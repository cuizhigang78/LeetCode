package no500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        String[] words = {"adsdf", "sfd"};
        String[] res = findWords(words);
        System.out.println(Arrays.toString(res));
    }

    public static String[] findWords(String[] words) {
        List<String> res = new ArrayList<>(words.length);
        String[] lines = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (String word : words) {
            for (String line : lines) {
                if (match(line, word)) {
                    res.add(word);
                }
            }
        }
        String[] ans = new String[res.size()];
        return res.toArray(ans);
    }

    /**
     * 判断s2是否由s1中的一个或多个字母组成
     *
     * @param s1
     * @param s2
     * @return
     */
    private static boolean match(String s1, String s2) {
        for (char c : s2.toCharArray()) {
            if (!s1.contains(String.valueOf(Character.toLowerCase(c)))) {
                return false;
            }
        }
        return true;
    }
}
