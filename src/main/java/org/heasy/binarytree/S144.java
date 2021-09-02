package org.heasy.binarytree;

import org.heasy.model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author wyh
 * @date 2021/8/12 19:45
 **/
public class S144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        task(root, list);
        return list;
    }

    public void task(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        task(root.left, list);
        task(root.right, list);
    }


    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode cur = root;
        while (!deque.isEmpty() || cur != null) {
            while (cur != null){
                deque.push(cur);
                cur = cur.left;
            }
            final TreeNode node = deque.pop();
            result.add(node.val);
//            if (node.left != null) {
//                deque.addFirst(node.left);
//            }
            if (node.right != null) {
                cur = node.right;
            }
        }
        return result;
    }

}
