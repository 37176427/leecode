package org.heasy.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution496 {

	/**
	 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
	 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
	 *
	 * 题解： 单调栈实际上就是栈，只是利用了一些巧妙的逻辑，使得每次新元素入栈后，栈内的元素都保持有序（单调递增或单调递减）
	 */

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Stack<Integer> stack = new Stack<>();
		Map<Integer, Integer> map = new HashMap<>(nums2.length);
		for (int value : nums2) {
			while (!stack.isEmpty() && value > stack.peek()) {
				map.put(stack.pop(), value);
			}
			stack.push(value);
		}
		for (int i = 0; i < nums1.length; i++) {
			nums1[i] = map.get(nums1[i]) == null ? -1 : map.get(nums1[i]);
		}
		return nums1;
	}
}
