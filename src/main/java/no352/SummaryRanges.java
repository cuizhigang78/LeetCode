package no352;

import java.util.ArrayList;
import java.util.List;

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
public class SummaryRanges {

    private List<Integer> arr;

    /**
     * 使用一个空数据流初始化对象
     */
    public SummaryRanges() {
        this.arr = new ArrayList<>();
    }

    /**
     * 向数据流中加入整数 val
     *
     * @param val
     */
    public void addNum(int val) {
        arr.add(val);
    }

    /**
     * 以不相交区间 [starti, endi] 的列表形式返回对数据流中整数的总结。
     *
     * @return
     */
    public int[][] getIntervals() {

        return null;
    }
}
