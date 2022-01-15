package no46_noermutations;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 46. 全排列 （medium）
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Solution {
    public static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        backtracking(nums, new Stack<>(), -1);
        return res;
    }

    public static void backtracking(int[] nums, Stack<Integer> path, int index) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) continue;
            path.push(nums[i]);
            backtracking(nums, path, i+1);
            path.pop();
        }
    }
}
