package no575;

public class Solution {

    public static void main(String[] args) {
        int[] candyType = {-100000, 1, 1, 2, 2, 3, 4, 100000};
        int res = distributeCandies(candyType);
        System.out.println(res);
    }

    public static int distributeCandies(int[] candyType) {
        boolean[] types = new boolean[200001];
        int halfLen = candyType.length / 2, maxTypeCnt = 0;
        for (int i : candyType) {
            int index = i + 100000;
            if (!types[index]) {
                types[index] = true;
                if (++maxTypeCnt >= halfLen) return halfLen;
            }
        }
        return maxTypeCnt;
    }
}
