package org.heasy.binarytree;

import org.heasy.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 描述 :给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * 作者 : wyh
 * 时间: 2020-03-14 18:27
 */
public class Solution107 {


	/**
	 * 使用队列 进行广度优先遍历
	 * 遍历每一层时 就将这层全部拿出来 加入一个链表中 然后把这个链表加入结果集
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> resList = new LinkedList<>();
		if(root==null) {
			return resList;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			List<Integer> list  = new ArrayList<>();
			int size = queue.size();
			for(int i=0;i<size;i++){
				TreeNode now = queue.poll();
				if(now.left!=null){
					queue.add(now.left);
				}
				if(now.right!=null){
					queue.add(now.right);
				}
				list.add(now.val);

			}
			resList.addFirst(list);
		}
		return resList;
	}

	public static void main(String[] args) {
		int l = 0;
		int r = 4;
		System.out.println((l+r)/2);
		System.out.println(l+(r-1)/2);
	}
}
