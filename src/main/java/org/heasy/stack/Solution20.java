package org.heasy.stack;

import java.util.ArrayList;
import java.util.Stack;

public class Solution20 {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 题解： 使用栈
     * 注意： 返回时如果栈不为空的情况 如： (((((
     */

    public boolean isValid(String s) {
        if (s==null || s.length()==0) {
            return true;
        }
        //判断一个值是不是偶数 可以&1 偶数最后一位一定是0 结果是0则为偶数
        if ((s.length()&1) !=0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        for (char value : array) {
            switch (value) {
                case ')':
                    if (stack.isEmpty() || stack.pop()!='(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop()!='[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop()!='{') {
                        return false;
                    }
                    break;
                default:
                    stack.push(value);
                    break;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        Solution20 s = new Solution20();
        boolean valid = s.isValid("((");
        System.out.println(valid);
    }
}
