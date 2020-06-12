package org.heasy;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例：
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * @author wyh
 * @date 2020/6/12 17:45
 **/
public class S22 {

    public List<String> generateParenthesis(int n) {
        List<String> resList = new ArrayList<>();
        generate("",n,n,resList);
        return resList;
    }


    private void generate(String curr,int left,int right,List<String> resList){
        if(left ==0 && right ==0){
            resList.add(curr);
            return;
        }
        if(right<left){
            return;
        }
        if(left>0){
            generate(curr+"(",left-1,right,resList);
        }

        if(right>0){
            generate(curr+")",left,right-1,resList);
        }

    }
}
