package no242;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        boolean anagram = isAnagram(s, t);
        System.out.println("输出： " + anagram);
    }

    public static boolean isAnagram(String s, String t) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            counts[c - 'a']--;
        }
        for (int count : counts) {
            if (count != 0) return false;
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t) {

        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

    public static boolean isAnagram1(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }

        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
