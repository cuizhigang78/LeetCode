package no34;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {};
        int target = 8;
        int[] res = searchRange(nums, target);
        System.out.println(Arrays.toString(res));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private static int[] binarySearch(int[] nums, int begin, int end, int target) {
        if (begin > end) return new int[]{-1, -1};
        int mid = (begin + end) / 2;
        if (nums[mid] == target) {
            int prev = mid - 1;
            while (prev >= 0 && nums[prev] == target) {
                prev--;
            }
            int post = mid + 1;
            while (post <= nums.length - 1 && nums[post] == target) {
                post++;
            }
            return new int[]{prev + 1, post - 1};
        } else if (nums[mid] > target) {
            return binarySearch(nums, begin, mid - 1, target);
        } else {
            return binarySearch(nums, mid + 1, end, target);
        }
    }
}
