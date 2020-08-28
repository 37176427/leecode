package org.heasy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * @author wyh
 * @date 2020/8/28 11:00
 **/
public class S42 {

    public int trap(int[] height) {
        if (height == null) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[stack.getLast()] < height[i]) {
                int curIdx = stack.removeLast();
                // 如果栈顶元素一直相等，那么全都pop出去，只留第一个。
                while (!stack.isEmpty() && height[stack.getLast()] == height[curIdx]) {
                    stack.removeLast();
                }
                if (!stack.isEmpty()) {
                    int stackTop = stack.getLast();
                    // stackTop此时指向的是此次接住的雨水的左边界的位置。右边界是当前的柱体，即i。
                    // Math.min(height[stackTop], height[i]) 是左右柱子高度的min，减去height[curIdx]就是雨水的高度。
                    // i - stackTop - 1 是雨水的宽度。
                    ans += (Math.min(height[stackTop], height[i]) - height[curIdx]) * (i - stackTop - 1);
                }
            }
            stack.add(i);
        }
        return ans;
    }


    /**
     * 双指针 速度最快
     */
    public int trap2(int[] height){
        int l = 0,r = height.length-1;
        int lmax = 0,rmax = 0;
        int result = 0;
        while(l<r){
            if (height[l] < height[r]){
                //走到这里说明右侧有比height[l] 大的数
                if (height[l] < lmax){
                    //这里 lmax一定是左边遍历过的最大值 且height[r]>lmax>height[l]
                    result += lmax - height[l];
                }else {
                    lmax = height[l];
                }
                l++;
            }else {
                //同理 这里说明左边一定有值比 height[r]大
                if (height[r] > rmax){
                    rmax = height[r];
                }else {
                    result += rmax - height[r];
                }
                r--;
            }
        }
        return result;

    }


    public static void main(String[] args) {
        S42 s42 = new S42();
        int[] array = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = s42.trap(array);
        System.out.println(trap);
    }
}
