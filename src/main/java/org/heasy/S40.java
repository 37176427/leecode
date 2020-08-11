package org.heasy;

import java.util.*;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 *
 * @author wyh
 * @date 2020/8/11 15:43
 **/
public class S40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int length = candidates.length;
        if (length == 0) {
            return list;
        }
        //进行排序很重要
        Arrays.sort(candidates);
        Deque queue = new ArrayDeque();
        dfs(candidates, target, 0, length, queue, list);
        return list;
    }

    private void dfs(int[] candidates, int remain, int start, int end, Deque queue, List<List<Integer>> list) {
        if (remain == 0) {
            list.add(new ArrayList(queue));
            return;
        }
        if (end > candidates.length) {
            return;
        }
        if (remain < 0) {
            return;
        }
        for (int i = start; i < end; i++) {
            //如果值比目标值大 后面的都比目标值大 没必要继续
            if (candidates[i] > remain) {
                break;
            }
            //如果不是第一次 且数与上一次相同 则跳过 代表去掉重复数字
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            queue.addLast(candidates[i]);
            //！！！数字只能用一次 则start参数传i+1 和39题的不同点就在这里!!!
            dfs(candidates, remain - candidates[i], i + 1, end, queue, list);
            queue.removeLast();
        }

    }
}
