package top100.p0001_two_sum;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        int volume = 2048;       //100000000000
        int bitMode = volume-1;//011111111111
        int [] result = new int[volume];

        for (int i=0;i<nums.length;i++){
            int c = (target - nums[i]) & bitMode;
            if (result[c]!=0){
                return new int[]{result[c]-1,i};
            }
            result[nums[i] & bitMode]=i+1;
        }
        return null;
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        int[] nums = new int[]{2, 2, 1, 3};
        int target = 4;
        Solution solution = new Solution();
        int[] array = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(array));
        System.out.println(System.currentTimeMillis() - begin);
    }
}
