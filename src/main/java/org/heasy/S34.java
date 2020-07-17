package org.heasy;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * @author wyh
 * @date 2020/7/17 18:20
 **/
public class S34 {

    /**
     * 参考了题解：
     * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/er-fen-cha-zhao-suan-fa-xi-jie-xiang-jie-by-labula/
     */
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int l = leftBound(nums,target);
            int r = rightBound(nums,target);
            return new int[]{l,r};
        }


        /**
         * 找左边界 或者理解为有几个数比target小
         * @param nums
         * @param target
         * @return
         */
        private int leftBound(int[] nums,int target){
            int l = 0;
            int r = nums.length-1;
            while(l<=r){
                int mid = l + ((r-l)>>1);
                if(nums[mid]<target){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
            if(l>=nums.length || nums[l]!=target){
                return -1;
            }
            return l;

        }

        /**
         * 找右边界 或几个数比target大
         * @param nums
         * @param target
         * @return
         */
        private int rightBound(int[] nums,int target){
            int l = 0;
            int r = nums.length-1;
            while(l<=r){
                int mid = l + ((r-l)>>1);
                if(nums[mid]>target){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }
            if(r<0 || nums[r]!=target){
                return -1;
            }
            return r;

        }
    }
}
