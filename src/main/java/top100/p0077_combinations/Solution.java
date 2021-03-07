package top100.p0077_combinations;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 77. 组合 （medium）
 * <p>
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [1,2],
 * [1,3],
 * [1,4],
 * [2,3],
 * [2,4],
 * [3,4]
 * ]
 */
public class Solution {

    public static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> combine = combine(n, k);
        for (List<Integer> list : combine) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n <= 0) return res;
        backtracking(n, k, 1, new Stack<>());
        return res;
    }

    /**
     * 递归函数backtracking的作用是什么？
     * <p>
     * 一个参数start，从这个元素开始（包括），直到n结束，要选出k个数组成一个path；
     *
     * @param n
     * @param k
     * @param path
     * @param start
     */
    public static void backtracking(int n, int k, Integer start, Stack<Integer> path) {
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 要取k个数，至少要保证，start后面还有k-1个数
        for (int i = start; i <= n - (k - 1); i++) {
            path.push(i);
            backtracking(n, k - 1, i + 1, path);
            // 回溯：递归之前做了什么操作，这里就要做相反的操作
            path.pop();
        }
    }
}
