package org.heasy.BinaryTree;

import org.heasy.model.TreeNode;

/**
 * 描述 :翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 作者 : wyh
 * 时间: 2020-03-16 11:06
 */
public class Solution226 {

	public TreeNode invertTree(TreeNode root) {
		if(root==null) {
			return null;
		}
		TreeNode tmp = root.left;
		root.left =root.right;
		root.right = tmp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}

}
