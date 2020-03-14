package org.heasy.BinaryTree;

import org.heasy.model.TreeNode;

/**
 * 描述 :将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * 作者 : wyh
 * 时间: 2020-03-14 20:06
 */
public class Solution108 {
	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums == null ) {
			return null;
		}
		return build(nums,0,nums.length-1);
	}

	private TreeNode build(int[] nums,int l,int r){
		if(l>r) {
			return null;
		}
		int m = l + (r-l)/2;
		TreeNode t = new TreeNode(nums[m]);
		t.left = build(nums,l,m-1);
		t.right = build(nums,m+1,r);
		return t;
	}
}
