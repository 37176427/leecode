package org.heasy;

import java.util.*;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * @author wyh
 * @date 2020/8/11 16:04
 **/
public class S39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int length = candidates.length;
        if(length == 0){
            return list;
        }
        Arrays.sort(candidates);
        Deque deque = new ArrayDeque();
        dfs(candidates,0,length,target,deque,list);
        return list;
    }

    private void dfs(int[] candidates,int start,int end,int target,Deque deque,List<List<Integer>> list){
        if(target < 0) return;
        if(target == 0){
            list.add(new ArrayList(deque));
            return;
        }

        for(int i=start;i<end;i++){
            if(candidates[i] > target) break;

            if(i > start && candidates[i] == candidates[i-1]) continue;

            deque.addLast(candidates[i]);
            dfs(candidates,i,end,target - candidates[i],deque,list);
            deque.removeLast();
        }

    }
}
