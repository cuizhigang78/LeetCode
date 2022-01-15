package no350;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] intersect = intersect(nums1, nums2);
        System.out.println("输出： " + Arrays.toString(intersect));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j] && !visited[j]) {
                    list.add(nums1[i]);
                    visited[j] = true;
                    break;
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
