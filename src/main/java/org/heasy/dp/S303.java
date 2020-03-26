package org.heasy.dp;

/**
 * 描述 :303. 区域和检索 - 数组不可变
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例：
 *
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 作者 : wyh
 * 时间: 2020-03-26 21:41
 */
public class S303 {

	class NumArray {
		final int[] nums;
		int[] sums;
		public NumArray(int[] nums) {
			this.nums = nums;
			this.sums = new int[nums.length+1];
			for(int i=0;i<nums.length;i++){
				sums[i+1]=sums[i]+nums[i];
			}
		}

		public int sumRange(int i, int j) {
			return sums[j+1]-sums[i];
		}
	}

}
