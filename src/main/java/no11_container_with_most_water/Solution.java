package no11_container_with_most_water;

public class Solution {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int maxArea = 0, i = 0, j = height.length - 1;
        while (i < j) {
            int x = j - i;
            int y1 = height[i];
            int y2 = height[j];
            if (y1 < y2) {
                maxArea = Math.max(maxArea, x * y1);
                i++;
            } else {
                maxArea = Math.max(maxArea, x * y2);
                j--;
            }
        }
        return maxArea;
    }

    public static int maxArea1(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int x = j - i;
                int y = Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, x * y);
            }
        }
        return maxArea;
    }
}
