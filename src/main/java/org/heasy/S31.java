package org.heasy;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 通过次数72,243提交次数211,881
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * @author wyh
 * @date 2020/7/9 15:42
 **/
public class S31 {

    /**
     *  首先从后向前找 找第一个不是降序排列的 记做key 代表右边有比他大的数字（如果把大数字挪到左边 就形成了更大的数字排列）
     *
     *  再从后面的降序排列中 从后往前找到第一个比key大的 因为是从后往前 所以这个比key大的是所有比key大的数字中最小的一个
     *
     *  交换两个数
     *
     *  再对交换位置后面的数字进行一次升序排列
     *
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        //从后往前 倒数第二个开始
        for (int i = nums.length - 2; i >= 0; i--) {
            //如果是降序 跳过
            if (nums[i] >= nums[i + 1]) {
                continue;
            }
            int key = nums[i];
            //找到一个比较小的 比key大的数 记录下标k 从后往前可以保证找到的第一个就是最小的 因为后面都是降序排列
            int k = 0;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > key) {
                    k = j;
                    break;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[k];
            nums[k] = tmp;
            //排序交换位置之后的为升序
            Arrays.sort(nums, i + 1, nums.length);
            return;
        }
        //如果从后往前为降序 则代表当前为最大排列
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
    }

}
