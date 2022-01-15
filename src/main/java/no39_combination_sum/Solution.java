package no39_combination_sum;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 39. 组合总和 （medium）
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 *
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * 示例 2：
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 提示：
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 */
public class Solution {

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        combinationSum(candidates, target);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, new Stack<>(), 0);
        return res;
    }

    /**
     * 从给定的数组candidates，取出n个数，有多少种取法
     * @param candidates
     * @param target
     * @param path
     */
    public static void backtracking(int[] candidates, int target, Stack<Integer> path, int start) {

        if (0 > target) {
            return;
        }
        if (0 == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int curr = candidates[i];
            path.push(curr);
            backtracking(candidates, target - curr, path, i);
            path.pop();
        }
    }
}
