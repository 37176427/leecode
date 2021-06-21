package org.heasy;

/**
 * @author wyh
 * @date 2021/6/21 17:42
 **/
public class S11 {

    public static int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int i = 0, j = height.length - 1;
        int max = 0;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            int area = h * (j - i);
            max = Math.max(area, max);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return max;

    }

    public static void main(String[] args) {
        int[] a = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(a));
    }
}
