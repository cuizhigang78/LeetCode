package no229;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 3, 1, 4, 5, 6};
        List<Integer> res = majorityElement(nums);
        System.out.println(res);
    }

    public static List<Integer> majorityElement(int[] nums) {
        int target = nums.length / 3;
        List<Integer> res = new ArrayList<>();
        int num1 = 0, vote1 = 0, num2 = 0, vote2 = 0;
        for (int num : nums) {
            if (vote1 > 0 && num == num1) {
                vote1++;
            } else if (vote2 > 0 && num == num2) {
                vote2++;
            } else if (vote1 == 0) {
                num1 = num;
                vote1++;
            } else if (vote2 == 0) {
                num2 = num;
                vote2++;
            } else {
                vote1--;
                vote2--;
            }
        }
        int cnt1 = 0;
        int cnt2 = 0;
        for (int num : nums) {
            if (vote1 > 0 && num == num1) cnt1++;
            if (vote2 > 0 && num == num2) cnt2++;
        }
        if (vote1 > 0 && cnt1 > target) res.add(num1);
        if (vote2 > 0 && cnt2 > target) res.add(num2);
        return res;
    }

    public static List<Integer> majorityElement1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > len / 3) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}
