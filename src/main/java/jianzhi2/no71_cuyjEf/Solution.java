package jianzhi2.no71_cuyjEf;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName Solution
 * @Author Maxwell
 * @Date 2022/3/1 20:35
 * @Description Solution
 * @Version 1.0
 */
public class Solution {

    int[] w;

    public static void main(String[] args) {
        Solution solution = new Solution(new int[] {3,14,1,7});
        System.out.println(solution.pickIndex());
    }

    public Solution(int[] w) {
        this.w = w;
    }

    public int pickIndex() {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < w[i]; j++) {
                list.add(i);
            }
        }
        int r = random.nextInt(list.size());
        System.out.println(r); 
        for (int i = 0; i < w.length; i++) {
            if (w[i] == r) {
                return i;
            }
        }
        return 0;
    }
}
