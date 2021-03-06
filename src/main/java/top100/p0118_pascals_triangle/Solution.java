package top100.p0118_pascals_triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角 （easy）
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class Solution {

    public static void main(String[] args) {
        List<List<Integer>> lists = generate(5);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    /**
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     *
     *
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> prev = new ArrayList<>();
        prev.add(1);

        result.add(prev);

        for (int i = 1; i < numRows; i++) {
            List<Integer> curr = next(prev);
            result.add(curr);
            prev = curr;
        }

        return result;
    }

    private static List<Integer> next(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 0; i < list.size() - 1; i++) {
            result.add(list.get(i) + list.get(i + 1));
        }
        result.add(1);
        return result;
    }
}
