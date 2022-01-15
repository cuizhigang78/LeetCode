package no387;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

        String s = "aabb";
        int index = firstUniqChar(s);
        System.out.println("返回： " + index);
    }

    public static int firstUniqChar(String s) {
        int index = s.length();
        for (char c = 'a'; c <= 'z'; c++) {
            int i = s.indexOf(c);
            if (i == -1) continue;
            if (i == s.lastIndexOf(c)) index = Math.min(index, i);

        }
        return index == s.length() ? -1 : index;
    }

    public static int firstUniqChar2(String s) {
        int len = s.length();
        Map<Character, Integer> map = new LinkedHashMap<>(len);
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return s.indexOf(entry.getKey());
            }
        }
        return -1;
    }

    public static int firstUniqChar1(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            boolean flag = false;
            for (int j = 0; j < len; j++) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return i;
            }
        }
        return -1;
    }
}
