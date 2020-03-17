package org.heasy.binarytree;

import org.heasy.model.TreeNode;

/**
 * 描述 :给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 * <p>
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 作者 : wyh
 * 时间: 2020-03-17 20:11
 */
public class Solution111 {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left != null && root.right != null) {
			return 1 + Math.min(minDepth(root.left), minDepth(root.right));
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		if (root.right != null) {
			return 1 + minDepth(root.right);
		}
		return 1 + minDepth(root.left);

	}
}
