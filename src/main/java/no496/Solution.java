package no496;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] res = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int len = nums1.length;

        return new int[len];
    }
}
